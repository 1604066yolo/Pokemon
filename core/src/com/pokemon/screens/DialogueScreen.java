package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;
import com.pokemon.PokemonMain;
import com.pokemon.tools.MenuInputProcessor;

public class DialogueScreen implements IMenuScreen {
	
	private final PokemonMain _game;
	
	private OrthographicCamera camera;
	private TextureRegion dialougeBox;
	
	private MenuInputProcessor menuInputProcessor;
	
	public DialogueScreen(PokemonMain _game) {
		this._game = _game;
		
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 720);
		
		this.dialougeBox = new TextureRegion(new Texture(Gdx.files.internal("dialouge.png")), 0, 0, 151, 37);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuInputProcessor);
	}

	@Override
	public void render(float delta) {
		camera.update();
		_game.batch.setProjectionMatrix(camera.combined);
		
		_game.batch.begin();
		
		_game.batch.draw(dialougeBox, 0, 0, dialougeBox.getRegionWidth() * 5, dialougeBox.getRegionHeight() * 5);
		_game.font.draw(_game.batch, "HELLO", 20, 100);
		
		_game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public IMenuOption getCurrentMenuOption() {
		return null;
	}

	@Override
	public void setCurrentMenuOption(IMenuOption option) {
		
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
