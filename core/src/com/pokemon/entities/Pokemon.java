package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.objects.Move;

public class Pokemon {
	
	private String name;
	private TextureRegion image;
	private List<Move> moves;
	
	public Pokemon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
