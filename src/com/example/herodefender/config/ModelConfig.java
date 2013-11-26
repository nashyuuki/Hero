package com.example.herodefender.config;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;

import com.example.core.CoreModel;
import com.example.core.GameBean;
import com.example.herodefender.BarrierModel;
import com.example.herodefender.GameModel;
import com.example.herodefender.LobbyModel;
import com.example.herodefender.SetModel;

public class ModelConfig
{
	public static final int END=-2;
	public static final int INIT=-1;
	public static final int LOGO = 0;
	public static final int GAME = 1;
	public static final int LOBBY=2;
	public static final int SET=3;
	public static final int BARRIER=4;
	public static final int RESTART=5;
	public static final int INIT_STATE = GAME;
	private Map<String, CoreModel> models;
	private GameBean gameBean;

	public ModelConfig(GameBean gameBean)
	{
		this.gameBean = gameBean;
		models = new HashMap<String, CoreModel>();
	}

	public CoreModel getModel(int state)
	{
		CoreModel model = models.get("" + state);
		if (model == null)
		{
			switch (state)
			{
				case LOGO:
					// model=new LogoModel(coreController);
					break;
				case GAME:
					model = new GameModel(gameBean);
					break;
				case LOBBY:
					model=new LobbyModel(gameBean);
					break;
				case BARRIER:
					model=new BarrierModel(gameBean);
					break;
				case SET:
					Intent intent=new Intent();
					intent.setClass(gameBean.getContext(), SetModel.class);
					gameBean.getContext().startActivity(intent);
					gameBean.setNextState(ModelConfig.GAME);
					break;
				default:
					model = new GameModel(gameBean);
					break;
			}
			models.put("" + state, model);
		}
		return model;
	}

	public void resetModels()
	{
		models.clear();
	}
}
