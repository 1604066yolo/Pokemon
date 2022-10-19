package com.pokemon.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	// ----- CONSTANTS ------
	public static final int SCALE_FACTOR = 5;
	public static final Color collisionColor = new Color(1f, 216f / 255f, 0f, 1f);
	
	// ----- MENUS -----
	public static TextureRegion titleScreen;
	public static TextureRegion mainMenu;
	
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
		
		// ----- BACKGROUNDS -----
		route01 = new Background("route01", 8, 23, 320, 576);
		
		// ----- TRAINERS -----
		chineseLady_battle = new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16);
		chineseLady_world = new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16);
		
		// ----- MISC -----
		selectionIconFilled = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 650, 195, 8, 8);
		
	}

}
