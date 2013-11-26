package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.config.ImageConfig;

public class WordSprite extends Sprite
{
	public static final int WORD_BARRIER=1;
	public static final int WORD_WEAPON=2;
	public WordSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
	}
	public void drawView(Canvas canvas)
	{
		if(state==WORD_BARRIER)
		{
			this.drawImage(canvas, ImageConfig.WORD_BARRIER, x, y);
		}
		else if(state==WORD_WEAPON)
		{
			this.drawImage(canvas, ImageConfig.WORD_WEAPON, x, y);
		}
	}
	
}
