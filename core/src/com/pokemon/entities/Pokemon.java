package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.objects.Move;
import com.pokemon.tools.Position;

public class Pokemon {
	
	private String name;
	private int HP;
	private int level;
	private TextureRegion inventoryImage;
	private TextureRegion battleImage;
	private List<Move> moves;
	
	public Pokemon(String name, Position inventoryTextureCoordinates) {
		this.name = name;
		this.inventoryImage = new TextureRegion(new Texture(Gdx.files.internal("pokemon.png")), 
				inventoryTextureCoordinates.x, inventoryTextureCoordinates.y, 16, 16);
	}
	
	public String getName() {
		return name;
	}
	
	public TextureRegion getInventoryImage() {
		return inventoryImage;
	}
	
	public TextureRegion getBattleImage() {
		return battleImage;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getLevel() {
		return level;
	}
	
}
