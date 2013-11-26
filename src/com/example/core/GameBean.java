package com.example.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.herodefender.GameConsts;
import com.example.herodefender.config.ImageConfig;
import com.example.herodefender.config.ModelConfig;
import com.example.herodefender.config.MusicConfig;
import com.example.herodefender.sprite.Item;

public class GameBean extends Application
{
	private Context context;
	private ModelConfig modelConfig;
	private ImageConfig imageConfig;
	private MusicConfig musciConfig;
	private GameConsts gameConsts;
	private int state = ModelConfig.INIT;
	private int nextState;
	private int[] items={Item.CROSS,Item.CROSS,Item.CROSS};

	public GameBean()
	{
		Log.v("TEST", "init gameBean");
	}

	public void init()
	{
		Log.v("TEST", "GameBean init");
		modelConfig = new ModelConfig(this);
		imageConfig = new ImageConfig(this.context);
		musciConfig = new MusicConfig(this.context);
		gameConsts = new GameConsts(context.getResources());
		state = -1;
	}

	public void restoreGameBean()
	{
	}
	public void storeGameBean()
	{
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
	
}
