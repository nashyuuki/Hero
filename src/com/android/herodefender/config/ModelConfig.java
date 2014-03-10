package com.android.herodefender.config;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;

import com.android.core.CoreModel;
import com.android.core.GameBean;
import com.android.herodefender.BarrierModel;
import com.android.herodefender.GameModel;
import com.android.herodefender.LobbyModel;
import com.android.herodefender.ResultModel;
import com.android.herodefender.SetModel;
import com.android.herodefender.WinModel;

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
	public static final int RESULT=6;
	public static final int WIN=7;
	public static final int INIT_STATE = LOBBY;
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
				case RESULT:
					model=new ResultModel(gameBean);
					break;
				case WIN:
					model=new WinModel(gameBean);
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
