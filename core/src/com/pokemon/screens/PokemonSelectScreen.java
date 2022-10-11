package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.screens.MainMenuScreen.MainMenuOption;
import com.pokemon.tools.MenuInputProcessor;

public class PokemonSelectScreen implements IMenuScreen {
	
	public enum PokemonSelectOption implements IMenuScreen.IMenuOption {
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
//		Gdx.gl.glClearColor(0, 1, 0, 0);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public IMenuOption getCurrentMenuOption() {
		return null;
	}

	@Override
	public void setCurrentMenuOption(IMenuOption option) {
		
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
	public IMenuScreen getLastScreen() {
		return new MainMenuScreen(_game, _camera);
	}

}
