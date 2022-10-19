package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pokemon.PokemonMain;
import com.pokemon.tools.Assets;

public class BattleScreen extends MenuScreen {

	private final PokemonMain _game;
	
	public BattleScreen(PokemonMain _game) {
		this._game = _game;
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(Assets.battleScreen, 0, 0, Assets.battleScreen.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.battleScreen.getRegionHeight() * Assets.SCALE_FACTOR);
		
		_game.batch.draw(Assets.playerBattle, 16 * Assets.SCALE_FACTOR, 720 - 96 * Assets.SCALE_FACTOR, 
				Assets.playerBattle.getRegionWidth() * Assets.SCALE_FACTOR, Assets.playerBattle.getRegionHeight() * Assets.SCALE_FACTOR);
		
		_game.batch.end();
	}
	
	@Override
	public void render(float delta) {
		update();
		draw();
	}
	
	@Override
	public void navigateUp() {
		
	}

	@Override
	public void navigateDown() {
		
	}

	@Override
	public void select() {
		
	}
	

}
