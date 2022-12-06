package com.pokemon.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.tools.Position;

public interface Entity {
	
	public enum EncounterType {
		BATTLE,
		DIALOGUE;
	}

	public void update(float elapsedTime);
	
	public TextureRegion getMapImage();
	
	public TextureRegion getBattleImage();
	
	public Position getPosition();
	
	public String getDisplayName();
		 
}
