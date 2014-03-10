package com.android.herodefender;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

import com.android.core.CoreController;
import com.android.core.GameBean;
import com.game.herodefender.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivity extends Activity
{
	private CoreController core;
	private GameBean gameBean;
	private AdView adView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().setFlags(	WindowManager.LayoutParams.FLAG_FULLSCREEN,
								WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		gameBean = (GameBean) this.getApplicationContext();
		gameBean = new GameBean();
		gameBean.setContext(this);
		gameBean.init();
		core = new CoreController(gameBean);
		setContentView(core);
		// window manager preparation
		WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();
		windowParams.gravity = Gravity.TOP;
		windowParams.x = 0;
		windowParams.y = 0;
		windowParams.height = LayoutParams.WRAP_CONTENT;
		windowParams.width = LayoutParams.WRAP_CONTENT;
		windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
		  | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL 
		  | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
		  | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
		windowParams.format = PixelFormat.TRANSLUCENT;
		windowParams.windowAnimations = 0;
		 
		WindowManager wm = getWindowManager();
		// Create the adView
		adView = new AdView(this, AdSize.BANNER, "a152fb81ab7af3f");
		 
		// Initiate a generic request to load it with an ad
		AdRequest adRequest = new AdRequest();

		adRequest.addTestDevice(AdRequest.TEST_EMULATOR);               // 模擬工具
		adRequest.addTestDevice("9803448178A8346601D680160203FCCB");    // 用來測試的 Android 裝置
		adRequest.addTestDevice("4BB46284FC0A3139ECBDD18041A1DF54");
		adView.loadAd(adRequest);
		// Add adView to WindowManager
		wm.addView(adView, windowParams);
		Handler handler = new Handler() 
		{
	        @Override
			public void handleMessage(Message msg) 
	        {
	        	adView.setVisibility(msg.what);                
	        }
	    };
	    gameBean.setHandler(handler);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onPause()
	{
		core.pause();
		super.onPause();
	}
	@Override
	protected void onDestroy()
	{
		if (adView != null) 
		{
			  getWindowManager().removeView(adView);
		      adView.destroy();
		 }
		gameBean.getImageConfig().resetDrawables();
		super.onDestroy();
	}
	@Override
	protected void onResume()
	{
		core.resume();
		super.onResume();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			core.onBackKeyDown();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
}
