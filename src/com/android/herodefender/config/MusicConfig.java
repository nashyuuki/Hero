package com.android.herodefender.config;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.android.core.GameBean;
import com.game.herodefender.R;

public class MusicConfig
{
	private Context context;
	public static final int BURST = 1;
	public static final int BOMB =2;
	public static final int MUSIC02 =3;
	public static final int DOOR =4;
	public static final int MUSIC01=5;
	public static final int BOW01=6;
	public static final int RESULT=7;
	public static final int BUTTON=8;
	public static final int TALK=9;
	private MediaPlayer music01=null;
	private MediaPlayer music02=null;
	private MediaPlayer open=null;
	private SoundPool soundPool;
	private Map<String, Integer> sounds;
	private GameBean gameBean;
	public MusicConfig(Context context,GameBean gameBean)
	{
		this.context = context;
		this.gameBean = gameBean;
		soundPool=new SoundPool(3, AudioManager.STREAM_MUSIC, 5);
		sounds=new HashMap<String, Integer>();
		this.putSound(BURST,  R.raw.bomb01);
		this.putSound(BOW01,  R.raw.bow1);
		this.putSound(BUTTON,  R.raw.button);
		this.putSound(BOMB,  R.raw.bomb02);
		this.putSound(DOOR,  R.raw.door);
		this.putSound(TALK, R.raw.talk);
		music01=MediaPlayer.create(context,R.raw.music);
		music01.setLooping(true);
		music02=MediaPlayer.create(context,R.raw.music01);
		music02.setVolume(0.0f,0.5f);
		open=MediaPlayer.create(context,R.raw.opening);
	}
	private void putSound(int music,int id)
	{
		int alertId = soundPool.load(context, id, 1);
		sounds.put(""+music, alertId);
	}
	private void playSound(int music)
	{
		int alertId=sounds.get(""+music);
		soundPool.play(alertId, 1.0F, 1.0F, 0, 0, 1.0F);
	}
	public void play(int music)
	{
		if(gameBean.isMusic())
		{
			switch (music)
			{
				case BURST:
					this.playSound(music);
					break;
				case BOMB:
					this.playSound(music);
					break;
				case DOOR:
					this.playSound(music);
					break;
				case MUSIC01:
					music01.start();
					break;
				case MUSIC02:
					music02.start();
					break;
				case BOW01:
					this.playSound(music);
					break;
				case RESULT:
					open.start();
					break;
				case BUTTON:
					this.playSound(music);
					break;
				case TALK:
					this.playSound(music);
					break;
			}
		}
	}
	public void stopMusic(int music)
	{
		switch (music)
		{
			case MUSIC01:
				music01.stop();
				music01=MediaPlayer.create(context,R.raw.music);
				music01.setLooping(true);
				break;
			case MUSIC02:
				music02.stop();
				music02=MediaPlayer.create(context,R.raw.music01);
				music02.setVolume(0.0f,0.5f);
				break;
		}
	}

}
