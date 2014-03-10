package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.core.VectorMath;
import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class AirSprite extends Sprite
{
	public static final int MOVE = 1;
	public static final int GATHER = 2;
	private int speed;
	private VectorMath vector;
	private int endX;
	private int endY;
	private int heroInt;
	private int type;
    private final float[] mTexs =  {0.0f,200.0f,100.0f,200.0f,200.0f,200.0f,0.0f,100.0f,100.0f,100.0f,200.0f,100.0f,0.0f,-0.0f,100.0f,-0.0f,200.0f,-0.0f,};
    private final float[][] mVerts = {
    		{10.0f,90.0f,50.0f,170.0f,120.0f,170.0f,120.0f,20.0f,140.0f,70.0f,180.0f,110.0f,240.0f,-30.0f,250.0f,80.0f,220.0f,110.0f,},
    		{110.0f,-20.0f,90.0f,60.0f,130.0f,110.0f,230.0f,30.0f,210.0f,60.0f,190.0f,100.0f,290.0f,60.0f,290.0f,140.0f,250.0f,140.0f,},
    		{240.0f,-30.000002f,180.0f,7.1225446E-7f,170.0f,59.999996f,270.0f,99.99999f,250.0f,100.0f,220.0f,99.99999f,270.0f,160.0f,240.0f,200.0f,220.0f,170.0f,},
    		};
    private final short[] mIndices = { 0,3,1,3,1,4,3,6,4,6,4,7,1,4,2,4,2,5,4,7,5,7,5,8,};

	public AirSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	public void update()
	{
		if (state == GATHER)
		{
			if(this.nextScriptInt(mVerts.length))
			{
				this.setState(DISABLE);
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if (state == MOVE)
		{
			this.drawImage(canvas, GameConsts.MONSTER_AIR_SCRIPT[type], x, y);
		}
		else if (state == GATHER)
		{
			this.drawImage(canvas, GameConsts.MONSTER_AIR_SCRIPT[type], x, y, mTexs, mVerts[scriptInt], mIndices);
		}
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public void setVector(int x1, int y1, int x2, int y2)
	{
		vector = new VectorMath(x1, y1, x2, y2);
	}

	public int getSpeedX(int dir)
	{
		return vector.getX(dir);
	}

	public int getSpeedY(int dir)
	{
		return vector.getY(dir);
	}

	public int getEndX()
	{
		return endX;
	}

	public void setEndX(int endX)
	{
		this.endX = endX;
	}

	public int getEndY()
	{
		return endY;
	}

	public void setEndY(int endY)
	{
		this.endY = endY;
	}

	public int getHeroInt()
	{
		return heroInt;
	}

	public void setHeroInt(int heroInt)
	{
		this.heroInt = heroInt;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

}
