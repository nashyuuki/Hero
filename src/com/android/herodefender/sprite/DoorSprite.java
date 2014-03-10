package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class DoorSprite extends Sprite
{
	public static final int STAY = 0;
	public static final int UP = 1;
	public static final int UP_MID = 2;
	public static final int MID_UP = 3;
	public static final int MID = 4;
	public static final int MID_DOWN = 5;
	public static final int DOWN_MID = 6;
	public static final int DOWN = 7;
	public static final int TYPE_SELECT=0;
	public static final int TYPE_NONE=1;
	private int selectTpye;
	private int moveType;
	private int speed = 2;// 2以上才能碰撞

	public DoorSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
		if (state == UP)
		{
			this.setCollisionArea(GameConsts.DOOR_COLLISION[0]);
		}
		else if (state == UP_MID)
		{
			this.setCollisionArea(GameConsts.UP_MID_DOOR_COLLISION);
			if (this.nextScriptInt(speed))
			{
				this.setState(MID);
			}
		}
		else if (state == MID_UP)
		{
			this.setCollisionArea(GameConsts.UP_MID_DOOR_COLLISION);
			if (this.nextScriptInt(speed))
			{
				this.setState(UP);
			}
		}
		else if (state == MID)
		{
			this.setCollisionArea(GameConsts.DOOR_COLLISION[1]);
		}
		else if (state == MID_DOWN)
		{
			this.setCollisionArea(GameConsts.DOWN_MID_DOOR_COLLISION);
			if (this.nextScriptInt(speed))
			{
				this.setState(DOWN);
			}
		}
		else if (state == DOWN_MID)
		{
			this.setCollisionArea(GameConsts.DOWN_MID_DOOR_COLLISION);
			if (this.nextScriptInt(speed))
			{
				this.setState(MID);
			}
		}
		else if (state == DOWN)
		{
			this.setCollisionArea(GameConsts.DOOR_COLLISION[2]);
		}
	}
	public void drawView(Canvas canvas)
	{
		if (state == UP)
		{
			this.drawImage(canvas, GameConsts.DOOR_UP_SCRIPT[selectTpye], 
			               x+GameConsts.DOOR_DIS_POSITION[0][0], 
			               y+GameConsts.DOOR_DIS_POSITION[0][1]);
		}
		else if (state == UP_MID || state == MID_UP)
		{
			this.drawImage(canvas, ImageConfig.DOOR_MOVE_UP, 
			               x+GameConsts.DOOR_DIS_POSITION[1][0], 
			               y+GameConsts.DOOR_DIS_POSITION[1][1]);
		}
		else if (state == MID)
		{
			this.drawImage(canvas, GameConsts.DOOR_MID_SCRIPT[selectTpye], 
			               x+GameConsts.DOOR_DIS_POSITION[2][0], 
			               y+GameConsts.DOOR_DIS_POSITION[2][1]);
		}
		else if (state == MID_DOWN || state == DOWN_MID)
		{
			this.drawImage(canvas, ImageConfig.DOOR_MOVE_DOWN, 
			               x+GameConsts.DOOR_DIS_POSITION[3][0], 
			               y+GameConsts.DOOR_DIS_POSITION[3][1]);
		}
		else if (state == DOWN)
		{
			this.drawImage(canvas, GameConsts.DOOR_DOWN_SCRIPT[selectTpye], 
			               x+GameConsts.DOOR_DIS_POSITION[4][0], 
			               y+GameConsts.DOOR_DIS_POSITION[4][1]);
		}
	}
	
	public int getMoveType()
	{
		return moveType;
	}

	public void setMoveType(int moveType)
	{
		this.moveType = moveType;
	}
	public int getSelectTpye()
	{
		return selectTpye;
	}
	public void setSelectTpye(int selectTpye)
	{
		this.selectTpye = selectTpye;
	}

}
