package com.android.herodefender;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;
import com.android.herodefender.sprite.BackgroundSprite;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.EffectSprite;
import com.android.herodefender.sprite.TeamSprite;
import com.android.herodefender.sprite.WordSprite;

public class LobbyModel extends CoreModel
{
	private static final int EFFECT=0;
	private static final int LOBBY=1;
	private static final int PUSH=2;
	private static final int TEAM=3;
	private BackgroundSprite backgroundSprite;
	private WordSprite[] buttons;
	private EffectSprite effectSprite;
	private WordSprite wordSprite;
	private TeamSprite teamSprite;
	public LobbyModel(GameBean gameBean)
	{
		super(gameBean);
	}
	public void init()
	{
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.LOBBY);
		buttons=new WordSprite[GameConsts.LOBBY_BUTTON_POSITION.length];
		for(int i=0;i<buttons.length;i++)
		{
			buttons[i]=new WordSprite(this.getImageConfig());
			buttons[i].setCollisionArea(GameConsts.LOBBY_BUTTON_COLLISION[i]);
			buttons[i].setPosition(GameConsts.LOBBY_BUTTON_POSITION[i][1], 
			                       GameConsts.LOBBY_BUTTON_POSITION[i][2]);
			buttons[i].setType(GameConsts.LOBBY_BUTTON_POSITION[i][0]);
			buttons[i].setState(WordSprite.STAY);
			if(buttons[i].getType()==WordSprite.TYPE_MUSIC)
			{
				if(!gameBean.isMusic())
				{
					buttons[i].setState(WordSprite.PUSH_END);
				}
			}
		}
		effectSprite=new EffectSprite(this.getImageConfig());
		effectSprite.setState(EffectSprite.MOVE);
		wordSprite=new WordSprite(this.getImageConfig());
		wordSprite.setState(WordSprite.HERO);
		wordSprite.setPosition(GameConsts.HERO_WORD_POSITION);
		teamSprite=new TeamSprite(this.getImageConfig());
		teamSprite.setPosition(GameConsts.TEAM_POSITION);
		this.playMusic(MusicConfig.MUSIC01);
		
	}
	public void updateView(long viewTime)
	{
		if(subState==EFFECT)
		{
			effectSprite.update();
			if(effectSprite.getState()==EffectSprite.MOVE_END)
			{
				subState=LOBBY;
			}
		}
		else if(subState==TEAM)
		{
			teamSprite.update();
		}
	}
	public void update()
	{
		if(subState==LOBBY)
		{
			wordSprite.update();
		}
		
		else if(subState==PUSH)
		{
			for(int i=0;i<buttons.length;i++)
			{
				buttons[i].update();
				if(buttons[i].getState()==WordSprite.PUSH_END)
				{
					if(buttons[i].getType()==WordSprite.TYPE_START)
					{
						this.stopMusic(MusicConfig.MUSIC01);
						this.setNextState(ModelConfig.BARRIER);			
					}
					else if(buttons[i].getType()==WordSprite.TYPE_TEAM)
					{
						subState=TEAM;
						teamSprite.setState(TeamSprite.START);
						buttons[i].setState(WordSprite.STAY);
					}
					else if(buttons[i].getType()==WordSprite.TYPE_EXIT)
					{
						this.stopMusic(MusicConfig.MUSIC01);
						this.setNextState(ModelConfig.END);
					}
					
				}
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if(subState==EFFECT||subState==LOBBY||subState==PUSH||subState==TEAM)
		{
			backgroundSprite.drawView(canvas);
			for(int i=0;i<buttons.length;i++)
			{
				buttons[i].drawView(canvas);
			}
			wordSprite.drawView(canvas);
			teamSprite.drawView(canvas);
			effectSprite.drawView(canvas);
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
		if(subState==LOBBY)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				for(int i=0;i<buttons.length;i++)
				{
					if(buttons[i].getType()==WordSprite.TYPE_MUSIC)
					{
						if(buttons[i].isCollision(x, y))
						{
							if(buttons[i].getState()==WordSprite.STAY)
							{
								gameBean.setMusic(false);
								this.stopMusic(MusicConfig.MUSIC01);
								buttons[i].setState(WordSprite.PUSH_END);
							}
							else if(buttons[i].getState()==WordSprite.PUSH_END)
							{
								gameBean.setMusic(true);
								this.playMusic(MusicConfig.MUSIC01);
								buttons[i].setState(WordSprite.STAY);
							}
						}
					}
					else if(buttons[i].getState()==WordSprite.STAY)
					{
						if(buttons[i].isCollision(x, y))
						{
							subState=PUSH;
							buttons[i].setState(WordSprite.PUSH);
						}
					}
				}
			}
		}
		else if(subState==TEAM)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				teamSprite.setState(TeamSprite.DISABLE);
				subState=LOBBY;
			}
		}
	}
	public void onBackKeyDown()
	{
		if(subState==LOBBY)
		{
			for(int i=0;i<buttons.length;i++)
			{
				if(buttons[i].getType()==WordSprite.TYPE_EXIT)
				{
					if(buttons[i].getState()==WordSprite.STAY)
					{
						buttons[i].setState(WordSprite.PUSH);
						subState=PUSH;
					}
				}
			}
		}
		else if(subState==TEAM)
		{
			teamSprite.setState(TeamSprite.DISABLE);
			subState=LOBBY;
		}
	}
	
}
