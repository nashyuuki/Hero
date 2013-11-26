package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class BurstSprite extends Sprite
{
	public static final int BURST = 1;
	public static final int BURST_END=2;
	public BurstSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
		if (state == BURST)
		{
			if (this.nextScriptInt(GameConsts.BURST_SCRIPT.length))
			{
				this.setState(BURST_END);
			}
		}
		else if(state == BURST_END)
		{
			if(this.nextScriptInt(GameConsts.BURST_END_SCRIPT.length))
			{
				this.setState(DISABLE);
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if (state == BURST)
		{
			this.drawImage(canvas, GameConsts.BURST_SCRIPT[scriptInt], x, y);
		}
		else if(state == BURST_END)
		{
			this.drawImage(canvas, GameConsts.BURST_END_SCRIPT[scriptInt], x, y);
		}
	}

}
