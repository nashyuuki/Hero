package com.example.herodefender.sprite;

public class Item
{
	public static final int NONE=-1;
	public static final int BULLET=0;
	public static final int CROSS=1;
	public static final int SYRINGE=2;
	private int type;
	private boolean useful;
	public Item()
	{
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public boolean isUseful()
	{
		return useful;
	}
	public void setUseful(boolean useful)
	{
		this.useful = useful;
	}
	
}
