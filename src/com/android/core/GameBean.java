package com.android.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;
import com.android.herodefender.sprite.Item;
import com.android.herodefender.sprite.Monster;
import com.google.ads.AdView;

public class GameBean extends Application
{
	private static final String FILE_NAME="HERO";
	
	private Context context;
	private ModelConfig modelConfig;
	private ImageConfig imageConfig;
	private MusicConfig musciConfig;
	private GameConsts gameConsts;
	private Handler handler;
	private int state = ModelConfig.INIT;
	private int nextState;
	private int[] items={Item.NONE,Item.BULLET,Item.NONE};
	private int[] select=new int[3];
	private Monster[] monster=new Monster[3];
	private int barrierInt;
	private int barrierClear;
	private boolean win=true;
	private boolean music=true;
	private int bombInt;
	private Item[][] picks=new Item[3][3];
	public GameBean()
	{
	}

	public void init()
	{
		for(int i=0;i<picks.length;i++)
		{
			for(int j=0;j<picks.length;j++)
			{
				picks[i][j]=new Item();
				picks[i][j].setType(j);
				if(i==1&&j==0)
				{
					picks[i][j].setUseful(true);
				}
				else
				{
					picks[i][j].setUseful(false);
				}
			}
		}
		modelConfig = new ModelConfig(this);
		imageConfig = new ImageConfig(this.context);
		musciConfig = new MusicConfig(this.context,this);
		gameConsts = new GameConsts(context.getResources());
		state = -1;
		for(int i=0;i<monster.length;i++)
		{
			monster[i]=new Monster();
			if(i==2)
			{
				monster[i].setWerewolvesInt(20);
				monster[i].setZombieInt(20);;
			}
		}
		barrierInt=0;
		bombInt=GameConsts.BOMB_INT;
	}

	public void restoreGameBean()
	{
		FileInputStream fis=null;
		try
		{
			fis = context.openFileInput(FILE_NAME);
			DataInputStream dis=new DataInputStream(fis);
			music=dis.readBoolean();
			barrierClear=dis.readInt();
			for(int i=0;i<picks.length;i++)
			{
				for(int j=0;j<picks.length;j++)
				{
					picks[i][j]=new Item();
					picks[i][j].setType(j);
					picks[i][j].setUseful(dis.readBoolean());
				}
			}
			barrierInt=dis.readInt();
			for(int i=0;i<select.length;i++)
			{
				select[i]=dis.readInt();
			}
			bombInt=dis.readInt();
			dis.close();
		}
		catch (FileNotFoundException e)
		{
			Log.v("TEST", "FileNotFoundException:"+e);
			music=true;
			barrierClear=0;
			for(int i=0;i<picks.length;i++)
			{
				for(int j=0;j<picks.length;j++)
				{
					picks[i][j]=new Item();
					picks[i][j].setType(j);
					if(i==1&&j==0)
					{
						picks[i][j].setUseful(true);
					}
					else
					{
						picks[i][j].setUseful(false);
					}
				}
			}
			select=new int[3];
			bombInt=GameConsts.BOMB_INT;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void storeGameBean()
	{
		FileOutputStream fos=null;
		try
		{
			fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
			DataOutputStream dos =new DataOutputStream(fos);
			dos.writeBoolean(music);
			dos.writeInt(barrierClear);
			for(int i=0;i<picks.length;i++)
			{
				for(int j=0;j<picks.length;j++)
				{
					dos.writeBoolean(picks[i][j].isUseful());
				}
			}
			dos.writeInt(barrierInt);
			for(int i=0;i<select.length;i++)
			{
				dos.writeInt(select[i]);
			}
			dos.writeInt(bombInt);
			dos.close();

		}
		catch (FileNotFoundException e)
		{
			Log.v("TEST", "FileNotFoundException:"+e);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public ModelConfig getModelConfig()
	{
		return modelConfig;
	}
	public void setModelConfig(ModelConfig modelConfig)
	{
		this.modelConfig = modelConfig;
	}
	public ImageConfig getImageConfig()
	{
		return imageConfig;
	}
	public void setImageConfig(ImageConfig imageConfig)
	{
		this.imageConfig = imageConfig;
	}
	public MusicConfig getMusciConfig()
	{
		return musciConfig;
	}
	public void setMusciConfig(MusicConfig musciConfig)
	{
		this.musciConfig = musciConfig;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public int getNextState()
	{
		return nextState;
	}
	public void setNextState(int nextState)
	{
		this.nextState = nextState;
	}
	public Context getContext()
	{
		return context;
	}
	public void setContext(Context context)
	{
		this.context = context;
	}
	public void finish()
	{
		 ((Activity) context).finish();
	}

	public int[] getItems()
	{
		return items;
	}

	public void setItems(int[] items)
	{
		this.items = items;
	}

	public Monster[] getMonster()
	{
		return monster;
	}

	public void setMonster(Monster[] monster)
	{
		this.monster = monster;
	}

	public int getBarrierInt()
	{
		return barrierInt;
	}

	public void setBarrierInt(int barrierInt)
	{
		this.barrierInt = barrierInt;
	}

	public int getBarrierClear()
	{
		return barrierClear;
	}

	public void setBarrierClear(int barrierClear)
	{
		this.barrierClear = barrierClear;
	}

	public Item[][] getPicks()
	{
		return picks;
	}

	public void setPicks(Item[][] picks)
	{
		this.picks = picks;
	}

	public boolean isWin()
	{
		return win;
	}

	public void setWin(boolean win)
	{
		this.win = win;
	}

	public boolean isMusic()
	{
		return music;
	}

	public void setMusic(boolean music)
	{
		this.music = music;
	}

	public int[] getSelect()
	{
		return select;
	}

	public void setSelect(int[] select)
	{
		this.select = select;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public int getBombInt()
	{
		return bombInt;
	}

	public void setBombInt(int bombInt)
	{
		this.bombInt = bombInt;
	}
	
}
