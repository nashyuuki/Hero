package com.example.herodefender.sprite;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.example.core.DrawUtil;
import com.example.herodefender.config.ImageConfig;

public class Sprite
{
	public static final int DISABLE = 0;
	public int x;
	public int y;
	public int preState;
	public int state;
	public int scriptInt;
	private ImageConfig imageConfig;
	private int[] collisionArea = {};
	private int[] scaleArea;
	public float scale = 1;
	private int layer;

	public void update()
	{
	};

	public void drawView(Canvas canvas)
	{
	};

	public void drawView(Canvas canvas, int layer)
	{
		if (this.layer == layer)
		{
			this.drawView(canvas);
		}
	}

	public Sprite(ImageConfig imageConfig)
	{
		this.imageConfig = imageConfig;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}

	public void setPosition(int[] position)
	{
		this.x = position[0];
		this.y = position[1];
	}

	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void setState(int state)
	{
		this.preState = this.state;
		scriptInt = 0;
		this.state = state;
	}

	public int getState()
	{
		return state;
	}

	public boolean nextScriptInt(int scriptLength)
	{
		boolean scriptEnd = false;
		if (scriptInt < (scriptLength - 1))
		{
			scriptInt++;
		}
		else
		{
			scriptInt = 0;
			scriptEnd = true;
		}
		return scriptEnd;
	}

	public boolean nextScriptInt(int scriptInt, int scriptLength)
	{
		boolean scriptEnd = false;
		if (scriptInt < (scriptLength - 1))
		{
			scriptInt++;
		}
		else
		{
			scriptEnd = true;
		}
		return scriptEnd;
	}

	public boolean isCollision(Sprite s1)
	{
		int x0, y0, x1, y1, ox0, oy0, ox1, oy1;
		int[] s1Area = s1.getCollisionArea();
		x0 = this.scaleArea[0] + this.getX();
		y0 = this.scaleArea[1] + this.getY();
		x1 = this.scaleArea[2] + this.getX();
		y1 = this.scaleArea[3] + this.getY();
		ox0 = s1Area[0] + s1.getX();
		oy0 = s1Area[1] + s1.getY();
		ox1 = s1Area[2] + s1.getX();
		oy1 = s1Area[3] + s1.getY();
		if (ox0 < x1 && x0 < ox1 && oy0 < y1 && y0 < oy1)
		{
			return true;
		}
		return false;
	}

	public boolean isCollision(int x, int y)
	{
		return this.isCollision(x, y, scaleArea);
	}
	public boolean isCollision(int x, int y,int[] area)
	{
		int x0, y0, x1, y1;
		x0 = area[0] + this.getX();
		y0 = area[1] + this.getY();
		x1 = area[2] + this.getX();
		y1 = area[3] + this.getY();
		if (x > x0 && x < x1 && y > y0 && y < y1)
		{
			return true;
		}
		return false;
	}
	public Drawable getDrawable(int image)
	{
		return imageConfig.getDrawable(image);
	}

	public int getWidth(int image)
	{
		return this.getDrawable(image).getIntrinsicWidth();
	}

	public int getHeight(int image)
	{
		return this.getDrawable(image).getIntrinsicHeight();
	}
	public void drawRoundRect(Canvas canvas,int x1,int y1,int x2,int y2,int a, int r, int g, int b,int strokeWidth)
	{
		DrawUtil.drawRoundRect(canvas,x1,y1,x2,y2,a, r, g, b,strokeWidth);
	}
	public void drawTile(Canvas canvas, int image, int x, int y,int w,int h)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawTile(canvas, drawable, x, y, w, h);
	}
	public void drawImage(Canvas canvas, int image, int x, int y, int width, int height, int frameInt, float scaleX, float scaleY)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawImage(canvas, drawable, x, y, width, height, frameInt, scaleX, scaleY);
	}

	public void drawRect(Canvas canvas, int x, int y, int width, int height, int a, int r, int g, int b)
	{
		DrawUtil.drawRect(canvas, x, y, width, height, a, r, g, b);
	}

	public void drawStrokeRect(Canvas canvas, int x, int y, int width, int height, int a, int r, int g, int b, int strokeWidth)
	{
		DrawUtil.drawStrokeRect(canvas, x, y, width, height, a, r, g, b, strokeWidth);
	}

	public void drawImage(Canvas canvas, int image, int x, int y, int width, int height, int frameInt)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawImage(canvas, drawable, x, y, width, height, frameInt);
	}

	public void drawImage(Canvas canvas, int image, int x, int y)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawImage(canvas, drawable, x, y);
	}

	public void drawColorImage(Canvas canvas, int image, int x, int y, int color)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawColorImage(canvas, drawable, x, y, color, 0, 255);
	}

	public void drawColorImage(Canvas canvas, int image, int x, int y, int color, int size, int alpha)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawColorImage(canvas, drawable, x, y, color, size, alpha);
	}

	public void drawText(Canvas canvas, String text, int x, int y, int size)
	{
		DrawUtil.drawText(canvas, text, x, y, size);
	}

	public void drawImage(Canvas canvas, int image, int x, int y, int alpha)
	{
		Drawable drawable = this.getDrawable(image);
		DrawUtil.drawImage(canvas, drawable, x, y, alpha);
	}

	public int[] getCollisionArea()
	{
		return collisionArea;
	}

	public void setCollisionArea(int[] collisionArea)
	{
		this.collisionArea = new int[collisionArea.length];
		for (int i = 0; i < collisionArea.length; i++)
		{
			this.collisionArea[i] = collisionArea[i];
		}

		this.setScale(scale);
	}

	public double getScale()
	{
		return scale;
	}

	public void setScale(float scale)
	{
		this.scale = scale;
		this.scaleArea = new int[collisionArea.length];
		for (int i = 0; i < this.scaleArea.length; i++)
		{
			this.scaleArea[i] = (int) (collisionArea[i] * scale);
		}
	}

	public int getScriptInt()
	{
		return scriptInt;
	}

	public void setScriptInt(int scriptInt)
	{
		this.scriptInt = scriptInt;
	}

	public int getLayer()
	{
		return layer;
	}

	public void setLayer(int layer)
	{
		this.layer = layer;
	}

	public int getPreState()
	{
		return preState;
	}

	public void setPreState(int preState)
	{
		this.preState = preState;
	}
}
