package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pokemon.PokemonMain;
import com.pokemon.tools.Assets;

public class DialogueScreen extends MenuScreen {
	
	private final PokemonMain _game;
		
	public DialogueScreen(PokemonMain _game) {
		this._game = _game;
	}

	@Override
	public void update() {
		super.update();
	}
	
	public void draw() {
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(Assets.dialougeBox, 0, 0, Assets.dialougeBox.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.dialougeBox.getRegionHeight() * Assets.SCALE_FACTOR);
		_game.font.draw(_game.batch, "Lets battle", 20, 100);
		
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
		_game.setScreen(new BattleScreen(_game));
	}

	@Override
	public void select() {
		
	}
	
}
