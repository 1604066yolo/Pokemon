package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.pokemon.PokemonMain;
import com.pokemon.tools.Assets;

public class TitleScreen extends ScreenAdapter {

	private final PokemonMain _game;
	
	private OrthographicCamera guiCamera;
	
	public TitleScreen(PokemonMain _game) {
		this._game = _game;
		
		guiCamera = new OrthographicCamera();
		guiCamera.setToOrtho(false, 800, 720);
	}
	
	public void update() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			_game.setScreen(new GameScreen(_game));
			return;
		}
	}
	
	public void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		guiCamera.update();
		_game.batch.setProjectionMatrix(guiCamera.combined);
		
		_game.batch.disableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(Assets.titleScreen, 0, 0, 
				Assets.titleScreen.getRegionWidth() * Assets.SCALE_FACTOR, Assets.titleScreen.getRegionHeight() * Assets.SCALE_FACTOR);
		
		_game.batch.end();
	}
	
	@Override
	public void render(float delta) {
		update();
		draw();
	}
	
}
