package com.android.herodefender.sprite;

import android.graphics.Canvas;

import com.android.herodefender.GameConsts;
import com.android.herodefender.config.ImageConfig;

public class PickSprite extends Sprite
{
	public static final int STAY=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;
	private Item[] items;
	private int index;
	public PickSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
	}
	@Override
	public void update()
	{
		if(state==LEFT)
		{
			scriptInt=scriptInt+GameConsts.BARRIER_MOVE_SCRIPT[1];
			if(scriptInt>GameConsts.BARRIER_MOVE_SCRIPT[0])
			{
				index++;
				if(index>items.length-1)
				{
					index=0;
				}
				this.setState(STAY);
			}
		}
		else if(state==RIGHT)
		{
			scriptInt=scriptInt+GameConsts.BARRIER_MOVE_SCRIPT[1];
			if(scriptInt>GameConsts.BARRIER_MOVE_SCRIPT[0])
			{
				index--;
				if(index<0)
				{
					index=items.length-1;
				}
				this.setState(STAY);
			}
		}
	}
	@Override
	public void drawView(Canvas canvas)
	{
		if(state==STAY)
		{
			int[] indexs=this.getIndexs(index);
			for(int i=0;i<indexs.length;i++)
			{
				int dx=x+i*GameConsts.BARRIER_MOVE_SCRIPT[0];
				this.drawItem(canvas,dx, y,indexs[i]);
			}
			this.drawImage(canvas, ImageConfig.FRAME_PICK01, 
			               x+GameConsts.BARRIER_MOVE_SCRIPT[4], 
			               y+GameConsts.BARRIER_MOVE_SCRIPT[5]);
		}
		else if(state==LEFT)
		{
			int[] indexs=this.getIndexs(index);
			for(int i=1;i<indexs.length;i++)
			{
				int dx=x+i*GameConsts.BARRIER_MOVE_SCRIPT[0]-scriptInt;
				this.drawItem(canvas,dx, y,indexs[i]);
			}
			this.drawImage(canvas, ImageConfig.FRAME_PICK02, 
			               x+GameConsts.BARRIER_MOVE_SCRIPT[4], 
			               y+GameConsts.BARRIER_MOVE_SCRIPT[5]);
		}
		else if(state==RIGHT)
		{
			int[] indexs=this.getIndexs(index);
			for(int i=0;i<indexs.length-1;i++)
			{
				int dx=x+i*GameConsts.BARRIER_MOVE_SCRIPT[0]+scriptInt;
				this.drawItem(canvas,dx, y,indexs[i]);
			}
			this.drawImage(canvas, ImageConfig.FRAME_PICK02, 
			               x+GameConsts.BARRIER_MOVE_SCRIPT[4], 
			               y+GameConsts.BARRIER_MOVE_SCRIPT[5]);
		}
	}
	private void drawItem(Canvas canvas,int x,int y,int index)
	{
		int type=items[index].getType();
		boolean useful=items[index].isUseful();
		this.drawImage(canvas, GameConsts.ITEM_SCRIPT[type], x, y);
		if(!useful)
		{
			this.drawImage(canvas, ImageConfig.ITEM_STOP, x, y);
		}
	}
	private int[] getIndexs(int index)
	{
		int[] indexs=new int[3];
		indexs[0]=index-1;
		indexs[1]=index;
		indexs[2]=index+1;
		if(indexs[0]<0)
		{
			indexs[0]=items.length-1;
		}
		if(indexs[2]>items.length-1)
		{
			indexs[2]=0;
		}
		return indexs;
	}
	public int getItmeType()
	{
		if(items[index].isUseful())
		{
			return items[index].getType();
		}
		else
		{
			return Item.NONE;
		}
	}
	public Item[] getItems()
	{
		return items;
	}
	public void setItems(Item[] items)
	{
		this.items = items;
	}
	public int getIndex()
	{
		return index;
	}
	public void setIndex(int index)
	{
		this.index = index;
	}
}
