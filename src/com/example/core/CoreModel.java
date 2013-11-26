package com.example.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import com.example.herodefender.config.ImageConfig;

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

	public void playMusic(int music)
	{
		gameBean.getMusciConfig().play(music);
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
	
}
