package com.example.herodefender;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SetModel extends Activity implements SeekBar.OnSeekBarChangeListener
{
	private static final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
	private static final int WP = ViewGroup.LayoutParams.WRAP_CONTENT;
	private SeekBar speedBar;
	private TextView speedText;
	public SetModel()
	{
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		this.setContentView(linearLayout);
		speedBar=new SeekBar(this);
		speedBar.setMax(5);
		speedText=new TextView(this);
		speedText.setText("速度:"+speedBar.getProgress());
		
		linearLayout.addView(speedText,new LinearLayout.LayoutParams(WP, WP));
		linearLayout.addView(speedBar,new LinearLayout.LayoutParams(MP, WP));
		speedBar.setOnSeekBarChangeListener(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
	{
		speedText.setText("速度:"+speedBar.getProgress());
		
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar)
	{
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar)
	{
		
	}

}
