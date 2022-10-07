package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.tools.MenuInputProcessor;

public class MainMenuScreen implements MenuScreen {

	public enum MainMenuOption implements MenuScreen.MenuOption {
		POKEDEX,
		POKEMON,
		PACK,
		POKEGEAR,
		GOLD,
		SAVE,
		OPTION,
		EXIT;
		
		private static MenuOption[] options = MainMenuOption.values();

		public static MenuOption get(int i) {
			return options[i];
		}

		public static int getLength() {
			return options.length;
		}
	}
	
	private SpriteBatch batch;
	private TextureRegion selectionIconFilled;
	private TextureRegion mainMenu;
	private MainMenuOption currentOption;
	
	private static MenuInputProcessor menuInputProcessor;
	
	public MainMenuScreen() {
		this.batch = new SpriteBatch();
		this.selectionIconFilled = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 650, 195, 8, 8);
		this.mainMenu = new TextureRegion(new Texture(Gdx.files.internal("menus.png")), 164, 10, 160, 144);
		
		this.currentOption = MainMenuOption.POKEDEX;
		
		menuInputProcessor = new MenuInputProcessor(this);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuInputProcessor);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		
		batch.draw(mainMenu, 0, 0, mainMenu.getRegionWidth() * 5, mainMenu.getRegionHeight() * 5);
		batch.draw(selectionIconFilled, 88 * 5, 120 * 5 - currentOption.ordinal() * 80, 
				selectionIconFilled.getRegionWidth() * 5, selectionIconFilled.getRegionHeight() * 5);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public MenuOption getCurrentMenuOption() {
		return currentOption;
	}

	@Override
	public void setCurrentMenuOption(MenuOption option) {
		this.currentOption = (MainMenuOption) option;
	}

	@Override
	public void navigateUp() {
		currentOption = (MainMenuOption) MainMenuOption.get((currentOption.ordinal() - 1) == -1 
				? MainMenuOption.getLength() - 1 : (currentOption.ordinal() - 1));
	}

	@Override
	public void navigateDown() {
		currentOption = (MainMenuOption) MainMenuOption.get((currentOption.ordinal() + 1) == MainMenuOption.getLength() 
				? 0 : (currentOption.ordinal() + 1));
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}
	
	

}
