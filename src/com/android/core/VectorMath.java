package com.android.core;

public class VectorMath
{
	private double vX;
	private double vY;

	public VectorMath(int x1, int y1, int x2, int y2)
	{
		double length = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		vX = (x2 - x1) / length;
		vY = (y2 - y1) / length;
	}

	public int getX(int speed)
	{
		return (int) (speed * vX);
	}

	public int getY(int speed)
	{
		return (int) (speed * vY);
	}
}
