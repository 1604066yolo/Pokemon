package com.pokemon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class FirstScreen implements Screen {
	
	private float elapsedTime;
	private Player player;

	@Override
	public void show() {
		player = new Player();
	}

	@Override
	public void render(float delta) {
		
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			player.setWalkState(Player.WalkState.LEFT);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.setWalkState(Player.WalkState.RIGHT);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.setWalkState(Player.WalkState.UP);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.setWalkState(Player.WalkState.DOWN);
		}
		else {
			player.setWalkState(Player.WalkState.STILL);
		}
		
		elapsedTime += delta;
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.move();
		player.animateWalk(elapsedTime);
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		player.dispose();
	}

}
