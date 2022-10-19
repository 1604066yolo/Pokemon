package com.pokemon.tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Player;
import com.pokemon.screens.GameScreen;
import com.pokemon.screens.IMenuScreen;

public class MenuInputProcessor implements InputProcessor {

	private final PokemonMain _game;
	
	private IMenuScreen _menu;
	
	public MenuInputProcessor(PokemonMain _game, IMenuScreen _menu) {
		this._game = _game;
		this._menu = _menu;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		_game.player.setWalkState(Player.WalkState.STILL);
		if (keycode == Input.Keys.UP) {
			_menu.navigateUp();
			return true;
		}
		else if (keycode == Input.Keys.DOWN) {
			_menu.navigateDown();
			return true;
		}
		else if (keycode == Input.Keys.ENTER) {
			_menu.select();
			return true;
		}
//		else if (keycode == Input.Keys.I) {
//			_game.setScreen(new FirstScreen(_game));
//			return true;
//		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

}
