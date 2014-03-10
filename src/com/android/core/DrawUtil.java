package com.android.core;

import java.util.Locale;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.android.herodefender.Consts;

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
	public static void drawText(Canvas canvas, String text,int x,int y,int width,int height, int size,Typeface typeface)
	{
		int dsize = (int) (size * Consts.coordScale);
		int dwidth = (int) (width * Consts.coordScale);
		int dheight;
		Paint paint=new Paint();
		paint.setTextSize(dsize);
		paint.setARGB(255, 0, 0, 0);
		paint.setAntiAlias(true);
		paint.setTypeface(typeface);
		Vector<String> texts=getTexts(dwidth,text,paint,"\n");
		int textSize=texts.size();
		dheight=(height-size*(textSize+1))/2;
		for(int i=0;i<textSize;i++)
		{
			drawText(canvas,texts.get(i), x,y+dheight+size*(i+1),paint);
		}
	}
	public static Vector<String> getTexts(int width, String text, Paint f, String token)
    {
	    Vector<String> v = new Vector<String>();
	    String tmp1 = "";
	    StringBuffer sb = new StringBuffer();
	    int length = 0;
	    for (int i = 0; i < text.length(); i++) {
	      tmp1 = text.substring(i, i + 1);
	      length += f.measureText(tmp1);
	      if (length > width) {
	        if ( (token != null && tmp1.equals(token))) {
	          v.addElement(sb.toString());
	          sb = new StringBuffer();
	          length = 0;
	        }
	        else {
	          v.addElement(sb.toString());
	          sb = new StringBuffer();
	          sb.append(tmp1);
	          length = (int)f.measureText(tmp1);
	        }
	      }
	      else if ( (token != null && tmp1.equals(token))) {
	        v.addElement(sb.toString());
	        sb = new StringBuffer();
	        length = 0;
	      }
	      else if (i == (text.length() - 1)) {
	        sb.append(tmp1);
	        v.addElement(sb.toString());
	      }
	      else {
	        sb.append(tmp1);
	      }
    }
    return v;
  }
	public static void drawText(Canvas canvas, String text, int x, int y, 
			int size,int radius,int a,int r, int g,int b,Typeface typeface,int shadowColor,Paint.Align align,boolean stroke)
	{
		int dsize = (int) (size * Consts.coordScale);
		int dradius = (int)(radius*Consts.coordScale);
		Paint paint = new Paint();
		paint.setTextSize(dsize);// 設定字體大小
		Locale.getDefault().getLanguage();
		paint.setTypeface(typeface);
		paint.setARGB(a, r, g, b);
		paint.setShadowLayer(dradius, 0, 0, shadowColor);
		paint.setAntiAlias(true);
		paint.setTextAlign(align);
		drawText(canvas,text, x,(int)(y-paint.descent()),paint);
		if(stroke)
		{
			Paint spaint=new Paint();
			spaint.setTextSize(dsize);
			spaint.setTypeface(typeface);
			spaint.setARGB(255, 0, 0, 0);
			spaint.setTextAlign(align);
			spaint.setStyle(Paint.Style.STROKE);
			spaint.setAntiAlias(true); 
			spaint.setStrokeWidth(2*Consts.coordScale);
			drawText(canvas,text, x,(int)(y-paint.descent()),spaint);
		}
	}
	public static void drawText(Canvas canvas,String text, int x, int y,Paint paint)
	{
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		canvas.save();
		canvas.drawText(text, dx, dy, paint);
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

//	public static void drawColorImage(Canvas canvas, Drawable drawable, int x, int y, int color, int size, int alpha)
//	{// alpha 0~255
//		int dsize = (int) (size * Consts.coordScale);
//		int width = drawable.getIntrinsicWidth() + dsize;
//		int height = drawable.getIntrinsicHeight() + dsize;
//		drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
//		drawable.setAlpha(alpha);
//		drawImage(canvas, drawable, x, y, width, height);
//		drawable.setColorFilter(null);
//		drawable.setAlpha(255);
//	}

	public static void drawScaleImage(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY)
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
	public static void drawShadowImage(Canvas canvas, Bitmap bitmap, int x, int y,int radius,int shadowColor)
	{
		int dr = (int)(radius*Consts.coordScale);
		Paint paint = new Paint();
		paint.setShadowLayer(dr, 0, 0, shadowColor);
		drawImage(canvas, bitmap, x, y,paint);
	}
	public static void drawImage(Canvas canvas, Bitmap bitmap, int x, int y,Paint paint)
	{
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		canvas.save();
		canvas.drawBitmap(bitmap.extractAlpha(), dx, dy, paint);
		canvas.restore();
	}
	public static void drawImage(Canvas canvas, Bitmap bitmap, int x, int y,float[]  mTexs,float[]  mVerts,short[]  mIndices)
	{
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		Paint paint=new Paint();
		Shader shader=new BitmapShader(bitmap, Shader.TileMode.CLAMP,
	                                        Shader.TileMode.CLAMP);
		paint.setShader(shader);
		canvas.save();
		canvas.translate(dx, dy);
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES, mVerts.length, getCoords(mVerts), 0,
                            getCoords(mTexs), 0, null, 0, mIndices, 0, mIndices.length, paint);
		canvas.restore();
	}
	private static float[] getCoords(float[] coords)
	{
		float[] coord=new float[coords.length];
		for(int i=0;i<coords.length;i++)
		{
			coord[i]=coords[i]*Consts.coordScale;
		}
		return coord;
	}
	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y,float src[],float dst[])
	{
		Matrix  matrix = new Matrix();
		matrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
		canvas.save();
		canvas.translate(x, y);
		canvas.concat(matrix);
		drawable.setBounds(0, 0, Consts.screenWidth, Consts.screenHeight);
		drawable.draw(canvas);
		canvas.restore();
	}
	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height)
	{
		canvas.save();
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		drawable.setBounds(dx, dy, dx + width, dy + height);
		if (setWindowClip(canvas, dx, dy, width, height))
		{
			drawable.draw(canvas);
		}
		canvas.restore();
	}



	public static void drawImage(Canvas canvas, Drawable drawable, int x, int y, int width, int height, int frameInt, float scaleX, float scaleY)
	{
		int imageWidth = (int) (drawable.getIntrinsicWidth() * scaleX);
		int imageHeight = (int) (drawable.getIntrinsicHeight() * scaleY);
		int width1 = (int) (width * scaleX);
		int height1 = (int) (height * scaleY);
		drawImage(canvas, drawable, x, y, width1, height1, frameInt, imageWidth, imageHeight);

	}

	public static void drawFrames(Canvas canvas, Drawable drawable, int x, int y, int width, int height, int[] frames)
	{
		int imageWidth = drawable.getIntrinsicWidth();
		int imageHeight = drawable.getIntrinsicHeight();
		int widthInt=imageWidth/width;
		int dx = (int) (x * Consts.coordScale);
		int dy = (int) (y * Consts.coordScale);
		for(int i=0;i<frames.length;i++)
		{
			drawable.setBounds(dx - width*(frames[i]%widthInt), 
			                   dy -	height*(frames[i]/widthInt), 
			                   dx - width*(frames[i]%widthInt) + imageWidth, 
			                   dy -	height*(frames[i]/widthInt)+ imageHeight);
			canvas.save();
			if (setWindowClip(canvas, dx, dy, width, height))
			{
				drawable.draw(canvas);
			}
			canvas.restore();
			dx=dx+width;
		}
		
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
