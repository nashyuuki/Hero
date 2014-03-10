package com.android.herodefender;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;
import com.android.herodefender.sprite.BackgroundSprite;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.FrameSprite;
import com.android.herodefender.sprite.Item;
import com.android.herodefender.sprite.Monster;
import com.android.herodefender.sprite.WordSprite;

public class ResultModel extends CoreModel
{
	private static final int RESULT=0;
	private BackgroundSprite backgroundSprite;
	private FrameSprite heroSprite;
	private WordSprite[] words;
	private ButtonSprite buttonSprite;
	private FrameSprite talkSprite;
	private int scriptInt=0;
	private int time;
	private String text=null;
	public ResultModel(GameBean gameBean)
	{
		super(gameBean);
	}
	public void init()
	{
		Monster[] monster=gameBean.getMonster();
		Item[][] items=gameBean.getPicks();
		boolean win=gameBean.isWin();
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.RESULT);
		heroSprite=new FrameSprite(gameBean);
		heroSprite.setPosition(GameConsts.RESULT_HERO_POSITION);
		heroSprite.setState(FrameSprite.HERO);
		words=new WordSprite[GameConsts.RESULT_WORD_POSITION.length];
		
		if(win)
		{
			text=GameConsts.TALK_RESULT_TEXT[0][0];
		}
		else
		{
			text=GameConsts.TALK_RESULT_TEXT[0][1];
		}
		int[][] weapon=this.isWeapon(items,win,monster);
		for(int i=0;i<words.length;i++)
		{
			words[i]=new WordSprite(this.getImageConfig());
			words[i].setPosition(GameConsts.RESULT_WORD_POSITION[i]);
			words[i].setHeroInt(i);
			words[i].setState(WordSprite.RESULT);
			words[i].setVampireInt(monster[i].getVampireInt());
			words[i].setWerewolvesInt(monster[i].getWerewolvesInt());
			words[i].setZombieInt(monster[i].getZombieInt());
			
			words[i].setWeapon(weapon[i]);
			for(int j=0;j<weapon.length;j++)
			{
				if(weapon[i][j]==WordSprite.TYPE_WEAPON)
				{
					text=text+"\n"+GameConsts.TALK_RESULT_TEXT[1][i]+
							GameConsts.TALK_RESULT_TEXT[0][2]+"\n"+
							GameConsts.TALK_RESULT_TEXT[2][j];
				}
			}
		}
		buttonSprite=new ButtonSprite(this.getImageConfig());
		buttonSprite.setType(ButtonSprite.TYPE_BACK);
		buttonSprite.setState(ButtonSprite.STAY);
		buttonSprite.setCollisionArea(GameConsts.BARRIER_BUTTON_COLLISION[3]);
		buttonSprite.setPosition(GameConsts.RESULT_BACK_POSITION);
		talkSprite=new FrameSprite(gameBean);
		talkSprite.setType(FrameSprite.TYPE_RESULT);
		talkSprite.setTalk(text);
		this.playMusic(MusicConfig.RESULT);
		
	}
	private void addBombInt()
	{
		int bombInt=gameBean.getBombInt();
		if(bombInt<GameConsts.BOMB_INT)
		{
			bombInt++;
			gameBean.setBombInt(bombInt);
		}
	}
	public int[][] isWeapon(Item[][] items,boolean win,Monster[] monster)
	{
		int[][] weapon=new int[3][3];
		int barrierInt=gameBean.getBarrierInt();
		for(int i=0;i<monster.length;i++)
		{
			if(monster[i].getVampireInt()>=GameConsts.MONSTER_BOMB_INT)
			{
				weapon[i][2]=WordSprite.TYPE_BOMB;
				this.addBombInt();
			}
			else if(monster[i].getWerewolvesInt()>=GameConsts.MONSTER_BOMB_INT)
			{
				weapon[i][1]=WordSprite.TYPE_BOMB;
				this.addBombInt();
			}
			else if(monster[i].getZombieInt()>=GameConsts.MONSTER_BOMB_INT)
			{
				weapon[i][0]=WordSprite.TYPE_BOMB;
				this.addBombInt();
			}
		}
		
		if(win)
		{
			for(int i=0;i<BarrierConsts.WEAPON_SCRIPT.length;i++)
			{
				if(BarrierConsts.WEAPON_SCRIPT[i][0]==barrierInt)
				{
					int heroInt=BarrierConsts.WEAPON_SCRIPT[i][1];
					int weaponType=BarrierConsts.WEAPON_SCRIPT[i][2];
					weapon[heroInt][GameConsts.ITEM_TO_MONSTER[weaponType]]=WordSprite.TYPE_WEAPON;
					this.setItems(items, heroInt, weaponType);
				}
			}
		}
		return weapon;
	}
	private void win(boolean win)
	{
		if(win)
		{
			int barrierClear =gameBean.getBarrierClear();
			int barrierInt=gameBean.getBarrierInt();
			if(barrierInt<BarrierConsts.BARRIER_SET.length-1)
			{
				if(barrierInt==barrierClear)
				{
					gameBean.setBarrierClear(barrierClear+1);
					gameBean.setBarrierInt(barrierInt+1);
				}
				else
				{
					gameBean.setBarrierInt(barrierInt+1);
				}
			}
		}
	}
	private void setItems(Item[][] items,int heroInt,int weaponInt)
	{
		for(int i=0;i<items[heroInt].length;i++)
		{
			if(items[heroInt][i].getType()==weaponInt)
			{
				items[heroInt][i].setUseful(true);
			}
		}
	}
	public void updateView(long viewTime)
	{
		if(subState==RESULT)
		{
			talkSprite.update();
		}
	}
	public void update()
	{
		if(subState==RESULT)
		{
			
			for(int i=0;i<words.length;i++)
			{
				words[i].update();
			}
			if(buttonSprite.getState()==ButtonSprite.PUSH_END)
			{
				boolean win=gameBean.isWin();
				if(win&&gameBean.getBarrierInt()==(BarrierConsts.BARRIER_SET.length-1))
				{
					this.setNextState(ModelConfig.WIN);
				}
				else
				{
					this.setNextState(ModelConfig.BARRIER);
				}
				this.win(win);
			}
			if(scriptInt<GameConsts.RESULT_SCRIPT.length)
			{
				if(time==GameConsts.RESULT_SCRIPT[scriptInt])
				{
					if(scriptInt==GameConsts.RESULT_SCRIPT.length-1)
					{
						talkSprite.setTalk(text);
					}
					else
					{
						talkSprite.setTalk(GameConsts.RESULT_TEXT[scriptInt]);
					}
					talkSprite.setState(FrameSprite.START);
					scriptInt++;
				}
				time++;
			}
			buttonSprite.update();
		}
	}
	public void drawView(Canvas canvas)
	{
		if(subState==RESULT)
		{
			backgroundSprite.drawView(canvas);
			heroSprite.drawView(canvas);
			drawSprite(canvas,words);
			buttonSprite.drawView(canvas);
			talkSprite.drawView(canvas);
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
		if(subState==RESULT)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				if(buttonSprite.getState()==ButtonSprite.STAY)
				{
					if(buttonSprite.isCollision(x, y))
					{
						buttonSprite.setState(ButtonSprite.PUSH);
					}
				}
				if(talkSprite.getState()==FrameSprite.STAY)
				{
					talkSprite.setState(FrameSprite.DISABLE);
				}
			}
		}
	}
	public void onBackKeyDown()
	{
		if(buttonSprite.getState()==ButtonSprite.STAY)
		{
			buttonSprite.setState(ButtonSprite.PUSH);
		}
	}
	
}
