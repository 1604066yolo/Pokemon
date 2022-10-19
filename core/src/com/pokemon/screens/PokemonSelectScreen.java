package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.pokemon.PokemonMain;
import com.pokemon.tools.Assets;

public class PokemonSelectScreen extends MenuScreen {
	
	public enum PokemonSelectOption {
		SLOT1,
		SLOT2,
		SLOT3,
		SLOT4,
		SLOT5,
		SLOT6,
		CANCEL;
	}
	
	private final PokemonMain _game;
	
	private PokemonSelectOption currentOption;
	
	public PokemonSelectScreen(PokemonMain _game) {
		this._game = _game;
				
		this.currentOption = PokemonSelectOption.SLOT1;
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();

		_game.batch.begin();
		
		_game.batch.draw(Assets.pokemonSelect, 0, 0, Assets.pokemonSelect.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.pokemonSelect.getRegionHeight() * Assets.SCALE_FACTOR);
		
		_game.batch.draw(Assets.selectionIconFilled, 0 * Assets.SCALE_FACTOR, 128 * Assets.SCALE_FACTOR - currentOption.ordinal() * 80, 
				Assets.selectionIconFilled.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.selectionIconFilled.getRegionHeight() * Assets.SCALE_FACTOR);
		
		for (int i = 0; i < _game.player.getPokemons().size(); i++) {
			_game.batch.draw(_game.player.getPokemons().get(i).getInventoryImage(), 
					currentOption.ordinal() == i ? 8 * Assets.SCALE_FACTOR : 0, 720 - (20 + 16*i) * Assets.SCALE_FACTOR, 80, 80);
			
			_game.font.draw(_game.batch, _game.player.getPokemons().get(i).getName(), 24 * Assets.SCALE_FACTOR, 720 - (8 + 16*i) * Assets.SCALE_FACTOR);
			_game.font.draw(_game.batch, Integer.toString(_game.player.getPokemons().get(i).getLevel()), 64 * Assets.SCALE_FACTOR, 720 - (16 + 16*i) * Assets.SCALE_FACTOR);
			_game.font.draw(_game.batch, Integer.toString(_game.player.getPokemons().get(i).getHP()), 104 * Assets.SCALE_FACTOR, 720 - (8 + 16*i) * Assets.SCALE_FACTOR);
		}
		
		_game.batch.end();
	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}
	

	@Override
	public void navigateUp() {
		currentOption = PokemonSelectOption.values()[(currentOption.ordinal() == 0  
				? PokemonSelectOption.values().length - 1 : (currentOption.ordinal() - 1))];
	}

	@Override
	public void navigateDown() {
		currentOption = PokemonSelectOption.values()[(currentOption.ordinal() == PokemonSelectOption.values().length - 1  
				? 0 : (currentOption.ordinal() + 1))];
	}

	@Override
	public void select() {
		switch(currentOption) {
			case CANCEL:
				_game.setScreen(_game.lastScreen);
				break;
			default:
				break;
		}
	}

}
