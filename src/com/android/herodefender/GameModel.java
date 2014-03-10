package com.android.herodefender;

import java.util.Random;
import java.util.Vector;

import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.MotionEvent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;
import com.android.herodefender.sprite.AirSprite;
import com.android.herodefender.sprite.ArrowSprite;
import com.android.herodefender.sprite.BackgroundSprite;
import com.android.herodefender.sprite.BurstSprite;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.CitywallSprite;
import com.android.herodefender.sprite.DoorSprite;
import com.android.herodefender.sprite.EffectSprite;
import com.android.herodefender.sprite.FrameSprite;
import com.android.herodefender.sprite.HeroSprite;
import com.android.herodefender.sprite.Item;
import com.android.herodefender.sprite.Monster;
import com.android.herodefender.sprite.MonsterSprite;
import com.android.herodefender.sprite.SelectSprite;
import com.android.herodefender.sprite.Sprite;
import com.android.herodefender.sprite.UiSprite;
import com.android.herodefender.sprite.VampireSprite;
import com.android.herodefender.sprite.WallSprite;
import com.android.herodefender.sprite.WerewolvesSprite;
import com.android.herodefender.sprite.ZombieSprite;

public class GameModel extends CoreModel
{
	private static final int EFFECT =0 ;
	private static final int START = 1;
	private static final int PLAY = 2;
	private static final int DESTROY = 3;
	private static final int FAILURE = 4;
	private static final int WIN = 5;
	private static final int PAUSE = 6;
	private static final int TEACH=7;
	
	private static final int ATTACK_NONE = 0;
	private static final int ATTACK_SHOOT = 1;
	private static final int ATTACK_STONE = 2;
	private static final int WOUND_BIG=0;
	private static final int WOUND_MID=1;
	private static final int WOUND_NON=2;
	private int scriptInt;
	private int[][] barrierSet;
	private BackgroundSprite backgroundSprite;
	private CitywallSprite citywallSprite;
	private WallSprite[] walls;
	private DoorSprite[] doors;
	private SparseArray<MonsterSprite> monsters;
	private SparseArray<ArrowSprite> arrows;
	private SparseArray<AirSprite> airs;
	private SparseArray<ArrowSprite> bats;
	private SparseArray<BurstSprite> bursts;
	private HeroSprite[] heros;
	private SelectSprite[][] selects;
	private Random random;
	private UiSprite barSprite;
	private UiSprite menuSprite;
	private EffectSprite effectSprite;
	private UiSprite reallySprite;
	private int[] items;
	public int perState;
	private Monster[] monster=new Monster[3];
	private ButtonSprite buttonSprite;
	private FrameSprite talkSprite;
	private boolean teachMode;
	public GameModel(GameBean gameBean)
	{
		super(gameBean);
	}

	public void init()
	{
		this.loadImage(ImageConfig.GAME_LOAD);
		int barrierInt=gameBean.getBarrierInt();
		int bombInt=gameBean.getBombInt();
		for(int i=0;i<monster.length;i++)
		{
			monster[i]=new Monster();
		}
		backgroundSprite = new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setPosition(GameConsts.BACKGROUND_POSITION);
		backgroundSprite.setState(BackgroundSprite.GAME);
		citywallSprite = new CitywallSprite(this.getImageConfig());
		citywallSprite.setPosition(GameConsts.CITYWALL_POSITION);
		citywallSprite.setState(CitywallSprite.STAY);
		walls = new WallSprite[GameConsts.WALL_POSITION.length];
		for (int i = 0; i < walls.length; i++)
		{
			walls[i] = new WallSprite(this.getImageConfig());
			walls[i].setPosition(GameConsts.WALL_POSITION[i]);
			walls[i].setLayer(GameConsts.WALL_POSITION[i][2]);
			walls[i].setState(GameConsts.WALL_POSITION[i][3]);
		}
		doors = new DoorSprite[GameConsts.DOOR_POSITION.length];
		for (int i = 0; i < doors.length; i++)
		{
			doors[i] = new DoorSprite(this.getImageConfig());
			doors[i].setPosition(GameConsts.DOOR_POSITION[i]);
			doors[i].setLayer(GameConsts.DOOR_POSITION[i][2]);
			doors[i].setSelectTpye(DoorSprite.TYPE_NONE);
			doors[i].setState(DoorSprite.MID);
		}
		monsters = new SparseArray<MonsterSprite>();
		arrows = new SparseArray<ArrowSprite>();
		airs = new SparseArray<AirSprite>();
		bats = new SparseArray<ArrowSprite>();
		bursts = new SparseArray<BurstSprite>();
		heros = new HeroSprite[GameConsts.HERO_POSITION.length];
		selects=new SelectSprite[heros.length][GameConsts.SELECT_POSITION.length];
		for (int i = 0; i < heros.length; i++)
		{
			int[] heroPosition=GameConsts.HERO_POSITION[i];
			heros[i] = new HeroSprite(this.getImageConfig());
			heros[i].setPosition(heroPosition);
			heros[i].setCollisionArea(GameConsts.HERO_COLLISION);
			heros[i].setMaxMp(GameConsts.HERO_MP);
			heros[i].setWeaponType(0);
			heros[i].setState(HeroSprite.STAY);
			for(int j=0;j<selects[i].length;j++)
			{
				selects[i][j]=new SelectSprite(this.getImageConfig());
				selects[i][j].setPosition(
				                          heroPosition[0]+GameConsts.SELECT_POSITION[j][0],
				                          heroPosition[1]+GameConsts.SELECT_POSITION[j][1]);
				selects[i][j].setCollisionArea(GameConsts.SELECT_COLLISION);
			}
		}
		barrierSet = BarrierConsts.BARRIER_SET[barrierInt];
		random = new Random();
		barSprite = new UiSprite(this.getImageConfig());
		barSprite.setPosition(GameConsts.BAR_POSITION);
		barSprite.setHp(GameConsts.CITYWALL_HP);
		barSprite.setMaxHp(GameConsts.CITYWALL_HP);
		barSprite.setCollisionArea(GameConsts.BUTTON_COLLISION);
		barSprite.setBombInt(bombInt);
		barSprite.setStage(barrierInt);
		barSprite.setState(UiSprite.BAR_START);
		barSprite.setMaxTime(barrierSet);
		menuSprite = new UiSprite(this.getImageConfig());
		menuSprite.setPosition(GameConsts.MENU_PAUSE_POSITION);
		items=gameBean.getItems();
		effectSprite=new EffectSprite(this.getImageConfig());
		effectSprite.setState(EffectSprite.MOVE);
		reallySprite=new UiSprite(this.getImageConfig());
		reallySprite.setPosition(GameConsts.REALLY_GO_POSITION);
		buttonSprite=new ButtonSprite(this.getImageConfig());
		buttonSprite.setType(ButtonSprite.TYPE_BACK);
		buttonSprite.setCollisionArea(GameConsts.BARRIER_BUTTON_COLLISION[3]);
		buttonSprite.setPosition(GameConsts.GAME_BACK_POSITION);
		talkSprite=new FrameSprite(gameBean);
		this.playMusic(MusicConfig.MUSIC02);
		this.removeAd();
		teachMode=false;
	}

	private void addAirSprite(MonsterSprite monsterSprite, int layer)
	{
		HeroSprite heroSprite = heros[layer];
		AirSprite airSprite = new AirSprite(this.getImageConfig());
		airSprite.setHeroInt(layer);
		int x = monsterSprite.getX();
		int y = monsterSprite.getY();
		airSprite.setX(x);
		airSprite.setY(y);
		airSprite.setSpeed(GameConsts.AIR_SPEED);
		int endX = heroSprite.getX() + GameConsts.AIR_SCRIPT[0];
		int endY = heroSprite.getY() + GameConsts.AIR_SCRIPT[1];
		airSprite.setVector(monsterSprite.getX(), monsterSprite.getY(), endX, endY);
		airSprite.setEndX(endX);
		airSprite.setEndY(endY);
		airSprite.setType(monsterSprite.getType());
		airSprite.setState(AirSprite.MOVE);
		int no = getHashNo(airs);
		airs.put(no, airSprite);
	}

	private void addMonsterSprite(int layer, int type)
	{
		MonsterSprite monsterSprite = null;
		if (type == MonsterSprite.TYPE_VAMPIRE)
		{
			monsterSprite = new VampireSprite(this.getImageConfig());
			monsterSprite.setType(MonsterSprite.TYPE_VAMPIRE);
		}
		else if (type == MonsterSprite.TYPE_ZOMBIE)
		{
			monsterSprite = new ZombieSprite(this.getImageConfig());
			monsterSprite.setType(MonsterSprite.TYPE_ZOMBIE);
		}
		else if (type == MonsterSprite.TYPE_WEREWOLVES)
		{
			monsterSprite = new WerewolvesSprite(this.getImageConfig());
			monsterSprite.setType(MonsterSprite.TYPE_WEREWOLVES);
		}
		else
		{
			monsterSprite = new MonsterSprite(this.getImageConfig());
		}

		int[] position = GameConsts.MONSTER_POSITION[layer];
		monsterSprite.setX(position[0]);
		monsterSprite.setY(position[1]);
		monsterSprite.setLayer(layer);
		monsterSprite.setHp(GameConsts.MONSTER_HP);
		monsterSprite.setMaxHp(GameConsts.MONSTER_HP);
		monsterSprite.setState(MonsterSprite.MOVE);
		monsterSprite.setSpeed(GameConsts.MONSTER_SPEED);
		monsterSprite.setAttack(GameConsts.MONSTER_ATTACK);
		monsterSprite.setCollisionArea(GameConsts.MONSTER_COLLISION);
		int no = getHashNo(monsters);
		monsters.put(no, monsterSprite);
	}

	private void addBatSprite(MonsterSprite monsterSprite)
	{
		ArrowSprite batSprite = new ArrowSprite(this.getImageConfig());
		int x = monsterSprite.getX() + GameConsts.BAT_POSITION[0];
		int y = monsterSprite.getY() + GameConsts.BAT_POSITION[1];
		batSprite.setX(x);
		batSprite.setY(y);
		batSprite.setType(ArrowSprite.TYPE_BAT);
		batSprite.setAttack(GameConsts.BAT_ATTACK);
		batSprite.setState(ArrowSprite.MOVE);
		batSprite.setSpeed(GameConsts.BAT_SPEED);
		batSprite.setCollisionArea(GameConsts.BAT_COLLISION);
		int no = getHashNo(bats);
		bats.put(no, batSprite);
	}

	private void addBurstSprite(HeroSprite heroSprite,int layer)
	{
		BurstSprite burstSprite = new BurstSprite(this.getImageConfig());
		int x = heroSprite.getX() + GameConsts.BURST_POSITION[0];
		int y = heroSprite.getY() + GameConsts.BURST_POSITION[1];
		burstSprite.setX(x);
		burstSprite.setY(y);
		burstSprite.setCollisionArea(GameConsts.BURST_COLLISION);
		burstSprite.setLayer(layer);
		burstSprite.setState(BurstSprite.BURST);
		int no = getHashNo(bursts);
		bursts.put(no, burstSprite);
	}
	private void addBoomSprite(MonsterSprite monsterSprite)
	{
		BurstSprite boomSprite = new BurstSprite(this.getImageConfig());
		
		int x = monsterSprite.getX() + GameConsts.BOOM_POSITION[0];
		int y = monsterSprite.getY() + GameConsts.BOOM_POSITION[1];
		boomSprite.setX(x);
		boomSprite.setY(y);
		boomSprite.setState(BurstSprite.BOOM);
		int no = getHashNo(bursts);
		bursts.put(no, boomSprite);
	}
	private void addArrowSprite(HeroSprite heroSprite, int layer)
	{
		int type = heroSprite.getWeaponType();
		ArrowSprite arrowSprite = new ArrowSprite(this.getImageConfig());
		int x = heroSprite.getX() + GameConsts.ARROW_POSITION[0];
		int y = heroSprite.getY() + GameConsts.ARROW_POSITION[1];
		arrowSprite.setType(type);
		arrowSprite.setX(x);
		arrowSprite.setY(y);
		arrowSprite.setLayer(layer);
		arrowSprite.setAttack(GameConsts.ARROW_ATTACK);
		arrowSprite.setState(ArrowSprite.MOVE);
		arrowSprite.setSpeed(GameConsts.ARROW_SPEED);
		arrowSprite.setCollisionArea(GameConsts.ARROW_COLLISION);
		int no = getHashNo(arrows);
		arrows.put(no, arrowSprite);
		this.playMusic(MusicConfig.BOW01);
	}

	public static int getHashNo(SparseArray hash)
	{
		int no = 0;
		while (no >= 0)
		{
			if (hash.get(no) == null)
			{
				break;
			}
			no++;
		}
		return no;
	}

	private boolean isCollisionMonster(ArrowSprite arrowSprite)
	{
		for (int i = 0; i < monsters.size(); i++)
		{
			int key = monsters.keyAt(i);
			MonsterSprite monsterSprite = monsters.get(key);
			if (monsterSprite.getState() != MonsterSprite.DEAD
					&& monsterSprite.getState() != MonsterSprite.DEAD_END)
			{
				int attack = arrowSprite.getAttack();
				int hp = monsterSprite.getHp();
				if (monsterSprite.isCollision(arrowSprite)
						&& this.isZombieHit(arrowSprite, monsterSprite))
				{
					int woundType=this.isWounded(arrowSprite, monsterSprite);
					if (woundType==WOUND_BIG)
					{
						attack = attack * GameConsts.WOUND_BIG_MULTIPLE;
						monsterSprite.setState(MonsterSprite.WOUNDED);
						arrowSprite.setState(ArrowSprite.HIT);
					}
					else if(woundType==WOUND_MID)
					{
						attack = attack * GameConsts.WOUND_MID_MULTIPLE;
						arrowSprite.setState(ArrowSprite.DROP);
					}
					else
					{
						arrowSprite.setState(ArrowSprite.BROKEN);
						if (monsterSprite.getType() == MonsterSprite.TYPE_ZOMBIE&&
								!monsterSprite.isAttack())
						{
							monsterSprite.setState(ZombieSprite.TOPPLE);
						}
					}
					monsterSprite.setHurt(true);
					hp = hp - attack;
					if (hp <= 0)
					{
						hp = 0;
						monsterSprite.setState(MonsterSprite.DEAD);
						this.addAirSprite(monsterSprite, arrowSprite.getLayer());
						arrowSprite.setState(ArrowSprite.HIT);
					}
					monsterSprite.setHp(hp);
					return true;
				}
			}
		}
		return false;
	}

	private boolean isZombieHit(ArrowSprite arrowSprite, MonsterSprite monsterSprite)
	{
		int arrowType = arrowSprite.getType();
		int monsterType = monsterSprite.getType();
		if (monsterType == MonsterSprite.TYPE_ZOMBIE && arrowType != ArrowSprite.TYPE_SYRING)
		{
			if (monsterSprite.getState() == ZombieSprite.CREEP
					|| monsterSprite.getState() == ZombieSprite.CREEP_UP
					|| monsterSprite.getState() == ZombieSprite.CREEP_DOWN)
			{
				return false;
			}
		}
		return true;
	}

	private int isWounded(ArrowSprite arrowSprite, MonsterSprite monsterSprite)
	{
		int arrowType = arrowSprite.getType();
		int monsterType = monsterSprite.getType();
		if (arrowType == ArrowSprite.TYPE_ARROW)
		{
			if (monsterType == MonsterSprite.TYPE_HERO)
			{
				return WOUND_BIG;
			}
			else
			{
				return WOUND_MID;
			}
		}
		else if (arrowType == ArrowSprite.TYPE_BULLET)
		{
			if (monsterType == MonsterSprite.TYPE_WEREWOLVES)
			{
				return WOUND_BIG;
			}
			else
			{
				return WOUND_NON;
			}
		}
		else if (arrowType == ArrowSprite.TYPE_CROSS)
		{
			if (monsterType == MonsterSprite.TYPE_VAMPIRE)
			{
				return WOUND_BIG;
			}
			else
			{
				return WOUND_NON;
			}
		}
		else if (arrowType == ArrowSprite.TYPE_SYRING)
		{
			if (monsterType == MonsterSprite.TYPE_ZOMBIE)
			{
				return WOUND_BIG;
			}
			else
			{
				return WOUND_NON;
			}
		}
		return WOUND_NON;
	}

	private boolean isCollisionDoor(ArrowSprite arrowSprite)
	{
		for (int i = 0; i < doors.length; i++)
		{
			DoorSprite doorSprite = doors[i];
			if (doorSprite.getState() != DoorSprite.MID)
			{
				if (doorSprite.isCollision(arrowSprite))
				{
					return true;
				}
			}
		}
		return false;
	}
	public void updateView(long viewTime)
	{
		if(subState==TEACH)
		{
			talkSprite.update();
		}
		else if(subState == EFFECT )
		{
			effectSprite.update();
			if(effectSprite.getState()==EffectSprite.MOVE_END)
			{
				reallySprite.setState(UiSprite.REALLY);
				subState=START;
			}
		}
		else if(subState==START)
		{
			reallySprite.update();
		}
		else if (subState == PLAY)
		{
			for (int i = 0; i < airs.size(); i++)
			{
				int key = airs.keyAt(i);
				AirSprite airSprite = airs.get(key);
				if (airSprite.getState() == AirSprite.MOVE)
				{
					int speed = (int) viewTime / airSprite.getSpeed();
					int x = airSprite.getX() + airSprite.getSpeedX(speed);
					int y = airSprite.getY() + airSprite.getSpeedY(speed);
					airSprite.setX(x);
					airSprite.setY(y);
					if (x > airSprite.getEndX())
					{
						airSprite.setX(airSprite.getEndX());
						airSprite.setY(airSprite.getEndY());
						airSprite.setState(AirSprite.GATHER);
						airSprite.setLayer(1);
						int heroInt = airSprite.getHeroInt();
						HeroSprite heroSprite = heros[heroInt];
						int mp = heroSprite.getMp();
						mp = mp + GameConsts.AIR_MP;
						int maxMp=heroSprite.getMaxMp();
						if (mp >= maxMp)
						{
							mp = maxMp;
							heroSprite.setAir(true);
							if(!teachMode)
							{
								selects[heroInt][SelectSprite.INT_BOOM].setState(SelectSprite.STAY);
							}
						}
						heroSprite.setMp(mp);
						heroSprite.setMp(true);
					}
				}
			}
			for (int i = 0; i < bats.size(); i++)
			{
				int key = bats.keyAt(i);
				ArrowSprite arrowSprite = bats.get(key);
				if (arrowSprite.getState() == ArrowSprite.MOVE)
				{
					int speed = (int) viewTime / arrowSprite.getSpeed();
					int x = arrowSprite.getX() + speed;
					arrowSprite.setX(x);
					if (this.isCollisionDoor(arrowSprite))
					{
						arrowSprite.setState(ArrowSprite.BROKEN);
					}
					if (x > GameConsts.BAT_ATTACK_POSITION)
					{
						this.setCitywall(arrowSprite.getAttack());
						arrowSprite.setState(ArrowSprite.HIT);
					}
				}
			}
			for (int i = 0; i < arrows.size(); i++)
			{
				int key = arrows.keyAt(i);
				ArrowSprite arrowSprite = arrows.get(key);

				if (arrowSprite.getState() == ArrowSprite.MOVE)
				{
					int speed = (int) viewTime / arrowSprite.getSpeed();
					int x = arrowSprite.getX() - speed;
					arrowSprite.setX(x);
					if (this.isCollisionDoor(arrowSprite))
					{
						arrowSprite.setState(ArrowSprite.BROKEN);
					}
					else if (this.isCollisionMonster(arrowSprite))
					{
					}
					if (x < GameConsts.ARROW_END_POSITION)
					{
						arrowSprite.setState(Sprite.DISABLE);
					}
				}
				else if(arrowSprite.getState() == ArrowSprite.DROP)
				{
					
					int dy=arrowSprite.getDy();
					if(dy<GameConsts.ARROW_SHADOW_POSITION)
					{
						int speed = (int) viewTime / (arrowSprite.getSpeed()*2);
						dy=dy+speed;
						if(dy>GameConsts.ARROW_SHADOW_POSITION)
						{
							dy=GameConsts.ARROW_SHADOW_POSITION;
						}
						int x=arrowSprite.getX()+speed;
						arrowSprite.setDy(dy);
						arrowSprite.setX(x);
					}
					
				}
			}
			for (int i = 0; i < monsters.size(); i++)
			{
				int key = monsters.keyAt(i);
				MonsterSprite monsterSprite = monsters.get(key);
				int x = monsterSprite.getX();
				int y = monsterSprite.getY();
				int speed = (int) viewTime / monsterSprite.getSpeed();
				int doorSet = this.getDoorSet(x);
				int layer = monsterSprite.getLayer();
				boolean isDoor = false;
				if (monsterSprite.getState() == MonsterSprite.MOVE
						|| monsterSprite.getState() == ZombieSprite.CREEP)
				{
					if (x < GameConsts.MONSTER_DOOR_COLLISION[doorSet]
							&& (x + speed) >= GameConsts.MONSTER_DOOR_COLLISION[doorSet])
					{
						if (!this.isLayer(layer, doorSet))
						{
							this.setMoveState(monsterSprite, doorSet);
							int dy = x + speed - GameConsts.MONSTER_DOOR_COLLISION[doorSet];
							x = GameConsts.MONSTER_DOOR_COLLISION[doorSet];
							if (monsterSprite.getState() == MonsterSprite.MOVE_UP)
							{
								y = y - dy;
							}
							else if (monsterSprite.getState() == MonsterSprite.MOVE_DOWN)
							{
								y = y + dy;
							}
							isDoor = true;
						}
						else if (monsterSprite.isVampire() && this.isAttackMonster(monsterSprite))
						{
							monsterSprite.setState(MonsterSprite.ATTACK);
						}
					}
					if (isDoor)
					{
						monsterSprite.setX(x);
						monsterSprite.setY(y);

					}
					else
					{
						monsterSprite.setX(x + speed);
					}
					if (x >= GameConsts.MONSTER_ATTACK_POSITION)
					{
						monsterSprite.setX(GameConsts.MONSTER_ATTACK_POSITION);
						monsterSprite.setAttack(true);
						monsterSprite.setState(MonsterSprite.ATTACK);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.MOVE_UP
						|| monsterSprite.getState() == ZombieSprite.CREEP_UP)
				{
					this.setLayer(monsterSprite);
					if (this.isMoveChange(y, speed, true))
					{
						if (this.isLayer(layer, doorSet))
						{
							if (this.isZombieCreep(monsterSprite))
							{
								monsterSprite.setState(ZombieSprite.CREEP);
							}
							else if (monsterSprite.isVampire()
									&& this.isAttackMonster(monsterSprite))
							{
								monsterSprite.setState(MonsterSprite.ATTACK);
							}
							else
							{
								monsterSprite.setState(MonsterSprite.MOVE);
							}
						}
						else
						{
							this.setMoveState(monsterSprite, doorSet);
							if (monsterSprite.getState() == MonsterSprite.MOVE_UP
									|| monsterSprite.getState() == ZombieSprite.CREEP_UP)
							{
								monsterSprite.setY(y - speed);
							}
						}
					}
					else
					{
						monsterSprite.setY(y - speed);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.MOVE_DOWN
						|| monsterSprite.getState() == ZombieSprite.CREEP_DOWN)
				{
					this.setLayer(monsterSprite);
					if (this.isMoveChange(y, speed, false))
					{
						if (this.isLayer(layer, doorSet))
						{
							if (this.isZombieCreep(monsterSprite))
							{
								monsterSprite.setState(ZombieSprite.CREEP);
							}
							else if (monsterSprite.isVampire()
									&& this.isAttackMonster(monsterSprite))
							{
								monsterSprite.setState(MonsterSprite.ATTACK);
							}
							else
							{
								monsterSprite.setState(MonsterSprite.MOVE);
							}
						}
						else
						{
							this.setMoveState(monsterSprite, doorSet);
							if (monsterSprite.getState() == MonsterSprite.MOVE_DOWN
									|| monsterSprite.getState() == ZombieSprite.CREEP_DOWN)
							{
								monsterSprite.setY(y + speed);
							}
						}
					}
					else
					{
						monsterSprite.setY(y + speed);
					}
				}
			}
		}
	}

	private void isCollisionMonster(DoorSprite doorSprite, int door)
	{
		for (int i = 0; i < monsters.size(); i++)
		{
			int key = monsters.keyAt(i);
			MonsterSprite monsterSprite = monsters.get(key);
			if (monsterSprite.isLive())
			{
				if (monsterSprite.isCollision(doorSprite))
				{
					int x = monsterSprite.getX();
					int y = monsterSprite.getY();
					int doorX = doorSprite.getX();
					int doorY = doorSprite.getY();
					int layer = doorSprite.getLayer();
					int doorSet = this.getDoorSet(x);
					monsterSprite.setDoor(door);
					if (doorSprite.getState() == DoorSprite.MID_UP)
					{
						if (this.isLayer(layer, doorSet))
						{
							int tempX = doorX + GameConsts.MID_UP_DOOR_SCRIPT[0];
							int tempY = doorY + GameConsts.MID_UP_DOOR_SCRIPT[1];
							if (x < tempX)
							{
								monsterSprite.setX(tempX);
							}
							if (y > tempY)
							{
								monsterSprite.setY(tempY);
							}
							this.setLayer(monsterSprite);
							monsterSprite.setState(MonsterSprite.MID_UP_DOOR);
						}
						else
						{
							int tempY = doorY + GameConsts.FLY_UP_DOOR_SCRIPT[0];
							if (tempY < y)
							{
								monsterSprite.setY(tempY);
							}
							monsterSprite.setLayer(layer);
							monsterSprite.setState(MonsterSprite.FLY_UP_DOOR);
						}
					}
					else if (doorSprite.getState() == DoorSprite.UP_MID)
					{
						monsterSprite.setLayer(layer + 1);
						int tempY = doorY + GameConsts.UP_MID_DOOR_SCRIPT[0];
						if (tempY > y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.UP_MID_DOOR);
					}
					else if (doorSprite.getState() == DoorSprite.MID_DOWN)
					{
						if (layer == 0)
						{
							layer = 1;
						}
						else if (layer == 1)
						{
							layer = 2;
						}
						monsterSprite.setLayer(layer);
						if (this.isLayer(layer, doorSet))
						{
							int tempX = doorX + GameConsts.MID_DOWN_DOOR_SCRIPT[0];
							int tempY = doorY + GameConsts.MID_DOWN_DOOR_SCRIPT[1];
							if (tempX > x)
							{
								monsterSprite.setX(tempX);
							}
							if (tempY > y)
							{
								monsterSprite.setY(tempY);
							}
							monsterSprite.setState(MonsterSprite.MID_DOWN_DOOR);
						}
						else
						{
							int tempY = doorY + GameConsts.FLY_DOWN_DOOR_SCRIPT[0];
							if (tempY > y)
							{
								monsterSprite.setY(tempY);
							}
							monsterSprite.setState(MonsterSprite.FLY_DOWN_DOOR);
						}
					}
					else if (doorSprite.getState() == DoorSprite.DOWN_MID)
					{
						monsterSprite.setLayer(layer);
						int tempY = doorY + GameConsts.DOWN_MID_DOOR_SCRIPT[0];
						if (tempY < y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.DOWN_MID_DOOR);
						;
					}
				}
			}
		}
	}

	private int getDoorSet(int x)
	{
		int doorSet = 0;
		for (int i = 0; i < GameConsts.DOOR_SET_POSITION.length; i++)
		{
			if (x < GameConsts.DOOR_SET_POSITION[i])
			{
				doorSet = i;
				break;
			}
		}
		return doorSet;
	}

	private boolean isLayer(int layer, int doorSet)
	{
		int[] doorSetArray = GameConsts.DOOR_SET[doorSet];
		boolean clearance = true;
		if (doors[doorSetArray[0]].getState() == DoorSprite.UP && layer == 0)
		{
			clearance = false;
		}
		else if (doors[doorSetArray[0]].getState() == DoorSprite.DOWN && layer == 1)
		{
			clearance = false;
		}
		else if (doors[doorSetArray[1]].getState() == DoorSprite.UP && layer == 1)
		{
			clearance = false;
		}
		else if (doors[doorSetArray[1]].getState() == DoorSprite.DOWN && layer == 2)
		{
			clearance = false;
		}
		return clearance;
	}
	private void setMoveState(MonsterSprite monsterSprite, int doorSet)
	{
		int[] doorSetArray = GameConsts.DOOR_SET[doorSet];
		int layer = monsterSprite.getLayer();
		if (layer == 0)
		{
			if (this.isZombieCreep(monsterSprite))
			{
				monsterSprite.setState(ZombieSprite.CREEP_DOWN);
			}
			else
			{
				monsterSprite.setState(MonsterSprite.MOVE_DOWN);
			}
		}
		else if (layer == 1)
		{
			if (doors[doorSetArray[0]].getState() == DoorSprite.DOWN)
			{
				if (this.isZombieCreep(monsterSprite))
				{
					monsterSprite.setState(ZombieSprite.CREEP_UP);
				}
				else
				{
					monsterSprite.setState(MonsterSprite.MOVE_UP);
				}
			}
			else if (doors[doorSetArray[1]].getState() == DoorSprite.UP)
			{
				if (this.isZombieCreep(monsterSprite))
				{
					monsterSprite.setState(ZombieSprite.CREEP_DOWN);
				}
				else
				{
					monsterSprite.setState(MonsterSprite.MOVE_DOWN);
				}
			}
		}
		else if (layer == 2)
		{
			if (this.isZombieCreep(monsterSprite))
			{
				monsterSprite.setState(ZombieSprite.CREEP_UP);
			}
			else
			{
				monsterSprite.setState(MonsterSprite.MOVE_UP);
			}
		}
	}

	private boolean isZombieCreep(MonsterSprite monsterSprite)
	{
		if (monsterSprite.getType() == MonsterSprite.TYPE_ZOMBIE)
		{
			if (monsterSprite.getState() == ZombieSprite.CREEP
					|| monsterSprite.getState() == ZombieSprite.CREEP_UP
					|| monsterSprite.getState() == ZombieSprite.CREEP_DOWN)
			{
				return true;
			}
		}
		return false;
	}

	public void setLayer(MonsterSprite monsterSprite)
	{
		int y = monsterSprite.getY();
		if (y < GameConsts.LAYER_POSITION[0])
		{
			monsterSprite.setLayer(0);
		}
		else if (y < GameConsts.LAYER_POSITION[1])
		{
			monsterSprite.setLayer(1);
		}
		else
		{
			monsterSprite.setLayer(2);
		}
	}

	private boolean isMoveChange(int y, int speed, boolean up)
	{
		if (up)
		{
			if (y > GameConsts.MONSTER_MID_POSITION[1]
					&& (y - speed) <= GameConsts.MONSTER_MID_POSITION[1])
			{
				return true;
			}
			else if (y > GameConsts.MONSTER_MID_POSITION[0]
					&& (y - speed) <= GameConsts.MONSTER_MID_POSITION[0])
			{
				return true;
			}
		}
		else
		{
			if (y < GameConsts.MONSTER_MID_POSITION[1]
					&& (y + speed) >= GameConsts.MONSTER_MID_POSITION[1])
			{
				return true;
			}
			else if (y < GameConsts.MONSTER_MID_POSITION[2]
					&& (y + speed) >= GameConsts.MONSTER_MID_POSITION[2])
			{
				return true;
			}
		}
		return false;
	}

	public void boomCollisionMonster(int layer)
	{
		for (int i = 0; i < monsters.size(); i++)
		{
			int key = monsters.keyAt(i);
			MonsterSprite monsterSprite = monsters.get(key);
			if (monsterSprite.getLayer() == layer)
			{
				if (monsterSprite.isLive())
				{
					this.addBoomSprite(monsterSprite);
					monsterSprite.setState(MonsterSprite.DEAD);
				}
			}
		}
	}
	private void disableSelect(int layer)
	{
		for(int j=0;j<selects[layer].length;j++)
		{
			selects[layer][j].setState(SelectSprite.DISABLE);
		}
		int bombInt=barSprite.getBombInt();
		if(bombInt<=0)
		{
			for(int k=0;k<selects.length;k++)
			{
				selects[k][SelectSprite.INT_BOMB].setState(SelectSprite.DISABLE);
			}
		}
	}
	private void enableSelect(int layer)
	{
		if(!teachMode)
		{
			int bombInt=barSprite.getBombInt();
			if(heros[layer].isAir())
			{
				selects[layer][SelectSprite.INT_BOOM].setState(SelectSprite.STAY);
			}
			if(bombInt>0)
			{
				selects[layer][SelectSprite.INT_BOMB].setState(SelectSprite.STAY);
			}
			if(items[layer]!=Item.NONE)
			{
				selects[layer][SelectSprite.INT_WEAPON].setState(SelectSprite.STAY);
			}
		}
	}
	public void update()
	{
		if (subState == START)
		{
			if(barSprite.getState()==UiSprite.BAR_START)
			{
				barSprite.update();
			}
			if (reallySprite.getState() == UiSprite.REALLY_END)
			{
				for(int i=0;i<selects.length;i++)
				{
					for(int j=0;j<selects[i].length;j++)
					{
						if(j==SelectSprite.INT_BOOM)
						{
							selects[i][j].setType(SelectSprite.TYPE_BOOM);
						}
						else if(j==SelectSprite.INT_BOMB)
						{
							selects[i][j].setType(SelectSprite.TYPE_BOMB);
						}
						else if(j==SelectSprite.INT_WEAPON)
						{
							if(items[i]==Item.BULLET)
							{
								selects[i][j].setType(SelectSprite.TYPE_BULLET);
							}
							else if(items[i]==Item.CROSS)
							{
								selects[i][j].setType(SelectSprite.TYPE_CROSS);
							}
							else if(items[i]==Item.SYRINGE)
							{
								selects[i][j].setType(SelectSprite.TYPE_SYRINGE);
							}
						}
					}
					this.enableSelect(i);
				}
				
				for(int i=0;i<doors.length;i++)
				{
					doors[i].setSelectTpye(DoorSprite.TYPE_SELECT);
				}
				this.updateSprite(heros);
				subState = PLAY;
			}
		}
		else if (subState == PAUSE)
		{
			menuSprite.update();
		}
		if (subState == PLAY)
		{
			for(int i=0;i<selects.length;i++)
			{
				for(int j=0;j<selects[i].length;j++)
				{
					SelectSprite selectSprite=selects[i][j];
					if(selectSprite.getState()==SelectSprite.SELECT_END)
					{
						if(j==SelectSprite.INT_BOOM)
						{
							this.disableSelect(i);
							heros[i].setState(HeroSprite.BOOM);
							heros[i].setAir(false);
							heros[i].setMp(0);
							this.playMusic(MusicConfig.BURST);
						}
						else if(j==SelectSprite.INT_BOMB)
						{
							this.disableSelect(i);
							heros[i].setState(HeroSprite.TOSS);
							this.playMusic(MusicConfig.BOMB);
						}
						else if(j==SelectSprite.INT_WEAPON)
						{
							int type=selectSprite.getType();
							int weaponType = heros[i].getWeaponType();
							if(weaponType==ArrowSprite.TYPE_ARROW)
							{
								selectSprite.setType(SelectSprite.TYPE_ARROW);
							}
							else if(weaponType==ArrowSprite.TYPE_CROSS)
							{
								selectSprite.setType(SelectSprite.TYPE_CROSS);
							}
							else if(weaponType==ArrowSprite.TYPE_BULLET)
							{
								selectSprite.setType(SelectSprite.TYPE_BULLET);
							}
							else if(weaponType==ArrowSprite.TYPE_SYRING)
							{
								selectSprite.setType(SelectSprite.TYPE_SYRINGE);
							}
							if(type==SelectSprite.TYPE_ARROW)
							{
								heros[i].setWeaponType(ArrowSprite.TYPE_ARROW);
							}
							else if(type==SelectSprite.TYPE_CROSS)
							{
								heros[i].setWeaponType(ArrowSprite.TYPE_CROSS);
							}
							else if(type==SelectSprite.TYPE_BULLET)
							{
								heros[i].setWeaponType(ArrowSprite.TYPE_BULLET);
							}
							else if(type==SelectSprite.TYPE_SYRINGE)
							{
								heros[i].setWeaponType(ArrowSprite.TYPE_SYRING);
							}
							if(teachMode)
							{
								selectSprite.setState(SelectSprite.DISABLE);
							}
							else
							{
								selectSprite.setState(SelectSprite.STAY);
							}
						}
					}
					selects[i][j].update();
				}
			}
			for (int i = 0; i < airs.size(); i++)
			{
				int key = airs.keyAt(i);
				AirSprite airSprite = airs.get(key);
				airSprite.update();
				if (airSprite.getState() == Sprite.DISABLE)
				{
					airs.remove(key);
				}
			}
			for (int i = 0; i < doors.length; i++)
			{
				DoorSprite doorSprite = doors[i];
				if (doorSprite.getMoveType() != DoorSprite.STAY)
				{
					this.playMusic(MusicConfig.DOOR);
					doorSprite.setState(doorSprite.getMoveType());
					doorSprite.setMoveType(DoorSprite.STAY);
				}
				doorSprite.update();
				if (doorSprite.getState() == DoorSprite.MID_DOWN
						|| doorSprite.getState() == DoorSprite.DOWN_MID
						|| doorSprite.getState() == DoorSprite.MID_UP
						|| doorSprite.getState() == DoorSprite.UP_MID)
				{
					this.isCollisionMonster(doors[i], i);
				}
			}
			int[] attackType = new int[3];
			for (int i = 0; i < monsters.size(); i++)
			{
				int key = monsters.keyAt(i);
				MonsterSprite monsterSprite = monsters.get(key);
				monsterSprite.update();
				int x = monsterSprite.getX();
				int y = monsterSprite.getY();
				if (monsterSprite.getState() == MonsterSprite.MID_UP_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.UP)
					{
						int doorX = doorSprite.getX();
						int tempX = doorX + GameConsts.MID_UP_DOOR_SCRIPT[2];
						if (tempX > x)
						{
							monsterSprite.setX(tempX);
						}
						monsterSprite.setState(MonsterSprite.MOVE);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.FLY_UP_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.UP)
					{
						int doorY = doorSprite.getY();
						int tempY = doorY + GameConsts.FLY_UP_DOOR_SCRIPT[1];
						if (tempY < y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.MOVE_UP);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.UP_MID_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.MID)
					{
						int doorY = doorSprite.getY();
						int tempY = doorY + GameConsts.UP_MID_DOOR_SCRIPT[1];
						if (tempY > y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.MOVE_DOWN);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.MID_DOWN_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.DOWN)
					{
						int doorX = doorSprite.getX();
						int tempX = doorX + GameConsts.MID_DOWN_DOOR_SCRIPT[2];
						if (tempX > x)
						{
							monsterSprite.setX(tempX);
						}
						monsterSprite.setState(MonsterSprite.MOVE);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.FLY_DOWN_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.DOWN)
					{
						int doorY = doorSprite.getY();
						int tempY = doorY + GameConsts.FLY_DOWN_DOOR_SCRIPT[1];
						if (tempY > y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.MOVE_DOWN);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.DOWN_MID_DOOR)
				{
					int door = monsterSprite.getDoor();
					DoorSprite doorSprite = doors[door];
					if (doorSprite.getState() == DoorSprite.MID)
					{
						int doorY = doorSprite.getY();
						int tempY = doorY + GameConsts.DOWN_MID_DOOR_SCRIPT[1];
						if (tempY < y)
						{
							monsterSprite.setY(tempY);
						}
						monsterSprite.setState(MonsterSprite.MOVE_UP);
					}
				}
				else if (monsterSprite.getState() == MonsterSprite.ATTACK)
				{
					if (!this.isAttackMonster(monsterSprite) && !monsterSprite.isAttack()
							&& monsterSprite.isVampire())
					{
						monsterSprite.setState(MonsterSprite.MOVE);
					}
					else if (monsterSprite.isAttackHit())
					{
						if (monsterSprite.isVampire())
						{
							this.addBatSprite(monsterSprite);
						}
						else
						{
							this.setCitywall(monsterSprite.getAttack());
						}
					}
				}
				else if (monsterSprite.getState() == Sprite.DISABLE)
				{
					int type=monsterSprite.getType();
					int layer=monsterSprite.getLayer();
					if(type==MonsterSprite.TYPE_VAMPIRE)
					{
						int vampireInt=monster[layer].getVampireInt()+1;
						monster[layer].setVampireInt(vampireInt);
					}
					else if(type==MonsterSprite.TYPE_WEREWOLVES)
					{
						int werewolvesInt=monster[layer].getWerewolvesInt()+1;
						monster[layer].setWerewolvesInt(werewolvesInt);
					}
					else if(type==MonsterSprite.TYPE_ZOMBIE)
					{
						int zombieInt=monster[layer].getZombieInt()+1;
						monster[layer].setZombieInt(zombieInt);
					}
					monsters.remove(key);
				}
				this.setAttackType(monsterSprite, attackType);
			}
			for (int i = 0; i < bats.size(); i++)
			{
				int key = bats.keyAt(i);
				ArrowSprite arrowSprite = bats.get(key);
				arrowSprite.update();
				if (arrowSprite.getState() == Sprite.DISABLE)
				{
					bats.remove(key);
				}
			}
			for (int i = 0; i < arrows.size(); i++)
			{
				int key = arrows.keyAt(i);
				ArrowSprite arrowSprite = arrows.get(key);
				arrowSprite.update();
				if (arrowSprite.getState() == Sprite.DISABLE)
				{
					arrows.remove(key);
				}
			}
			for (int i = 0; i < heros.length; i++)
			{
				HeroSprite heroSprite = heros[i];
				heroSprite.update();
				if (heroSprite.getState() == HeroSprite.ARROW)
				{
					this.addArrowSprite(heroSprite, i);
				}
				else if (heroSprite.getState() == HeroSprite.TOSS_END)
				{
					this.addBurstSprite(heroSprite,i);
				}
				else if (heroSprite.getState() == HeroSprite.BOOM_END)
				{
					this.boomCollisionMonster(i);
					if(heroSprite.isBoomEnd())
					{
						this.enableSelect(i);
					}
				}
			}
			for (int i = 0; i < attackType.length; i++)
			{
				HeroSprite heroSprite = heros[i];
				if (attackType[i] == ATTACK_NONE)
				{
					if (heroSprite.getState() == HeroSprite.SHOOT)
					{
						heroSprite.setState(HeroSprite.STAY);
					}
				}
				else if (attackType[i] == ATTACK_SHOOT)
				{
					if (heroSprite.getState() == HeroSprite.STAY)
					{
						heroSprite.setState(HeroSprite.SHOOT);
					}
				}
				else if (attackType[i] == ATTACK_STONE)
				{
					if (heroSprite.getState() == HeroSprite.STAY)
					{
						heroSprite.setState(HeroSprite.SHOOT);
					}
				}
			}
			this.updateSprite(walls);
			for (int i = 0; i < bursts.size(); i++)
			{
				int key = bursts.keyAt(i);
				BurstSprite burstSprite = bursts.get(key);
				burstSprite.update();
				if (burstSprite.getState() == Sprite.DISABLE)
				{
					this.enableSelect(burstSprite.getLayer());
					bursts.remove(key);
				}
				else if(burstSprite.getState() == BurstSprite.BURST_END)
				{
					for (int j = 0; j < monsters.size(); j++)
					{
						int keyj = monsters.keyAt(j);
						MonsterSprite monsterSprite = monsters.get(keyj);
						
						if (monsterSprite.isLive()&&
							monsterSprite.getState()!=MonsterSprite.HURT_STONE&&
							burstSprite.isCollision(monsterSprite)
							)
						{
							monsterSprite.setState(MonsterSprite.HURT_STONE);
						}
					}
				}
			}
			barSprite.update();
			int time = barSprite.getTime();
			if (this.isHasScript(barrierSet, scriptInt))
			{
				int[] script = barrierSet[scriptInt];
				while (this.isBorn(script, time))
				{
					scriptInt++;
					if(script[1]==MonsterSprite.TYPE_TEACH)
					{
						if(script[2]==FrameSprite.DISABLE)
						{
							this.disableSelect();
							teachMode=true;
							barSprite.setBombInt(1);
							break;
						}
						else
						{
							if(script[2]==FrameSprite.TYPE_DOOR_UP||
							   script[2]==FrameSprite.TYPE_DOOR_LEFT)
							{
								doors[0].setSelectTpye(DoorSprite.TYPE_SELECT);
							}
							else if(script[2]==FrameSprite.TYPE_ATTACK01)
							{
								selects[1][SelectSprite.INT_WEAPON].setType(SelectSprite.TYPE_BULLET);
								selects[1][SelectSprite.INT_WEAPON].setState(SelectSprite.STAY);
							}
							else if(script[2]==FrameSprite.TYPE_ATTACK02)
							{
								selects[1][SelectSprite.INT_WEAPON].setType(SelectSprite.TYPE_ARROW);
								selects[1][SelectSprite.INT_WEAPON].setState(SelectSprite.STAY);
							}
							else if(script[2]==FrameSprite.TYPE_BOMB)
							{
								selects[1][SelectSprite.INT_BOMB].setType(SelectSprite.TYPE_BOMB);
								selects[1][SelectSprite.INT_BOMB].setState(SelectSprite.STAY);
							}
							else if(script[2]==FrameSprite.TYPE_AIR)
							{
								selects[1][SelectSprite.INT_BOOM].setType(SelectSprite.TYPE_BOOM);
								selects[1][SelectSprite.INT_BOOM].setState(SelectSprite.STAY);
							}
							talkSprite.setType(script[2]);
							talkSprite.setState(FrameSprite.START);
							subState=TEACH;
							break;
						}
					}
					else
					{
						this.addMonsterSprite(script[2], script[1]);
						if (this.isHasScript(barrierSet, scriptInt))
						{
							script = barrierSet[scriptInt];
						}
						else
						{
							break;
						}
					}
				}
			}
			else
			{
				if (monsters.size() == 0)
				{
					for (int i = 0; i < heros.length; i++)
					{
						reallySprite.setState(UiSprite.WIN);
						heros[i].setState(HeroSprite.WIN);
					}
					disableSelect();
					this.resetDrawables();
					subState = WIN;
				}
			}
		}
		else if (subState == DESTROY)
		{
			citywallSprite.update();
			if (citywallSprite.getState() == CitywallSprite.DESTROY_END)
			{
				this.resetDrawables();
				subState = FAILURE;
				for (int i = 0; i < heros.length; i++)
				{
					reallySprite.setState(UiSprite.LOSE);
					heros[i].setState(HeroSprite.FAILURE);
				}
			}
		}
		else if (subState == WIN||subState == FAILURE)
		{
			reallySprite.update();
			if(buttonSprite.getState()==ButtonSprite.DISABLE)
			{
				if(reallySprite.getState()==UiSprite.WIN_END||reallySprite.getState()==UiSprite.LOSE_END)
				{
					buttonSprite.setState(ButtonSprite.STAY);
				}
			}
			else if(buttonSprite.getState()==ButtonSprite.PUSH_END)
			{
				if(subState == WIN)
				{
					gameBean.setWin(true);
				}
				else
				{
					gameBean.setWin(false);
				}
				gameBean.setMonster(monster);
				if(!teachMode)
				{
					gameBean.setBombInt(barSprite.getBombInt());
				}
				this.stopMusic(MusicConfig.MUSIC02);
				this.setNextState(ModelConfig.RESULT);
				this.addAd();
			}
			buttonSprite.update();
			this.updateSprite(heros);
		}
	}

	private void disableSelect()
	{
		for(int i =0;i<doors.length;i++)
		{
			doors[i].setSelectTpye(DoorSprite.TYPE_NONE);
		}
		for(int i=0;i<selects.length;i++)
		{
			for(int j=0;j<selects[i].length;j++)
			{
				selects[i][j].setState(SelectSprite.DISABLE);
			}
		}
	}
	private boolean isHasScript(int[][] script, int scriptInt)
	{
		if (scriptInt < script.length)
		{
			return true;
		}
		return false;
	}

	private boolean isBorn(int[] script, int time)
	{
		if (script[0] == time)
		{
			return true;
		}
		return false;
	}

	private void setCitywall(int attack)
	{
		int hp = barSprite.getHp();
		hp = hp - attack;
		if (hp < 0)
		{
			hp = 0;
			citywallSprite.setState(CitywallSprite.DESTROY);
			this.disableSelect();
			subState = DESTROY;
		}
		citywallSprite.setHpInt(barSprite.getMaxHp(), barSprite.getHp());
		barSprite.setHp(hp);
	}

	private void setAttackType(MonsterSprite monsterSprite, int[] attackType)
	{
		int layer = monsterSprite.getLayer();
		if (attackType[layer] == ATTACK_NONE)
		{
			if (monsterSprite.getState() == MonsterSprite.MOVE)
			{
				if (this.isAttackMonster(monsterSprite))
				{
					attackType[layer] = ATTACK_SHOOT;
				}
			}
			else if (monsterSprite.isLiveAttack())
			{
				attackType[layer] = ATTACK_STONE;
			}
			else if (monsterSprite.getState() == MonsterSprite.ATTACK
					|| monsterSprite.getState() == MonsterSprite.STAY)
			{
				if (monsterSprite.isVampire())
				{
					attackType[layer] = ATTACK_SHOOT;
				}
			}

		}
		else if (attackType[layer] == ATTACK_SHOOT)
		{
			if (monsterSprite.isLiveAttack())
			{
				attackType[layer] = ATTACK_STONE;
			}
		}
	}

	private boolean isAttackMonster(MonsterSprite monsterSprite)
	{
		int layer = monsterSprite.getLayer();
		int doorSet = this.getDoorSet(monsterSprite.getX());
		if (doorSet == 0)
		{
			if (this.isLayer(layer, 0) && this.isLayer(layer, 1))
			{
				return true;
			}
		}
		else if (doorSet == 1)
		{
			if (this.isLayer(layer, 1))
			{
				return true;
			}
		}
		return false;
	}

	private int[] getRandomLayer(int no)
	{
		int[] layer = null;
		if (no == 0)
		{
			layer = new int[0];
		}
		else if (no == 1)
		{
			layer = new int[1];
			layer[0] = random.nextInt(3);
		}
		else if (no == 2)
		{
			layer = new int[2];
			layer[0] = random.nextInt(3);
			int add = random.nextInt(2);
			if (add == 0)
			{
				layer[1] = layer[0] + 1;
				if (layer[1] > 2)
				{
					layer[1] = 0;
				}
			}
			else
			{
				layer[1] = layer[0] - 1;
				if (layer[1] < 0)
				{
					layer[1] = 2;
				}
			}

		}
		else
		{
			layer = new int[3];
			for (int i = 0; i < layer.length; i++)
			{
				layer[i] = i;
			}
		}
		return layer;
	}

	private void updateSprite(Sprite[] sprites)
	{
		for (int i = 0; i < sprites.length; i++)
		{
			sprites[i].update();
		}
	}

	@Override
	public void drawView(Canvas canvas)
	{
		if (subState==EFFECT||subState == START || subState == PLAY || subState == DESTROY || 
			subState == FAILURE|| subState == WIN || subState == PAUSE|| subState==TEACH)
		{
			backgroundSprite.drawView(canvas);
			for (int i = 0; i < arrows.size(); i++)
			{
				int key = arrows.keyAt(i);
				arrows.get(key).drawShadowView(canvas);
			}
			for (int i = 0; i < bats.size(); i++)
			{
				int key = bats.keyAt(i);
				bats.get(key).drawShadowView(canvas);
			}
			Vector<MonsterSprite> monsterArray = new Vector<MonsterSprite>();
			for (int i = 0; i < monsters.size(); i++)
			{
				int key = monsters.keyAt(i);
				MonsterSprite monsterSprite = monsters.get(key);
				monsterArray.add(monsterSprite);
			}
			this.sort(monsterArray);
			this.drawSprite(canvas, monsterArray, 0);
			this.drawSprite(canvas, walls, 0);
			this.drawSprite(canvas, doors, 0);
			this.drawSprite(canvas, monsterArray, 1);
			this.drawSprite(canvas, walls, 1);
			this.drawSprite(canvas, doors, 1);
			this.drawSprite(canvas, monsterArray, 2);
			citywallSprite.drawView(canvas);
			this.drawSprite(canvas, airs, 0);
			this.drawSprite(canvas, bats, 0);
			this.drawSprite(canvas, heros, 0);
			this.drawSprite(canvas, bursts);
			this.drawSprite(canvas, arrows);
			barSprite.drawView(canvas);
			reallySprite.drawView(canvas);
			for(int i=0;i<selects.length;i++)
			{
				for(int j=0;j<selects[i].length;j++)
				{
					selects[i][j].drawView(canvas);
				}
			}
			this.drawSprite(canvas, airs, 1);
			buttonSprite.drawView(canvas);
			talkSprite.drawView(canvas);
			menuSprite.drawView(canvas);
			effectSprite.drawView(canvas);
			
		}
	}

	private void sort(Vector<MonsterSprite> monsterArray)
	{// ®ðªw±Æ§Ç
		for (int i = 0; i < monsterArray.size() - 1; i++)
		{
			for (int j = 0; j < monsterArray.size() - i - 1; j++)
			{
				if (monsterArray.get(j + 1).getY() < monsterArray.get(j).getY())
				{
					MonsterSprite temp = monsterArray.get(j + 1);// ¥æ´«
					monsterArray.remove(j + 1);
					monsterArray.insertElementAt(temp, j);
				}
			}
		}
	}

	private void drawSprite(Canvas canvas, Sprite[] sprites, int layer)
	{
		for (int i = 0; i < sprites.length; i++)
		{
			sprites[i].drawView(canvas, layer);
		}
	}

	private void drawSprite(Canvas canvas, Vector sprites, int layer)
	{
		for (int i = 0; i < sprites.size(); i++)
		{
			Sprite sprite = (Sprite) sprites.get(i);
			sprite.drawView(canvas, layer);
		}
	}

	private void drawSprite(Canvas canvas, SparseArray sprites)
	{
		this.drawSprite(canvas, sprites, -1);
	}

	private void drawSprite(Canvas canvas, SparseArray sprites, int layer)
	{
		for (int i = 0; i < sprites.size(); i++)
		{
			int key = sprites.keyAt(i);
			Sprite sprite = (Sprite) sprites.get(key);
			if (layer == -1)
			{
				sprite.drawView(canvas);
			}
			else
			{
				sprite.drawView(canvas, layer);
			}
		}
	}

	public void onKeyDown(int keyCode)
	{

	}

	public void onKeyUp(int keyCode)
	{

	}

	public void onTouchEvent(int x, int y, MotionEvent event, int touchState)
	{
		if (subState == PLAY)
		{
			if(!teachMode)
			{
				if (event.getAction() == MotionEvent.ACTION_DOWN)
				{
					for(int i=0;i<selects.length;i++)
					{
						for(int j=0;j<selects[i].length;j++)
						{
							SelectSprite selectSprite=selects[i][j];
							if(selectSprite.getState()==SelectSprite.STAY&&
							   selectSprite.isCollision(x, y))
							{
								if(j==SelectSprite.INT_BOOM)
								{
									if(heros[i].isWork()&&
									   !selects[i][SelectSprite.INT_BOMB].isSelect())
									{
										selectSprite.setState(SelectSprite.SELECT);
									}
								}
								else if(j==SelectSprite.INT_BOMB)
								{	
									if(heros[i].isWork()&&
									   !selects[i][SelectSprite.INT_BOOM].isSelect())
									{
										int bombInt=barSprite.getBombInt();
										if(bombInt>0)
										{
											bombInt--;
											selectSprite.setState(SelectSprite.SELECT);
											barSprite.setBombInt(bombInt);
										}
									}
								}
								else
								{
									selectSprite.setState(SelectSprite.SELECT);
								}
							}
						}
					}
				}
				else if (event.getAction() == MotionEvent.ACTION_MOVE)
				{
					for (int i = 0; i < doors.length; i++)
					{
						if (doors[i].isCollision(x, y))
						{
							if ((touchState == TOUCH_DOWN || touchState == TOUCH_RIGHT)
									&& doors[i].getState() == DoorSprite.MID)
							{
								doors[i].setMoveType(DoorSprite.MID_DOWN);
							}
							else if ((touchState == TOUCH_UP || touchState == TOUCH_RIGHT)
									&& doors[i].getState() == DoorSprite.MID)
							{
								doors[i].setMoveType(DoorSprite.MID_UP);
							}
							else if ((touchState == TOUCH_LEFT || touchState == TOUCH_DOWN)
									&& doors[i].getState() == DoorSprite.UP)
							{
								doors[i].setMoveType(DoorSprite.UP_MID);
							}
							else if ((touchState == TOUCH_LEFT || touchState == TOUCH_UP)
									&& doors[i].getState() == DoorSprite.DOWN)
							{
								doors[i].setMoveType(DoorSprite.DOWN_MID);
							}
						}
					}
				}
			}
		}
		if(subState == PLAY||subState==START||
		   subState== DESTROY ||subState== FAILURE ||
		   subState == WIN||subState==TEACH)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				if (barSprite.isCollision(x, y))
				{
					this.menuPause();
				}
				else if(subState== FAILURE ||subState == WIN)
				{
					if(buttonSprite.isCollision(x, y))
					{
						if(buttonSprite.getState()==ButtonSprite.STAY)
						{
							this.playMusic(MusicConfig.BUTTON);
							buttonSprite.setState(ButtonSprite.PUSH);
						}
					}
				}
			}
		}
		else if (subState == PAUSE)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				if (barSprite.isCollision(x, y))
				{
					menuContinue();
				}
				else if(menuSprite.isCollisionMenu(UiSprite.MENU_LOBBY, x, y))
				{
					this.stopMusic(MusicConfig.MUSIC02);
					this.setNextState(ModelConfig.LOBBY);
					this.addAd();
				}
				else if(menuSprite.isCollisionMenu(UiSprite.MENU_RESTART, x, y))
				{
					this.stopMusic(MusicConfig.MUSIC02);
					this.setNextState(ModelConfig.RESTART);
				}
				else if(menuSprite.isCollisionMenu(UiSprite.MENU_CONTINUE, x, y))
				{
					menuContinue();
				}
			}
		}
		if(subState == TEACH)
		{
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
				int type = barrierSet[scriptInt-1][2];
				if(type==FrameSprite.TYPE_DOOR_UP)
				{
					if (doors[0].isCollision(x, y)&&touchState == TOUCH_UP)
					{
						doors[0].setSelectTpye(DoorSprite.TYPE_NONE);
						doors[0].setMoveType(DoorSprite.MID_UP);
						this.playMusic(MusicConfig.DOOR);
						talkSprite.setState(FrameSprite.DISABLE);
						subState=PLAY;
					}
					else
					{
						talkSprite.setState(FrameSprite.START);
					}
				}
				else if(type==FrameSprite.TYPE_DOOR_LEFT)
				{
					if (doors[0].isCollision(x, y)&&touchState == TOUCH_LEFT)
					{
						doors[0].setSelectTpye(DoorSprite.TYPE_NONE);
						doors[0].setMoveType(DoorSprite.UP_MID);
						this.playMusic(MusicConfig.DOOR);
						talkSprite.setState(FrameSprite.DISABLE);
						subState=PLAY;
					}
					else
					{
						talkSprite.setState(FrameSprite.START);
					}
				}
			}
			else if(event.getAction() == MotionEvent.ACTION_DOWN)
			{
				int type = barrierSet[scriptInt-1][2];
				if(type==FrameSprite.TYPE_ATTACK01||
				   type==FrameSprite.TYPE_ATTACK02)
				{
					if(selects[1][SelectSprite.INT_WEAPON].isCollision(x, y))
					{
						selects[1][SelectSprite.INT_WEAPON].setState(SelectSprite.SELECT);
						talkSprite.setState(FrameSprite.DISABLE);
						subState=PLAY;
					}
					else
					{
						talkSprite.setState(FrameSprite.START);
					}
				}
				else if(type==FrameSprite.TYPE_BOMB)
				{
					if(selects[1][SelectSprite.INT_BOMB].isCollision(x, y))
					{
						selects[1][SelectSprite.INT_BOMB].setState(SelectSprite.SELECT);
						talkSprite.setState(FrameSprite.DISABLE);
						subState=PLAY;
					}
					else
					{
						talkSprite.setState(FrameSprite.START);
					}
				}
				else if(type==FrameSprite.TYPE_AIR)
				{
					if(selects[1][SelectSprite.INT_BOOM].isCollision(x, y))
					{
						selects[1][SelectSprite.INT_BOOM].setState(SelectSprite.SELECT);
						talkSprite.setState(FrameSprite.DISABLE);
						subState=PLAY;
					}
					else
					{
						talkSprite.setState(FrameSprite.START);
					}
				}
			}
		}
	}
	private void menuPause()
	{
		if (!barSprite.isPause())
		{
			barSprite.setPause(true);
			menuSprite.setState(UiSprite.MENU_PAUSE);
			perState = subState;
			subState = PAUSE;
		}
	}
	private void menuContinue()
	{
		if (barSprite.isPause())
		{
			barSprite.setPause(false);
			menuSprite.setState(Sprite.DISABLE);
			subState = perState;
		}
	}
	public void pause()
	{
		menuPause();
	}

	public void onBackKeyDown()
	{
		if(subState== FAILURE ||subState == WIN)
		{
			if(buttonSprite.getState()==ButtonSprite.STAY)
			{
				buttonSprite.setState(ButtonSprite.PUSH);
			}
		}
		else
		{
			menuPause();
		}
	}
}
