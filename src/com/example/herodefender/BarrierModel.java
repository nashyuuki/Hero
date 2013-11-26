package com.example.herodefender;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.core.CoreModel;
import com.example.core.GameBean;
import com.example.herodefender.config.ModelConfig;
import com.example.herodefender.sprite.BackgroundSprite;
import com.example.herodefender.sprite.ButtonSprite;
import com.example.herodefender.sprite.FrameSprite;
import com.example.herodefender.sprite.Item;
import com.example.herodefender.sprite.PickSprite;
import com.example.herodefender.sprite.RoleSprite;
import com.example.herodefender.sprite.Sprite;
import com.example.herodefender.sprite.UiSprite;
import com.example.herodefender.sprite.WordSprite;

public class BarrierModel extends CoreModel
{
	private static final int BARRIER=0;
	private static final int PUSH=1;
	private static final int LEFT=2;
	private static final int RIGHT=3;
	private BackgroundSprite backgroundSprite;
	private FrameSprite[] frames;
	private ButtonSprite[] buttons;
	private WordSprite[] words;
	private RoleSprite[] roles;
	private RoleSprite[] nextRoles;
	private PickSprite[] picks;
	private UiSprite numberSprite;
	private int distance;
	private int barrierInt;
	public BarrierModel(GameBean gameBean)
	{
		super(gameBean);
	}
	public void init()
	{
		barrierInt=0;
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.BARRIER);
		frames=new FrameSprite[GameConsts.BARRIER_FRAME_POSITION.length];
		for(int i=0;i<frames.length;i++)
		{
			frames[i]=new FrameSprite(this.getImageConfig());
			frames[i].setState(GameConsts.BARRIER_FRAME_POSITION[i][0]);
			frames[i].setPosition(GameConsts.BARRIER_FRAME_POSITION[i][1],
			                      GameConsts.BARRIER_FRAME_POSITION[i][2]);
		}
		buttons=new ButtonSprite[GameConsts.BARRIR_BUTTON_POSITION.length];
		for(int i=0;i<buttons.length;i++)
		{
			buttons[i]=new ButtonSprite(this.getImageConfig());
			buttons[i].setCollisionArea(GameConsts.BARRIER_BUTTON_COLLISION[i]);
			buttons[i].setType(GameConsts.BARRIR_BUTTON_POSITION[i][0]);
			buttons[i].setPosition(GameConsts.BARRIR_BUTTON_POSITION[i][1], 
			                       GameConsts.BARRIR_BUTTON_POSITION[i][2]);
			buttons[i].setState(ButtonSprite.STAY);
		}
		words=new WordSprite[GameConsts.BARRIER_WORD_POSITION.length];
		for(int i=0;i<words.length;i++)
		{
			words[i]=new WordSprite(this.getImageConfig());
			words[i].setState(GameConsts.BARRIER_WORD_POSITION[i][0]);
			words[i].setPosition(GameConsts.BARRIER_WORD_POSITION[i][1], 
			                     GameConsts.BARRIER_WORD_POSITION[i][2]);
		}
		int[] roleType=GameConsts.BARRIER_SCRIPT[barrierInt];
		roles=new RoleSprite[GameConsts.BARRIER_ROLE_POSITION.length];
		for(int i=0;i<roles.length;i++)
		{
			roles[i]=new RoleSprite(this.getImageConfig());
			roles[i].setPosition(GameConsts.BARRIER_ROLE_POSITION[i]);
			roles[i].setType(roleType[i]);
			roles[i].setState(RoleSprite.STAY);
		}
		nextRoles=new RoleSprite[GameConsts.BARRIER_ROLE_POSITION.length];
		for(int i=0;i<nextRoles.length;i++)
		{
			nextRoles[i]=new RoleSprite(this.getImageConfig());
			nextRoles[i].setPosition(GameConsts.BARRIER_ROLE_POSITION[i]);
		}
		Item[] items=new Item[3];
		for(int i=0;i<items.length;i++)
		{
			items[i]=new Item();
			items[i].setType(i);
			items[i].setUseful(true);
		}
		picks=new PickSprite[GameConsts.PICK_POSITION.length];
		for(int i=0;i<picks.length;i++)
		{
			picks[i]=new PickSprite(this.getImageConfig());
			picks[i].setCollisionArea(GameConsts.PICK_COLLISION);
			picks[i].setItems(items);
			picks[i].setPosition(GameConsts.PICK_POSITION[i]);
			picks[i].setState(PickSprite.STAY);
		}
		numberSprite=new UiSprite(this.getImageConfig());
		numberSprite.setBarrierInt(barrierInt);
		numberSprite.setPosition(GameConsts.BARRIER_NUMBER_POSITION);
		numberSprite.setState(UiSprite.NUMBER);
	}
	public void updateView(long viewTime)
	{
		
	}
	public void update()
	{
		if(subState==BARRIER)
		{
			for(int i=0;i<roles.length;i++)
			{
				roles[i].update();
			}
			for(int i=0;i<picks.length;i++)
			{
				picks[i].update();
			}
		}
		else if(subState==RIGHT)
		{
			distance=distance-GameConsts.BARRIER_MOVE_SCRIPT[3];
			for(int i=0;i<roles.length;i++)
			{
				roles[i].setX(roles[i].getX()+GameConsts.BARRIER_MOVE_SCRIPT[3]);
				nextRoles[i].setX(nextRoles[i].getX()+GameConsts.BARRIER_MOVE_SCRIPT[3]);
			}
		}
		else if(subState==LEFT)
		{
			distance=distance-GameConsts.BARRIER_MOVE_SCRIPT[3];
			for(int i=0;i<roles.length;i++)
			{
				roles[i].setX(roles[i].getX()-GameConsts.BARRIER_MOVE_SCRIPT[3]);
				nextRoles[i].setX(nextRoles[i].getX()-GameConsts.BARRIER_MOVE_SCRIPT[3]);
			}
		}
		else if(subState==PUSH)
		{
			for(int i=0;i<buttons.length;i++)
			{
				buttons[i].update();
				if(buttons[i].getState()==ButtonSprite.PUSH_END)
				{
					if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_LEFT)
					{	
						barrierInt++;
						if(barrierInt>GameConsts.BARRIER_SCRIPT.length-1)
						{
							barrierInt=0;
						}
						subState=LEFT;
						this.setBarrierRole(barrierInt);
						break;
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_RIGHT)
					{
						barrierInt--;
						if(barrierInt<0)
						{
							barrierInt=GameConsts.BARRIER_SCRIPT.length-1;
						}
						subState=RIGHT;
						this.setBarrierRole(barrierInt);
						break;
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_BACK)
					{
						this.setNextState(ModelConfig.LOBBY);
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_START_B)
					{
						this.setItems();
						this.setNextState(ModelConfig.GAME);
					}
					else
					{
						subState=BARRIER;
						buttons[i].setState(ButtonSprite.STAY);
					}
				}
			}
		}
		if(subState==RIGHT||subState==LEFT)
		{
			if(distance<=0)
			{
				for(int i=0;i<roles.length;i++)
				{
					roles[i].setPosition(GameConsts.BARRIER_ROLE_POSITION[i]);
					roles[i].setType(nextRoles[i].getType());
					nextRoles[i].setState(RoleSprite.DISABLE);
				}
				numberSprite.setBarrierInt(barrierInt);
				subState=BARRIER;
				for(int i=0;i<buttons.length;i++)
				{
					buttons[i].setState(ButtonSprite.STAY);
				}
			}
		}
	}
	private void setItems()
	{
		int[] items=new int[picks.length];
		for(int i=0;i<items.length;i++)
		{
			items[i]=picks[i].getItmeType();
		}
		gameBean.setItems(items);
	}
	private void setBarrierRole(int barrierInt)
	{
		distance=GameConsts.BARRIER_MOVE_SCRIPT[2];
		for(int i=0;i<nextRoles.length;i++)
		{
			nextRoles[i].setState(RoleSprite.STAY);
			nextRoles[i].setType(GameConsts.BARRIER_SCRIPT[barrierInt][i]);
			if(subState==RIGHT)
			{
				nextRoles[i].setPosition(GameConsts.BARRIER_ROLE_POSITION[i][0]-distance,
				                         GameConsts.BARRIER_ROLE_POSITION[i][1]);
			}
			else if(subState==LEFT)
			{
				nextRoles[i].setPosition(GameConsts.BARRIER_ROLE_POSITION[i][0]+distance,
				                         GameConsts.BARRIER_ROLE_POSITION[i][1]);
			}
			
		}
	}
	public void drawView(Canvas canvas)
	{
		if(subState==BARRIER||subState==PUSH||subState==RIGHT||subState==LEFT)
		{
			backgroundSprite.drawView(canvas);
			this.drawSprite(canvas, picks);
			this.drawSprite(canvas, frames);
			this.drawSprite(canvas, buttons);
			this.drawSprite(canvas, words);
			this.drawSprite(canvas, roles);
			this.drawSprite(canvas, nextRoles);
			numberSprite.drawView(canvas);
		}
	}
	private void drawSprite(Canvas canvas,Sprite[] sprite)
	{
		for(int i=0;i<sprite.length;i++)
		{
			sprite[i].drawView(canvas);
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
		if(subState==BARRIER)
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
			else if(event.getAction() == MotionEvent.ACTION_MOVE)
			{
				for(int i=0;i<picks.length;i++)
				{
					if(picks[i].getState()==PickSprite.STAY&&picks[i].isCollision(x, y))
					{
						if(touchState== TOUCH_LEFT )
						{
							picks[i].setState(PickSprite.LEFT);
						}
						else if(touchState == TOUCH_RIGHT)
						{
							picks[i].setState(PickSprite.RIGHT);
						}
					}
				}
			}
		}
	}
}
