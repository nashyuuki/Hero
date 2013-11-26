package com.example.herodefender.sprite;

import android.graphics.Canvas;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class RoleSprite extends Sprite
{
	public static final int STAY=1;
	public static final int TYPE_VAMPIRE=0;
	public static final int TYPE_WEREWOLVES=1;
	public static final int TYPE_ZOMBIE=2;
	private int type;
	public RoleSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
		if(state==STAY)
		{
			this.nextScriptInt(GameConsts.BARRIER_ROLE_SCRIPT[type].length);
		}
	}
	public void drawView(Canvas canvas)
	{
		if(state==STAY)
		{
			this.drawImage(canvas, GameConsts.BARRIER_ROLE_SCRIPT[type][scriptInt],
			               x+GameConsts.ROLE_POSITION[type][0], 
			               y+GameConsts.ROLE_POSITION[type][1]);
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
