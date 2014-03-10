package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class ZombieSprite extends MonsterSprite
{
	public static final int CREEP = 116;
	public static final int CREEP_UP = 117;
	public static final int CREEP_DOWN = 118;
	public static final int TOPPLE = 119;

	public ZombieSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	@Override
	public void update()
	{
		super.updateMonster();
		if (state == MOVE || state == MID_UP_DOOR || state == MID_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_MOVE_SCRIPT.length);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_UP_SCRIPT.length);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_DOWN_SCRIPT.length);
		}
		else if (state == ATTACK)
		{
			if (this.nextScriptInt(GameConsts.ZOMBIE_ATTACK_SCRIPT.length))
			{
				this.setState(STAY);
			}
		}
		else if (state == DEAD)
		{
			if (this.nextScriptInt(GameConsts.ZOMBIE_DEAD_SCRIPT.length))
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
			if (this.nextScriptInt(GameConsts.ZOMBIE_WOUNDED_SCRIPT.length))
			{
				this.setState(DEAD);
			}
		}
		else if (state == STAY)
		{
			if (this.nextScriptInt(GameConsts.ZOMBIE_STAY_SCRIPT.length))
			{
				this.setState(ATTACK);
			}
		}
		else if (state == WOUNDED)
		{
			if (this.nextScriptInt(GameConsts.ZOMBIE_WOUNDED_SCRIPT.length))
			{
				this.setState(preState);
			}
		}
		else if (state == CREEP)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_CREEP_SCRIPT.length);
		}
		else if (state == CREEP_UP)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_CREEP_UP_SCRIPT.length);
		}
		else if (state == CREEP_DOWN)
		{
			this.nextScriptInt(GameConsts.ZOMBIE_CREEP_DOWN_SCRIPT.length);
		}
		else if (state == TOPPLE)
		{
			if (this.nextScriptInt(GameConsts.ZOMBIE_TOPPLE_SCRIPT.length))
			{
				if (preState == MOVE)
				{
					this.setState(CREEP);
				}
				else if (preState == MOVE_UP)
				{
					this.setState(CREEP_UP);
				}
				else if (preState == MOVE_DOWN)
				{
					this.setState(CREEP_DOWN);
				}
				else
				{
					this.setState(CREEP);
				}
			}
		}
	}

	@Override
	public void drawView(Canvas canvas)
	{
		if (state == MOVE || state == MID_UP_DOOR || state == MID_DOWN_DOOR)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_MOVE_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_UP_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_DOWN_SCRIPT[scriptInt], x, y);
		}
		else if (state == ATTACK)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_ATTACK_SCRIPT[scriptInt][0], x, y);
		}
		else if (state == DEAD)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_DEAD_SCRIPT[scriptInt], x, y);
		}
		else if (state == DEAD_END)
		{
			this.drawImage(canvas, ImageConfig.ZOMBIE_DEAD03, x, y, alpha);
		}
		else if (state == HURT_STONE)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_WOUNDED_SCRIPT[scriptInt], x
					+ GameConsts.HURT_STONE_POSITION, y);
		}
		else if (state == STAY)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_STAY_SCRIPT[scriptInt], x, y);
		}
		else if (state == WOUNDED)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_WOUNDED_SCRIPT[scriptInt], x, y);
		}
		else if (state == CREEP)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_CREEP_SCRIPT[scriptInt], x, y);
		}
		else if (state == CREEP_UP)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_CREEP_UP_SCRIPT[scriptInt], x, y);
		}
		else if (state == CREEP_DOWN)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_CREEP_DOWN_SCRIPT[scriptInt], x, y);
		}
		else if (state == TOPPLE)
		{
			this.drawImage(canvas, GameConsts.ZOMBIE_TOPPLE_SCRIPT[scriptInt], x, y);
		}
		super.drawMonster(canvas);
	}

	@Override
	public boolean isAttackHit()
	{
		return this.isAttackHit(GameConsts.ZOMBIE_ATTACK_SCRIPT);
	}
}
