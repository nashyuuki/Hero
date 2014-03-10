package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class ButtonSprite extends Sprite
{
	public static final int STAY=1;
	public static final int PUSH=2;
	public static final int PUSH_END=3;
	public static final int LOCK=4;
	public static final int TYPE_TRIANGLE_LEFT=0;
	public static final int TYPE_TRIANGLE_RIGHT=1;
	public static final int TYPE_START_B=2;
	public static final int TYPE_BACK=3;
	public static final int TYPE_INFO=4;
	private int type;
	public ButtonSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	@Override
	public void update()
	{
		if(state==PUSH)
		{
			if(this.nextScriptInt(GameConsts.BUTTON_PUSH_SCRIPT[type].length))
			{
				this.setState(PUSH_END);
			}
		}
	}
	@Override
	public void drawView(Canvas canvas)
	{
		if(state==STAY)
		{
			this.drawImage(canvas, GameConsts.BUTTON_TYPE[type], x, y);
		}
		else if(state==PUSH)
		{
			this.drawImage(canvas, GameConsts.BUTTON_PUSH_SCRIPT[type][scriptInt], x, y);
		}
		else if(state==PUSH_END)
		{
			int i=GameConsts.BUTTON_PUSH_SCRIPT[type].length-1;
			this.drawImage(canvas, GameConsts.BUTTON_PUSH_SCRIPT[type][i], x, y);
		}
		else if(state==LOCK)
		{
			this.drawImage(canvas, ImageConfig.BUTTON_START_B02, x, y);
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
