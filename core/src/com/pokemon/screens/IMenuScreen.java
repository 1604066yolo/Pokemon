package com.pokemon.screens;

import com.badlogic.gdx.Screen;

public interface IMenuScreen extends Screen {
	
	public interface IMenuOption {}
	
	public IMenuOption getCurrentMenuOption();
	
	public void setCurrentMenuOption(IMenuOption option);
	
	public void navigateUp();
	
	public void navigateDown();
	
	public void select();

}
