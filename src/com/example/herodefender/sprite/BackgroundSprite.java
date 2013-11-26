package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class BackgroundSprite extends Sprite
{
	public static final int GAME = 1;
	public static final int LOBBY=2;
	public static final int BARRIER=3;
	public BackgroundSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	@Override
	public void drawView(Canvas canvas)
	{
		if (state == GAME)
		{
			this.drawImage(canvas, ImageConfig.BACKGROUND_GAME, x, y);
		}
		else if(state==LOBBY)
		{
			this.drawImage(canvas, ImageConfig.BACKGROUND_LOBBY, x, y);
		}
		else if(state==BARRIER)
		{
			this.drawTile(canvas, ImageConfig.BACKGROUND_BARRIER, x, y, 2, 2);
		}
	}
}
