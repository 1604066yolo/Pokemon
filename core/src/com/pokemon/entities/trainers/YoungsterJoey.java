package com.pokemon.entities.trainers;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.entities.Pokemon;
import com.pokemon.entities.Trainer;

public class YoungsterJoey extends Trainer{

	public YoungsterJoey(String name, List<Pokemon> trainersPokemon, TextureRegion trainerInMap,
			TextureRegion trainerInBattle, int x, int y) {
		super(name, trainersPokemon, trainerInMap, trainerInBattle, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float elapsedTime, boolean movable) {
		// TODO Auto-generated method stub
		
	}
	
}
