package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;

public abstract class MenuScreen extends ScreenAdapter {
	
	public void update() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			navigateUp();
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			navigateDown();
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			select();
		}
	}
	
	public abstract void navigateUp();
	
	public abstract void navigateDown();
	
	public abstract void select();
	
}
