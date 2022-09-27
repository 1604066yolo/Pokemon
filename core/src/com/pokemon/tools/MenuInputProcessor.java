package com.pokemon.tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pokemon.PokemonMain;
import com.pokemon.screens.MenuScreen;

public class MenuInputProcessor implements InputProcessor {

	private MenuScreen menu;
	
	public MenuInputProcessor(MenuScreen menu) {
		this.menu = menu;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.UP) {
			menu.navigateUp();
			return true;
		}
		else if (keycode == Input.Keys.DOWN) {
			menu.navigateDown();
			return true;
		}
		else if (keycode == Input.Keys.ENTER) {
			menu.select();
			return true;
		}
		
		if (keycode == Input.Keys.I) {
			PokemonMain.setScreen(PokemonMain.ScreenType.MainGame);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

}
