package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class SelectSprite extends Sprite
{
	public static final int STAY=1;
	public static final int SELECT=2;
	public static final int STOP=3;
	public static final int SELECT_END=4;
	public static final int TYPE_ARROW=0;
	public static final int TYPE_BULLET=1;
	public static final int TYPE_CROSS=2;
	public static final int TYPE_SYRINGE=3;
	public static final int TYPE_BOMB=4;
	public static final int TYPE_BOOM=5;
	
	public static final int INT_BOOM=0;
	public static final int INT_BOMB=1;
	public static final int INT_WEAPON=2;
	
	private int type;
	public SelectSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}

	public void update()
	{
		if(state==SELECT)
		{
			this.setState(SELECT_END);
		}
	}
	public void drawView(Canvas canvas)
	{
		if(state==STAY)
		{
			this.drawImage(canvas, ImageConfig.SELECT_FRAME01, x, y);
			this.drawType(canvas);
		}
		else if(state==SELECT||state==SELECT_END)
		{
			this.drawImage(canvas, ImageConfig.SELECT_FRAME02, x, y);
			this.drawType(canvas);
		}
		else if(state==STOP)
		{
			this.drawType(canvas);
			this.drawImage(canvas, ImageConfig.SELECT_STOP, x, y);
		}
	}
	private void drawType(Canvas canvas)
	{
		this.drawImage(canvas, GameConsts.SELECT_TYPE_POSITION[type][0], 
		               x+GameConsts.SELECT_TYPE_POSITION[type][1], 
		               y+GameConsts.SELECT_TYPE_POSITION[type][2]);
	}
	public boolean isSelect()
	{
		if(state==SELECT||state==SELECT_END)
		{
			return true;
		}
		else
		{
			return false;
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
	
}
