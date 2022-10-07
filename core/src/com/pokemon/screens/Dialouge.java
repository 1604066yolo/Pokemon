package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.screens.MainMenuScreen.MainMenuOption;
import com.pokemon.tools.MenuInputProcessor;

public class Dialouge implements MenuScreen{
	private SpriteBatch batch;
	private TextureRegion dialougeBox;
	
	private static MenuInputProcessor menuInputProcessor;
	
	public Dialouge() {
		this.batch= new SpriteBatch();
		this.dialougeBox = new TextureRegion(new Texture(Gdx.files.internal("dialouge.png")), 0, 0, 151, 37);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuInputProcessor);
		
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(dialougeBox, 0, 0, dialougeBox.getRegionWidth() * 5, dialougeBox.getRegionHeight() * 5);
		
		batch.end();
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenuOption getCurrentMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentMenuOption(MenuOption option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}
	
}
