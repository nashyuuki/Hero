package com.example.herodefender;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.example.core.CoreController;
import com.example.core.GameBean;

public class MainActivity extends Activity
{
	private CoreController core;
	private GameBean gameBean;
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
		Log.v("TEST", "onPause");
		core.pause();
		super.onPause();
	}
	@Override
	protected void onDestroy()
	{
		Log.v("TEST", "onDestroy");
		gameBean.getImageConfig().resetDrawables();
		super.onDestroy();
	}
	@Override
	protected void onResume()
	{
		Log.v("TEST", "onResume");
		core.resume();
		super.onResume();
	}
}
