package com.pokemon.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.tools.Position;

public interface Entity {

	public void update(float elapsedTime);
	
	public TextureRegion getMapImage();
	
	public Position getPosition();
		 
}
