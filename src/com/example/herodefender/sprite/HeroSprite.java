package com.example.herodefender.sprite;

import android.graphics.Canvas;
import android.graphics.Color;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;

public class HeroSprite extends Sprite
{
	public static final int STAY=1;
	public static final int ARROW=2;
	public static final int SHOOT=3;
	public static final int STONE=4;
	public static final int STONE_END=5;
	public static final int BOOM=6;
	public static final int BOOM_END=7;
	public static final int FAILURE=8;
	public static final int WIN=9;
	private int weaponType;
	private boolean air;
	private int airInt;
	private int alpha = 255;
	private int mp;
	private int maxMp;
	private boolean isMp;
	public HeroSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
		if(isMp)
		{
			alpha = alpha - 20;
			if (alpha < 0)
			{
				isMp=false;
			}
		}
		if(state==STAY)
		{
			this.nextScriptInt(GameConsts.HERO_STAY_SCRIPT.length);
		}
		else if(state==ARROW)
		{
			this.setState(SHOOT);
		}
		else if(state==SHOOT)
		{
			if(this.nextScriptInt(GameConsts.HERO_SHOOT02_SCRIPT.length))
			{
				this.setState(ARROW);
			}
		}
		else if(state==STONE)
		{
			if(this.nextScriptInt(GameConsts.HERO_STONE_SCRIPT.length))
			{
				this.setState(STONE_END);
			}
		}
		else if(state==STONE_END)
		{
			this.setState(STONE);
		}
		else if(state==BOOM)
		{
			if(this.nextScriptInt(GameConsts.HERO_BOOM_SCRIPT.length))
			{
				this.setState(BOOM_END);
			}
		}
		else if(state==BOOM_END)
		{
			if(this.nextScriptInt(GameConsts.HERO_BOOM_END_SCRIPT.length))
			{
				this.setState(STAY);
			}
		}
		else if(state==FAILURE)
		{
			this.nextScriptInt(GameConsts.HERO_FAULURE_SCRIPT.length);
		}
		else if(state==WIN)
		{
			this.nextScriptInt(GameConsts.HERO_WIN_SCRIPT.length);
		}
		this.updateAir();
	}
	private void updateAir()
	{
		if(air)
		{
			if(airInt<GameConsts.HERO_AIR_SCRIPT.length-1)
			{
				airInt++;
			}
			else
			{
				airInt=0;
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if(state==STAY)
		{
			this.drawAir(canvas, GameConsts.HERO_STAY_SCRIPT[scriptInt]);
			this.drawImage(canvas, GameConsts.HERO_STAY_SCRIPT[scriptInt], x, y);
			this.drawImage(canvas, GameConsts.ARROW_STAY_SCRIPT[weaponType], 
					x+63, 
					y+127);
		}
		else if(state==ARROW)
		{
			this.drawAir(canvas, ImageConfig.HERO_SHOOT01);
			this.drawImage(canvas, ImageConfig.HERO_SHOOT01, x, y);
		}
		else if(state==SHOOT)
		{
			this.drawAir(canvas, GameConsts.HERO_SHOOT02_SCRIPT[scriptInt][0]);
			this.drawImage(canvas, GameConsts.HERO_SHOOT02_SCRIPT[scriptInt][0], x, y);
			if(GameConsts.HERO_SHOOT02_SCRIPT[scriptInt][1]!=-1)
			{
			this.drawImage(canvas, GameConsts.ARROW_STAY_SCRIPT[weaponType], 
					x+GameConsts.HERO_SHOOT02_SCRIPT[scriptInt][2], 
					y+GameConsts.HERO_SHOOT02_SCRIPT[scriptInt][3]);
			}
		}
		else if(state==STONE)
		{
			this.drawAir(canvas, GameConsts.HERO_STONE_SCRIPT[scriptInt]);
			this.drawImage(canvas, GameConsts.HERO_STONE_SCRIPT[scriptInt], x, y);
		}
		else if(state==STONE_END)
		{
			this.drawAir(canvas, ImageConfig.HERO_STONE04);
			this.drawImage(canvas, ImageConfig.HERO_STONE04, x, y);
		}
		else if(state==BOOM)
		{
			this.drawImage(canvas, GameConsts.HERO_BOOM_SCRIPT[scriptInt], 
					x+GameConsts.HERO_BOOM_POSITION[0], 
					y+GameConsts.HERO_BOOM_POSITION[1]);
		}
		else if(state==BOOM_END)
		{
			this.drawImage(canvas, GameConsts.HERO_BOOM_END_SCRIPT[scriptInt], 
					x+GameConsts.HERO_BOOM_POSITION[0], 
					y+GameConsts.HERO_BOOM_POSITION[1]);
		}
		else if(state==FAILURE)
		{
			this.drawImage(canvas, GameConsts.HERO_FAULURE_SCRIPT[scriptInt], x, y);
		}
		else if(state==WIN)
		{
			this.drawImage(canvas, GameConsts.HERO_WIN_SCRIPT[scriptInt], x, y);
		}
		if(isMp)
		{
			this.drawRect(canvas, 
					x + GameConsts.HERO_MP_POSITION[0], 
					y + GameConsts.HERO_MP_POSITION[1], 
					GameConsts.HERO_MP_POSITION[2]*mp/maxMp, 
					GameConsts.HERO_MP_POSITION[3], alpha, 0, 0, 255);
			this.drawStrokeRect(canvas, x + GameConsts.HERO_MP_POSITION[0], y
					+ GameConsts.HERO_MP_POSITION[1], GameConsts.HERO_MP_POSITION[2], 
					GameConsts.HERO_MP_POSITION[3], alpha, 0, 0, 0,GameConsts.HERO_MP_POSITION[4]);
		}
		
	}
	private void drawAir(Canvas canvas,int image)
	{
		if(air)
		{
			this.drawColorImage(canvas, image, 
					x-GameConsts.HERO_AIR_SCRIPT[airInt][0], 
					y-GameConsts.HERO_AIR_SCRIPT[airInt][1],
					GameConsts.HERO_AIR_SCRIPT[airInt][2],
					GameConsts.HERO_AIR_SCRIPT[airInt][3],
					GameConsts.HERO_AIR_SCRIPT[airInt][4]);
		}
	}
	public boolean isAir()
	{
		return air;
	}
	public void setAir(boolean air)
	{
		this.air = air;
	}
	public int getMp()
	{
		return mp;
	}
	public void setMp(int mp)
	{
		this.mp = mp;
	}
	public int getMaxMp()
	{
		return maxMp;
	}
	public void setMaxMp(int maxMp)
	{
		this.maxMp = maxMp;
	}
	public boolean isMp()
	{
		return isMp;
	}
	public void setMp(boolean isMp)
	{
		this.isMp = isMp;
		if(isMp)
		{
			alpha = 255 ;
		}
	}
	public int getWeaponType()
	{
		return weaponType;
	}
	public void setWeaponType(int weaponType)
	{
		this.weaponType = weaponType;
	}
	
}
