package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.screens.PokemonSelectScreen.PokemonSelectOption;
import com.pokemon.tools.MenuInputProcessor;

public class MainMenuScreen implements IMenuScreen {

	public enum MainMenuOption implements IMenuScreen.IMenuOption {
		POKEDEX,
		POKEMON,
		PACK,
		POKEGEAR,
		GOLD,
		SAVE,
		OPTION,
		EXIT;
	}
	
	private final PokemonMain _game;
	
	private OrthographicCamera _camera;
	
	private TextureRegion selectionIconFilled;
	private TextureRegion mainMenu;
	private MainMenuOption currentOption;
	private MenuInputProcessor menuInputProcessor;
	private Texture backgroundImage;
	
	public MainMenuScreen(PokemonMain _game, OrthographicCamera _camera) {
		this._game = _game;
		this._camera = _camera;
		
		this.selectionIconFilled = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 650, 195, 8, 8);
		this.mainMenu = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 164, 10, 160, 144);
		
		this.currentOption = MainMenuOption.POKEDEX;
		
		menuInputProcessor = new MenuInputProcessor(_game, this);
		backgroundImage = new Texture(_game.mainMenuBackgroundImage);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuInputProcessor);
	}

	@Override
	public void render(float delta) {
		_game.batch.setProjectionMatrix(_camera.combined);
		
		_game.batch.begin();
		
		_game.batch.draw(backgroundImage, 0, 200, backgroundImage.getWidth(), backgroundImage.getHeight(), 
				0, 0, backgroundImage.getWidth(), backgroundImage.getHeight(), false, true);
		_game.batch.draw(mainMenu, 0, 0, mainMenu.getRegionWidth() * 5, mainMenu.getRegionHeight() * 5);
		_game.batch.draw(selectionIconFilled, 88 * 5, 120 * 5 - currentOption.ordinal() * 80, 
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
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public IMenuOption getCurrentMenuOption() {
		return currentOption;
	}

	@Override
	public void setCurrentMenuOption(IMenuOption option) {
		this.currentOption = (MainMenuOption) option;
	}

	@Override
	public void navigateUp() {
		currentOption = MainMenuOption.values()[(currentOption.ordinal() == 0  
				? MainMenuOption.values().length - 1 : (currentOption.ordinal() - 1))];
	}

	@Override
	public void navigateDown() {
		currentOption = MainMenuOption.values()[(currentOption.ordinal() == MainMenuOption.values().length - 1  
				? 0 : (currentOption.ordinal() + 1))];
	}

	@Override
	public void select() {
		switch(currentOption) {
			case POKEMON:
				_game.lastScreen = this;
				_game.setScreen(new PokemonSelectScreen(_game, _camera));
				break;
			default:
				System.out.println("not implemented yet");
				break;
		}
	}

	@Override
	public IMenuScreen getLastScreen() {
		return null;
	}
	
	

}
