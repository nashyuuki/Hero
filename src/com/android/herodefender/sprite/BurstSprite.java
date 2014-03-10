package com.android.herodefender.sprite;

import java.util.Random;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class BurstSprite extends Sprite
{
	public static final int BURST = 1;
	public static final int BURST_END=2;
	public static final int BOOM=3;
	private Random random;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	public BurstSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
		random=new Random();
	}
	@Override
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
		else if(state == BOOM)
		{
			x1=x+random.nextInt()%30;
			y1=y+random.nextInt()%30;
			x2=x+random.nextInt()%30;
			y2=y+random.nextInt()%30;
			if(this.nextScriptInt(GameConsts.BOOM_SCRIPT.length))
			{
				this.setState(DISABLE);
			}
		}
	}
	@Override
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
		else if(state==BOOM)
		{
			this.drawImage(canvas, GameConsts.BOOM_SCRIPT[scriptInt], x, y);
			if(scriptInt>=1)
			{
				this.drawImage(canvas, GameConsts.BOOM_SCRIPT[scriptInt-1], x1, y1);
			}
			if(scriptInt>=2)
			{
			 this.drawImage(canvas, GameConsts.BOOM_SCRIPT[scriptInt-2], x2, y2);
			}
		}
	}

}
