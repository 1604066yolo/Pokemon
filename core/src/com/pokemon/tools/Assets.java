package com.pokemon.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.entities.Pokemon;

public class Assets {
	
	// ----- CONSTANTS ------
	public static final int SCALE_FACTOR = 5;
	public static final Color collisionColor = new Color(1f, 216f / 255f, 0f, 1f);
	private static final float ANIMATION_FRAME_TIME = 1 / 4f;

	
	// ----- MENUS -----
	public static TextureRegion titleScreen;
	public static TextureRegion mainMenu;
	public static TextureRegion pokemonSelect;
	public static TextureRegion dialougeBox;
	public static TextureRegion battleScreen;
	
	// ----- PLAYER -----
	public static Animation<TextureRegion> playerLeft;
	public static Animation<TextureRegion> playerRight;
	public static Animation<TextureRegion> playerUp;
	public static Animation<TextureRegion> playerDown;
	public static Animation<TextureRegion> playerStill;
	public static TextureRegion playerBattle;
	
	// ----- POKEMON -----
	public static Pokemon pikachu;
	public static Pokemon bulbasaur;
	public static Pokemon charmander;
	
	// ----- BACKGROUNDS -----
	public static Background route01;
	
	// ----- TRAINERS -----
	public static TextureRegion chineseLady_battle;
	public static TextureRegion chineseLady_world;
	
	// ----- MISC -----
	public static TextureRegion selectionIconFilled;


	
	public static void load() {
		// ----- MENUS -----
		titleScreen = new TextureRegion(new Texture(Gdx.files.internal("titles.png")), 8, 728, 160, 144);
		mainMenu = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 164, 10, 160, 144);
		pokemonSelect = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 326, 164, 160, 144);
		dialougeBox = new TextureRegion(new Texture(Gdx.files.internal("dialouge.png")), 0, 0, 151, 37);
		battleScreen = new TextureRegion(new Texture(Gdx.files.internal("battleMenus.png")), 177, 8, 160, 144);

		// ----- PLAYER -----
		TextureAtlas charset = new TextureAtlas(Gdx.files.internal("characters.atlas"));
		
		playerUp = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("up"));
		playerUp.setFrameDuration(ANIMATION_FRAME_TIME);
		
		playerDown = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("down"));
		playerDown.setFrameDuration(ANIMATION_FRAME_TIME);
		
		playerLeft = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("left"));
		playerLeft.setFrameDuration(ANIMATION_FRAME_TIME);
		
		playerRight = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("right"));
		playerRight.setFrameDuration(ANIMATION_FRAME_TIME);
		
		playerStill = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("still"));
		playerStill.setFrameDuration(ANIMATION_FRAME_TIME);
		
		playerBattle = new TextureRegion(new Texture(Gdx.files.internal("charactersBattle.png")), 72, 374, 48, 48);
		
		// ----- POKEMON -----
		pikachu = new Pokemon("Pikachu", new Position(0, 0)); //TODO
		bulbasaur = new Pokemon("Bulbasaur", new Position(1140, 4735));
		charmander = new Pokemon("Charmander", new Position(1191, 4735));
		
		// ----- BACKGROUNDS -----
		route01 = new Background("route01", 8, 23, 320, 576);
		
		// ----- TRAINERS -----
		chineseLady_battle = new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16);
		chineseLady_world = new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16);
		
		// ----- MISC -----
		selectionIconFilled = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 650, 195, 8, 8);
		
	}

}
