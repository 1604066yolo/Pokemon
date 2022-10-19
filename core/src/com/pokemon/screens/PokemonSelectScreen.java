package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.tools.MenuInputProcessor;

public class PokemonSelectScreen implements IMenuScreen {
	
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
	
	private OrthographicCamera _camera;
	
	private TextureRegion selectionIconFilled;
	private TextureRegion pokemonSelect;
	private PokemonSelectOption currentOption;
	private MenuInputProcessor menuInputProcesser;
	
	public PokemonSelectScreen(PokemonMain _game, OrthographicCamera _camera) {
		this._game = _game;
		this._camera = _camera;
		
		this.selectionIconFilled = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 650, 195, 8, 8);
		this.pokemonSelect = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 326, 164, 160, 144);
		
		this.currentOption = PokemonSelectOption.SLOT1;
		
		this.menuInputProcesser = new MenuInputProcessor(_game, this);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuInputProcesser);
	}

	@Override
	public void render(float delta) {
		_game.batch.setProjectionMatrix(_camera.combined);
		
		_game.batch.begin();
		
		_game.batch.draw(pokemonSelect, 0, 0, pokemonSelect.getRegionWidth() * 5, pokemonSelect.getRegionHeight() * 5);
		_game.batch.draw(selectionIconFilled, 0 * 5, 128 * 5 - currentOption.ordinal() * 80, 
				selectionIconFilled.getRegionWidth() * 5, selectionIconFilled.getRegionHeight() * 5);
		for (int i = 0; i < _game.player.getPokemons().size(); i++) {
			_game.batch.draw(_game.player.getPokemons().get(i).getInventoryImage(), 
					currentOption.ordinal() == i ? 8 * 5 : 0, 720 - (20 + 16*i) * 5, 80, 80);
			
			_game.font.draw(_game.batch, _game.player.getPokemons().get(i).getName(), 24 * 5, 720 - (8 + 16*i) * 5);
			_game.font.draw(_game.batch, Integer.toString(_game.player.getPokemons().get(i).getLevel()), 64 * 5, 720 - (16 + 16*i) * 5);
			_game.font.draw(_game.batch, Integer.toString(_game.player.getPokemons().get(i).getHP()), 104 * 5, 720 - (8 + 16*i) * 5);
			
			// LEVEL
			// x: 64 * 5
			// y: 720 - (24 + 16*i) * 5
			
			// HP
			// x: 104 * 5
			// y: 720 - (16 + 16*i) * 5
		}
		
		
		_game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
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

	@Override
	public Screen getLastScreen() {
		return new GameScreen(_game);
	}

}
