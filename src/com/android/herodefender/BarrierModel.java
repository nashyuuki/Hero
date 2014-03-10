package com.android.herodefender;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;
import com.android.herodefender.sprite.BackgroundSprite;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.EffectSprite;
import com.android.herodefender.sprite.FrameSprite;
import com.android.herodefender.sprite.Item;
import com.android.herodefender.sprite.PickSprite;
import com.android.herodefender.sprite.RoleSprite;
import com.android.herodefender.sprite.WordSprite;

public class BarrierModel extends CoreModel
{
	private static final int EFFECT=0;
	private static final int BARRIER=1;
	private static final int PUSH=2;
	private static final int LEFT=3;
	private static final int RIGHT=4;
	private BackgroundSprite backgroundSprite;
	private FrameSprite frame;
	private ButtonSprite[] buttons;
	private RoleSprite[] roles;
	private RoleSprite[] nextRoles;
	private PickSprite[] picks;
	private EffectSprite effectSprite;
	private WordSprite barrierSprite;
	private int distance;
	private int barrierInt;
	private int barrierClear;
	private FrameSprite talkSprite;
	public BarrierModel(GameBean gameBean)
	{
		super(gameBean);
	}
	public void init()
	{
		this.loadImage(ImageConfig.BARRIER_LOAD);
		barrierInt=gameBean.getBarrierInt();
		barrierClear=gameBean.getBarrierClear();
		backgroundSprite=new BackgroundSprite(this.getImageConfig());
		backgroundSprite.setState(BackgroundSprite.BARRIER);
		frame=new FrameSprite(gameBean);
		frame.setState(GameConsts.BARRIER_FRAME_POSITION[2]);
		frame.setCollisionArea(GameConsts.FRAME_COLLISION);
		frame.setPosition(GameConsts.BARRIER_FRAME_POSITION);
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
		int[] roleType=BarrierConsts.BARRIER_SCRIPT[barrierInt];
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
		Item[][] pick=gameBean.getPicks();
		int[] select=gameBean.getSelect();
		picks=new PickSprite[GameConsts.PICK_POSITION.length];
		for(int i=0;i<picks.length;i++)
		{
			picks[i]=new PickSprite(this.getImageConfig());
			picks[i].setCollisionArea(GameConsts.PICK_COLLISION);
			picks[i].setItems(pick[i]);
			picks[i].setIndex(select[i]);
			picks[i].setPosition(GameConsts.PICK_POSITION[i]);
			picks[i].setState(PickSprite.STAY);
		}
		barrierSprite=new WordSprite(this.getImageConfig());
		barrierSprite.setBarrierInt(barrierInt);
		barrierSprite.setPosition(GameConsts.BARRIER_WORD_POSITION);
		barrierSprite.setState(WordSprite.BARRIER);
		effectSprite=new EffectSprite(this.getImageConfig());
		effectSprite.setState(EffectSprite.MOVE);
		talkSprite=new FrameSprite(gameBean);
	}
	public void updateView(long viewTime)
	{
		if(subState==BARRIER)
		{
			talkSprite.update();
		}
		else if(subState==RIGHT)
		{
			int speed=(int)viewTime*GameConsts.BARRIER_MOVE_SCRIPT[3];
			distance=distance-speed;
			for(int i=0;i<roles.length;i++)
			{
				roles[i].setX(roles[i].getX()+speed);
				nextRoles[i].setX(nextRoles[i].getX()+speed);
			}
		}
		else if(subState==LEFT)
		{
			int speed=(int)viewTime*GameConsts.BARRIER_MOVE_SCRIPT[3];
			distance=distance-speed;
			for(int i=0;i<roles.length;i++)
			{
				roles[i].setX(roles[i].getX()-speed);
				nextRoles[i].setX(nextRoles[i].getX()-speed);
			}
		}
		else if(subState==EFFECT)
		{
			effectSprite.update();
			if(effectSprite.getState()==EffectSprite.MOVE_END)
			{
				this.setTalkSprite();
				subState=BARRIER;
			}
		}
	}
	private void setTalkSprite()
	{
		if(roles[0].getType()==RoleSprite.TYPE_VAMPIRE)
		{
			talkSprite.setType(FrameSprite.TYPE_VAMPIRE);
		}
		else if(roles[0].getType()==RoleSprite.TYPE_WEREWOLVES)
		{
			talkSprite.setType(FrameSprite.TYPE_WEREWOLVES);
		}
		else if(roles[0].getType()==RoleSprite.TYPE_ZOMBIE)
		{
			talkSprite.setType(FrameSprite.TYPE_ZOMBIE);
		}
		talkSprite.setBarrierInt(barrierInt);
		
		talkSprite.setState(FrameSprite.START);
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
		else if(subState==PUSH)
		{
			for(int i=0;i<buttons.length;i++)
			{
				if(buttons[i].getState()==ButtonSprite.PUSH_END)
				{
					if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_RIGHT)
					{	
						barrierInt++;
						if(barrierInt>BarrierConsts.BARRIER_SCRIPT.length-1)
						{
							barrierInt=0;
						}
						subState=LEFT;
						this.setBarrierRole(barrierInt);
						break;
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_INFO)
					{
						talkSprite.setType(FrameSprite.TYPE_WEAPON);
						talkSprite.setState(FrameSprite.START);
						subState=BARRIER;
						buttons[i].setState(ButtonSprite.STAY);
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_LEFT)
					{
						barrierInt--;
						if(barrierInt<0)
						{
							barrierInt=BarrierConsts.BARRIER_SCRIPT.length-1;
						}
						subState=RIGHT;
						this.setBarrierRole(barrierInt);
						break;
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_BACK)
					{
						this.setItems();
						this.setNextState(ModelConfig.LOBBY);
					}
					else if(buttons[i].getType()==ButtonSprite.TYPE_START_B)
					{
						this.setItems();
						gameBean.setBarrierInt(barrierInt);
						this.setNextState(ModelConfig.GAME);
					}
					else
					{
						subState=BARRIER;
						buttons[i].setState(ButtonSprite.STAY);
					}
				}
				buttons[i].update();
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
				this.setTalkSprite();
				barrierSprite.setBarrierInt(barrierInt);
				this.setButton();
				subState=BARRIER;
			}
		}
	}
	private void setItems()
	{
		int[] items=new int[picks.length];
		int[] select=new int[picks.length];
		for(int i=0;i<items.length;i++)
		{
			items[i]=picks[i].getItmeType();
			select[i]=picks[i].getIndex();
		}
		gameBean.setItems(items);
		gameBean.setSelect(select);
	}
	private void setBarrierRole(int barrierInt)
	{
		distance=GameConsts.BARRIER_MOVE_SCRIPT[2];
		for(int i=0;i<nextRoles.length;i++)
		{
			nextRoles[i].setState(RoleSprite.STAY);
			nextRoles[i].setType(BarrierConsts.BARRIER_SCRIPT[barrierInt][i]);
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
		if(subState==EFFECT||subState==BARRIER||subState==PUSH||subState==RIGHT||subState==LEFT)
		{
			backgroundSprite.drawView(canvas);
			this.drawSprite(canvas, picks);
			frame.drawView(canvas);
			this.drawSprite(canvas, buttons);
			roles[1].drawView(canvas);
			roles[2].drawView(canvas);
			roles[0].drawView(canvas);
			nextRoles[1].drawView(canvas);
			nextRoles[2].drawView(canvas);
			nextRoles[0].drawView(canvas);
			barrierSprite.drawView(canvas);
			talkSprite.drawView(canvas);
			effectSprite.drawView(canvas);
		}
	}
	private void setButton()
	{
		for(int i=0;i<buttons.length;i++)
		{
			if(buttons[i].getType()==ButtonSprite.TYPE_START_B)
			{
				if(barrierInt>barrierClear)
				{
					buttons[i].setState(ButtonSprite.LOCK);
				}
				else
				{
					buttons[i].setState(ButtonSprite.STAY);
				}
			}
			else
			{
				buttons[i].setState(ButtonSprite.STAY);
			}
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
				boolean isTalk=false;
				for(int i=0;i<buttons.length;i++)
				{
					if(buttons[i].isCollision(x, y))
					{
						if(buttons[i].getState()==ButtonSprite.STAY)
						{	
							this.playMusic(MusicConfig.BUTTON);
							subState=PUSH;
							buttons[i].setState(ButtonSprite.PUSH);
						}
						else if(buttons[i].getState()==ButtonSprite.LOCK)
						{
							isTalk=true;
							talkSprite.setType(FrameSprite.TYPE_START);
							talkSprite.setState(FrameSprite.START);
						}
					}
				}
				if(!isTalk)
				{
					if(talkSprite.getState()==FrameSprite.STAY)
					{
						talkSprite.setState(FrameSprite.DISABLE);
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
				if(frame.isCollision(x, y))
				{
					if(touchState== TOUCH_LEFT )
					{
						subState=PUSH;
						for(int i=0;i<buttons.length;i++)
						{
							if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_RIGHT)
							{
								this.playMusic(MusicConfig.BUTTON);
								buttons[i].setState(ButtonSprite.PUSH);
							}
						}
					}
					else if(touchState == TOUCH_RIGHT)
					{
						subState=PUSH;
						for(int i=0;i<buttons.length;i++)
						{
							if(buttons[i].getType()==ButtonSprite.TYPE_TRIANGLE_LEFT)
							{
								this.playMusic(MusicConfig.BUTTON);
								buttons[i].setState(ButtonSprite.PUSH);
							}
						}
					}
				}
			}
		}
	}
	public void onBackKeyDown()
	{
		for(int i=0;i<buttons.length;i++)
		{
			if(buttons[i].getType()==ButtonSprite.TYPE_BACK)
			{
				if(buttons[i].getState()==ButtonSprite.STAY)
				{
					buttons[i].setState(ButtonSprite.PUSH);
				}
			}
		}
		subState=PUSH;
	}
}
