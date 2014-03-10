package com.android.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.sprite.Sprite;

public abstract class CoreModel
{
	public static final int TOUCH_NON = 0;
	public static final int TOUCH_UP = 1;
	public static final int TOUCH_DOWN = 2;
	public static final int TOUCH_LEFT = 3;
	public static final int TOUCH_RIGHT = 4;
	public Context context;
	public GameBean gameBean;
	public int subState;

	public CoreModel(GameBean gameBean)
	{
		this.context = gameBean.getContext();
		this.gameBean = gameBean;
	}

	public abstract void init();

	public abstract void updateView(long viewTime);

	public abstract void update();

	public abstract void drawView(Canvas canvas);

	public abstract void onKeyDown(int keyCode);

	public abstract void onKeyUp(int keyCode);
	
	public void onBackKeyDown(){};

	public void onTouchEvent(int x, int y, MotionEvent event, int touchState)
	{
	};

	public void setNextState(int nextState)
	{
		gameBean.setNextState(nextState);
	}

	public ImageConfig getImageConfig()
	{
		return gameBean.getImageConfig();
	}

	public Drawable getDrawable(int image)
	{
		return this.getImageConfig().getDrawable(image);
	}
	public void drawSprite(Canvas canvas,Sprite[] sprite)
	{
		for(int i=0;i<sprite.length;i++)
		{
			sprite[i].drawView(canvas);
		}
	}
	public void playMusic(int music)
	{
		gameBean.getMusciConfig().play(music);
	}
	public void stopMusic(int music)
	{
		gameBean.getMusciConfig().stopMusic(music);
	}
	public void exitGame()
	{
		// TestCoreActivity.getInstance().finish();
	}
	public void pause()
	{
		
	}
	public void restart()
	{

	}
	public void resetDrawables()
	{
		gameBean.getImageConfig().resetDrawables();
	}
	public void loadImage(int[] load)
	{
		gameBean.getImageConfig().LoadDrawable(load);
	}
	public void removeAd()
	{
		this.disableAdView();
	}
	public void addAd()
	{
		this.visibleView();
	}
    private void disableAdView() 
    {
        new Thread() 
        {
            @Override
			public void run() 
            {
            	gameBean.getHandler().sendEmptyMessage(View.GONE);
            }
        }.start();
    }
    private void visibleView() 
    {
        new Thread() 
        {
            @Override
			public void run() 
            {
            	gameBean.getHandler().sendEmptyMessage(View.VISIBLE);
            }
        }.start();
    }
}
