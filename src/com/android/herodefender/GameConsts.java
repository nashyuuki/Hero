package com.android.herodefender;

import com.android.herodefender.config.ImageConfig;
import com.android.herodefender.sprite.ButtonSprite;
import com.android.herodefender.sprite.FrameSprite;
import com.android.herodefender.sprite.MonsterSprite;
import com.android.herodefender.sprite.RoleSprite;
import com.android.herodefender.sprite.WallSprite;
import com.android.herodefender.sprite.WordSprite;

import android.content.res.Resources;
import android.graphics.Color;

public class GameConsts
{
	Resources resources;
	public static final int CITYWALL_HP = 100;
	public static final int BAT_ATTACK = 3;
	public static final int BAT_SPEED = 3;
	public static final int HURT_STONE_POSITION = -20;
	public static final int ARROW_ATTACK = 1;
	public static final int MONSTER_HP = 100;
	public static final int MONSTER_ATTACK = 5;
	public static final int HERO_MP = 10;
	public static final int AIR_MP = 1;
	public static final int ARROW_SPEED = 2;
	public static final int AIR_SPEED = 3;
	public static final int WOUND_BIG_MULTIPLE = 34;
	public static final int WOUND_MID_MULTIPLE = 5;
	public static final int MONSTER_SPEED = 15;
	public static final int BOMB_INT = 3;
	public static final int MONSTER_BOMB_INT=15;
	public static final int ARROW_END_POSITION=-110;
	public static final int[] WIN_POSITION={8,245};
	public static final int ARROW_SHADOW_POSITION=50; 
	public static final int[] TALK_WEAPON_POSITION={42,5};
	public static final int[] BUTTON_TYPE =
		{
				ImageConfig.BUTTON_TRIANGLE_LEFT01,
				ImageConfig.BUTTON_TRIANGLE_RIGHT01,
				ImageConfig.BUTTON_START_B01,
				ImageConfig.BUTTON_BACK01,
				ImageConfig.BUTTON_INFO01
		};
	public static final int[] TEAM_POSITION=
			{
				334,160
			};
	public static final int[] UI_REALLY_POSITION=
			{
				7,65
			};
	public static final int[][] LOBBY_BUTTON_COLLISION =
		{
			{0,0,487,141},
			{0,0,487,141},
			{0,0,487,141},
			{0,0,230,141}};
	public static final int[][] LOBBY_BUTTON_POSITION =
		{
			{WordSprite.TYPE_START,0,630},
			{WordSprite.TYPE_TEAM,420,630},
			{WordSprite.TYPE_EXIT,840,630},
			{WordSprite.TYPE_MUSIC,1060,520},};
	public static final int[][] BARRIER_BUTTON_COLLISION =
		{
			{0,0,101,106},
			{0,0,101,106},
			{0,0,380,155},
			{0,0,156,154},
			{0,0,156,154},};
	public static final int[] FRAME_POSITION =
		{893,738,255,0,0,0,15};
	public static final int[] FRAME_COLLISION=
			{
				60,40,850,600
			};
	public static final int[] TALK_IMAGE_SCRIPT=
			{
				ImageConfig.UI_TALK01,
				ImageConfig.UI_TALK02,
			};
	public static final int[][] TALK_SCRIPT=
			{
				{30, 26, 330,230, 40,},
				{90, 26, 330,230, 40,},
			};
	public static final int[] BARRIER_FRAME_POSITION =
		{13,10,FrameSprite.BIG,};
	
	
	public static final int[][] ROLE_POSITION=
			{
				{0,0},
				{0,0},
				{-73,-20},
			};
	public static final int[][] BARRIER_ROLE_SCRIPT =
		{
					{
							ImageConfig.ROLE_VAMPIRE01,
							ImageConfig.ROLE_VAMPIRE02,
							ImageConfig.ROLE_VAMPIRE03,
							ImageConfig.ROLE_VAMPIRE04},
					{
							ImageConfig.ROLE_WEREWOLVES01,
							ImageConfig.ROLE_WEREWOLVES02,
							ImageConfig.ROLE_WEREWOLVES03,
							ImageConfig.ROLE_WEREWOLVES04},
					{
							ImageConfig.ROLE_ZOMBIE01,
							ImageConfig.ROLE_ZOMBIE02,
							ImageConfig.ROLE_ZOMBIE03,
							ImageConfig.ROLE_ZOMBIE04,}};
	public static final int[] ITEM_TO_MONSTER=
			{
				1,2,0,
			};
	public static final int[] ITEM_SCRIPT=
			{
				ImageConfig.ITEM_BULLET,
				ImageConfig.ITEM_CROSS,
				ImageConfig.ITEM_SYRINGE,
			};
	public static final int[] BARRIER_MOVE_SCRIPT=
			{// PICK距離 ,PICK移動速度 ,角色出現距離,角色移動速度
			 // PICK圖檔 x,y
				70,30,1000,3,-7,-28
			};
	public static final int[][] PICK_POSITION=
			{
				{913,28},
				{913,228},
				{913,428},
			};
	public static final int[] PICK_COLLISION=
			{
				0,0,188,166
			};
	public static final int[][] BARRIER_ROLE_POSITION=
			{
				{280,40},
				{0,40},
				{560,40},
			};
	public static final int[][] BARRIR_BUTTON_POSITION =
		{
			{ButtonSprite.TYPE_TRIANGLE_LEFT,168,630},
			{ButtonSprite.TYPE_TRIANGLE_RIGHT,649,630},
			{ButtonSprite.TYPE_START_B,915,609},
			{ButtonSprite.TYPE_BACK,1128,4},
			{ButtonSprite.TYPE_INFO,1128,200}};
	public static final int[][] BUTTON_PUSH_SCRIPT =
		{
			{ImageConfig.BUTTON_TRIANGLE_LEFT02,ImageConfig.BUTTON_TRIANGLE_LEFT02},
			{ImageConfig.BUTTON_TRIANGLE_RIGHT02,ImageConfig.BUTTON_TRIANGLE_RIGHT02},
			{ImageConfig.BUTTON_START_B02,ImageConfig.BUTTON_START_B02},
			{ImageConfig.BUTTON_BACK02,ImageConfig.BUTTON_BACK03},
			{ImageConfig.BUTTON_INFO02,ImageConfig.BUTTON_INFO02}};
	public static final int[] BOMB_POSITION =
		{185,56,44};
	public static final int[] GOLD_POSITION =
		{308,65};
	public static final int[] STAGE_POSITION =
		{434,65};
	
	public static final int[] BAR_POSITION =
		{3,616};
	public static final int[] BUTTON_POSITION =
		{105,60};
	public static final int[] BUTTON_COLLISION =
		{88,59,168,108};
	public static final int[] MENU_PAUSE_POSITION =
			//x1,y1,x2,y2
			{334,160,85,203};
	public static final int[][] MENU_COLLISION=
			{
				{74,200,191,323},
				{245,200,362,323},
				{427,200,544,323},
			};
	public static final int[] RESULT_HERO_POSITION={770,11};
	public static final int[][] RESULT_WORD_POSITION=
			{
				{100,0},
				{100,250},
				{100,500},
			};
	public static final int[] RESULT_SCRIPT={0,10,20,30};
	public static final String[] RESULT_TEXT={"最後的結果是","...","......."};
	public static final String MENU_TEXT="暫停";
	public static final String BARRIER_TEXT="關卡";
	public static final String HERO_TEXT="勇者行不行";
	public static final String[] LOBBY_TEXT={"開 始","團 隊","離 開","音樂"};
	public static final String BAR_TEXT="關卡";
	public static final String[] HERO_TYPE_TEXT={"上","中","下"};
	public static final String[] RESULT_WORD_TEXT=
			{
				".勇者!",
				"殺",
				"隻殭屍!",
				"隻狼人!",
				"隻吸血鬼!",
				"武器解鎖",
				"獲得炸彈",
			};
	public static final int[][] TALK_POSITION=
			{
				{520,430,FrameSprite.TYPE_TALK01},
				{480,255,FrameSprite.TYPE_TALK01},
				{410,0,FrameSprite.TYPE_TALK02},
				{520,0,FrameSprite.TYPE_TALK02},
				{680,150,FrameSprite.TYPE_TALK01},
				{680,150,FrameSprite.TYPE_TALK01},
				{620,150,FrameSprite.TYPE_TALK01},
				{620,30,FrameSprite.TYPE_TALK01},
				{540,55,FrameSprite.TYPE_TALK02},
				{540,55,FrameSprite.TYPE_TALK02},
				{550,150,FrameSprite.TYPE_TALK02},
				{530,140,FrameSprite.TYPE_TALK01},
				{300,210,FrameSprite.TYPE_TALK02},
				{728,193,FrameSprite.TYPE_TALK02},
				{504,248,FrameSprite.TYPE_TALK02},
				{342,193,FrameSprite.TYPE_TALK01},
			};
	public static final String[] TALK_TEXT=
			{
				"必須先通過前面關卡。",
				"滑動切換武器。",
				"向上滑動發光的門。",
				"向左滑動發光的門。",
				"狼人怕銀彈，觸碰發光的圓圈切換武器。",
				"勇者怕弓箭，觸碰發光的圓圈切換武器。",
				"觸碰發光的圓圈丟出炸彈。",
				"殺掉10隻怪物，勇者發光，可以放出火焰清掉所有怪物。",	
			};
	public static final String[][] TALK_RESULT_TEXT=
			{
				{"你贏了！","你輸了！","得到了",},
				{"上.勇者","中.勇者","下.勇者",},
				{"針筒！","銀彈！","十字架！",},
			};
	public static final String[] TALK_BARRIER_TEXT=
			{
				/*0*/"不知道怎麼玩，依照遊戲指示，玩完這關就對了！！",
				/*1*/"銀彈！！！\n我一點也不怕～～",
				/*2*/"這殺小啊！都打到家裡來了！",
				/*3*/"狼人最不靠譜了！只會出一張嘴！！",
				/*4*/"嘖！小嫩嫩！一點都不痛！",
				/*5*/"其實！我是跟鄉民進來看熱鬧的，只是往前站了一點…",
				/*6*/"你媽叫你回家吃飯！！",
				/*7*/"搞毛呀！告你虐待動物哦！！！",
				/*8*/"耶！等了好久終於等到今天～！上場摟！！",
				/*9*/"斷開魂結！斷開鎖鏈！斷開一切的牽連！",
				/*10*/"得罪了方丈還想走！",
				/*11*/"殭屍哪有這麼帥！",
				/*12*/"殭屍不給力呀！靠我來打贏你吧！",
				/*15*/"謗佛者死！！",
				/*13*/"唉壓！我要在地上寫個慘字！",
				/*14*/"最後這關根本佛心來的嘛！",
			};
	public static final String[] TALK_WIN_TEXT=
			{
				"凹～凹嗚!這該不會是傳說中的破關吧!",
				"我們都大和解了還能有假嗎?",
				"都是殭屍只會在地上翻滾害的!",
				"滾的好!凹嗚～～",
				"唉~!其實我想當個好人!",
				"去死啦!等下輩子吧你!",
				"去死吧!你投胎去吧你!汪汪!",
				"有點常識好嗎?就是死了才會變殭屍好嗎!",
				"別吵了!其實大家都很盡力了啦!包括作者!",
				"其實是玩家太厲害了!太優秀了啦!",
				"VERY GOOD!凹凹～!",
				"感謝你～!",
				"期待再見哦～!",
				"再見囉～!",
				"Goodbye～凹嗚～!\n破關獎勵所有武器解鎖！"
			};
	public static final String[] TEAM_TEXT=
			{
				"團隊名單",
				"程式設計",
				"Nash Yuuki",
				"美術設計",
				"巫大明",
			};
	public static final int[][] TEAM_WORD_POSITION=
			{
				{325, 10, 100, 20, 255, 245, 238, 85, Color.WHITE},
				{325, 110, 60, 20, 255, 245, 238, 85, Color.WHITE},
				{325, 190, 60, 20, 255, 245, 238, 85, Color.WHITE},
				{325, 290, 60, 20, 255, 245, 238, 85, Color.WHITE},
				{325, 360, 60, 20, 255, 245, 238, 85, Color.WHITE},
			};
	public static final int[] WIN_TALK_SCRIPT=
			{
				FrameSprite.TYPE_WIN_W,
				FrameSprite.TYPE_WIN_H,
				FrameSprite.TYPE_WIN_V,
				FrameSprite.TYPE_WIN_W,
				FrameSprite.TYPE_WIN_Z,
				FrameSprite.TYPE_WIN_V,
				FrameSprite.TYPE_WIN_W,
				FrameSprite.TYPE_WIN_Z,
				FrameSprite.TYPE_WIN_H,
				FrameSprite.TYPE_WIN_V,
				FrameSprite.TYPE_WIN_W,
				FrameSprite.TYPE_WIN_Z,
				FrameSprite.TYPE_WIN_H,
				FrameSprite.TYPE_WIN_V,
				FrameSprite.TYPE_WIN_W,
			};
	public static final String WIN_TEXT ="Congratulations";
	public static final int[][] RESULT_TEXT_POSITION=
			{//x,y,size,radius,a,r,b,g,radiusColor
				{-64,64,64,20,255,0,0,0,Color.WHITE},//勇者
				{0,128,56,20,255,0,0,0,Color.WHITE},//殺
				{128,128,56,20,255,255,0,0,Color.WHITE},//數字
				{192,128},//隻殭屍!
				{0,192},//殺
				{128,192},//數字
				{192,192},//隻狼人!
				{0,256},//殺
				{128,256},//數字
				{196,256},//隻吸血鬼!
				{580,128,64,20,255,255,255,255,Color.YELLOW},//武器解鎖
				{580,192},
				{580,256}
				
			};
	public static final int[] BAR_WORD_POSITION=
			{
				400, 103, 45, 20, 255, 245, 238, 85, Color.WHITE
			};
	public static final int[][] BAR_UI_POSITION=
			{
				{ImageConfig.BAR_TIME,499, 59},
				{ImageConfig.BAR_BLOOD,840,59},
			};
	public static final int[] MENU_POSITION=
			{// centerX,centerY,size,a,r,g,b
				311, 200, 120,20, 255, 255, 0, 0 , Color.BLACK
			};
	public static final int[] BARRIER_WORD_POSITION=
			{// x,y, size a,
				454,720,90,20,255,255, 0, 0, Color.WHITE
			};
	public static final int[] HERO_WORD_POSITION=
			{//50,50,200
				640,200,180,255,255,200,0,Color.argb(255, 255, 255, 100)
			};
	public static final int[] WIN_WORD_POSITION=
			{
				640,200,140,255,255,0,0,Color.WHITE
			};
	public static final int[][] LOBBY_TEXT01_POSITION=
			{
				{ImageConfig.BUTTON_STAY,200,115,85,0,255,255,0,0,Color.WHITE},
				{ImageConfig.BUTTON_STAY,200,115,85,0,255,255,0,0,Color.WHITE},
				{ImageConfig.BUTTON_STAY,200,115,85,0,255,255,0,0,Color.WHITE},
				{ImageConfig.BUTTON_MUSIC01,115,108,67,0,255,12,255,0,Color.WHITE},
			};
	public static final int[][] LOBBY_TEXT02_POSITION=
			{
				{ImageConfig.BUTTON_PUSH,200,110,78,0,255,68,1,1,Color.WHITE},
				{ImageConfig.BUTTON_PUSH,200,110,78,0,255,68,1,1,Color.WHITE},
				{ImageConfig.BUTTON_PUSH,200,110,78,0,255,68,1,1,Color.WHITE},
				{ImageConfig.BUTTON_MUSIC02,115,103,67,0,255,3,47,1,Color.WHITE},
			};
	public static final int[][] BAR_START_SCRIPT=
			{
				{0,2},
				{0,1,2},
				{0,1,1,1,2},
				{0,1,1,1,1,1,1,2},
				{0,1,1,1,1,1,1,1,1,1,1,2},
				{0,1,1,1,1,1,1,1,1,1,1,1,2},
			}; 			
	public static final int[] BURST_COLLISION=
			{
				97,161,274,330
			};
	public static final int[] BURST_POSITION =
		{-150,-40};
	public static final int[] BURST_SCRIPT =
		{
				ImageConfig.BURST01,ImageConfig.BURST02,ImageConfig.BURST03,
		};
	public static final int[] BOOM_POSITION=
			{19,36};
	public static final int[] BOOM_SCRIPT=
			{
				ImageConfig.BOOM_BURST01,
				ImageConfig.BOOM_BURST01,
				ImageConfig.BOOM_BURST02,
				ImageConfig.BOOM_BURST03,
				ImageConfig.BOOM_BURST02,
				ImageConfig.BOOM_BURST03,
				ImageConfig.BOOM_BURST04,
			};
	public static final int[] BURST_END_SCRIPT=
			{
				ImageConfig.BURST04,
				ImageConfig.BURST05,
				ImageConfig.BURST06,
			};
	public static final int[] BACKGROUND_POSITION =
		{0,0};
	public static final int[] CITYWALL_POSITION =
		{987,-19};
	public static final int[] BAR_TIME_POSITION =
		{559,68,248,32,5};
	public static final int[] BAR_HP_POSITION =
		{// x,y,width,height,size
		905,68,261,32,5};
	public static final int[][] SELECT_POSITION=
			{
				{94,62},
				{84,168},
				{174,213},
			};
	public static final int[] SELECT_COLLISION=
			{15,11,106,106};
	public static final int[][] SELECT_TYPE_POSITION=
			{
				{ImageConfig.SELECT_ARROW,33,14},
				{ImageConfig.SELECT_BULLET,33,14},
				{ImageConfig.SELECT_CROSS,33,14},
				{ImageConfig.SELECT_SYRINGE,33,14},
				{ImageConfig.SELECT_BOMB,33,14},
				{ImageConfig.SELECT_BOOM,19,37},
			};
	public static final int[] CITYWALL_STAY_SCRIPT =
		{
				ImageConfig.CITY_WALL_STAY01,
				ImageConfig.CITY_WALL_STAY03,
				ImageConfig.CITY_WALL_STAY05,
				ImageConfig.CITY_WALL_STAY07,
				ImageConfig.CITY_WALL_STAY09,};
	public static final int[] CITYWALL_DESTROY_SCRIPT =
		{
				ImageConfig.CITY_WALL_DESTROY01,
				ImageConfig.CITY_WALL_DESTROY02,
				ImageConfig.CITY_WALL_DESTROY03,
				ImageConfig.CITY_WALL_DESTROY04,
				ImageConfig.CITY_WALL_DESTROY05,};
	public static final int[][] DOOR_DIS_POSITION=
			{
				{201,-24},//UP
				{72,46},//MID_UP
				{-25,128},//MID
				{59,168},//MID_DOWN
				{181,143}//DOWN
			};
	public static final int[] DOOR_MID_SCRIPT=
			{
				ImageConfig.DOOR_MID01,
				ImageConfig.DOOR_MID02,
			};
	public static final int[] DOOR_UP_SCRIPT=
			{
				ImageConfig.DOOR_UP01,
				ImageConfig.DOOR_UP02,
			};
	public static final int[] DOOR_DOWN_SCRIPT=
			{
				ImageConfig.DOOR_DOWN01,
				ImageConfig.DOOR_DOWN02,
			};
	public static final int[] WALL_LONG_SCRIPT =
		{
				ImageConfig.WALL_LONG01,
				ImageConfig.WALL_LONG03,
				};
	public static final int[] WALL_SCRIPT =
		{
				ImageConfig.WALL01,
				ImageConfig.WALL03,
				};
	public static final int[] MONSTER_MOVE_SCRIPT =
		{
				ImageConfig.MONSTER_MOVE01,
				ImageConfig.MONSTER_MOVE02,
				ImageConfig.MONSTER_MOVE03,
				ImageConfig.MONSTER_MOVE04,
				ImageConfig.MONSTER_MOVE05,};
	public static final int[] MONSTER_UP_SCRIPT =
		{
				ImageConfig.MONSTER_UP01,
				ImageConfig.MONSTER_UP02,
				ImageConfig.MONSTER_UP03,
				ImageConfig.MONSTER_UP04,
				ImageConfig.MONSTER_UP05,};
	public static final int[] MONSTER_DOWN_SCRIPT =
		{
				ImageConfig.MONSTER_DOWN01,
				ImageConfig.MONSTER_DOWN02,
				ImageConfig.MONSTER_DOWN03,
				ImageConfig.MONSTER_DOWN04,
				ImageConfig.MONSTER_DOWN05,};
	public static final int[][] MONSTER_ATTACK_SCRIPT =
		{// 圖檔,攻擊命中 1=命中
			{ImageConfig.MONSTER_ATTACK04,0},
			{ImageConfig.MONSTER_ATTACK05,1},};
	public static final int MONSTER_ATTACK_POSITION = 860;// 950
	public static final int[][] WALL_POSITION =
		{// x,y,layer,state
			{-3,161,0,WallSprite.WALL_LONG},
			{459,161,0,WallSprite.WALL},
			{902,161,0,WallSprite.WALL},
			{-3,395,1,WallSprite.WALL_LONG},
			{459,395,1,WallSprite.WALL},
			{902,395,1,WallSprite.WALL}};
	public static final int[] HERO_MP_POSITION =
		{// x,y ,width,height,Stroke
			// width
				188,
				250,
				90,
				10,
				5};
	public static final int[] GAME_BACK_POSITION=
			{
				787,494
			};
	public static final int[] RESULT_BACK_POSITION=
			{
				810,540
			};
	public static final int[] WIN_BACK_POSITION=
			{
				1086,368
			};
	public static final int[] REALLY_GO_POSITION=
			{
				358,136
			};
	public static final int[] HERO_STAY_SCRIPT =
		{
				ImageConfig.HERO_STAY01,
				ImageConfig.HERO_STAY02,
				ImageConfig.HERO_STAY03,
				ImageConfig.HERO_STAY04,};
	public static final int[] HERO_SHOOT01_SCRIPT =
		{ImageConfig.HERO_SHOOT03,};
	public static final int[][] HERO_SHOOT02_SCRIPT =
		{
			{ImageConfig.HERO_SHOOT02,-1,37,124},
			{ImageConfig.HERO_SHOOT03,1,45,124},
			{ImageConfig.HERO_SHOOT02,1,56,124},};
	public static final int[] HERO_TOSS_SCRIPT =
		{
				ImageConfig.HERO_BOMB01,
				ImageConfig.HERO_BOMB02,
				ImageConfig.HERO_BOMB03,};
	public static final int[] HERO_COLLISION =
		{95,103,312,245};
	public static final int[][] HERO_BOOM_SCRIPT =
		{
			{ImageConfig.HERO_BOOM01,42,0},
			{ImageConfig.HERO_BOOM02,143,0},
			{ImageConfig.HERO_BOOM01,42,0},
			{ImageConfig.HERO_BOOM02,143,0},
			{ImageConfig.HERO_BOOM03,-255,0},
			{ImageConfig.HERO_BOOM04,-962,0},};
	public static final int[][] HERO_BOOM_END_SCRIPT =
		{
			{ImageConfig.HERO_BOOM05,-962,0},
			{ImageConfig.HERO_BOOM06,-962,0},
			{ImageConfig.HERO_BOOM07,-962,0},
			{ImageConfig.HERO_BOOM06,-962,0},
			{ImageConfig.HERO_BOOM05,-962,0},};
	public static final int[] HERO_FAULURE_POSITION=
			{
				167,90
			};
	public static final int[] HERO_FAULURE_SCRIPT =
		{
				ImageConfig.HERO_FAILURE01,
				ImageConfig.HERO_FAILURE01,
				ImageConfig.HERO_FAILURE01,
				ImageConfig.HERO_FAILURE02,
				ImageConfig.HERO_FAILURE02,
				ImageConfig.HERO_FAILURE03,};
	public static final int[] HERO_WIN_SCRIPT =
		{
				ImageConfig.HERO_WIN01,
				ImageConfig.HERO_WIN02,
				ImageConfig.HERO_WIN03,
				ImageConfig.HERO_WIN04,
				ImageConfig.HERO_WIN05,
				ImageConfig.HERO_WIN06,
				ImageConfig.HERO_WIN07,
				ImageConfig.HERO_WIN08,};
	public static final int[] MONSTER_DEAD_SCRIPT =
		{
				ImageConfig.MONSTER_DEAD01,
				ImageConfig.MONSTER_DEAD02,
				ImageConfig.MONSTER_DEAD03,
				ImageConfig.MONSTER_DEAD04,
				ImageConfig.MONSTER_DEAD05,};
	public static final int[] WEREWOLVES_MOVE_SCRIPT =
		{
				ImageConfig.WEREWOLVES_MOVE01,
				ImageConfig.WEREWOLVES_MOVE02,
				ImageConfig.WEREWOLVES_MOVE03,
				ImageConfig.WEREWOLVES_MOVE04,};
	public static final int[] WEREWOLVES_UP_SCRIPT =
		{
				ImageConfig.WEREWOLVES_UP01,
				ImageConfig.WEREWOLVES_UP02,
				ImageConfig.WEREWOLVES_UP03,
				ImageConfig.WEREWOLVES_UP04,};
	public static final int[] WEREWOLVES_DOWN_SCRIPT =
		{
				ImageConfig.WEREWOLVES_DOWN01,
				ImageConfig.WEREWOLVES_DOWN02,
				ImageConfig.WEREWOLVES_DOWN03,
				ImageConfig.WEREWOLVES_DOWN04,};
	public static final int[][] WEREWOLVES_ATTACK_SCRIPT =
		{
			{ImageConfig.WEREWOLVES_ATTACK01,0},
			{ImageConfig.WEREWOLVES_ATTACK02,0},
			{ImageConfig.WEREWOLVES_ATTACK03,0},
			{ImageConfig.WEREWOLVES_ATTACK04,1},};
	public static final int[] WEREWOLVES_DEAD_SCRIPT =
		{ImageConfig.WEREWOLVES_DEAD01,ImageConfig.WEREWOLVES_DEAD02,};
	public static final int[] ZOMBIE_MOVE_SCRIPT =
		{
				ImageConfig.ZOMBIE_MOVE01,
				ImageConfig.ZOMBIE_MOVE02,
				ImageConfig.ZOMBIE_MOVE03,
				ImageConfig.ZOMBIE_MOVE04,};
	public static final int[] ZOMBIE_UP_SCRIPT =
		{
				ImageConfig.ZOMBIE_UP01,
				ImageConfig.ZOMBIE_UP02,
				ImageConfig.ZOMBIE_UP03,
				ImageConfig.ZOMBIE_UP04,};
	public static final int[] ZOMBIE_DOWN_SCRIPT =
		{
				ImageConfig.ZOMBIE_DOWN01,
				ImageConfig.ZOMBIE_DOWN02,
				ImageConfig.ZOMBIE_DOWN03,
				ImageConfig.ZOMBIE_DOWN04,};
	public static final int[][] ZOMBIE_ATTACK_SCRIPT =
		{
			{ImageConfig.ZOMBIE_ATTACK01,0},
			{ImageConfig.ZOMBIE_ATTACK02,1},};
	public static final int[] ZOMBIE_DEAD_SCRIPT =
		{ImageConfig.ZOMBIE_DEAD01,ImageConfig.ZOMBIE_DEAD02,ImageConfig.ZOMBIE_DEAD03,};
	public static final int[] VAMPIRE_MOVE_SCRIPT =
		{
				ImageConfig.VAMPIRE_MOVE01,
				ImageConfig.VAMPIRE_MOVE02,
				ImageConfig.VAMPIRE_MOVE03,
				ImageConfig.VAMPIRE_MOVE04,};
	public static final int[] VAMPIRE_UP_SCRIPT =
		{
				ImageConfig.VAMPIRE_UP01,
				ImageConfig.VAMPIRE_UP02,
				ImageConfig.VAMPIRE_UP03,
				ImageConfig.VAMPIRE_UP04,};
	public static final int[] VAMPIRE_DOWN_SCRIPT =
		{
				ImageConfig.VAMPIRE_DOWN01,
				ImageConfig.VAMPIRE_DOWN02,
				ImageConfig.VAMPIRE_DOWN03,
				ImageConfig.VAMPIRE_DOWN04,};
	public static final int[] VAMPIRE_DEAD_SCRIPT =
		{ImageConfig.VAMPIRE_DEAD01,ImageConfig.VAMPIRE_DEAD02,};
	public static final int[][] VAMPIRE_ATTACK_SCRIPT =
		{
			{ImageConfig.VAMPIRE_SHOOT01,0},
			{ImageConfig.VAMPIRE_SHOOT02,1},};
	public static final int[] MONSTER_STAY_SCRIPT =
		{
				ImageConfig.MONSTER_STAY01,
				ImageConfig.MONSTER_STAY02,
				ImageConfig.MONSTER_STAY03,
				ImageConfig.MONSTER_STAY04,};
	public static final int[] WEREWOLVES_STAY_SCRIPT =
		{ImageConfig.WEREWOLVES_STAY01,ImageConfig.WEREWOLVES_STAY02,};
	public static final int[] ZOMBIE_STAY_SCRIPT =
		{ImageConfig.ZOMBIE_STAY01,ImageConfig.ZOMBIE_STAY02,};
	public static final int[] VAMPIRE_STAY_SCRIPT =
		{
				ImageConfig.VAMPIRE_STAY01,
				ImageConfig.VAMPIRE_STAY02,
				ImageConfig.VAMPIRE_STAY01,
				ImageConfig.VAMPIRE_STAY02,};
	public static final int[] MONSTER_AIR_SCRIPT =
		{
			ImageConfig.MONSTER_AIR,
			ImageConfig.WEREWOLVES_AIR,
			ImageConfig.ZOMBIE_AIR,
			ImageConfig.VAMPIRE_AIR,};
	public static final int[][] ARROW_MOVE_SCRIPT =
		{
			{ImageConfig.ARROW_MOVE01,ImageConfig.ARROW_MOVE02,ImageConfig.ARROW_MOVE03},
			{ImageConfig.BULLET_MOVE01,ImageConfig.BULLET_MOVE02},
			{ImageConfig.CROSS_MOVE01,ImageConfig.CROSS_MOVE02,ImageConfig.CROSS_MOVE03},
			{ImageConfig.SYRINGE_MOVE01,ImageConfig.SYRINGE_MOVE02},
			{ImageConfig.BAT_MOVE01,ImageConfig.BAT_MOVE02},};
	public static final int[][] ARROW_SHADOW_SCRIPT=
			{
			{ImageConfig.ARROW_SHADOW01,ImageConfig.ARROW_SHADOW02,ImageConfig.ARROW_SHADOW03},
			{ImageConfig.BULLET_SHADOW01,ImageConfig.BULLET_SHADOW02},
			{ImageConfig.CROSS_SHADOW01,ImageConfig.CROSS_SHADOW02,ImageConfig.CROSS_SHADOW03},
			{ImageConfig.SYRINGE_SHADOW01,ImageConfig.SYRINGE_SHADOW02},
			{ImageConfig.BAT_SHADOW01,ImageConfig.BAT_SHADOW02},
			};
	public static final int[][] ARROW_BROKEN_SCRIPT =
		{
			{ImageConfig.ARROW_BROKEN01,ImageConfig.ARROW_BROKEN02},
			{ImageConfig.BULLET_BROKEN01,ImageConfig.BULLET_BROKEN02},
			{ImageConfig.CROSS_BROKEN01,ImageConfig.CROSS_BROKEN02},
			{ImageConfig.SYRINGE_BROKEN01,ImageConfig.SYRINGE_BROKEN02},
			{ImageConfig.BAT_BROKEN01,ImageConfig.BAT_BROKEN02},};
	public static final int[][] ARROW_HIT_SCRIPT =
		{
			{ImageConfig.ARROW_HIT01,ImageConfig.ARROW_HIT02,ImageConfig.ARROW_HIT03},
			{ImageConfig.BULLET_HIT01,ImageConfig.BULLET_HIT02,ImageConfig.BULLET_HIT03},
			{ImageConfig.CROSS_HIT01,ImageConfig.CROSS_HIT02,ImageConfig.CROSS_HIT03},
			{ImageConfig.SYRINGE_HIT01,ImageConfig.SYRINGE_HIT02,ImageConfig.SYRINGE_HIT03},
			{ImageConfig.BAT_HIT01,ImageConfig.BAT_HIT02,ImageConfig.BAT_HIT03},};
	public static final int[] ARROW_STAY_SCRIPT =
		{
				ImageConfig.ARROW_STAY,
				ImageConfig.BULLET_STAY,
				ImageConfig.CROSS_STAY,
				ImageConfig.SYRINGE_STAY,};
	public static final int[] MONSTER_WOUNDED_SCRIPT =
		{ImageConfig.MONSTER_WOUNDED01,ImageConfig.MONSTER_WOUNDED02,};
	public static final int[] WEREWOLVES_WOUNDED_SCRIPT =
		{ImageConfig.WEREWOLVES_WOUNDED01,ImageConfig.WEREWOLVES_WOUNDED02,};
	public static final int[] ZOMBIE_WOUNDED_SCRIPT =
		{ImageConfig.ZOMBIE_WOUNDED01,ImageConfig.ZOMBIE_WOUNDED02,};
	public static final int[] VAMPIRE_WOUNDED_SCRIPT =
		{ImageConfig.VAMPIRE_WOUNDED01,ImageConfig.VAMPIRE_WOUNDED02,};
	public static final int[] ZOMBIE_CREEP_SCRIPT =
		{
				ImageConfig.ZOMBIE_CREEP01,
				ImageConfig.ZOMBIE_CREEP02,
				ImageConfig.ZOMBIE_CREEP03,
				ImageConfig.ZOMBIE_CREEP04,};
	public static final int[] ZOMBIE_CREEP_UP_SCRIPT =
		{ImageConfig.ZOMBIE_CREEP_UP01,ImageConfig.ZOMBIE_CREEP_UP02,};
	public static final int[] ZOMBIE_CREEP_DOWN_SCRIPT =
		{ImageConfig.ZOMBIE_CREEP_DOWN01,ImageConfig.ZOMBIE_CREEP_DOWN02,};
	public static final int[] ZOMBIE_TOPPLE_SCRIPT =
		{ImageConfig.ZOMBIE_TOPPLE01,ImageConfig.ZOMBIE_TOPPLE02,ImageConfig.ZOMBIE_TOPPLE03,};
	public static final int BAT_ATTACK_POSITION = 1020;
	public static final int[] BAT_POSITION =
		{113,45};
	public static final int[] BAT_COLLISION =
		{11,11,89,81};
	public static final int[] MONSTER_HP_POSITION =
		{// x,y ,width,height,Stroke
			// width
				35,
				150,
				90,
				10,
				5};
	public static final int[] ARROW_POSITION =
		{83,124};
	public static final int[] ARROW_COLLISION =
		{21,41,89,61};

	public static final int[] AIR_SCRIPT =
		{// image,x,y,apha
		0,0};
	public static final int[][] HERO_POSITION =
		{
			{959,-80},
			{959,135},
			{959,350},};
	public static final int[][] DOOR_POSITION =
		{
			{224,8,0},
			{667,8,0},
			{224,243,1},
			{667,243,1}};
	public static final int[][] DOOR_COLLISION =
		{
			{228,0,257,226},
			{0,157,241,225},
			{218,171,243,401},};
	public static final int[][] MONSTER_POSITION =
		{// x,y1,y2
			{-200,-10},// {-77,-19,50},//0
					{-200,220},// {-77,162,285},//230
					{-200,450},// {-77,396,485}//460
		};

	public static final int[] DOOR_SET_POSITION =
		{// 判斷要用哪個門 x座標 區間
		481,924};
	public static final int[] MONSTER_DOOR_COLLISION =
		{// 上下移動的點 x座標
		259,702};
	public static final int[] MONSTER_MID_POSITION =
		{// 轉向路線 座標 y
		0,230,460};
	public static final int[][] DOOR_SET =
		{// 對應DOOR_POSITION DOOR_SET_POSITION
			{0,2},
			{1,3},};
	public static final int[] LAYER_POSITION =
		{// 設定上下圖層 y座標
		70,395
		// 161,395
		};
	public static final int[] UP_MID_DOOR_COLLISION =
		{77,53,208,165
		// 99,53,208,207
		};
	public static final int[] DOWN_MID_DOOR_COLLISION =
		{66,218,195,325
		// 101,191,221,325
		};
	public static final int[] MONSTER_COLLISION =
		{29,32,113,161};
	public static final int[] MID_UP_DOOR_SCRIPT =
		{// x1,y1,x2
		129,-11,224};
	public static final int[] FLY_UP_DOOR_SCRIPT =
		{// y1,y2
		-60,-150};
	public static final int[] UP_MID_DOOR_SCRIPT =
		{// y1
		120,194};
	public static final int[] MID_DOWN_DOOR_SCRIPT =
		{// x1,y1,x2
		135,216,224};
	public static final int[] FLY_DOWN_DOOR_SCRIPT =
		{// y1,y2
		280,370};
	public static final int[] DOWN_MID_DOOR_SCRIPT =
		{// y1,y2
		97,39};

	public GameConsts(Resources resources)
	{
		this.resources = resources;
	}

	public int getInt(int id)
	{
		return this.resources.getInteger(id);
	}

	public int[] getArrayInt(int id)
	{
		return this.resources.getIntArray(id);
	}

	public int[][] getArrayInt(int[] id)
	{
		int[][] arrays = new int[id.length][];
		for (int i = 0; i < id.length; i++)
		{
			arrays[i] = getArrayInt(id[i]);
		}
		return arrays;
	}
}
