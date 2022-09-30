package com.pokemon.entities;

public interface Entity {

	public void update(float elapsedTime);
	
	public void update(float elapsedTime, boolean movable); 
	 
}
