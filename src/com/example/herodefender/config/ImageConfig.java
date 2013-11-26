package com.example.herodefender.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.herodefender.Consts;
import com.example.herodefender.R;

public class ImageConfig
{
	public static final int BACKGROUND_SIZE = -1;
	public static final int TEST = 0;
	public static final int BACKGROUND_GAME = 1;
	public static final int CITY_WALL = 2;
	public static final int WALL_LONG01 = 3;
	public static final int WALL_LONG02 = 4;
	public static final int WALL_LONG03 = 5;
	public static final int WALL_LONG04 = 6;
	public static final int WALL_LONG05 = 7;
	public static final int WALL01 = 8;
	public static final int WALL02 = 9;
	public static final int WALL03 = 10;
	public static final int WALL04 = 11;
	public static final int WALL05 = 12;
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
	public static final int CITY_WALL_STAY02 = 197;
	public static final int CITY_WALL_STAY03 = 198;
	public static final int CITY_WALL_STAY04 = 199;
	public static final int CITY_WALL_STAY05 = 200;
	public static final int CITY_WALL_STAY06 = 201;
	public static final int CITY_WALL_STAY07 = 202;
	public static final int CITY_WALL_STAY08 = 203;
	public static final int CITY_WALL_STAY09 = 204;
	public static final int CITY_WALL_DESTROY01 = 205;
	public static final int CITY_WALL_DESTROY02 = 206;
	public static final int CITY_WALL_DESTROY03 = 207;
	public static final int CITY_WALL_DESTROY04 = 208;
	public static final int CITY_WALL_DESTROY05 = 209;
	public static final int HERO_FAILURE01 = 210;
	public static final int HERO_FAILURE02 = 211;
	public static final int HERO_FAILURE03 = 212;
	public static final int HERO_FAILURE04 = 213;
	public static final int HERO_FAILURE05 = 214;
	public static final int HERO_FAILURE06 = 215;
	public static final int HERO_FAILURE07 = 216;
	public static final int HERO_WIN01 = 217;
	public static final int HERO_WIN02 = 218;
	public static final int HERO_WIN03 = 219;
	public static final int HERO_WIN04 = 220;
	public static final int HERO_WIN05 = 221;
	public static final int HERO_WIN06 = 222;
	public static final int HERO_WIN07 = 223;
	public static final int HERO_WIN08 = 224;
	public static final int UI_BAR01 = 225;
	public static final int UI_BAR02 = 226;
	public static final int UI_BAR03 = 227;
	public static final int UI_BAR04 = 228;
	public static final int UI_BAR05 = 229;
	public static final int UI_BAR06 = 230;
	public static final int UI_BAR07 = 231;
	public static final int BUTTON_PAUSE = 232;
	public static final int BUTTON_CONTINUE = 233;
	public static final int MENU_PAUSE01 = 234;
	public static final int MENU_PAUSE02 = 235;
	public static final int MENU_PAUSE03 = 236;
	public static final int MENU_PAUSE04 = 237;
	public static final int NUMBER_STAGE = 238;
	public static final int BURST01 = 240;
	public static final int BURST02 = 241;
	public static final int BURST03 = 242;
	public static final int BURST04 = 243;
	public static final int BURST05 = 244;
	public static final int BURST06 = 245;
	public static final int UI_BOMB = 250;
	public static final int BACKGROUND_LOBBY=251;
	public static final int BUTTON_START01=252;
	public static final int BUTTON_START02=253;
	public static final int BUTTON_TEAM01=254;
	public static final int BUTTON_TEAM02=255;
	public static final int BUTTON_EXIT01=256;
	public static final int BUTTON_EXIT02=257;
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
	public static final int FRAME_PICK01=270;
	public static final int FRAME_PICK02=271;
	public static final int WORD_BARRIER=272;
	public static final int WORD_WEAPON=273;
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
	public static final int NUMBER_BARRIER=290;
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

	private static final int[] CITYWALL =
		{
				CITY_WALL_STAY01,
				CITY_WALL_STAY02,
				CITY_WALL_STAY03,
				CITY_WALL_STAY04,
				CITY_WALL_STAY05,
				CITY_WALL_STAY06,
				CITY_WALL_STAY07,
				CITY_WALL_STAY08,
				CITY_WALL_STAY09,
				CITY_WALL_DESTROY01,
				CITY_WALL_DESTROY02,
				CITY_WALL_DESTROY03,
				CITY_WALL_DESTROY04,
				CITY_WALL_DESTROY05,};
	private static final int[] UI_BAR =
		{UI_BAR01,UI_BAR02,UI_BAR03,UI_BAR04,UI_BAR05,UI_BAR06,UI_BAR07,};
	private Map<String, Drawable> drawables;
	private Context context;

	public ImageConfig(Context context)
	{
		this.context = context;
		drawables = new HashMap<String, Drawable>();
	}

	public Drawable getDrawable(int image)
	{
		Drawable drawable = drawables.get("" + image);
		if (drawable == null)
		{
			switch (image)
			{
				case BACKGROUND_SIZE:
					drawable = context.getResources().getDrawable(R.raw.world1);
					break;
				case BACKGROUND_GAME:
					drawable = this.getResizeDrawable(R.raw.world1);
					break;
				case CITY_WALL:
					drawable = this.getResizeDrawable(R.raw.world_000);
					break;
				case WALL_LONG01:
					drawable = this.getResizeDrawable(R.raw.wall1_001);
					break;
				case WALL_LONG02:
					drawable = this.getResizeDrawable(R.raw.wall1_002);
					break;
				case WALL_LONG03:
					drawable = this.getResizeDrawable(R.raw.wall1_003);
					break;
				case WALL_LONG04:
					drawable = this.getResizeDrawable(R.raw.wall1_004);
					break;
				case WALL_LONG05:
					drawable = this.getResizeDrawable(R.raw.wall1_005);
					break;
				case WALL01:
					drawable = this.getResizeDrawable(R.raw.wall2_001);
					break;
				case WALL02:
					drawable = this.getResizeDrawable(R.raw.wall2_002);
					break;
				case WALL03:
					drawable = this.getResizeDrawable(R.raw.wall2_003);
					break;
				case WALL04:
					drawable = this.getResizeDrawable(R.raw.wall2_004);
					break;
				case WALL05:
					drawable = this.getResizeDrawable(R.raw.wall2_005);
					break;
				case DOOR_UP01:
					drawable = this.getResizeDrawable(R.raw.wall2_001_1);
					break;
				case DOOR_UP02:
					drawable = this.getResizeDrawable(R.raw.wall2_001_2);
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
					drawable = this.getResizeDrawable(R.raw.wall2_005_2);
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
					drawable = this.getResizeDrawable(R.raw.h_stay_000);
					drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
					break;
				case WEREWOLVES_AIR:
					drawable = this.getResizeDrawable(R.raw.werewolves_stay_001);
					drawable.setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
					break;
				case ZOMBIE_AIR:
					drawable = this.getResizeDrawable(R.raw.zombie_stay_001);
					drawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
					break;
				case VAMPIRE_AIR:
					drawable = this.getResizeDrawable(R.raw.vampire_stay_001);
					drawable.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
					break;
				case CITY_WALL_STAY01:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_000);
					break;
				case CITY_WALL_STAY02:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_001);
					break;
				case CITY_WALL_STAY03:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_002);
					break;
				case CITY_WALL_STAY04:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_003);
					break;
				case CITY_WALL_STAY05:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_004);
					break;
				case CITY_WALL_STAY06:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_005);
					break;
				case CITY_WALL_STAY07:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_006);
					break;
				case CITY_WALL_STAY08:
					this.removeDrawable(CITYWALL);
					drawable = this.getResizeDrawable(R.raw.world_007);
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
					drawable = this.getResizeDrawable(R.raw.knight_failure_000);
					break;
				case HERO_FAILURE02:
					drawable = this.getResizeDrawable(R.raw.knight_failure_001);
					break;
				case HERO_FAILURE03:
					drawable = this.getResizeDrawable(R.raw.knight_failure_002);
					break;
				case HERO_FAILURE04:
					drawable = this.getResizeDrawable(R.raw.knight_failure_003);
					break;
				case HERO_FAILURE05:
					drawable = this.getResizeDrawable(R.raw.knight_failure_004);
					break;
				case HERO_FAILURE06:
					drawable = this.getResizeDrawable(R.raw.knight_failure_005);
					break;
				case HERO_FAILURE07:
					drawable = this.getResizeDrawable(R.raw.knight_failure_006);
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
				case UI_BAR01:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_001);
					break;
				case UI_BAR02:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_002);
					break;
				case UI_BAR03:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_003);
					break;
				case UI_BAR04:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_004);
					break;
				case UI_BAR05:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_005);
					break;
				case UI_BAR06:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_006);
					break;
				case UI_BAR07:
					this.removeDrawable(UI_BAR);
					drawable = this.getResizeDrawable(R.raw.directory_007);
					break;
				case BUTTON_PAUSE:
					drawable = this.getResizeDrawable(R.raw.directory_p1_001);
					break;
				case BUTTON_CONTINUE:
					drawable = this.getResizeDrawable(R.raw.directory_p1_002);
					break;
				case MENU_PAUSE01:
					drawable = this.getResizeDrawable(R.raw.stop_001);
					break;
				case MENU_PAUSE02:
					drawable = this.getResizeDrawable(R.raw.stop_002);
					break;
				case MENU_PAUSE03:
					drawable = this.getResizeDrawable(R.raw.stop_003);
					break;
				case MENU_PAUSE04:
					drawable = this.getResizeDrawable(R.raw.stop_004);
					break;
				case NUMBER_STAGE:
					drawable = this.getResizeDrawable(R.raw.directory_p2_002);
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
				case BUTTON_START01:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_start_000);
					break;
				case BUTTON_START02:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_start_001);
					break;
				case BUTTON_TEAM01:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_team_000);
					break;
				case BUTTON_TEAM02:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_team_001);
					break;
				case BUTTON_EXIT01:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_away_000);
					break;
				case BUTTON_EXIT02:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_away_001);
					break;
				case BUTTON_MUSIC01:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_music_000);
					break;
				case BUTTON_MUSIC02:
					drawable = this.getResizeDrawable(R.raw.gamedirectory1_music_001);
					break;
				case BACKGROUND_BARRIER:
					drawable = this.getResizeDrawable(R.raw.book3_back);
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
					drawable =this.getResizeDrawable(R.raw.book3_st2);
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
				case FRAME_PICK01:
					drawable =this.getResizeDrawable(R.raw.book3_doc1);
					break;
				case FRAME_PICK02:
					drawable =this.getResizeDrawable(R.raw.book3_doc2);
					break;
				case WORD_BARRIER:
					drawable =this.getResizeDrawable(R.raw.book3_wd1);
					break;
				case WORD_WEAPON:
					drawable =this.getResizeDrawable(R.raw.book3_wd2);
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
				case NUMBER_BARRIER:
					drawable =this.getResizeDrawable(R.raw.book3_wd3);
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
				default:
					drawable = this.getResizeDrawable(R.drawable.ic_launcher);
					break;
			}
			drawables.put("" + image, drawable);
		}
		return drawable;
	}
	private Drawable getMirrorDrawable(int id)
	{
		Matrix matrix = new Matrix();
		matrix.preScale(-1, 1);
		matrix.postScale(Consts.screenScale, Consts.screenScale);
		return this.getMatrixDrawable(id, matrix);
	}
	private Drawable getMatrixDrawable(int id,Matrix matrix)
	{
		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), id);
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
		return this.getMatrixDrawable(id, matrix);
//		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), id);
//		int oldwidth = bmp.getWidth();
//		int oldheight = bmp.getHeight();
//		Matrix matrix = new Matrix();
//		matrix.postScale(Consts.screenScale, Consts.screenScale);
//		Bitmap resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, oldwidth, oldheight, matrix, true);
//		BitmapDrawable bmd = new BitmapDrawable(context.getResources(), resizedBitmap);
//		if (bmp.hashCode() != resizedBitmap.hashCode())
//		{
//			bmp.recycle();
//		}
//		return bmd;
	}

	private void removeDrawable(int[] images)
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
		Set<Entry<String, Drawable>> set = drawables.entrySet();
		for (Entry<String, Drawable> entry : set)
		{
			entry.getValue().setCallback(null);
		}
		drawables.clear();
	}
}
