package com.android.herodefender.sprite;

import android.graphics.Canvas;
import android.util.Log;

import com.android.herodefender.Consts;
import com.android.herodefender.config.ImageConfig;

public class EffectSprite extends Sprite
{
	public static final int MOVE=1;
	public static final int MOVE_END=2;
	private float[] src;
	private float[] dst;
	public EffectSprite(ImageConfig imageConfig)
	{
		super(imageConfig);
		src=this.getSrc();
		dst=this.getSrc();
	}
	private float[] getSrc()
	{
		return new float[]{
				0,0,
				0,Consts.screenHeight,
				Consts.screenWidth,0,
				Consts.screenWidth,Consts.screenHeight
				};
	}
	public void update()
	{
		if(state==MOVE)
		{
			if(this.getDrawable(ImageConfig.BACKGROUND_STATE)==null)
			{
				this.setState(MOVE_END);
			}
			int lengthX=Consts.screenWidth/(40-scriptInt*2);
			int lengthY=Consts.screenHeight/(40-scriptInt*2);
			scriptInt++;
			dst[0]=dst[0]+lengthX;
			dst[1]=dst[1]+lengthY;
			dst[2]=dst[2]+lengthX;
			dst[3]=dst[3]-lengthY;
			dst[4]=dst[4]-lengthX;
			dst[5]=dst[5]+lengthY;
			dst[6]=dst[6]-lengthX;
			dst[7]=dst[7]-lengthY;
			if(dst[0]>Consts.screenWidth/2)
			{
				this.removeImage(ImageConfig.BACKGROUND_STATE);
				this.setState(MOVE_END);
			}
		}
	}
	public void drawView(Canvas canvas)
	{
		if(state==MOVE)
		{
			this.drawImage(canvas, ImageConfig.BACKGROUND_STATE, x, y,src,dst);
		}
	}
	
}
