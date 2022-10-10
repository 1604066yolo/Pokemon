package com.pokemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.entities.Player;
import com.pokemon.screens.FirstScreen;

public class PokemonMain extends Game {
	
	// public singletons
	public SpriteBatch batch;
	public BitmapFont font;
	public Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		player = new Player();
		
		// default screen -> FirstScreen()
		setScreen(new FirstScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
	
}
