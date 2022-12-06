package com.pokemon.tools;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;
import com.pokemon.entities.Pokemon;
import com.pokemon.objects.Move;
import com.pokemon.objects.TrainerDialogue;

public class Assets {
	
	// ----- CONSTANTS ------
	public static final int SCALE_FACTOR = 5;
	public static final Color collisionColor = new Color(1f, 216f / 255f, 0f, 1f);
	private static final float ANIMATION_FRAME_TIME = 1 / 4f;
	
	// ----- COMMON TEXTURES -----
	public static Texture pokemons;
	public static Texture pokemonsBattle;
	private static Texture characters;
	private static Texture charactersBattle;
	private static Texture menus;
	private static Texture battleMenus;
	
	// ----- MENUS -----
	public static TextureRegion titleScreen;
	public static TextureRegion mainMenu;
	public static TextureRegion pokemonSelect;
	public static TextureRegion dialougeBox;
	public static TextureRegion battleScreenIntro;
	
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
	public static TextureRegion youngsterjoey_battle;
	public static TextureRegion youngsterjoey_world;
	
//	public static TextureRegion chineseLady_battle;
//	public static TextureRegion chineseLady_world;
	
	// ----- MISC -----
	public static TextureRegion selectionIconFilled;
	public static TextureRegion pokeballFilled;
	public static TextureRegion pokeballUnfilled;
	
	// ----- JSON -----
	public static Move[] moves;
	public static Map<String, TrainerDialogue> trainerDialogue;

	
	public static void load() {
		// ----- COMMON TEXTURES ------
		pokemons = new Texture(Gdx.files.internal("pokemon.png"));
		characters = new Texture(Gdx.files.internal("characters.png"));
		charactersBattle = new Texture(Gdx.files.internal("charactersBattle.png"));
		menus = new Texture(Gdx.files.internal("menus.png"));
		battleMenus = new Texture(Gdx.files.internal("battleMenus.png"));
		
		// ----- MENUS -----
		titleScreen = new TextureRegion(new Texture(Gdx.files.internal("titles.png")), 8, 728, 160, 144);
		mainMenu = new TextureRegion(menus, 164, 10, 160, 144);
		pokemonSelect = new TextureRegion(menus, 326, 164, 160, 144);
		dialougeBox = new TextureRegion(new Texture(Gdx.files.internal("dialogueScreen.png")));
		battleScreenIntro = new TextureRegion(battleMenus, 177, 8, 160, 144);

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
		
		playerBattle = new TextureRegion(charactersBattle, 72, 374, 48, 48);
		
		// ----- POKEMON -----
		pikachu = new Pokemon("Pikachu", new Position(1072, 4718), new Position(685, 394), new Position(693, 516)); //TODO
		bulbasaur = new Pokemon("Bulbasaur", new Position(1140, 4735), new Position(1, 18), new Position(9, 140));
		charmander = new Pokemon("Charmander", new Position(1191, 4735), new Position(514, 18), new Position(522, 140));
		
		// ----- BACKGROUNDS -----
		route01 = new Background("route01", 8, 23, 320, 576);
		
		// ----- TRAINERS -----
		youngsterjoey_battle = new TextureRegion(charactersBattle, 8, 16, 56, 56);
		youngsterjoey_world = new TextureRegion(characters, 26, 1640, 16, 16);
		
//		chineseLady_battle = new TextureRegion(charactersBattle, 456, 156, 56, 56);
//		chineseLady_world = new TextureRegion(characters, 9, 136, 16, 16);
		
		// ----- MISC -----
		selectionIconFilled = new TextureRegion(menus, 650, 195, 8, 8);
		pokeballFilled = new TextureRegion(battleMenus, 345, 8, 8, 8);
		pokeballUnfilled = new TextureRegion(battleMenus, 345, 24, 8, 8);
		
		// ----- TYPES -----
		Types.initializeTypes();
		
		// ----- JSON -----
		moves = parseJson(Move[].class, "moves.json");
		trainerDialogue = new HashMap<String, TrainerDialogue>();
		TrainerDialogue[] tds = parseJson(TrainerDialogue[].class, "trainerDialogue.json");
		for (TrainerDialogue td : tds) {
//			System.out.println(td);
			trainerDialogue.put(td.classification, td);
		}
	}
	
	private static <T> T parseJson(Class<T> type, String file) {
		Json json = new Json();
		return json.fromJson(type, Gdx.files.internal(file));
	}

}
