package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.pokemon.entities.Player;
import com.pokemon.tools.Background;

public class FirstScreen implements Screen {
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float elapsedTime;
	private Player player;
	private Background route01;

	@Override
	public void show() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 720);
		player = new Player();
		route01 = new Background("route01.png", 8, 23, 320, 576);
	}

	@Override
	public void render(float delta) {
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
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
		TextureRegion currentPlayerFrame = player.animateWalk(elapsedTime);
		
		
		camera.position.set(calculatePlayerCameraPosition(camera, route01));
		
		batch.begin();
		batch.draw(route01.getImage(), 0, 0, route01.getScaledWidth(), route01.getScaledHeight());
		batch.draw(currentPlayerFrame, player.getX(), player.getY(), 
				currentPlayerFrame.getRegionWidth() * 5f, currentPlayerFrame.getRegionHeight() * 5f);
		
		batch.end();
		
	}
	
	private Vector3 calculatePlayerCameraPosition(OrthographicCamera camera, Background bg) {
		Vector3 cameraPosition = camera.position;
		boolean lockX = false, lockY = false;
		if (player.getX() < 400 || player.getX() + 400 > bg.getScaledWidth())
			lockX = true;
		if (player.getY() < 400 || player.getY() + 400 > bg.getScaledHeight())
			lockY = true;
		
		if (!lockX)
			cameraPosition.x = player.getX();
		if (!lockY)
			cameraPosition.y = player.getY();
		
		return cameraPosition;
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
		batch.dispose();
	}

}
