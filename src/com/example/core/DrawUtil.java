package com.example.core;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.example.herodefender.Consts;

public class DrawUtil
{
	
	public static void drawRect(Canvas canvas, int x, int y, int width, int height, int a, int r, int g, int b)
	{
		Paint paint = new Paint();
		paint.setARGB(a, r, g, b);
		drawRect(canvas, x, y, width, height, paint);
	}

	public static void drawRect(Canvas canvas, int x, int y, int width, int height, Paint paint)
	{
		canvas.save();
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		Rect rect = new Rect(dx, dy, dx + width, dy + height);
		int dwidth = (int) (width * Consts.coordScale);
		int dheight = (int) (height * Consts.coordScale);
		if (setWindowClip(canvas, dx, dy, dwidth, dheight))
		{
			canvas.scale(Consts.coordScale, Consts.coordScale, dx, dy);
			canvas.drawRect(rect, paint);
		}
		canvas.restore();
	}
	public static void drawRoundRect(Canvas canvas,int x1,int y1,int x2,int y2,int a, int r, int g, int b,int strokeWidth)
	{
		Paint paint = new Paint();
		paint.setARGB(a, r, b, g);
		float dstrokeWidth=strokeWidth * Consts.coordScale ;
		paint.setStrokeWidth(dstrokeWidth);
	    paint.setStyle(Style.STROKE);
	    int dx1=(int) (x1 * Consts.coordScale);
	    int dy1=(int) (y1 * Consts.coordScale);
	    int dx2=(int) (x2 * Consts.coordScale);
	    int dy2=(int) (y2 * Consts.coordScale);
		RectF rect = new RectF(dx1,dy1,dx2,dy2);
		canvas.save();
		canvas.drawRoundRect(rect, 20, 20, paint);
		canvas.restore();
	}
	public static void drawStrokeRect(Canvas canvas, int x, int y, int width, int height, int a, int r, int g, int b, int strokeWidth)
	{
		Paint paint = new Paint();
		paint.setARGB(a, r, g, b);
		paint.setStrokeWidth(strokeWidth);
		paint.setStyle(Style.STROKE);
		drawRect(canvas, x, y, width, height, paint);
	}

	public static void drawText(Canvas canvas, String text, int x, int y, int size)
	{
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		int dsize = (int) (size * Consts.coordScale);
		Paint paint = new Paint();
		paint.setTextSize(dsize);// 設定字體大小
		paint.setColor(Color.BLACK);
		int width = (int) paint.measureText(text);
		Paint rpaint = new Paint();
		rpaint.setARGB(255, 255, 255, 255);
		Rect rect = new Rect(dx, dy, dx + width, dy + dsize);
		canvas.save();
		if (setWindowClip(canvas, dx, dy, width, size))
		{
			canvas.drawRect(rect, rpaint);
			canvas.drawText(text, dx, dy + dsize, paint);
		}
		canvas.restore();

	}
	public static void drawTile(Canvas canvas, Drawable drawable, int x, int y,int w,int h)
	{//w 圖片橫的個數,h 圖片直的個數
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{
				drawOriginalImage(canvas, drawable, dx+i*width, dy+j*height, width, height);
			}
		}
	}
	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y)
	{
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		drawImage(canvas, drawable, x, y, width, height);
	}

	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int alpha)
	{// alpha 0~255
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		drawable.setAlpha(alpha);
		drawImage(canvas, drawable, x, y, width, height);
		drawable.setAlpha(255);
	}

	public static void drawColorImage(Canvas canvas, Drawable drawable, int x, int y, int color, int size, int alpha)
	{// alpha 0~255
		int dsize = (int) (size * Consts.coordScale);
		int width = drawable.getIntrinsicWidth() + dsize;
		int height = drawable.getIntrinsicHeight() + dsize;
		drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
		drawable.setAlpha(alpha);
		drawImage(canvas, drawable, x, y, width, height);
		drawable.setColorFilter(null);
		drawable.setAlpha(255);
	}

	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY)
	{
		int width = (int) (drawable.getIntrinsicWidth() * scaleX);
		int height = (int) (drawable.getIntrinsicHeight() * scaleY);
		drawImage(canvas, drawable, x, y, width, height);
	}
	public static void drawOriginalImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height)
	{//用在使用長寬被縮小的圖檔
		canvas.save();
		drawable.setBounds(x, y, x + width, y + height);
		if (setWindowClip(canvas, x, y, width, height))
		{
			drawable.draw(canvas);
		}
		canvas.restore();
	}
	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height)
	{
		canvas.save();
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		// int dwidth=(int)(width*Consts.screenScale);
		// int dheight=(int)(height*Consts.screenScale);
		drawable.setBounds(dx, dy, dx + width, dy + height);
		if (setWindowClip(canvas, dx, dy, width, height))
		{
			// canvas.scale(Consts.screenScale, Consts.screenScale, dx, dy);
			drawable.draw(canvas);
		}
		canvas.restore();
	}

	// public static void drawImage(Canvas canvas, Drawable drawable, int x,
	// int y, int width, int height)
	// {
	// canvas.save();
	// int dx=(int)(x*Consts.coordScale);
	// int dy=(int)(y*Consts.coordScale);
	// int dwidth=(int)(width*Consts.screenScale);
	// int dheight=(int)(height*Consts.screenScale);
	// drawable.setBounds(dx, dy, dx + width, dy + height);
	// if (setWindowClip(canvas, dx, dy, dwidth, dheight))
	// {
	// canvas.scale(Consts.screenScale, Consts.screenScale, dx, dy);
	// drawable.draw(canvas);
	// }
	// canvas.restore();
	// }

	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height, int frameInt)
	{
		int imageWidth = drawable.getIntrinsicWidth();
		int imageHeight = drawable.getIntrinsicHeight();
		drawImage(canvas, drawable, x, y, width, height, frameInt, imageWidth, imageHeight);

	}

	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height, int frameInt, float scaleX, float scaleY)
	{
		int imageWidth = (int) (drawable.getIntrinsicWidth() * scaleX);
		int imageHeight = (int) (drawable.getIntrinsicHeight() * scaleY);
		int width1 = (int) (width * scaleX);
		int height1 = (int) (height * scaleY);
		drawImage(canvas, drawable, x, y, width1, height1, frameInt, imageWidth, imageHeight);

	}

	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height, int frameInt, int imageWidth, int imageHeight)
	{
		canvas.save();
		int widthInt = imageWidth / width;
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		drawable.setBounds(dx - width * (frameInt % widthInt), dy - height * (frameInt / widthInt), dx
				- width * (frameInt % widthInt) + imageWidth, dy - height * (frameInt / widthInt)
				+ imageHeight);
		if (setWindowClip(canvas, dx, dy, width, height))
		{
			drawable.draw(canvas);
		}
		canvas.restore();
	}

	public static boolean setWindowClip(Canvas canvas, int x, int y, int width, int height)
	{// 判斷是否會繪於螢幕上 true=畫 false=不畫
		// 設定clip的大小
		int windowWidth = Consts.screenWidth;
		int windowHeight = Consts.screenHeight;
		if (x > windowWidth)
		{
			return false;
		}
		if (y > windowHeight)
		{
			return false;
		}
		if (x < -width)
		{
			return false;
		}
		if (y < -height)
		{
			return false;
		}
		if (x + width > windowWidth)
		{
			width = windowWidth - x;
		}
		if (y + height > windowHeight)
		{
			height = windowHeight - y;
		}
		if (x < 0)
		{
			width += x;
			x = 0;
		}
		if (y < 0)
		{
			height += y;
			y = 0;
		}
		canvas.clipRect(x, y, x + width, y + height);
		return true;
	}
}
