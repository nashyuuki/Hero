package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class FrameSprite extends Sprite
{
	public static final int BIG=1;
//	public static final int PICK=2;
//	public static final int PICK_SELECT=3;
	public FrameSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
	}
	public void drawView(Canvas canvas)
	{
		if(state==BIG)
		{
			
			this.drawRoundRect(canvas,
			                   x,
			                   y, 
			                   GameConsts.FRAME_POSITION[0], 
			                   GameConsts.FRAME_POSITION[1], 
			                   GameConsts.FRAME_POSITION[2], 
			                   GameConsts.FRAME_POSITION[3], 
			                   GameConsts.FRAME_POSITION[4], 
			                   GameConsts.FRAME_POSITION[5], 
			                   GameConsts.FRAME_POSITION[6]);
		}
//		else if(state==PICK)
//		{
//			this.drawImage(canvas, ImageConfig.FRAME_PICK01, x, y);
//		}
//		else if(state==PICK_SELECT)
//		{
//			this.drawImage(canvas, ImageConfig.FRAME_PICK02, x, y);
//		}
	}
	
}
