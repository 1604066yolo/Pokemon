package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.tools.Position;

public class Trainer implements Entity{
	private List<Pokemon> trainersPokemon;
	private String name;
	private TextureRegion trainerInMap;
	private TextureRegion trainerInBattle;
	private int x;
	private int y;
	private Position p;
	
	public Trainer(String name, List<Pokemon> trainersPokemon, TextureRegion trainerInMap,
			TextureRegion trainerInBattle, int x, int y) {
		this.name= name;
		this.trainersPokemon= trainersPokemon;
		this.trainerInBattle= trainerInBattle;
		this.trainerInMap= trainerInMap;
		this.p= new Position(x, y);
		
	}
	
	public List<Pokemon> getTrainersPokemon() {
		return trainersPokemon;
	}
	
	public String getName() {
		return name;
	}
	
	public void update(float elapsedTime) {
		Player player = PokemonMain.getPlayer();
		if (p.distance(player.getPosition().x, player.getPosition().y)<16) {
			System.out.println("Reached near trainer");
		}
	}

	
	public TextureRegion getTrainerImage() {
		return trainerInMap;
	}
	
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
}
