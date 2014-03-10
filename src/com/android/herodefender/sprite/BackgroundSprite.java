package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class BackgroundSprite extends Sprite
{
	public static final int GAME = 1;
	public static final int LOBBY=2;
	public static final int BARRIER=3;
	public static final int RESULT=4;
	public static final int WIN=5;
	public BackgroundSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	@Override
	public void drawView(Canvas canvas)
	{
		if (state == GAME)
		{
			this.drawTile(canvas, ImageConfig.BACKGROUND_GAME, x, y,7,4);
		}
		else if(state==LOBBY)
		{
			this.drawImage(canvas, ImageConfig.BACKGROUND_LOBBY, x, y);
		}
		else if(state==BARRIER)
		{
			this.drawTile(canvas, ImageConfig.BACKGROUND_BARRIER, x, y, 7, 4);
		}
		else if(state==RESULT)
		{
			this.drawTile(canvas, ImageConfig.BACKGROUND_BARRIER, x, y, 7, 4);
		}
		else if(state==WIN)
		{
			this.drawTile(canvas, ImageConfig.BACKGROUND_BARRIER, x, y, 7, 4);
			this.drawImage(canvas, ImageConfig.END, 
			               x+GameConsts.WIN_POSITION[0], 
			               y+GameConsts.WIN_POSITION[1]);
		}
	}
}
