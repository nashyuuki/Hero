package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class MonsterSprite extends Sprite
{
	public static final int MOVE = 1;
	public static final int MOVE_UP = 2;
	public static final int MOVE_DOWN = 3;
	public static final int MID_UP_DOOR = 4;
	public static final int FLY_UP_DOOR = 5;
	public static final int UP_MID_DOOR = 6;
	public static final int MID_DOWN_DOOR = 7;
	public static final int DOWN_MID_DOOR = 8;
	public static final int FLY_DOWN_DOOR = 9;
	public static final int ATTACK = 10;
	public static final int DEAD = 11;
	public static final int DEAD_END = 12;
	public static final int HURT_STONE = 13;
	public static final int STAY = 14;
	public static final int WOUNDED = 15;

	public static final int TYPE_TEACH = -1;
	public static final int TYPE_HERO = 0;
	public static final int TYPE_WEREWOLVES = 1;
	public static final int TYPE_ZOMBIE = 2;
	public static final int TYPE_VAMPIRE = 3;

	private int speed;
	private int door;
	public int alpha = 255;
	private boolean isHurt;
	private int maxHp;
	private int hp;
	private int type;
	private int attack;
	private boolean isAttack;

	public MonsterSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	public void updateMonster()
	{
		if (isHurt)
		{
			alpha = alpha - 100;
			if (alpha < 0)
			{
				isHurt = false;
			}
		}
	}

	@Override
	public void update()
	{
		this.updateMonster();
		if (state == MOVE || state == MID_UP_DOOR || state == MID_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.MONSTER_MOVE_SCRIPT.length);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.nextScriptInt(GameConsts.MONSTER_UP_SCRIPT.length);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.MONSTER_DOWN_SCRIPT.length);
		}
		else if (state == ATTACK)
		{
			if (this.nextScriptInt(GameConsts.MONSTER_ATTACK_SCRIPT.length))
			{
				this.setState(STAY);
			}
		}
		else if (state == DEAD)
		{
			if (this.nextScriptInt(GameConsts.MONSTER_DEAD_SCRIPT.length))
			{
				alpha = 255;
				this.setState(DEAD_END);
			}
		}
		else if (state == DEAD_END)
		{
			alpha = alpha - 10;
			if (alpha < 0)
			{
				this.setState(DISABLE);
			}
		}
		else if (state == HURT_STONE)
		{
			if (this.nextScriptInt(GameConsts.MONSTER_WOUNDED_SCRIPT.length))
			{
				this.setState(DEAD);
			}
		}
		else if (state == STAY)
		{
			if (this.nextScriptInt(GameConsts.MONSTER_STAY_SCRIPT.length))
			{
				this.setState(ATTACK);
			}
		}
		else if (state == WOUNDED)
		{
			if (this.nextScriptInt(GameConsts.MONSTER_WOUNDED_SCRIPT.length))
			{
				this.setState(preState);
			}
		}
	}

	@Override
	public void drawView(Canvas canvas)
	{
		if (state == MOVE || state == MID_UP_DOOR || state == MID_DOWN_DOOR)
		{
			this.drawImage(canvas, GameConsts.MONSTER_MOVE_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.drawImage(canvas, GameConsts.MONSTER_UP_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.drawImage(canvas, GameConsts.MONSTER_DOWN_SCRIPT[scriptInt], x, y);
		}
		else if (state == ATTACK)
		{
			this.drawImage(canvas, GameConsts.MONSTER_ATTACK_SCRIPT[scriptInt][0], x, y);
		}
		else if (state == DEAD)
		{
			this.drawImage(canvas, GameConsts.MONSTER_DEAD_SCRIPT[scriptInt], x, y);
		}
		else if (state == DEAD_END)
		{
			this.drawImage(canvas, ImageConfig.MONSTER_DEAD05, x, y, alpha);
		}
		else if (state == HURT_STONE)
		{
			this.drawImage(canvas, GameConsts.MONSTER_WOUNDED_SCRIPT[scriptInt], x
					+ GameConsts.HURT_STONE_POSITION, y);
		}
		else if (state == STAY)
		{
			this.drawImage(canvas, GameConsts.MONSTER_STAY_SCRIPT[scriptInt], x, y);
		}
		else if (state == WOUNDED)
		{
			this.drawImage(canvas, GameConsts.MONSTER_WOUNDED_SCRIPT[scriptInt], x, y);
		}
		this.drawMonster(canvas);
	}

	public void drawMonster(Canvas canvas)
	{
		if (isHurt || state == DEAD)
		{
			this.drawRect(canvas, x + GameConsts.MONSTER_HP_POSITION[0], y
					+ GameConsts.MONSTER_HP_POSITION[1], GameConsts.MONSTER_HP_POSITION[2] * hp
					/ maxHp, GameConsts.MONSTER_HP_POSITION[3], alpha, 255, 0, 0);
			this.drawStrokeRect(canvas,
								x + GameConsts.MONSTER_HP_POSITION[0],
								y + GameConsts.MONSTER_HP_POSITION[1],
								GameConsts.MONSTER_HP_POSITION[2],
								GameConsts.MONSTER_HP_POSITION[3],
								alpha,
								0,
								0,
								0,
								GameConsts.MONSTER_HP_POSITION[4]);
		}
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getDoor()
	{
		return door;
	}

	public void setDoor(int door)
	{
		this.door = door;
	}

	public int getMaxHp()
	{
		return maxHp;
	}

	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}

	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}

	public boolean isHurt()
	{
		return isHurt;
	}

	public void setHurt(boolean isHurt)
	{
		this.isHurt = isHurt;
		if (isHurt)
		{
			alpha = 255;
		}
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public boolean isAttack()
	{
		return isAttack;
	}

	public void setAttack(boolean isAttack)
	{
		this.isAttack = isAttack;
	}

	public boolean isLive()
	{
		if (state != MonsterSprite.DEAD && state != MonsterSprite.DEAD_END)
		{
			return true;
		}
		return false;
	}

	public boolean isLiveAttack()
	{
		if (isAttack)
		{
			if (this.isLive())
			{
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean isVampire()
	{
		if (type == TYPE_VAMPIRE)
		{
			return true;
		}
		return false;
	}

	public boolean isAttackHit()
	{
		return this.isAttackHit(GameConsts.MONSTER_ATTACK_SCRIPT);
	}

	public boolean isAttackHit(int[][] script)
	{
		if (state == ATTACK)
		{
			if (script[scriptInt][1] == 1)
			{
				return true;
			}
		}
		return false;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

}
