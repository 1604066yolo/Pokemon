package com.pokemon.screens;

import com.badlogic.gdx.Screen;

public interface MenuScreen extends Screen {
	
	public interface MenuOption {}
	
	public MenuOption getCurrentMenuOption();
	
	public void setCurrentMenuOption(MenuOption option);
	
	public void navigateUp();
	
	public void navigateDown();
	
	public void select();

}
