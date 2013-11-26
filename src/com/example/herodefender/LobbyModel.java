package com.example.herodefender;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.core.CoreModel;
import com.example.core.GameBean;
import com.example.herodefender.config.ModelConfig;
import com.example.herodefender.sprite.BackgroundSprite;
import com.example.herodefender.sprite.ButtonSprite;

public class LobbyModel extends CoreModel
{
	private static final int LOBBY=0;
	private static final int PUSH=1;
	private BackgroundSprite backgroundSprite;
	private ButtonSprite[] buttons;
	public LobbyModel(GameBean gameBean)
	{
		super(gameBean);
	}

	@Override
	public void init()
	{
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.LOBBY);
		buttons=new ButtonSprite[GameConsts.LOBBY_BUTTON_POSITION.length];
		for(int i=0;i<buttons.length;i++)
		{
			buttons[i]=new ButtonSprite(this.getImageConfig());
			buttons[i].setCollisionArea(GameConsts.LOBBY_BUTTON_COLLISION[i]);
			buttons[i].setPosition(GameConsts.LOBBY_BUTTON_POSITION[i][1], 
			                       GameConsts.LOBBY_BUTTON_POSITION[i][2]);
			buttons[i].setType(GameConsts.LOBBY_BUTTON_POSITION[i][0]);
			buttons[i].setState(ButtonSprite.STAY);
		}
	}
	@Override
	public void updateView(long viewTime)
	{
		
	}
	@Override
	public void update()
	{
		if(subState==LOBBY)
		{
			
		}
		else if(subState==PUSH)
		{
			for(int i=0;i<buttons.length;i++)
			{
				buttons[i].update();
				if(buttons[i].getState()==ButtonSprite.PUSH_END)
				{
					if(buttons[i].getType()==ButtonSprite.TYPE_START)
					{
						this.setNextState(ModelConfig.BARRIER);			
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_EXIT)
					{
						this.setNextState(ModelConfig.END);
					}
					else
					{
						subState=LOBBY;
						buttons[i].setState(ButtonSprite.STAY);
					}
				}
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if(subState==LOBBY||subState==PUSH)
		{
			backgroundSprite.drawView(canvas);
			for(int i=0;i<buttons.length;i++)
			{
				buttons[i].drawView(canvas);
			}
		}
	}
	@Override
	public void onKeyDown(int keyCode)
	{
		
	}
	@Override
	public void onKeyUp(int keyCode)
	{
		
	}
	@Override
	public void onTouchEvent(int x, int y, MotionEvent event, int touchState)
	{
		if(subState==LOBBY)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				for(int i=0;i<buttons.length;i++)
				{
					if(buttons[i].getState()==ButtonSprite.STAY)
					{
						if(buttons[i].isCollision(x, y))
						{
							subState=PUSH;
							buttons[i].setState(ButtonSprite.PUSH);
						}
					}
				}
			}
		}
	}
	
}
