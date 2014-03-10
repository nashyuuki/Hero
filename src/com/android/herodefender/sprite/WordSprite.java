package com.android.herodefender.sprite;

import android.graphics.Canvas;
import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class WordSprite extends Sprite
{
	public static final int BARRIER=1;
	public static final int HERO=2;
	public static final int STAY=3;
	public static final int PUSH=4;
	public static final int PUSH_END=5;
	public static final int RESULT=6;
	public static final int WIN=7;
	
	public static final int TYPE_START=0;
	public static final int TYPE_TEAM=1;
	public static final int TYPE_EXIT=2;
	public static final int TYPE_MUSIC=3;
	
	public static final int TYPE_NONE=0;
	public static final int TYPE_BOMB=1;
	public static final int TYPE_WEAPON=2;
	private int type;
	private int barrierInt;
    private int radius;
    private int zombieInt;
    private int werewolvesInt;
    private int vampireInt;
    private int heroInt;
    private int[] weapon={TYPE_NONE,TYPE_NONE,TYPE_NONE};
	public WordSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	@Override
	public void update()
	{
		if(state==HERO||state==WIN)
		{
			radius=radius+10;
			if(radius>60)
			{
				radius=20;
			}
		}
		else if(state==PUSH)
		{
			if(this.nextScriptInt(2))
			{
				this.setState(PUSH_END);
			}
		}
		else if(state==RESULT)
		{
			radius=radius+10;
			if(radius>GameConsts.RESULT_TEXT_POSITION[10][3])
			{
				radius=0;
			}
		}
	}
	
	@Override
	public void drawView(Canvas canvas)
	{
		if(state==WIN)
		{
			this.drawEnText(canvas,GameConsts.WIN_TEXT,x,y, 
			              GameConsts.WIN_WORD_POSITION[2],
			              radius,
			              GameConsts.WIN_WORD_POSITION[3], 
			              GameConsts.WIN_WORD_POSITION[4], 
			              GameConsts.WIN_WORD_POSITION[5], 
			              GameConsts.WIN_WORD_POSITION[6],
			              GameConsts.WIN_WORD_POSITION[7]);
		}
		else if(state==BARRIER)
		{
			this.drawText(canvas, GameConsts.BARRIER_TEXT+(barrierInt),x,y, 
			              GameConsts.BARRIER_WORD_POSITION[2], 
			              GameConsts.BARRIER_WORD_POSITION[3], 
			              GameConsts.BARRIER_WORD_POSITION[4],
			              GameConsts.BARRIER_WORD_POSITION[5],  
			              GameConsts.BARRIER_WORD_POSITION[6],
			              GameConsts.BARRIER_WORD_POSITION[7], 
			              GameConsts.BARRIER_WORD_POSITION[8]);
		}
		else if(state==HERO)
		{
			this.drawText(canvas,GameConsts.HERO_TEXT,x,y, 
			              GameConsts.HERO_WORD_POSITION[2],
			              radius,
			              GameConsts.HERO_WORD_POSITION[3], 
			              GameConsts.HERO_WORD_POSITION[4], 
			              GameConsts.HERO_WORD_POSITION[5], 
			              GameConsts.HERO_WORD_POSITION[6],
			              GameConsts.HERO_WORD_POSITION[7]);
		}
		else if(state==STAY)
		{
			int[] position=GameConsts.LOBBY_TEXT01_POSITION[type];
			this.drawImage(canvas,position[0], x, y);
			if(position[0]!=ImageConfig.BUTTON_MUSIC01)
			{
				this.drawText(canvas,GameConsts.LOBBY_TEXT[type],
				              x+position[1],
				              y+position[2], 
				              position[3],
				              position[4],
				              position[5], 
				              position[6], 
				              position[7], 
				              position[8],
				              position[9]);
			}
		}
		else if(state==PUSH||state==PUSH_END)
		{
			int[] position=GameConsts.LOBBY_TEXT02_POSITION[type];
			this.drawImage(canvas,position[0], x, y);
			if(position[0]!=ImageConfig.BUTTON_MUSIC02)
			{
				this.drawText(canvas,GameConsts.LOBBY_TEXT[type],
				              x+position[1],
				              y+position[2], 
				              position[3],
				              position[4],
				              position[5], 
				              position[6], 
				              position[7], 
				              position[8],
				              position[9]);
			}
		}
		else if(state==RESULT)
		{
			this.drawTextL(canvas,GameConsts.HERO_TYPE_TEXT[heroInt]+GameConsts.RESULT_WORD_TEXT[0],
			              x+GameConsts.RESULT_TEXT_POSITION[0][0],
			              y+GameConsts.RESULT_TEXT_POSITION[0][1], 
			              GameConsts.RESULT_TEXT_POSITION[0][2],
			              GameConsts.RESULT_TEXT_POSITION[0][3],
			              GameConsts.RESULT_TEXT_POSITION[0][4], 
			              GameConsts.RESULT_TEXT_POSITION[0][5], 
			              GameConsts.RESULT_TEXT_POSITION[0][6], 
			              GameConsts.RESULT_TEXT_POSITION[0][7],
			              GameConsts.RESULT_TEXT_POSITION[0][8]);
			;
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[1][0], 
			                 GameConsts.RESULT_TEXT_POSITION[1][1], 
			                 GameConsts.RESULT_WORD_TEXT[1]);
			this.drawInt(canvas,
			             GameConsts.RESULT_TEXT_POSITION[2][0],
			             GameConsts.RESULT_TEXT_POSITION[2][1],zombieInt);
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[3][0], 
			                 GameConsts.RESULT_TEXT_POSITION[3][1], 
			                 GameConsts.RESULT_WORD_TEXT[2]);
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[4][0], 
			                 GameConsts.RESULT_TEXT_POSITION[4][1], 
			                 GameConsts.RESULT_WORD_TEXT[1]);
			this.drawInt(canvas,
			             GameConsts.RESULT_TEXT_POSITION[5][0],
			             GameConsts.RESULT_TEXT_POSITION[5][1],
			             werewolvesInt);
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[6][0], 
			                 GameConsts.RESULT_TEXT_POSITION[6][1], 
			                 GameConsts.RESULT_WORD_TEXT[3]);
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[7][0], 
			                 GameConsts.RESULT_TEXT_POSITION[7][1], 
			                 GameConsts.RESULT_WORD_TEXT[1]);
			this.drawInt(canvas,
			             GameConsts.RESULT_TEXT_POSITION[8][0],
			             GameConsts.RESULT_TEXT_POSITION[8][1],vampireInt);
			this.drawMonster(canvas, 
			                 GameConsts.RESULT_TEXT_POSITION[9][0], 
			                 GameConsts.RESULT_TEXT_POSITION[9][1], 
			                 GameConsts.RESULT_WORD_TEXT[4]);
			for(int i=0;i<weapon.length;i++)
			{
				if(weapon[i]!=TYPE_NONE)
				{
					int index=i+10;
					String text="";
					if(weapon[i]==TYPE_BOMB)
					{
						text=GameConsts.RESULT_WORD_TEXT[6];
					}
					else if(weapon[i]==TYPE_WEAPON)
					{
						text=GameConsts.RESULT_WORD_TEXT[5];
					}
					this.drawText(canvas,text, 
					              x+GameConsts.RESULT_TEXT_POSITION[index][0], 
					              y+GameConsts.RESULT_TEXT_POSITION[index][1], 
					              GameConsts.RESULT_TEXT_POSITION[10][2], 
					              radius, 
					              GameConsts.RESULT_TEXT_POSITION[10][4], 
					              GameConsts.RESULT_TEXT_POSITION[10][5], 
					              GameConsts.RESULT_TEXT_POSITION[10][6], 
					              GameConsts.RESULT_TEXT_POSITION[10][7], 
					              GameConsts.RESULT_TEXT_POSITION[10][8]);
				}
			}
		}
	}
	private void drawMonster(Canvas canvas,int dx,int dy,String word)
	{
		this.drawTextL(canvas,word,
			              x+dx,
			              y+dy, 
			              GameConsts.RESULT_TEXT_POSITION[1][2],
			              GameConsts.RESULT_TEXT_POSITION[1][3],
			              GameConsts.RESULT_TEXT_POSITION[1][4], 
			              GameConsts.RESULT_TEXT_POSITION[1][5], 
			              GameConsts.RESULT_TEXT_POSITION[1][6], 
			              GameConsts.RESULT_TEXT_POSITION[1][7],
			              GameConsts.RESULT_TEXT_POSITION[1][8]);
	}
	private void drawInt(Canvas canvas,int dx,int dy,int index)
	{
		int color=255;
		if(index<20)
		{
			color=index*GameConsts.RESULT_TEXT_POSITION[2][4]/20;
		}
		this.drawText(canvas,""+index,
		              x+dx,
		              y+dy, 
		              GameConsts.RESULT_TEXT_POSITION[2][2],
		              GameConsts.RESULT_TEXT_POSITION[2][3],
		              color, 
		              GameConsts.RESULT_TEXT_POSITION[2][5], 
		              GameConsts.RESULT_TEXT_POSITION[2][6], 
		              GameConsts.RESULT_TEXT_POSITION[2][7],
		              GameConsts.RESULT_TEXT_POSITION[2][8]);
	}
	public int getBarrierInt()
	{
		return barrierInt;
	}
	public void setBarrierInt(int barrierInt)
	{
		this.barrierInt = barrierInt;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public int getHeroInt()
	{
		return heroInt;
	}
	public void setHeroInt(int heroInt)
	{
		this.heroInt = heroInt;
	}
	public int getZombieInt()
	{
		return zombieInt;
	}
	public void setZombieInt(int zombieInt)
	{
		this.zombieInt = zombieInt;
	}
	public int getWerewolvesInt()
	{
		return werewolvesInt;
	}
	public void setWerewolvesInt(int werewolvesInt)
	{
		this.werewolvesInt = werewolvesInt;
	}
	public int getVampireInt()
	{
		return vampireInt;
	}
	public void setVampireInt(int vampireInt)
	{
		this.vampireInt = vampireInt;
	}
	public int[] getWeapon()
	{
		return weapon;
	}
	public void setWeapon(int[] weapon)
	{
		this.weapon = weapon;
	}
	
}
