package com.android.core;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.android.herodefender.Consts;
import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.config.ModelConfig;
import com.android.herodefender.config.MusicConfig;

public class CoreController extends SurfaceView implements SurfaceHolder.Callback, Runnable
{
	private SurfaceHolder holder;
	private Thread thread;
	private boolean running;
	private boolean change;
	private ModelConfig modelConfig;
	private ImageConfig imageConfig;
	private MusicConfig musciConfig;
	private GameBean gameBean;
	private float upX, upY, downX, downY;
	private long lastUpdateTime;
	private long viewUpdateTime;
	private int timeUpdateSpeed = 200;
	public CoreController(GameBean gameBean)
	{
		super(gameBean.getContext());
		this.gameBean = gameBean;
		holder = getHolder();
		holder.addCallback(this);
		modelConfig = gameBean.getModelConfig();
		imageConfig = gameBean.getImageConfig();
		musciConfig = gameBean.getMusciConfig();
		running = false;
		change=false;
	}
	public void surfaceChanged(SurfaceHolder holder, int arg1, int width, int height)
	{
		if (running&&!change)
		{
			Consts.screenWidth = width;
			Consts.screenHeight = height;
			Drawable image = imageConfig.getDrawable(ImageConfig.BACKGROUND_SIZE);
			int imageWidth = image.getIntrinsicWidth();
			int imageHeight = image.getIntrinsicHeight();
			imageConfig.removeDrawable(ImageConfig.BACKGROUND_SIZE);
			float scaleX = (float) width / imageWidth;
			float scaleY = (float) height / imageHeight;
			float scale = 1;
			float coord = 1;
			if (scaleX < scaleY)
			{
				scale = scaleX;
//				Consts.screenHeight = (int) (imageHeight * scale);
				coord = (float) width / Consts.COORD_WIDTH;
			}
			else
			{
				scale = scaleY;
//				Consts.screenWidth = (int) (imageWidth * scale);
				coord = (float) height / Consts.COORD_HEIGHT;
			}
			Consts.screenScale = scale;
			Consts.coordScale = coord;
			change=true;
		}
	}
	
	
	public void surfaceCreated(SurfaceHolder holder)
	{
		setFocusable(true); // make sure we get key events
	}
	public void pause()
	{
		CoreModel coreModel = modelConfig.getModel(gameBean.getState());
		coreModel.pause();;
		// 存資料
		gameBean.storeGameBean();
		if (running)
		{
			running = false;
			try
			{
				thread.join();
			}
			catch (Exception e)
			{
				Log.v(Consts.TAG, "pause e:" + e);
			}
		}
	}

	public void resume()
	{
		// 讀資料
		gameBean.restoreGameBean();
		CoreModel coreModel = modelConfig.getModel(gameBean.getState());
		coreModel.restart();
		if (!running)
		{
			running = true;
			lastUpdateTime = System.currentTimeMillis();
			viewUpdateTime = System.currentTimeMillis();
			thread = new Thread(this);
			thread.start();
		}
	}
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		change=false;
		this.pause();
	}
	public void run()
	{
		while (running)
		{
			if(change){
				CoreModel coreModel = null;
				int state = gameBean.getState();
				int nextState = gameBean.getNextState();
				// 取得Model
				if (state == ModelConfig.INIT)
				{// 程式初始化
					state = ModelConfig.INIT_STATE;
					nextState = ModelConfig.INIT_STATE;
					coreModel = modelConfig.getModel(state);
					coreModel.init();
				}
				else if (state != nextState&&
						nextState!=ModelConfig.END)
				{// 狀態切換
					//將結束圖檔儲存
					Bitmap bitmap =this.getStateImage(state);
					// 清除Models資料
					modelConfig.resetModels();
					// 清除image資料
					imageConfig.resetDrawables();
					this.setStateImage(bitmap);
					if(nextState==ModelConfig.RESTART)
					{
						nextState=state;
					}
					else
					{
						state = nextState;
					}
					coreModel = modelConfig.getModel(state);
					if(coreModel!=null)
					{
						coreModel.init();
					}
					else
					{
						break;
					}
				}
				else
				{
					coreModel = modelConfig.getModel(state);
				}
				if(nextState!=ModelConfig.END)
				{
					gameBean.setState(state);
					gameBean.setNextState(nextState);
				}
				else
				{
					gameBean.finish();
				}
				long nowTime = System.currentTimeMillis();
				coreModel.updateView(nowTime - viewUpdateTime);
				viewUpdateTime = System.currentTimeMillis();
				if (this.nextTime(timeUpdateSpeed, lastUpdateTime))
				{
					lastUpdateTime = lastUpdateTime+timeUpdateSpeed;
					coreModel.update();
				}
				// 繪圖
				Canvas canvas=holder.lockCanvas();
				try
				{
					// 畫預設背景
					DrawUtil.drawRect(	canvas,
										0,
										0,
										Consts.screenWidth,
										Consts.screenHeight,
										Consts.BACKGROUND_COLOR[0],
										Consts.BACKGROUND_COLOR[1],
										Consts.BACKGROUND_COLOR[2],
										Consts.BACKGROUND_COLOR[3]);
					coreModel.drawView(canvas);
					if (canvas != null)
					{
						holder.unlockCanvasAndPost(canvas);
					}
				}
				catch (Exception e)
				{
					Log.v(Consts.TAG, "run e:" + e);
				}
				finally
				{
				}
			}
		}
	}
	private Bitmap getStateImage(int state)
	{
		CoreModel coreModel=modelConfig.getModel(state);
		Bitmap bitmap=Bitmap.createBitmap(Consts.screenWidth, Consts.screenHeight, Config.ARGB_8888);
		Canvas canvas=new Canvas(bitmap);
		DrawUtil.drawRect(	canvas,
							0,
							0,
							Consts.screenWidth,
							Consts.screenHeight,
							Consts.BACKGROUND_COLOR[0],
							Consts.BACKGROUND_COLOR[1],
							Consts.BACKGROUND_COLOR[2],
							Consts.BACKGROUND_COLOR[3]);
		coreModel.drawView(canvas);
		return bitmap;
	}
	private void setStateImage(Bitmap bitmap)
	{
		imageConfig.addDrawable(ImageConfig.BACKGROUND_STATE, bitmap);
	}
	public boolean nextTime(long timeSpeed, long lastTime)
	{
		long nowTime = System.currentTimeMillis();
		if (nowTime - lastTime > timeSpeed)
		{
			return true;
		}
		return false;
	}
	public ImageConfig getImageConfig()
	{
		return imageConfig;
	}
	public MusicConfig getMusciConfig()
	{
		return musciConfig;
	}
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		int state = gameBean.getState();
		int nextState = gameBean.getNextState();
		if(state==nextState)
		{
			CoreModel coreModel = modelConfig.getModel(gameBean.getState());
			coreModel.onKeyDown(keyCode);
		}
		return super.onKeyDown(keyCode, event);
	}

	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		int state = gameBean.getState();
		int nextState = gameBean.getNextState();
		if(state==nextState)
		{
			CoreModel coreModel = modelConfig.getModel(gameBean.getState());
			coreModel.onKeyUp(keyCode);
		}
		return super.onKeyUp(keyCode, event);
	}

	public void onBackKeyDown()
	{
		int state = gameBean.getState();
		int nextState = gameBean.getNextState();
		if(state==nextState)
		{
			CoreModel coreModel = modelConfig.getModel(gameBean.getState());
			coreModel.onBackKeyDown();
		}
	}
	public boolean onTouchEvent(MotionEvent event)
	{
		int state = gameBean.getState();
		int nextState = gameBean.getNextState();
		if(state==nextState)
		{
			CoreModel coreModel = modelConfig.getModel(gameBean.getState());
			int tx = (int) (event.getX() / Consts.coordScale);
			int ty = (int) (event.getY() / Consts.coordScale);
			int touchState = CoreModel.TOUCH_NON;
			switch (event.getAction())
			{
				case MotionEvent.ACTION_DOWN:
					downX = event.getX();
					downY = event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					upX = event.getX();
					upY = event.getY();
					float x = Math.abs(upX - downX);
					float y = Math.abs(upY - downY);
					double z = Math.sqrt(x * x + y * y);
					if(z>10)
					{
						int jiaodu = Math.round((float) (Math.asin(y / z) / Math.PI * 180));// 角度
						if (upY < downY && jiaodu > 45)
						{// 上
							touchState = CoreModel.TOUCH_UP;
						}
						else if (upY > downY && jiaodu > 45)
						{// 下
							touchState = CoreModel.TOUCH_DOWN;
						}
						else if (upX < downX && jiaodu <= 45)
						{// 左
							touchState = CoreModel.TOUCH_LEFT;
						}
						else if (upX > downX && jiaodu <= 45)
						{// 右
							touchState = CoreModel.TOUCH_RIGHT;
						}
						coreModel.onTouchEvent(tx, ty, event, touchState);
						downX = event.getX();
						downY = event.getY();
					}
					return false;
				case MotionEvent.ACTION_UP:
					break;
		}
		coreModel.onTouchEvent(tx, ty, event, touchState);
		}
		return true;
	}

	public GameBean getGameBean()
	{
		return gameBean;
	}
}
