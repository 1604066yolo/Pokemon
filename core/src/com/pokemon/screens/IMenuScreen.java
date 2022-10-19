package com.pokemon.screens;

import com.badlogic.gdx.Screen;

public interface IMenuScreen extends Screen {
	
	public void navigateUp();
	
	public void navigateDown();
	
	public void select();
	
	public Screen getLastScreen();

}
