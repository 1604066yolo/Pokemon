package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;

public class Trainer implements Entity{
	private List<Pokemon> trainersPokemon;
	private String name;
	private TextureRegion trainerInMap;
	private TextureRegion trainerInBattle;
	private int x;
	private int y;
	
	public Trainer(String name, List<Pokemon> trainersPokemon, TextureRegion trainerInMap,
			TextureRegion trainerInBattle, int x, int y) {
		this.name= name;
		this.trainersPokemon= trainersPokemon;
		this.trainerInBattle= trainerInBattle;
		this.trainerInMap= trainerInMap;
		this.x= x;
		this.y= y;
		
	}
	
	public List<Pokemon> getTrainersPokemon() {
		return trainersPokemon;
	}
	
	public String getName() {
		return name;
	}
	
	public void update(float elapsedTime) {
		Player player = PokemonMain.getPlayer();	
		int x=2;
	}

	
	public TextureRegion getTrainerImage() {
		return trainerInMap;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public void update(float elapsedTime, boolean movable) {
		// TODO Auto-generated method stub
		
	}

	
}
