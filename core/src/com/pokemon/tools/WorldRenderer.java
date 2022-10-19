package com.pokemon.tools;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Entity;

public class WorldRenderer {
	
	private final PokemonMain _game;
	private Background _background;
	private List<Entity> _entities;
	
	private OrthographicCamera worldCamera;
	
	public WorldRenderer(PokemonMain _game, Background _background, List<Entity> _entities) {
		this._game = _game;
		this._background = _background;
		this._entities = _entities;
		
		worldCamera = new OrthographicCamera();
		worldCamera.setToOrtho(false, 800, 720);
	}
	
	public void render() {
		worldCamera.position.set(calculateCameraPosition());
		worldCamera.update();
		
		_game.batch.setProjectionMatrix(worldCamera.combined);
		
		renderBackground();
		renderEntities();
	}
	
	public void renderBackground() {
		_game.batch.disableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(_background.getImage(), 0, 0, 
				_background.getWidth() * Assets.SCALE_FACTOR, _background.getHeight() * Assets.SCALE_FACTOR);
		
		_game.batch.end();
	}
	
	public void renderEntities() {
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		renderPlayer();
		
		for (Entity e : _entities) {
			_game.batch.draw(e.getMapImage(), e.getPosition().x * Assets.SCALE_FACTOR, 
					e.getPosition().y * Assets.SCALE_FACTOR, 16 * Assets.SCALE_FACTOR, 16 * Assets.SCALE_FACTOR);
		}
		
		_game.batch.end();
	}
	
	public void renderPlayer() {
		_game.batch.draw(_game.player.getMapImage(), 
				_game.player.getPosition().x * Assets.SCALE_FACTOR, _game.player.getPosition().y * Assets.SCALE_FACTOR, 
				_game.player.getMapImage().getRegionWidth() * Assets.SCALE_FACTOR, 
				_game.player.getMapImage().getRegionHeight() * Assets.SCALE_FACTOR);
	}
	
	public Vector3 calculateCameraPosition() {
		Vector3 cameraPosition = worldCamera.position;
		boolean lockX = false, lockY = false;
		if (_game.player.getPosition().x * Assets.SCALE_FACTOR < 360 || 
				_game.player.getPosition().x * Assets.SCALE_FACTOR + 440 > Assets.SCALE_FACTOR * _background.getWidth())
			lockX = true;
		if (_game.player.getPosition().y * Assets.SCALE_FACTOR < 320 || 
				_game.player.getPosition().y * Assets.SCALE_FACTOR + 400 > Assets.SCALE_FACTOR * _background.getHeight())
			lockY = true;
		
		if (!lockX)
			cameraPosition.x = _game.player.getPosition().x * Assets.SCALE_FACTOR + 40;
		if (!lockY)
			cameraPosition.y = _game.player.getPosition().y * Assets.SCALE_FACTOR + 40;
		
		return cameraPosition;
	}

}
