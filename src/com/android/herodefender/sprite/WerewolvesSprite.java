package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class WerewolvesSprite extends MonsterSprite
{

	public WerewolvesSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	@Override
	public void update()
	{
		super.updateMonster();
		if (state == MOVE || state == MID_UP_DOOR || state == MID_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.WEREWOLVES_MOVE_SCRIPT.length);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.nextScriptInt(GameConsts.WEREWOLVES_UP_SCRIPT.length);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.nextScriptInt(GameConsts.WEREWOLVES_DOWN_SCRIPT.length);
		}
		else if (state == ATTACK)
		{
			if (this.nextScriptInt(GameConsts.WEREWOLVES_ATTACK_SCRIPT.length))
			{
				this.setState(STAY);
			}
		}
		else if (state == DEAD)
		{
			if (this.nextScriptInt(GameConsts.WEREWOLVES_DEAD_SCRIPT.length))
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
			if (this.nextScriptInt(GameConsts.WEREWOLVES_WOUNDED_SCRIPT.length))
			{
				this.setState(DEAD);
			}
		}
		else if (state == STAY)
		{
			if (this.nextScriptInt(GameConsts.WEREWOLVES_STAY_SCRIPT.length))
			{
				this.setState(ATTACK);
			}
		}
		else if (state == WOUNDED)
		{
			if (this.nextScriptInt(GameConsts.WEREWOLVES_WOUNDED_SCRIPT.length))
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
			this.drawImage(canvas, GameConsts.WEREWOLVES_MOVE_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_UP || state == DOWN_MID_DOOR || state == FLY_UP_DOOR)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_UP_SCRIPT[scriptInt], x, y);
		}
		else if (state == MOVE_DOWN || state == UP_MID_DOOR || state == FLY_DOWN_DOOR)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_DOWN_SCRIPT[scriptInt], x, y);
		}
		else if (state == ATTACK)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_ATTACK_SCRIPT[scriptInt][0], x, y);
		}
		else if (state == DEAD)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_DEAD_SCRIPT[scriptInt], x, y);
		}
		else if (state == DEAD_END)
		{
			this.drawImage(canvas, ImageConfig.WEREWOLVES_DEAD02, x, y, alpha);
		}
		else if (state == HURT_STONE)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_WOUNDED_SCRIPT[scriptInt], x
					+ GameConsts.HURT_STONE_POSITION, y);
		}
		else if (state == STAY)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_STAY_SCRIPT[scriptInt], x, y);
		}
		else if (state == WOUNDED)
		{
			this.drawImage(canvas, GameConsts.WEREWOLVES_WOUNDED_SCRIPT[scriptInt], x, y);
		}

		super.drawMonster(canvas);
	}

	@Override
	public boolean isAttackHit()
	{
		return this.isAttackHit(GameConsts.WEREWOLVES_ATTACK_SCRIPT);
	}

}
