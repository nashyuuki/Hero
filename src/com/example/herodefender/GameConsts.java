package com.example.herodefender;

import com.example.herodefender.config.ImageConfig;
import com.example.herodefender.sprite.ButtonSprite;
import com.example.herodefender.sprite.FrameSprite;
import com.example.herodefender.sprite.MonsterSprite;
import com.example.herodefender.sprite.RoleSprite;
import com.example.herodefender.sprite.WallSprite;
import com.example.herodefender.sprite.WordSprite;

import android.content.res.Resources;
import android.graphics.Color;

public class GameConsts
{
	Resources resources;
	public static final int CITYWALL_HP = 300;
	public static final int BAT_ATTACK = 3;
	public static final int BAT_SPEED = 3;
	public static final int HURT_STONE_POSITION = -20;
	// public static final int STONE_ATTACK=10;
	public static final int ARROW_ATTACK = 3;
	public static final int MONSTER_HP = 100;
	public static final int MONSTER_ATTACK = 3;
	public static final int HERO_MP = 10;
	public static final int AIR_MP = 10;
	public static final int ARROW_SPEED = 3;
	public static final int AIR_SPEED = 3;
	public static final int WOUND_BIG_MULTIPLE = 20;
	public static final int WOUND_MID_MULTIPLE = 3;
	public static final int MONSTER_SPEED = 20;
	public static final int BOMB_INT = 3;

	// public static final int[][] BARRIER_SET=
	// {
	// {3,MonsterSprite.TYPE_WEREWOLVES,0},
	// {8,MonsterSprite.TYPE_WEREWOLVES,1},
	// {13,MonsterSprite.TYPE_WEREWOLVES,2},
	// {18,MonsterSprite.TYPE_ZOMBIE,0},
	// {23,MonsterSprite.TYPE_ZOMBIE,1},
	// {28,MonsterSprite.TYPE_ZOMBIE,2},
	// {33,MonsterSprite.TYPE_VAMPIRE,0},
	// {38,MonsterSprite.TYPE_VAMPIRE,1},
	// {43,MonsterSprite.TYPE_VAMPIRE,2},
	// {48,MonsterSprite.TYPE_VAMPIRE,0},
	//
	// };
	public static final int[] BUTTON_TYPE =
		{
				ImageConfig.BUTTON_START01,
				ImageConfig.BUTTON_TEAM01,
				ImageConfig.BUTTON_EXIT01,
				ImageConfig.BUTTON_MUSIC01,
				ImageConfig.BUTTON_TRIANGLE_LEFT01,
				ImageConfig.BUTTON_TRIANGLE_RIGHT01,
				ImageConfig.BUTTON_START_B01,
				ImageConfig.BUTTON_BACK01,};
	public static final int[][] LOBBY_BUTTON_COLLISION =
		{
			{0,0,487,141},
			{0,0,487,141},
			{0,0,487,141},
			{0,0,230,141}};
	public static final int[][] LOBBY_BUTTON_POSITION =
		{
			{ButtonSprite.TYPE_START,440,350},
			{ButtonSprite.TYPE_TEAM,440,490},
			{ButtonSprite.TYPE_EXIT,440,630},
			{ButtonSprite.TYPE_MUSIC,1060,640},};
	public static final int[][] BARRIER_BUTTON_COLLISION =
		{
			{0,0,101,106},
			{0,0,101,106},
			{0,0,380,155},
			{0,0,156,154},};
	public static final int[] FRAME_POSITION =
		{893,738,255,0,0,0,15};
	public static final int[][] BARRIER_FRAME_POSITION =
		{
			{FrameSprite.BIG,13,7},
//			{FrameSprite.PICK,906,0},
//			{FrameSprite.PICK,906,200},
//			{FrameSprite.PICK,906,400},
			};
	public static final int[][] BARRIER_WORD_POSITION =
		{
			{WordSprite.WORD_BARRIER,273,628},
			{WordSprite.WORD_WEAPON,1135,204},};
	public static final int[][] ROLE_POSITION=
			{
				{0,0},
				{0,0},
				{-73,-20},
			};
	public static final int[] BARRIER_NUMBER_POSITION=
			{
				430,633
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
	public static final int[][] BARRIER_SCRIPT=
			{
				{RoleSprite.TYPE_VAMPIRE,RoleSprite.TYPE_VAMPIRE,RoleSprite.TYPE_VAMPIRE},
				{RoleSprite.TYPE_ZOMBIE,RoleSprite.TYPE_ZOMBIE,RoleSprite.TYPE_ZOMBIE},
				{RoleSprite.TYPE_WEREWOLVES,RoleSprite.TYPE_WEREWOLVES,RoleSprite.TYPE_WEREWOLVES},
				{RoleSprite.TYPE_VAMPIRE,RoleSprite.TYPE_WEREWOLVES,RoleSprite.TYPE_ZOMBIE},
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
				70,30,1000,150,-7,-28
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
				{0,40},
				{560,40},
				{280,40},
			};
	public static final int[][] BARRIR_BUTTON_POSITION =
		{
			{ButtonSprite.TYPE_TRIANGLE_LEFT,168,630},
			{ButtonSprite.TYPE_TRIANGLE_RIGHT,649,630},
			{ButtonSprite.TYPE_START_B,915,609},
			{ButtonSprite.TYPE_BACK,1128,4}};
	public static final int[][] BUTTON_PUSH_SCRIPT =
		{
			{ImageConfig.BUTTON_START02,ImageConfig.BUTTON_START02},
			{ImageConfig.BUTTON_TEAM02,ImageConfig.BUTTON_TEAM02},
			{ImageConfig.BUTTON_EXIT02,ImageConfig.BUTTON_EXIT02},
			{ImageConfig.BUTTON_MUSIC02,ImageConfig.BUTTON_MUSIC02},
			{ImageConfig.BUTTON_TRIANGLE_LEFT02,ImageConfig.BUTTON_TRIANGLE_LEFT02},
			{ImageConfig.BUTTON_TRIANGLE_RIGHT02,ImageConfig.BUTTON_TRIANGLE_RIGHT02},
			{ImageConfig.BUTTON_START_B02,ImageConfig.BUTTON_START_B02},
			{ImageConfig.BUTTON_BACK02,ImageConfig.BUTTON_BACK03}};
	// public static final int[][] BARRIER_SET =
	// {
	// {0,MonsterSprite.TYPE_WEREWOLVES,0},
	// {0,MonsterSprite.TYPE_WEREWOLVES,1},
	// {0,MonsterSprite.TYPE_WEREWOLVES,2},
	// {8,MonsterSprite.TYPE_ZOMBIE,0},
	// {8,MonsterSprite.TYPE_ZOMBIE,1},
	// {8,MonsterSprite.TYPE_ZOMBIE,2},
	// {13,MonsterSprite.TYPE_VAMPIRE,0},
	// {13,MonsterSprite.TYPE_VAMPIRE,1},
	// {13,MonsterSprite.TYPE_VAMPIRE,2},
	// {48,MonsterSprite.TYPE_VAMPIRE,0},
	// };
	public static final int[] BOMB_POSITION =
		{174,56,39};
	public static final int[][] BARRIER_SET =
		{
			{0,MonsterSprite.TYPE_ZOMBIE,1},
			{3,MonsterSprite.TYPE_ZOMBIE,1},
			{6,MonsterSprite.TYPE_ZOMBIE,1},
			{9,MonsterSprite.TYPE_ZOMBIE,1},
			{12,MonsterSprite.TYPE_ZOMBIE,1},
			{15,MonsterSprite.TYPE_ZOMBIE,1},
			{17,MonsterSprite.TYPE_ZOMBIE,1},
			{19,MonsterSprite.TYPE_ZOMBIE,1},
			{21,MonsterSprite.TYPE_ZOMBIE,1},
			{23,MonsterSprite.TYPE_ZOMBIE,1},
			{25,MonsterSprite.TYPE_ZOMBIE,1},
			{27,MonsterSprite.TYPE_ZOMBIE,1},
			{28,MonsterSprite.TYPE_ZOMBIE,1},
			{30,MonsterSprite.TYPE_ZOMBIE,1},
			{33,MonsterSprite.TYPE_ZOMBIE,1},
			{36,MonsterSprite.TYPE_ZOMBIE,1},
			{39,MonsterSprite.TYPE_ZOMBIE,1},
			{42,MonsterSprite.TYPE_ZOMBIE,1},
			{45,MonsterSprite.TYPE_ZOMBIE,1},
			{48,MonsterSprite.TYPE_ZOMBIE,1},
			{51,MonsterSprite.TYPE_ZOMBIE,1},
			{52,MonsterSprite.TYPE_ZOMBIE,1},
			{53,MonsterSprite.TYPE_ZOMBIE,1},
			{54,MonsterSprite.TYPE_ZOMBIE,1},
			{55,MonsterSprite.TYPE_ZOMBIE,1},
			{56,MonsterSprite.TYPE_ZOMBIE,1},
			{57,MonsterSprite.TYPE_ZOMBIE,1},
			{58,MonsterSprite.TYPE_ZOMBIE,1},
			{59,MonsterSprite.TYPE_ZOMBIE,1},};
	public static final int[] GOLD_POSITION =
		{308,65};
	public static final int[] STAGE_POSITION =
		{434,65};
	public static final int[] MENU_PAUSE_POSITION =
		{306,216};
	public static final int[] BAR_POSITION =
		{0,616};
	public static final int[] BUTTON_POSITION =
		{87,60};
	public static final int[] BUTTON_COLLISION =
		{87,60,168,108};
	public static final int[][] MENU_COLLISION=
			{
				{30,72,222,168},
				{226,72,415,168},
				{419,72,608,168},
			};
	public static final int[] MENU_PAUSE_SCRIPT =
		{
				ImageConfig.MENU_PAUSE01,
				ImageConfig.MENU_PAUSE02,
				ImageConfig.MENU_PAUSE03,
				ImageConfig.MENU_PAUSE04,};
	public static final int[] BAR_START_SCRIPT =
		{
				ImageConfig.UI_BAR01,
				ImageConfig.UI_BAR02,
				ImageConfig.UI_BAR03,
				ImageConfig.UI_BAR04,
				ImageConfig.UI_BAR05,
				ImageConfig.UI_BAR06,
				ImageConfig.UI_BAR07,};
	public static final int[] BURST_COLLISION=
			{
				97,161,274,330
			};
	public static final int[] BURST_POSITION =
		{-150,-40};
	public static final int[] BURST_SCRIPT =
		{
				ImageConfig.BURST01,
				ImageConfig.BURST02,
				ImageConfig.BURST03,
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
		{540,68,248,32,5};
	public static final int[] BAR_HP_POSITION =
		{// x,y,width,height,size
		915,68,261,32,5};
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
				ImageConfig.CITY_WALL_STAY02,
				ImageConfig.CITY_WALL_STAY03,
				ImageConfig.CITY_WALL_STAY04,
				ImageConfig.CITY_WALL_STAY05,
				ImageConfig.CITY_WALL_STAY06,
				ImageConfig.CITY_WALL_STAY07,
				ImageConfig.CITY_WALL_STAY08,
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
				ImageConfig.DOOR_MID01,
			};
	public static final int[] DOOR_UP_SCRIPT=
			{
				ImageConfig.DOOR_UP01,
				ImageConfig.DOOR_UP01,
			};
	public static final int[] DOOR_DOWN_SCRIPT=
			{
				ImageConfig.DOOR_DOWN01,
				ImageConfig.DOOR_DOWN01,
			};
	public static final int[] WALL_LONG_SCRIPT =
		{
				ImageConfig.WALL_LONG01,
				ImageConfig.WALL_LONG02,
				ImageConfig.WALL_LONG03,
				ImageConfig.WALL_LONG04,
				ImageConfig.WALL_LONG05,};
	public static final int[] WALL_SCRIPT =
		{
				ImageConfig.WALL01,
				ImageConfig.WALL02,
				ImageConfig.WALL03,
				ImageConfig.WALL04,
				ImageConfig.WALL05,};
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
	public static final int[] HERO_FAULURE_SCRIPT =
		{
				ImageConfig.HERO_FAILURE01,
				ImageConfig.HERO_FAILURE02,
				ImageConfig.HERO_FAILURE03,
				ImageConfig.HERO_FAILURE04,
				ImageConfig.HERO_FAILURE05,
				ImageConfig.HERO_FAILURE06,
				ImageConfig.HERO_FAILURE07,};
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
	public static final int[][] MONSTER_AIR_SCRIPT =
		{
			{ImageConfig.MONSTER_AIR,ImageConfig.MONSTER_STAY01},
			{ImageConfig.WEREWOLVES_AIR,ImageConfig.WEREWOLVES_STAY01},
			{ImageConfig.ZOMBIE_AIR,ImageConfig.ZOMBIE_STAY01},
			{ImageConfig.VAMPIRE_AIR,ImageConfig.VAMPIRE_STAY01},};
	public static final int[][] ARROW_MOVE_SCRIPT =
		{
			{ImageConfig.ARROW_MOVE01,ImageConfig.ARROW_MOVE02},
			{ImageConfig.BULLET_MOVE01,ImageConfig.BULLET_MOVE02},
			{ImageConfig.CROSS_MOVE01,ImageConfig.CROSS_MOVE02,ImageConfig.CROSS_MOVE03},
			{ImageConfig.SYRINGE_MOVE01,ImageConfig.SYRINGE_MOVE02},
			{ImageConfig.BAT_MOVE01,ImageConfig.BAT_MOVE02},};
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
		185,77,125};
	public static final int[][] HERO_AIR_SCRIPT =
		{
			{15,12,Color.YELLOW,25,255},
			{35,25,Color.YELLOW,50,150},
			{70,50,Color.YELLOW,100,80},};
	public static final int[][] HERO_POSITION =
		{
			{959,-100},
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
