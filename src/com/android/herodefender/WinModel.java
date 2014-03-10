package com.android.herodefender;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.sprite.BackgroundSprite;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.FrameSprite;
import com.android.herodefender.sprite.Item;
import com.android.herodefender.sprite.WordSprite;

public class WinModel extends CoreModel
{
	public static final int WIN=0;
	private BackgroundSprite backgroundSprite;
	private FrameSprite talkSprite;
	private WordSprite wordSprite;
	private ButtonSprite buttonSprite;
	private int scriptInt;
	public WinModel(GameBean gameBean)
	{
		super(gameBean);
	}
	public void init()
	{
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.WIN);
		talkSprite=new FrameSprite(gameBean);
		this.setTalkSprite();
		wordSprite=new WordSprite(this.getImageConfig());
		wordSprite.setPosition(GameConsts.WIN_WORD_POSITION);
		wordSprite.setState(WordSprite.WIN);
		buttonSprite=new ButtonSprite(this.getImageConfig());
		buttonSprite.setType(ButtonSprite.TYPE_BACK);
		buttonSprite.setCollisionArea(GameConsts.BARRIER_BUTTON_COLLISION[3]);
		buttonSprite.setPosition(GameConsts.WIN_BACK_POSITION);
		Item[][] items=gameBean.getPicks();
		for(int i=0;i<items.length;i++)
		{
			for(int j=0;j<items[i].length;j++)
			{
				items[i][j].setUseful(true);
			}
		}
	}
	private void setTalkSprite()
	{
		talkSprite.setType(GameConsts.WIN_TALK_SCRIPT[scriptInt]);
		talkSprite.setTalk(GameConsts.TALK_WIN_TEXT[scriptInt]);
		talkSprite.setState(FrameSprite.START);
	}
	public void updateView(long viewTime)
	{
		if(subState==WIN)
		{
			talkSprite.update();
		}
	}
	public void update()
	{	
		if(subState==WIN)
		{
			wordSprite.update();
			if(buttonSprite.getState()==ButtonSprite.PUSH_END)
			{
				this.setNextState(ModelConfig.LOBBY);
			}
			buttonSprite.update();
		}
	}
	public void drawView(Canvas canvas)
	{
		if(subState==WIN)
		{
			backgroundSprite.drawView(canvas);
			wordSprite.drawView(canvas);
			talkSprite.drawView(canvas);
			buttonSprite.drawView(canvas);
		}
	}
	public void onKeyDown(int keyCode)
	{
	}
	public void onKeyUp(int keyCode)
	{
	}
	public void onTouchEvent(int x, int y, MotionEvent event, int touchState)
	{
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			if(buttonSprite.getState()==ButtonSprite.STAY)
			{
				if(buttonSprite.isCollision(x, y))
				{
					buttonSprite.setState(ButtonSprite.PUSH);
				}
			}
			touchDown();
		}
	}
	private void touchDown()
	{
		if(buttonSprite.getState()==ButtonSprite.DISABLE)
		{
			if(talkSprite.getState()==FrameSprite.STAY)
			{
				if(scriptInt<GameConsts.WIN_TALK_SCRIPT.length-1)
				{
					scriptInt++;
					this.setTalkSprite();
				}
				else
				{
					buttonSprite.setState(ButtonSprite.STAY);
				}
			}
		}
	}
	public void onBackKeyDown()
	{
		if(buttonSprite.getState()==ButtonSprite.STAY)
		{
			buttonSprite.setState(ButtonSprite.PUSH);
		}
		touchDown();
	}
	
}
