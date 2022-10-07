package com.pokemon.tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Player;

public class PlayerInputProcessor implements InputProcessor {

	private Player player;
	
	public PlayerInputProcessor(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.A) {
			player.setWalkState(Player.WalkState.LEFT);
			return true;
		}
		else if (keycode == Input.Keys.D) {
			player.setWalkState(Player.WalkState.RIGHT);
			return true;
		}
		else if (keycode == Input.Keys.W) {
			player.setWalkState(Player.WalkState.UP);
			return true;
		}
		else if (keycode == Input.Keys.S) {
			player.setWalkState(Player.WalkState.DOWN);
			return true;
		}
		
		if (keycode == Input.Keys.I) {
			player.setWalkState(Player.WalkState.STILL);
			PokemonMain.setScreen(PokemonMain.ScreenType.MainMenu);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.A || keycode == Input.Keys.D || keycode == Input.Keys.W || keycode == Input.Keys.S) {
			player.setWalkState(Player.WalkState.STILL);
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
