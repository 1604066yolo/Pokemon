package com.pokemon.tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Player;
import com.pokemon.screens.MainMenuScreen;

public class PlayerInputProcessor implements InputProcessor {

	private final PokemonMain _game;
	
	public PlayerInputProcessor(PokemonMain _game) {
		this._game = _game;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.A) {
			_game.player.setWalkState(Player.WalkState.LEFT);
			return true;
		}
		else if (keycode == Input.Keys.D) {
			_game.player.setWalkState(Player.WalkState.RIGHT);
			return true;
		}
		else if (keycode == Input.Keys.W) {
			_game.player.setWalkState(Player.WalkState.UP);
			return true;
		}
		else if (keycode == Input.Keys.S) {
			_game.player.setWalkState(Player.WalkState.DOWN);
			return true;
		}
		else if (keycode == Input.Keys.I) {
			_game.setScreen(new MainMenuScreen(_game));
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.A || keycode == Input.Keys.D || keycode == Input.Keys.W || keycode == Input.Keys.S) {
			_game.player.setWalkState(Player.WalkState.STILL);
			return true;
		}
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
