package com.pokemon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.pokemon.screens.FirstScreen;

public class PokemonMain extends ApplicationAdapter {
	
	public static final float DELTA = 1 / 60f;
	
	Screen screen = new FirstScreen();
	
	@Override
	public void create () {
		screen.show();
	}

	@Override
	public void render () {
		screen.render(DELTA);
	}
	
	@Override
	public void dispose () {
		screen.dispose();
	}
}
