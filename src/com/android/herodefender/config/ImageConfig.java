package com.android.herodefender.config;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.herodefender.Consts;
import com.game.herodefender.R;

public class ImageConfig
{
	public static final int BACKGROUND_STATE=-2;
	public static final int BACKGROUND_SIZE = -1;
	public static final int TEST = 0;
	public static final int BACKGROUND_GAME = 1;
	public static final int CITY_WALL = 2;
	public static final int WALL_LONG01 = 3;
	public static final int WALL_LONG03 = 5;
	public static final int WALL01 = 8;
	public static final int WALL03 = 10;
	public static final int DOOR_MOVE_UP = 14;
	public static final int DOOR_MOVE_DOWN = 16;
	public static final int MONSTER_MOVE01 = 18;
	public static final int MONSTER_MOVE02 = 19;
	public static final int MONSTER_MOVE03 = 20;
	public static final int MONSTER_MOVE04 = 21;
	public static final int MONSTER_MOVE05 = 22;
	public static final int MONSTER_UP01 = 23;
	public static final int MONSTER_UP02 = 24;
	public static final int MONSTER_UP03 = 25;
	public static final int MONSTER_UP04 = 26;
	public static final int MONSTER_UP05 = 27;
	public static final int MONSTER_DOWN01 = 28;
	public static final int MONSTER_DOWN02 = 29;
	public static final int MONSTER_DOWN03 = 30;
	public static final int MONSTER_DOWN04 = 31;
	public static final int MONSTER_DOWN05 = 32;
	public static final int HERO_STAY01 = 33;
	public static final int HERO_STAY02 = 34;
	public static final int HERO_STAY03 = 35;
	public static final int HERO_STAY04 = 36;
	public static final int MONSTER_ATTACK01 = 37;
	public static final int MONSTER_ATTACK02 = 38;
	public static final int MONSTER_ATTACK03 = 39;
	public static final int MONSTER_ATTACK04 = 40;
	public static final int MONSTER_ATTACK05 = 41;
	public static final int HERO_SHOOT01 = 42;
	public static final int HERO_SHOOT02 = 43;
	public static final int HERO_SHOOT03 = 44;
	public static final int HERO_BOMB01 = 46;
	public static final int HERO_BOMB02 = 47;
	public static final int HERO_BOMB03 = 48;
	public static final int HERO_BOMB04 = 49;
	public static final int MONSTER_DEAD01 = 52;
	public static final int MONSTER_DEAD02 = 53;
	public static final int MONSTER_DEAD03 = 54;
	public static final int MONSTER_DEAD04 = 55;
	public static final int MONSTER_DEAD05 = 56;
	public static final int HERO_BOOM01 = 57;
	public static final int HERO_BOOM02 = 58;
	public static final int HERO_BOOM03 = 59;
	public static final int HERO_BOOM04 = 60;
	public static final int HERO_BOOM05 = 61;
	public static final int HERO_BOOM06 = 62;
	public static final int HERO_BOOM07 = 63;
	public static final int WEREWOLVES_MOVE01 = 69;
	public static final int WEREWOLVES_MOVE02 = 70;
	public static final int WEREWOLVES_MOVE03 = 71;
	public static final int WEREWOLVES_MOVE04 = 72;
	public static final int WEREWOLVES_UP01 = 73;
	public static final int WEREWOLVES_UP02 = 74;
	public static final int WEREWOLVES_UP03 = 75;
	public static final int WEREWOLVES_UP04 = 76;
	public static final int WEREWOLVES_DOWN01 = 77;
	public static final int WEREWOLVES_DOWN02 = 78;
	public static final int WEREWOLVES_DOWN03 = 79;
	public static final int WEREWOLVES_DOWN04 = 80;
	public static final int WEREWOLVES_ATTACK01 = 81;
	public static final int WEREWOLVES_ATTACK02 = 82;
	public static final int WEREWOLVES_ATTACK03 = 83;
	public static final int WEREWOLVES_ATTACK04 = 84;
	public static final int WEREWOLVES_DEAD01 = 85;
	public static final int WEREWOLVES_DEAD02 = 86;
	public static final int ZOMBIE_MOVE01 = 89;
	public static final int ZOMBIE_MOVE02 = 90;
	public static final int ZOMBIE_MOVE03 = 91;
	public static final int ZOMBIE_MOVE04 = 92;
	public static final int ZOMBIE_UP01 = 93;
	public static final int ZOMBIE_UP02 = 94;
	public static final int ZOMBIE_UP03 = 95;
	public static final int ZOMBIE_UP04 = 96;
	public static final int ZOMBIE_DOWN01 = 97;
	public static final int ZOMBIE_DOWN02 = 98;
	public static final int ZOMBIE_DOWN03 = 99;
	public static final int ZOMBIE_DOWN04 = 100;
	public static final int ZOMBIE_ATTACK01 = 101;
	public static final int ZOMBIE_ATTACK02 = 102;
	public static final int ZOMBIE_DEAD01 = 103;
	public static final int ZOMBIE_DEAD02 = 104;
	public static final int ZOMBIE_DEAD03 = 105;
	public static final int VAMPIRE_MOVE01 = 108;
	public static final int VAMPIRE_MOVE02 = 109;
	public static final int VAMPIRE_MOVE03 = 110;
	public static final int VAMPIRE_MOVE04 = 111;
	public static final int VAMPIRE_UP01 = 112;
	public static final int VAMPIRE_UP02 = 113;
	public static final int VAMPIRE_UP03 = 114;
	public static final int VAMPIRE_UP04 = 115;
	public static final int VAMPIRE_DOWN01 = 116;
	public static final int VAMPIRE_DOWN02 = 117;
	public static final int VAMPIRE_DOWN03 = 118;
	public static final int VAMPIRE_DOWN04 = 119;
	public static final int VAMPIRE_DEAD01 = 120;
	public static final int VAMPIRE_DEAD02 = 121;
	public static final int MONSTER_STAY01 = 124;
	public static final int MONSTER_STAY02 = 125;
	public static final int MONSTER_STAY03 = 126;
	public static final int MONSTER_STAY04 = 127;
	public static final int WEREWOLVES_STAY01 = 128;
	public static final int WEREWOLVES_STAY02 = 129;
	public static final int ZOMBIE_STAY01 = 130;
	public static final int ZOMBIE_STAY02 = 131;
	public static final int VAMPIRE_STAY01 = 132;
	public static final int VAMPIRE_STAY02 = 133;
	public static final int ARROW_MOVE01 = 50;
	public static final int ARROW_MOVE02 = 51;
	public static final int ARROW_MOVE03 = 64;
	public static final int BULLET_MOVE01 = 134;
	public static final int BULLET_MOVE02 = 135;
	public static final int CROSS_MOVE01 = 136;
	public static final int CROSS_MOVE02 = 137;
	public static final int CROSS_MOVE03 = 138;
	public static final int SYRINGE_MOVE01 = 139;
	public static final int SYRINGE_MOVE02 = 140;
	public static final int ARROW_BROKEN01 = 141;
	public static final int ARROW_BROKEN02 = 142;
	public static final int BULLET_BROKEN01 = 143;
	public static final int BULLET_BROKEN02 = 144;
	public static final int CROSS_BROKEN01 = 145;
	public static final int CROSS_BROKEN02 = 146;
	public static final int SYRINGE_BROKEN01 = 147;
	public static final int SYRINGE_BROKEN02 = 148;
	public static final int ARROW_HIT01 = 149;
	public static final int ARROW_HIT02 = 150;
	public static final int ARROW_HIT03 = 151;
	public static final int BULLET_HIT01 = 152;
	public static final int BULLET_HIT02 = 153;
	public static final int BULLET_HIT03 = 154;
	public static final int CROSS_HIT01 = 155;
	public static final int CROSS_HIT02 = 156;
	public static final int CROSS_HIT03 = 157;
	public static final int SYRINGE_HIT01 = 158;
	public static final int SYRINGE_HIT02 = 159;
	public static final int SYRINGE_HIT03 = 160;
	public static final int MONSTER_WOUNDED01 = 161;
	public static final int MONSTER_WOUNDED02 = 162;
	public static final int WEREWOLVES_WOUNDED01 = 163;
	public static final int WEREWOLVES_WOUNDED02 = 164;
	public static final int ZOMBIE_WOUNDED01 = 165;
	public static final int ZOMBIE_WOUNDED02 = 166;
	public static final int VAMPIRE_WOUNDED01 = 167;
	public static final int VAMPIRE_WOUNDED02 = 168;
	public static final int ZOMBIE_CREEP01 = 169;
	public static final int ZOMBIE_CREEP02 = 170;
	public static final int ZOMBIE_CREEP03 = 171;
	public static final int ZOMBIE_CREEP04 = 172;
	public static final int ZOMBIE_CREEP_UP01 = 173;
	public static final int ZOMBIE_CREEP_UP02 = 174;
	public static final int ZOMBIE_CREEP_DOWN01 = 175;
	public static final int ZOMBIE_CREEP_DOWN02 = 176;
	public static final int ZOMBIE_TOPPLE01 = 177;
	public static final int ZOMBIE_TOPPLE02 = 178;
	public static final int ZOMBIE_TOPPLE03 = 179;
	public static final int ARROW_STAY = 180;
	public static final int BULLET_STAY = 181;
	public static final int CROSS_STAY = 182;
	public static final int SYRINGE_STAY = 183;
	public static final int VAMPIRE_SHOOT01 = 184;
	public static final int VAMPIRE_SHOOT02 = 185;
	public static final int BAT_MOVE01 = 186;
	public static final int BAT_MOVE02 = 187;
	public static final int BAT_BROKEN01 = 188;
	public static final int BAT_BROKEN02 = 189;
	public static final int BAT_HIT01 = 190;
	public static final int BAT_HIT02 = 191;
	public static final int BAT_HIT03 = 192;
	public static final int MONSTER_AIR = 68;
	public static final int WEREWOLVES_AIR = 193;
	public static final int ZOMBIE_AIR = 194;
	public static final int VAMPIRE_AIR = 195;
	public static final int CITY_WALL_STAY01 = 196;
	public static final int CITY_WALL_STAY03 = 198;
	public static final int CITY_WALL_STAY05 = 200;
	public static final int CITY_WALL_STAY07 = 202;
	public static final int CITY_WALL_STAY09 = 204;
	public static final int CITY_WALL_DESTROY01 = 205;
	public static final int CITY_WALL_DESTROY02 = 206;
	public static final int CITY_WALL_DESTROY03 = 207;
	public static final int CITY_WALL_DESTROY04 = 208;
	public static final int CITY_WALL_DESTROY05 = 209;
	public static final int HERO_FAILURE01 = 210;
	public static final int HERO_FAILURE02 = 211;
	public static final int HERO_FAILURE03 = 212;
	public static final int HERO_WIN01 = 217;
	public static final int HERO_WIN02 = 218;
	public static final int HERO_WIN03 = 219;
	public static final int HERO_WIN04 = 220;
	public static final int HERO_WIN05 = 221;
	public static final int HERO_WIN06 = 222;
	public static final int HERO_WIN07 = 223;
	public static final int HERO_WIN08 = 224;
	public static final int UI_BAR = 225;
	public static final int BUTTON_PAUSE = 232;
	public static final int BUTTON_CONTINUE = 233;
	public static final int MENU_PAUSE01 = 234;
	public static final int MENU_PAUSE02 = 235;
	public static final int BURST01 = 240;
	public static final int BURST02 = 241;
	public static final int BURST03 = 242;
	public static final int BURST04 = 243;
	public static final int BURST05 = 244;
	public static final int BURST06 = 245;
	public static final int UI_BOMB = 250;
	public static final int BACKGROUND_LOBBY=251;
	public static final int BUTTON_STAY=256;
	public static final int BUTTON_PUSH=257;
	public static final int BUTTON_MUSIC01=258;
	public static final int BUTTON_MUSIC02=259;
	public static final int BACKGROUND_BARRIER=260;
	public static final int BUTTON_TRIANGLE_LEFT01=261;
	public static final int BUTTON_TRIANGLE_LEFT02=262;
	public static final int BUTTON_TRIANGLE_RIGHT01=263;
	public static final int BUTTON_TRIANGLE_RIGHT02=264;
	public static final int BUTTON_START_B01=265;
	public static final int BUTTON_START_B02=266;
	public static final int BUTTON_BACK01=267;
	public static final int BUTTON_BACK02=268;
	public static final int BUTTON_BACK03=269;
	public static final int BUTTON_INFO01=312;
	public static final int BUTTON_INFO02=313;
	public static final int FRAME_PICK01=270;
	public static final int FRAME_PICK02=271;
	public static final int ROLE_WEREWOLVES01=274;
	public static final int ROLE_WEREWOLVES02=275;
	public static final int ROLE_WEREWOLVES03=276;
	public static final int ROLE_WEREWOLVES04=277;
	public static final int ROLE_ZOMBIE01=278;
	public static final int ROLE_ZOMBIE02=279;
	public static final int ROLE_ZOMBIE03=280;
	public static final int ROLE_ZOMBIE04=281;
	public static final int ROLE_VAMPIRE01=282;
	public static final int ROLE_VAMPIRE02=283;
	public static final int ROLE_VAMPIRE03=284;
	public static final int ROLE_VAMPIRE04=285;
	public static final int ITEM_BULLET=286;
	public static final int ITEM_CROSS=287;
	public static final int ITEM_SYRINGE=288;
	public static final int ITEM_STOP=289;
	public static final int DOOR_MID01= 291;
	public static final int DOOR_MID02=292;
	public static final int DOOR_UP01 = 293;
	public static final int DOOR_UP02 = 294;
	public static final int DOOR_DOWN01 = 295;
	public static final int DOOR_DOWN02 = 296;
	public static final int SELECT_FRAME01=297;
	public static final int SELECT_FRAME02=298;
	public static final int SELECT_STOP=299;
	public static final int SELECT_BULLET=300;
	public static final int SELECT_CROSS=301;
	public static final int SELECT_SYRINGE =302;
	public static final int SELECT_BOOM =303;
	public static final int SELECT_BOMB =304;
	public static final int SELECT_ARROW=305;
	public static final int WIN=334;
	public static final int LOSE=335;
	public static final int BOOM_BURST01=349;
	public static final int BOOM_BURST02=350;
	public static final int BOOM_BURST03=351;
	public static final int BOOM_BURST04=352;
	public static final int RESULT_HERO=353;
	public static final int UI_REALLY=354;
	public static final int UI_GO=355;
	public static final int UI_WOOD=356;
	public static final int UI_TALK01=357;
	public static final int UI_TALK02=358;
	public static final int END=359;
	public static final int ARROW_SHADOW01=360;
	public static final int ARROW_SHADOW02=361;
	public static final int ARROW_SHADOW03=362;
	public static final int BULLET_SHADOW01=363;
	public static final int BULLET_SHADOW02=364;
	public static final int CROSS_SHADOW01=365;
	public static final int CROSS_SHADOW02=366;
	public static final int CROSS_SHADOW03=367;
	public static final int SYRINGE_SHADOW01=368;
	public static final int SYRINGE_SHADOW02=369;
	public static final int BAT_SHADOW01=370;
	public static final int BAT_SHADOW02=372;
	public static final int BAR_TIME=373;
	public static final int BAR_BLOOD=374;
	public static final int TALK_WEAPON=375;
	public static final int[] GAME_LOAD=
			{
				HERO_BOMB01,
				HERO_BOMB02,
				HERO_BOMB03,
				HERO_BOMB04,
				HERO_BOOM01,
				HERO_BOOM02,
				HERO_BOOM03,
				HERO_BOOM04,
				HERO_BOOM05,
				HERO_BOOM06,
				HERO_BOOM07,
				BOOM_BURST01,
				BOOM_BURST02,
				BOOM_BURST03,
				BOOM_BURST04,
				
			};
	public static final int [] BARRIER_LOAD={
			ROLE_WEREWOLVES01,
			ROLE_WEREWOLVES02,
			ROLE_WEREWOLVES03,
			ROLE_WEREWOLVES04,
			ROLE_ZOMBIE01,
			ROLE_ZOMBIE02,
			ROLE_ZOMBIE03,
			ROLE_ZOMBIE04,
			ROLE_VAMPIRE01,
			ROLE_VAMPIRE02,ROLE_VAMPIRE03,ROLE_VAMPIRE04};
	private static final int[] CITYWALL =
		{
				CITY_WALL_STAY01,
				CITY_WALL_STAY03,
				CITY_WALL_STAY05,
				CITY_WALL_STAY07,
				CITY_WALL_STAY09,
				CITY_WALL_DESTROY01,
				CITY_WALL_DESTROY02,
				CITY_WALL_DESTROY03,
				CITY_WALL_DESTROY04,
				CITY_WALL_DESTROY05,};
	private Map<String, Drawable> drawables;
	private Context context;
	private Typeface font;
	public ImageConfig(Context context)
	{
		font = Typeface.createFromAsset(context.getAssets(), "fonts/w9.TTC");
		this.context = context;
		drawables = new HashMap<String, Drawable>();
	}
	public void LoadDrawable(int[] load)
	{
		for(int i=0;i<load.length;i++)
		{
			getDrawable(load[i]);
		}
	}
	public void addDrawable(int image,Bitmap bitmap)
	{
		drawables.put(""+image, new BitmapDrawable(context.getResources(), bitmap) );
		this.getDrawable(image);
	}
	public Drawable getDrawable(int image)
	{
		Drawable drawable = drawables.get("" + image);
		if (drawable == null)
		{
			switch (image)
			{
				case BACKGROUND_STATE:
					break;
				case BACKGROUND_SIZE:
					drawable = context.getResources().getDrawable(R.raw.gamedirectory1_world);
					break;
				case BACKGROUND_GAME:
					drawable = this.getResizeDrawable(R.raw.book1);
					break;
				case BACKGROUND_BARRIER:
					drawable = this.getResizeDrawable(R.raw.book2);
					break;
				case CITY_WALL:
					drawable = this.getResizeDrawable(R.raw.world_000);
					break;
				case WALL_LONG01:
					drawable = this.getResizeDrawable(R.raw.wall1_001);
					break;
				case WALL_LONG03:
					drawable = this.getResizeDrawable(R.raw.wall1_003);
					break;
				case WALL01:
					drawable = this.getResizeDrawable(R.raw.wall2_001);
					break;
				case WALL03:
					drawable = this.getResizeDrawable(R.raw.wall2_003);
					break;
				case DOOR_UP01:
					drawable = this.getResizeDrawable(R.raw.wall2_001_1);
					break;
				case DOOR_UP02:
					drawable = this.getResizeDrawable(R.raw.wall2_001_0);
					break;
				case DOOR_MOVE_UP:
					drawable = this.getResizeDrawable(R.raw.door2_002);
					break;
				case DOOR_MID01:
					drawable = this.getResizeDrawable(R.raw.wall2_003_1);
					break;
				case DOOR_MID02:
					drawable = this.getResizeDrawable(R.raw.wall2_003_0);
					break;
				case DOOR_MOVE_DOWN:
					drawable = this.getResizeDrawable(R.raw.door2_004);
					break;
				case DOOR_DOWN01:
					drawable = this.getResizeDrawable(R.raw.wall2_005_1);
					break;
				case DOOR_DOWN02:
					drawable = this.getResizeDrawable(R.raw.wall2_005_0);
					break;
				case MONSTER_MOVE01:
					drawable = this.getResizeDrawable(R.raw.h_move0_000);
					break;
				case MONSTER_MOVE02:
					drawable = this.getResizeDrawable(R.raw.h_move0_005);
					break;
				case MONSTER_MOVE03:
					drawable = this.getResizeDrawable(R.raw.h_move0_010);
					break;
				case MONSTER_MOVE04:
					drawable = this.getResizeDrawable(R.raw.h_move0_015);
					break;
				case MONSTER_MOVE05:
					drawable = this.getResizeDrawable(R.raw.h_move0_020);
					break;
				case MONSTER_UP01:
					drawable = this.getResizeDrawable(R.raw.h_move2_000);
					break;
				case MONSTER_UP02:
					drawable = this.getResizeDrawable(R.raw.h_move2_005);
					break;
				case MONSTER_UP03:
					drawable = this.getResizeDrawable(R.raw.h_move2_010);
					break;
				case MONSTER_UP04:
					drawable = this.getResizeDrawable(R.raw.h_move2_015);
					break;
				case MONSTER_UP05:
					drawable = this.getResizeDrawable(R.raw.h_move2_020);
					break;
				case MONSTER_DOWN01:
					drawable = this.getResizeDrawable(R.raw.h_move1_000);
					break;
				case MONSTER_DOWN02:
					drawable = this.getResizeDrawable(R.raw.h_move1_005);
					break;
				case MONSTER_DOWN03:
					drawable = this.getResizeDrawable(R.raw.h_move1_010);
					break;
				case MONSTER_DOWN04:
					drawable = this.getResizeDrawable(R.raw.h_move1_015);
					break;
				case MONSTER_DOWN05:
					drawable = this.getResizeDrawable(R.raw.h_move1_020);
					break;
				case HERO_STAY01:
					drawable = this.getResizeDrawable(R.raw.knight_daze_000);
					break;
				case HERO_STAY02:
					drawable = this.getResizeDrawable(R.raw.knight_daze_001);
					break;
				case HERO_STAY03:
					drawable = this.getResizeDrawable(R.raw.knight_daze_002);
					break;
				case HERO_STAY04:
					drawable = this.getResizeDrawable(R.raw.knight_daze_003);
					break;
				case MONSTER_ATTACK01:
					drawable = this.getResizeDrawable(R.raw.h_attack_000);
					break;
				case MONSTER_ATTACK02:
					drawable = this.getResizeDrawable(R.raw.h_attack_005);
					break;
				case MONSTER_ATTACK03:
					drawable = this.getResizeDrawable(R.raw.h_attack_010);
					break;
				case MONSTER_ATTACK04:
					drawable = this.getResizeDrawable(R.raw.h_attack_015);
					break;
				case MONSTER_ATTACK05:
					drawable = this.getResizeDrawable(R.raw.h_attack_020);
					break;
				case HERO_SHOOT01:
					drawable = this.getResizeDrawable(R.raw.knight_shoot_000);
					break;
				case HERO_SHOOT02:
					drawable = this.getResizeDrawable(R.raw.knight_shoot_001);
					break;
				case HERO_SHOOT03:
					drawable = this.getResizeDrawable(R.raw.knight_shoot_002);
					break;
				case HERO_BOMB01:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_000);
					break;
				case HERO_BOMB02:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_001);
					break;
				case HERO_BOMB03:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_002);
					break;
				case HERO_BOMB04:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_003);
					break;
				case ARROW_MOVE01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_001);
					break;
				case ARROW_MOVE02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_002);
					break;
				case ARROW_MOVE03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_003);
					break;
				case MONSTER_DEAD01:
					drawable = this.getResizeDrawable(R.raw.h_dead_000);
					break;
				case MONSTER_DEAD02:
					drawable = this.getResizeDrawable(R.raw.h_dead_005);
					break;
				case MONSTER_DEAD03:
					drawable = this.getResizeDrawable(R.raw.h_dead_010);
					break;
				case MONSTER_DEAD04:
					drawable = this.getResizeDrawable(R.raw.h_dead_015);
					break;
				case MONSTER_DEAD05:
					drawable = this.getResizeDrawable(R.raw.h_dead_020);
					break;
				case HERO_BOOM01:
					drawable = this.getResizeDrawable(R.raw.knight_boom_000);
					break;
				case HERO_BOOM02:
					drawable = this.getResizeDrawable(R.raw.knight_boom_001);
					break;
				case HERO_BOOM03:
					drawable = this.getResizeDrawable(R.raw.knight_boom_002);
					break;
				case HERO_BOOM04:
					drawable = this.getResizeDrawable(R.raw.knight_boom_003);
					break;
				case HERO_BOOM05:
					drawable = this.getResizeDrawable(R.raw.knight_boom_004);
					break;
				case HERO_BOOM06:
					drawable = this.getResizeDrawable(R.raw.knight_boom_005);
					break;
				case HERO_BOOM07:
					drawable = this.getResizeDrawable(R.raw.knight_boom_006);
					break;
				case WEREWOLVES_MOVE01:
					drawable = this.getResizeDrawable(R.raw.werewolves_walk_001);
					break;
				case WEREWOLVES_MOVE02:
					drawable = this.getResizeDrawable(R.raw.werewolves_walk_002);
					break;
				case WEREWOLVES_MOVE03:
					drawable = this.getResizeDrawable(R.raw.werewolves_walk_003);
					break;
				case WEREWOLVES_MOVE04:
					drawable = this.getResizeDrawable(R.raw.werewolves_walk_004);
					break;
				case WEREWOLVES_UP01:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkup_001);
					break;
				case WEREWOLVES_UP02:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkup_002);
					break;
				case WEREWOLVES_UP03:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkup_003);
					break;
				case WEREWOLVES_UP04:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkup_004);
					break;
				case WEREWOLVES_DOWN01:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkdown_001);
					break;
				case WEREWOLVES_DOWN02:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkdown_002);
					break;
				case WEREWOLVES_DOWN03:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkdown_003);
					break;
				case WEREWOLVES_DOWN04:
					drawable = this.getResizeDrawable(R.raw.werewolves_walkdown_004);
					break;
				case WEREWOLVES_ATTACK01:
					drawable = this.getResizeDrawable(R.raw.werewolves_attack_001);
					break;
				case WEREWOLVES_ATTACK02:
					drawable = this.getResizeDrawable(R.raw.werewolves_attack_002);
					break;
				case WEREWOLVES_ATTACK03:
					drawable = this.getResizeDrawable(R.raw.werewolves_attack_003);
					break;
				case WEREWOLVES_ATTACK04:
					drawable = this.getResizeDrawable(R.raw.werewolves_attack_004);
					break;
				case WEREWOLVES_DEAD01:
					drawable = this.getResizeDrawable(R.raw.werewolves_death_001);
					break;
				case WEREWOLVES_DEAD02:
					drawable = this.getResizeDrawable(R.raw.werewolves_death_002);
					break;
				case ZOMBIE_MOVE01:
					drawable = this.getResizeDrawable(R.raw.zombie_walk_001);
					break;
				case ZOMBIE_MOVE02:
					drawable = this.getResizeDrawable(R.raw.zombie_walk_002);
					break;
				case ZOMBIE_MOVE03:
					drawable = this.getResizeDrawable(R.raw.zombie_walk_003);
					break;
				case ZOMBIE_MOVE04:
					drawable = this.getResizeDrawable(R.raw.zombie_walk_004);
					break;
				case ZOMBIE_UP01:
					drawable = this.getResizeDrawable(R.raw.zombie_walkup_001);
					break;
				case ZOMBIE_UP02:
					drawable = this.getResizeDrawable(R.raw.zombie_walkup_002);
					break;
				case ZOMBIE_UP03:
					drawable = this.getResizeDrawable(R.raw.zombie_walkup_003);
					break;
				case ZOMBIE_UP04:
					drawable = this.getResizeDrawable(R.raw.zombie_walkup_004);
					break;
				case ZOMBIE_DOWN01:
					drawable = this.getResizeDrawable(R.raw.zombie_walkdown_001);
					break;
				case ZOMBIE_DOWN02:
					drawable = this.getResizeDrawable(R.raw.zombie_walkdown_002);
					break;
				case ZOMBIE_DOWN03:
					drawable = this.getResizeDrawable(R.raw.zombie_walkdown_003);
					break;
				case ZOMBIE_DOWN04:
					drawable = this.getResizeDrawable(R.raw.zombie_walkdown_004);
					break;
				case ZOMBIE_ATTACK01:
					drawable = this.getResizeDrawable(R.raw.zombie_attack_001);
					break;
				case ZOMBIE_ATTACK02:
					drawable = this.getResizeDrawable(R.raw.zombie_attack_002);
					break;
				case ZOMBIE_DEAD01:
					drawable = this.getResizeDrawable(R.raw.zombie_death_001);
					break;
				case ZOMBIE_DEAD02:
					drawable = this.getResizeDrawable(R.raw.zombie_death_002);
					break;
				case ZOMBIE_DEAD03:
					drawable = this.getResizeDrawable(R.raw.zombie_death_003);
					break;
				case VAMPIRE_MOVE01:
					drawable = this.getResizeDrawable(R.raw.vampire_walk_001);
					break;
				case VAMPIRE_MOVE02:
					drawable = this.getResizeDrawable(R.raw.vampire_walk_002);
					break;
				case VAMPIRE_MOVE03:
					drawable = this.getResizeDrawable(R.raw.vampire_walk_003);
					break;
				case VAMPIRE_MOVE04:
					drawable = this.getResizeDrawable(R.raw.vampire_walk_004);
					break;
				case VAMPIRE_UP01:
					drawable = this.getResizeDrawable(R.raw.vampire_walkup_001);
					break;
				case VAMPIRE_UP02:
					drawable = this.getResizeDrawable(R.raw.vampire_walkup_002);
					break;
				case VAMPIRE_UP03:
					drawable = this.getResizeDrawable(R.raw.vampire_walkup_003);
					break;
				case VAMPIRE_UP04:
					drawable = this.getResizeDrawable(R.raw.vampire_walkup_004);
					break;
				case VAMPIRE_DOWN01:
					drawable = this.getResizeDrawable(R.raw.vampire_walkdown_001);
					break;
				case VAMPIRE_DOWN02:
					drawable = this.getResizeDrawable(R.raw.vampire_walkdown_002);
					break;
				case VAMPIRE_DOWN03:
					drawable = this.getResizeDrawable(R.raw.vampire_walkdown_003);
					break;
				case VAMPIRE_DOWN04:
					drawable = this.getResizeDrawable(R.raw.vampire_walkdown_004);
					break;
				case VAMPIRE_DEAD01:
					drawable = this.getResizeDrawable(R.raw.vampire_death_001);
					break;
				case VAMPIRE_DEAD02:
					drawable = this.getResizeDrawable(R.raw.vampire_death_002);
					break;
				case MONSTER_STAY01:
					drawable = this.getResizeDrawable(R.raw.h_stay_000);
					break;
				case MONSTER_STAY02:
					drawable = this.getResizeDrawable(R.raw.h_stay_005);
					break;
				case MONSTER_STAY03:
					drawable = this.getResizeDrawable(R.raw.h_stay_010);
					break;
				case MONSTER_STAY04:
					drawable = this.getResizeDrawable(R.raw.h_stay_015);
					break;
				case WEREWOLVES_STAY01:
					drawable = this.getResizeDrawable(R.raw.werewolves_stay_001);
					break;
				case WEREWOLVES_STAY02:
					drawable = this.getResizeDrawable(R.raw.werewolves_stay_002);
					break;
				case ZOMBIE_STAY01:
					drawable = this.getResizeDrawable(R.raw.zombie_stay_001);
					break;
				case ZOMBIE_STAY02:
					drawable = this.getResizeDrawable(R.raw.zombie_stay_002);
					break;
				case VAMPIRE_STAY01:
					drawable = this.getResizeDrawable(R.raw.vampire_stay_001);
					break;
				case VAMPIRE_STAY02:
					drawable = this.getResizeDrawable(R.raw.vampire_stay_002);
					break;
				case BULLET_MOVE01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_001);
					break;
				case BULLET_MOVE02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_002);
					break;
				case CROSS_MOVE01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_001);
					break;
				case CROSS_MOVE02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_002);
					break;
				case CROSS_MOVE03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_003);
					break;
				case SYRINGE_MOVE01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_001);
					break;
				case SYRINGE_MOVE02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_002);
					break;
				case ARROW_BROKEN01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_004);
					break;
				case ARROW_BROKEN02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_005);
					break;
				case BULLET_BROKEN01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_003);
					break;
				case BULLET_BROKEN02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_004);
					break;
				case CROSS_BROKEN01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_004);
					break;
				case CROSS_BROKEN02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_005);
					break;
				case SYRINGE_BROKEN01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_003);
					break;
				case SYRINGE_BROKEN02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_004);
					break;
				case ARROW_HIT01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_005);
					break;
				case ARROW_HIT02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_006);
					break;
				case ARROW_HIT03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_007);
					break;
				case BULLET_HIT01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_005);
					break;
				case BULLET_HIT02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_006);
					break;
				case BULLET_HIT03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_007);
					break;
				case CROSS_HIT01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_006);
					break;
				case CROSS_HIT02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_007);
					break;
				case CROSS_HIT03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_008);
					break;
				case SYRINGE_HIT01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_005);
					break;
				case SYRINGE_HIT02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_006);
					break;
				case SYRINGE_HIT03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_007);
					break;
				case MONSTER_WOUNDED01:
					drawable = this.getResizeDrawable(R.raw.h_hurt_005);
					break;
				case MONSTER_WOUNDED02:
					drawable = this.getResizeDrawable(R.raw.h_hurt_015);
					break;
				case WEREWOLVES_WOUNDED01:
					drawable = this.getResizeDrawable(R.raw.werewolves_heavyhurt_001);
					break;
				case WEREWOLVES_WOUNDED02:
					drawable = this.getResizeDrawable(R.raw.werewolves_heavyhurt_002);
					break;
				case ZOMBIE_WOUNDED01:
					drawable = this.getResizeDrawable(R.raw.zombie_heavyhurt_001);
					break;
				case ZOMBIE_WOUNDED02:
					drawable = this.getResizeDrawable(R.raw.zombie_heavyhurt_002);
					break;
				case VAMPIRE_WOUNDED01:
					drawable = this.getResizeDrawable(R.raw.vampire_heavyhurt_001);
					break;
				case VAMPIRE_WOUNDED02:
					drawable = this.getResizeDrawable(R.raw.vampire_heavyhurt_002);
					break;
				case ZOMBIE_CREEP01:
					drawable = this.getResizeDrawable(R.raw.zombie_creep_001);
					break;
				case ZOMBIE_CREEP02:
					drawable = this.getResizeDrawable(R.raw.zombie_creep_002);
					break;
				case ZOMBIE_CREEP03:
					drawable = this.getResizeDrawable(R.raw.zombie_creep_003);
					break;
				case ZOMBIE_CREEP04:
					drawable = this.getResizeDrawable(R.raw.zombie_creep_004);
					break;
				case ZOMBIE_CREEP_UP01:
					drawable = this.getResizeDrawable(R.raw.zombie_creepup_001);
					break;
				case ZOMBIE_CREEP_UP02:
					drawable = this.getResizeDrawable(R.raw.zombie_creepup_002);
					break;
				case ZOMBIE_CREEP_DOWN01:
					drawable = this.getResizeDrawable(R.raw.zombie_creepdown_001);
					break;
				case ZOMBIE_CREEP_DOWN02:
					drawable = this.getResizeDrawable(R.raw.zombie_creepdown_002);
					break;
				case ZOMBIE_TOPPLE01:
					drawable = this.getResizeDrawable(R.raw.zombie_groundhurt_001);
					break;
				case ZOMBIE_TOPPLE02:
					drawable = this.getResizeDrawable(R.raw.zombie_groundhurt_002);
					break;
				case ZOMBIE_TOPPLE03:
					drawable = this.getResizeDrawable(R.raw.zombie_groundhurt_003);
					break;
				case ARROW_STAY:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_knight_000);
					break;
				case BULLET_STAY:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bullet_000);
					break;
				case CROSS_STAY:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_cross_000);
					break;
				case SYRINGE_STAY:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_syringes_000);
					break;
				case VAMPIRE_SHOOT01:
					drawable = this.getResizeDrawable(R.raw.vampire_shoot_001);
					break;
				case VAMPIRE_SHOOT02:
					drawable = this.getResizeDrawable(R.raw.vampire_shoot_002);
					break;
				case BAT_MOVE01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_001);
					break;
				case BAT_MOVE02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_002);
					break;
				case BAT_BROKEN01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_003);
					break;
				case BAT_BROKEN02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_004);
					break;
				case BAT_HIT01:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_006);
					break;
				case BAT_HIT02:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_007);
					break;
				case BAT_HIT03:
					drawable = this.getResizeDrawable(R.raw.knight_arrow_bat_008);
					break;
				case MONSTER_AIR:
					drawable = getColorDrawable(R.raw.h_stay_000 ,Color.WHITE,125);
					break;
				case WEREWOLVES_AIR:
					drawable = getColorDrawable(R.raw.werewolves_stay_001 ,Color.DKGRAY,125);
					break;
				case ZOMBIE_AIR:
					drawable = getColorDrawable(R.raw.zombie_stay_001 ,Color.RED,125);
					break;
				case VAMPIRE_AIR:
					drawable = getColorDrawable(R.raw.vampire_stay_001 ,Color.BLACK,125);
					break;
				case CITY_WALL_STAY01:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_000);
					break;
				case CITY_WALL_STAY03:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_002);
					break;
				case CITY_WALL_STAY05:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_004);
					break;
				case CITY_WALL_STAY07:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_006);
					break;
				case CITY_WALL_STAY09:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_008);
					break;
				case CITY_WALL_DESTROY01:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_009);
					break;
				case CITY_WALL_DESTROY02:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_010);
					break;
				case CITY_WALL_DESTROY03:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_011);
					break;
				case CITY_WALL_DESTROY04:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_012);
					break;
				case CITY_WALL_DESTROY05:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_013);
					break;
				case HERO_FAILURE01:
					drawable = this.getResizeDrawable(R.raw.knight_failure_007);
					break;
				case HERO_FAILURE02:
					drawable = this.getResizeDrawable(R.raw.knight_failure_008);
					break;
				case HERO_FAILURE03:
					drawable = this.getResizeDrawable(R.raw.knight_failure_009);
					break;
				case HERO_WIN01:
					drawable = this.getResizeDrawable(R.raw.knight_win_000);
					break;
				case HERO_WIN02:
					drawable = this.getResizeDrawable(R.raw.knight_win_001);
					break;
				case HERO_WIN03:
					drawable = this.getResizeDrawable(R.raw.knight_win_002);
					break;
				case HERO_WIN04:
					drawable = this.getResizeDrawable(R.raw.knight_win_003);
					break;
				case HERO_WIN05:
					drawable = this.getResizeDrawable(R.raw.knight_win_004);
					break;
				case HERO_WIN06:
					drawable = this.getResizeDrawable(R.raw.knight_win_005);
					break;
				case HERO_WIN07:
					drawable = this.getResizeDrawable(R.raw.knight_win_006);
					break;
				case HERO_WIN08:
					drawable = this.getResizeDrawable(R.raw.knight_win_007);
					break;
				case UI_BAR:
					drawable = this.getResizeDrawable(R.raw.directory_001);
					break;
				case BUTTON_PAUSE:
					drawable = this.getResizeDrawable(R.raw.directory_p1_001);
					break;
				case BUTTON_CONTINUE:
					drawable = this.getResizeDrawable(R.raw.directory_p1_002);
					break;
				case MENU_PAUSE01:
					drawable = this.getResizeDrawable(R.raw.book2_stop2);
					break;
				case MENU_PAUSE02:
					drawable = this.getResizeDrawable(R.raw.book2_stop3);
					break;
				case BURST01:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_004);
					break;
				case BURST02:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_005);
					break;
				case BURST03:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_006);
					break;
				case BURST04:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_007);
					break;
				case BURST05:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_008);
					break;
				case BURST06:
					drawable = this.getResizeDrawable(R.raw.knight_throwstone_009);
					break;
				case UI_BOMB:
					drawable = this.getResizeDrawable(R.raw.directory_p2_003);
					break;
				case BACKGROUND_LOBBY:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_world);
					break;
				case BUTTON_STAY:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_away_000);
					break;
				case BUTTON_PUSH:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_away_001);
					break;
				case BUTTON_MUSIC01:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_music_000);
					break;
				case BUTTON_MUSIC02:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_music_001);
					break;
				case BUTTON_TRIANGLE_LEFT01:
					drawable = this.getMirrorDrawable(R.raw.book3_doa1);
					break;
				case BUTTON_TRIANGLE_LEFT02:
					drawable = this.getMirrorDrawable(R.raw.book3_doa2);
					break;
				case BUTTON_TRIANGLE_RIGHT01:
					drawable =this.getResizeDrawable(R.raw.book3_doa1);
					break;
				case BUTTON_TRIANGLE_RIGHT02:
					drawable =this.getResizeDrawable(R.raw.book3_doa2);
					break;
				case BUTTON_START_B01:
					drawable =this.getResizeDrawable(R.raw.book3_st1);
					break;
				case BUTTON_START_B02:
					drawable =this.getResizeDrawable(R.raw.book3_st3);
					break;
				case BUTTON_BACK01:
					drawable =this.getResizeDrawable(R.raw.book3_dod1);
					break;
				case BUTTON_BACK02:
					drawable =this.getResizeDrawable(R.raw.book3_dod2);
					break;
				case BUTTON_BACK03:
					drawable =this.getResizeDrawable(R.raw.book3_dod3);
					break;
				case BUTTON_INFO01:
					drawable =this.getResizeDrawable(R.raw.book3_dod4);
					break;
				case BUTTON_INFO02:
					drawable =this.getResizeDrawable(R.raw.book3_dod5);
					break;
				case FRAME_PICK01:
					drawable =this.getResizeDrawable(R.raw.book3_doc1);
					break;
				case FRAME_PICK02:
					drawable =this.getResizeDrawable(R.raw.book3_doc2);
					break;
				case ROLE_WEREWOLVES01:
					drawable =this.getResizeDrawable(R.raw.werewolves_business_001);
					break;
				case ROLE_WEREWOLVES02:
					drawable =this.getResizeDrawable(R.raw.werewolves_business_002);
					break;
				case ROLE_WEREWOLVES03:
					drawable =this.getResizeDrawable(R.raw.werewolves_business_003);
					break;
				case ROLE_WEREWOLVES04:
					drawable =this.getResizeDrawable(R.raw.werewolves_business_004);
					break;
				case ROLE_ZOMBIE01:
					drawable =this.getResizeDrawable(R.raw.zombie_business_001);
					break;
				case ROLE_ZOMBIE02:
					drawable =this.getResizeDrawable(R.raw.zombie_business_002);
					break;
				case ROLE_ZOMBIE03:
					drawable =this.getResizeDrawable(R.raw.zombie_business_003);
					break;
				case ROLE_ZOMBIE04:
					drawable =this.getResizeDrawable(R.raw.zombie_business_004);
					break;
				case ROLE_VAMPIRE01:
					drawable =this.getResizeDrawable(R.raw.vampire_business_001);
					break;
				case ROLE_VAMPIRE02:
					drawable =this.getResizeDrawable(R.raw.vampire_business_002);
					break;
				case ROLE_VAMPIRE03:
					drawable =this.getResizeDrawable(R.raw.vampire_business_003);
					break;
				case ROLE_VAMPIRE04:
					drawable =this.getResizeDrawable(R.raw.vampire_business_004);
					break;
				case ITEM_BULLET:
					drawable =this.getResizeDrawable(R.raw.book3_doc5);
					break;
				case ITEM_CROSS:
					drawable =this.getResizeDrawable(R.raw.book3_doc3);
					break;
				case ITEM_SYRINGE:
					drawable =this.getResizeDrawable(R.raw.book3_doc4);
					break;
				case ITEM_STOP:
					drawable =this.getResizeDrawable(R.raw.book3_doc6);
					break;
				case SELECT_FRAME01:
					drawable =this.getResizeDrawable(R.raw.select_002);
					break;
				case SELECT_FRAME02:
					drawable =this.getResizeDrawable(R.raw.select_003);
					break;
				case SELECT_STOP:
					drawable =this.getResizeDrawable(R.raw.select_001);
					break;
				case SELECT_BULLET:
					drawable =this.getResizeDrawable(R.raw.select_008);
					break;
				case SELECT_CROSS:
					drawable =this.getResizeDrawable(R.raw.select_006);
					break;
				case SELECT_SYRINGE:
					drawable =this.getResizeDrawable(R.raw.select_007);
					break;
				case SELECT_BOOM:
					drawable =this.getResizeDrawable(R.raw.select_004);
					break;
				case SELECT_BOMB:
					drawable =this.getResizeDrawable(R.raw.select_005);
					break;
				case SELECT_ARROW:
					drawable =this.getResizeDrawable(R.raw.select_009);
					break;
				case WIN:
					drawable =this.getResizeDrawable(R.raw.rgo_04);
					break;
				case LOSE:
					drawable =this.getResizeDrawable(R.raw.rgo_05);
					break;
				case BOOM_BURST01:
					drawable =this.getResizeDrawable(R.raw.knight_boom2_001);
					break;
				case BOOM_BURST02:
					drawable =this.getResizeDrawable(R.raw.knight_boom2_002);
					break;
				case BOOM_BURST03:
					drawable =this.getResizeDrawable(R.raw.knight_boom2_003);
					break;
				case BOOM_BURST04:
					drawable =this.getResizeDrawable(R.raw.knight_boom2_004);
					break;
				case RESULT_HERO:
					drawable =this.getResizeDrawable(R.raw.book_pose_001);
					break;
				case UI_REALLY:
					drawable =this.getResizeDrawable(R.raw.rgo_01);
					break;
				case UI_GO:
					drawable =this.getResizeDrawable(R.raw.rgo_02);
					break;
				case UI_WOOD:
					drawable =this.getResizeDrawable(R.raw.rgo_03);
					break;
				case UI_TALK01:
					drawable =this.getResizeDrawable(R.raw.took);
					break;
				case UI_TALK02:
					drawable =this.getMirrorDrawable(R.raw.took);
					break;
				case ARROW_SHADOW01:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_knight_001,Color.BLACK, 125);
					break;
				case ARROW_SHADOW02:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_knight_001,Color.BLACK, 125);
					break;
				case ARROW_SHADOW03:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_knight_001,Color.BLACK, 125);
					break;
				case BULLET_SHADOW01:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_bullet_001,Color.BLACK, 125);
					break;
				case BULLET_SHADOW02:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_bullet_002,Color.BLACK, 125);
					break;
				case CROSS_SHADOW01:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_cross_001,Color.BLACK, 125);
					break;
				case CROSS_SHADOW02:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_cross_002,Color.BLACK, 125);
					break;
				case CROSS_SHADOW03:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_cross_003,Color.BLACK, 125);
					break;
				case SYRINGE_SHADOW01:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_syringes_001,Color.BLACK, 125);
					break;
				case SYRINGE_SHADOW02:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_syringes_002,Color.BLACK, 125);
					break;
				case BAT_SHADOW01:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_bat_001,Color.BLACK, 125);
					break;
				case BAT_SHADOW02:
					drawable=this.getAlphaDrawable(R.raw.knight_arrow_bat_002,Color.BLACK, 125);
					break;
				case END:
					drawable =this.getResizeDrawable(R.raw.end);
					break;
				case BAR_TIME:
					drawable =this.getResizeDrawable(R.raw.hourglass);
					break;
				case BAR_BLOOD:
					drawable =this.getResizeDrawable(R.raw.blood);
					break;
				case TALK_WEAPON:
					drawable =this.getResizeDrawable(R.raw.book2_say);
					break;
				default:
					drawable = this.getResizeDrawable(R.drawable.mark);
					break;
			}
			drawables.put("" + image, drawable);
		}
		return drawable;
	}
	private Drawable getColorDrawable(int id ,int color,int alpha)
	{
		Drawable drawable=context.getResources().getDrawable(id);
		drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
		int width=drawable.getIntrinsicWidth();
		int height=drawable.getIntrinsicHeight();
		Bitmap bitmap=Bitmap.createBitmap(width,height, Config.ARGB_8888);
		Canvas canvas=new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		drawable.setColorFilter(null);
		drawable.setAlpha(alpha);
		drawable.draw(canvas);
		Matrix matrix = new Matrix();
		matrix.postScale(Consts.screenScale, Consts.screenScale);
		return this.getMatrixDrawable(bitmap, matrix);
	}
	private Drawable getAlphaDrawable(int id ,int color,int alpha)
	{
		Drawable drawable=context.getResources().getDrawable(id);
		drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
		int width=drawable.getIntrinsicWidth();
		int height=drawable.getIntrinsicHeight();
		Bitmap bitmap=Bitmap.createBitmap(width,height, Config.ARGB_8888);
		Canvas canvas=new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.setAlpha(alpha);
		drawable.draw(canvas);
		Matrix matrix = new Matrix();
		matrix.postScale(Consts.screenScale, Consts.screenScale);
		return this.getMatrixDrawable(bitmap, matrix);
	}
	private Drawable getMirrorDrawable(int id)
	{
		Matrix matrix = new Matrix();
		matrix.preScale(-1, 1);
		matrix.postScale(Consts.screenScale, Consts.screenScale);
		Bitmap bmp = this.getBitmap(id);
		return this.getMatrixDrawable(bmp, matrix);
	}
	public Bitmap getImageBitmap(int image)
	{
		return ((BitmapDrawable)this.getDrawable(image)).getBitmap();
	}
	public Bitmap getBitmap(int id)
	{
		return BitmapFactory.decodeResource(context.getResources(), id);
	}
	private Drawable getMatrixDrawable(Bitmap bmp,Matrix matrix)
	{
		int oldwidth = bmp.getWidth();
		int oldheight = bmp.getHeight();
		Bitmap resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, oldwidth, oldheight, matrix, true);	
		BitmapDrawable bmd = new BitmapDrawable(context.getResources(), resizedBitmap);
		if (bmp.hashCode() != resizedBitmap.hashCode())
		{
			bmp.recycle();
		}
		return bmd;
	}
	private Drawable getResizeDrawable(int id)
	{
		Matrix matrix = new Matrix();
		matrix.postScale(Consts.screenScale, Consts.screenScale);
		Bitmap bmp = this.getBitmap(id);
		return this.getMatrixDrawable(bmp, matrix);
	}

	public void removeDrawable(int[] images)
	{
		for (int i = 0; i < images.length; i++)
		{
			this.removeDrawable(images[i]);
		}
	}

	public void removeDrawable(int image)
	{
		drawables.remove("" + image);
	}

	public void resetDrawables()
	{
//		Set<Entry<String, Drawable>> set = drawables.entrySet();
//		for (Entry<String, Drawable> entry : set)
//		{
//			Drawable d=entry.getValue();
//			if(d!=null)
//			{
//				d.setCallback(null);;
//			}
//		}
		drawables.clear();
//		System.gc();
	}
	public Typeface getFont()
	{
		return font;
	}
	public void setFont(Typeface font)
	{
		this.font = font;
	}
}
