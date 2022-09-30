package com.pokemon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.pokemon.entities.Player;
import com.pokemon.screens.FirstScreen;
import com.pokemon.screens.MainMenuScreen;

public class PokemonMain extends ApplicationAdapter {
	
	public static final float DELTA = 1 / 60f;
	
	private static Screen mainGameScreen;
	private static Screen mainMenuScreen;
	private static Player player;
	
	private static ScreenType currentScreen;
	
	public static enum ScreenType {
		MainMenu,
		MainGame
	}
	
	public static Screen getScreen(ScreenType type) {
		switch(type) {
			case MainMenu:
				return mainMenuScreen;
			case MainGame:
				return mainGameScreen;
			default:
				return mainGameScreen;
		}
	}
	
	public static ScreenType getCurrentScreen() {
		return currentScreen;
	}
	
	public static void setScreen(ScreenType type) {
		currentScreen = type;
	}
	
	@Override
	public void create () {
		player= new Player();
		mainGameScreen = new FirstScreen();
		mainMenuScreen = new MainMenuScreen();
		currentScreen = ScreenType.MainGame;
	}

	@Override
	public void render () {
		switch(currentScreen) {
		case MainGame:
			mainGameScreen.show();
			mainGameScreen.render(DELTA);
			break;
		case MainMenu:
			mainMenuScreen.show();
			mainMenuScreen.render(DELTA);
			break;
		}
		
	}
	
	@Override
	public void dispose () {
		mainGameScreen.dispose();
	}
	
	public static Player getPlayer() {
		return player;
	}
	
}
