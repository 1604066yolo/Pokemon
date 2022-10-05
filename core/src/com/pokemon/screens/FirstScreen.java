package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Player;
import com.pokemon.tools.Background;
import com.pokemon.tools.PlayerInputProcessor;

public class FirstScreen implements Screen {
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float elapsedTime;
	private Player player;
	private Background route01;

	private static Color collisionColor;
	
	private static PlayerInputProcessor playerInputProcessor;

	
	public FirstScreen() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 720);
		player = PokemonMain.getPlayer();
		route01 = new Background("route01", 8, 23, 320, 576);
		
		collisionColor = new Color(255f / 255f, 216f / 255f, 0f / 255f, 255f / 255f);
		
		playerInputProcessor = new PlayerInputProcessor(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(playerInputProcessor);
	}

	@Override
	public void render(float delta) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		elapsedTime += delta;
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		player.update(elapsedTime, calculatePlayerCollision());
		TextureRegion currentPlayerFrame = player.getCurrentWalkFrame();
		
		camera.position.set(calculatePlayerCameraPosition(camera, route01));
		
		batch.begin();
		
		
		batch.draw(route01.getImage(), 0, 0, route01.getScaledWidth(), route01.getScaledHeight());
		batch.draw(currentPlayerFrame, player.getX() * 5, player.getY() * 5, 
				currentPlayerFrame.getRegionWidth() * 5f, currentPlayerFrame.getRegionHeight() * 5f);
		
		batch.end();
		
	}
	
	private Vector3 calculatePlayerCameraPosition(OrthographicCamera camera, Background bg) {
		Vector3 cameraPosition = camera.position;
		boolean lockX = false, lockY = false;
		if (player.getX() * 5 < 360 || player.getX() * 5 + 440 > bg.getScaledWidth())
			lockX = true;
		if (player.getY() * 5 < 320 || player.getY() * 5 + 400 > bg.getScaledHeight())
			lockY = true;
		
		if (!lockX)
			cameraPosition.x = player.getX() * 5 + 40;
		if (!lockY)
			cameraPosition.y = player.getY() * 5 + 40;
		
		return cameraPosition;
	}
	
	private boolean calculatePlayerCollision() {
		if (!route01.getCollision().getTexture().getTextureData().isPrepared())
			route01.getCollision().getTexture().getTextureData().prepare();
		Pixmap pixmap = route01.getCollision().getTexture().getTextureData().consumePixmap();
		
		if (player.getWalkState() == Player.WalkState.LEFT) {
			Color color = new Color(pixmap.getPixel(player.getX() + 8, route01.getImage().getRegionHeight() - player.getY()));
			if ((int) (color.r*255) == (int) (collisionColor.r*255) && 
					(int) (color.g*255) == (int) (collisionColor.g*255) && 
					(int) (color.b*255) == (int) (collisionColor.b*255)) {
				return false;
			}
		}
		
		/*if (player.getWalkState() == Player.WalkState.RIGHT) {
			Color color = new Color(pixmap.getPixel(player.getX() / 5 + 8, route01.getImage().getRegionHeight() - player.getY() / 5));
			if ((int) (color.r*255) == (int) (collisionColor.r*255) && 
					(int) (color.g*255) == (int) (collisionColor.g*255) && 
					(int) (color.b*255) == (int) (collisionColor.b*255)) {
				return false;
			}
		}*/
		
		return true;
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
