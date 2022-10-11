package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.objects.Move;
import com.pokemon.tools.Position;

public class Pokemon {
	
	private String name;
	private TextureRegion image;
	private List<Move> moves;
	
	public Pokemon(String name, Position textureCoordinates) {
		this.name = name;
		this.image = new TextureRegion(new Texture(Gdx.files.internal("pokemon.png")), 
				textureCoordinates.x, textureCoordinates.y, 56, 56);
	}
	
	public String getName() {
		return this.name;
	}
	
}
