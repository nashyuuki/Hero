package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class CitywallSprite extends Sprite
{
	public static final int STAY = 1;
	public static final int DESTROY = 2;
	public static final int DESTROY_END = 3;
	// private int hp;
	// private int maxHp;
	private int hpInt;

	public CitywallSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	@Override
	public void update()
	{
		if (state == DESTROY)
		{
			if (this.nextScriptInt(GameConsts.CITYWALL_DESTROY_SCRIPT.length))
			{
				this.setState(DESTROY_END);
			}
		}
	}

	@Override
	public void drawView(Canvas canvas)
	{
		if (state == STAY)
		{
			this.drawImage(canvas, GameConsts.CITYWALL_STAY_SCRIPT[hpInt], x, y);
			// this.drawImage(canvas, GameConsts.CITYWALL_STAY_SCRIPT[0], x, y);
		}
		else if (state == DESTROY)
		{
			this.drawImage(canvas, GameConsts.CITYWALL_DESTROY_SCRIPT[scriptInt], x, y);
		}
		else if (state == DESTROY_END)
		{
			int i = GameConsts.CITYWALL_DESTROY_SCRIPT.length - 1;
			this.drawImage(canvas, GameConsts.CITYWALL_DESTROY_SCRIPT[i], x, y);
		}

	}

	public void setHpInt(int maxHp, int hp)
	{
		hpInt = (maxHp - hp) / (maxHp / (GameConsts.CITYWALL_STAY_SCRIPT.length - 1));
	}
	// public int getHp()
	// {
	// return hp;
	// }
	// public void setHp(int hp)
	// {
	// this.hp = hp;
	// }
	// public int getMaxHp()
	// {
	// return maxHp;
	// }
	// public void setMaxHp(int maxHp)
	// {
	// this.maxHp = maxHp;
	// }

}
