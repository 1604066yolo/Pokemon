package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.screens.DialogueScreen;
import com.pokemon.tools.Position;

public class Trainer implements Entity {
	
	private final PokemonMain _game;
	private TextureRegion _mapImage;
	private TextureRegion _battleImage;
	
	private List<Pokemon> pokemons;
	private String name;
	private Position position;
	
	public Trainer(PokemonMain _game, String name, List<Pokemon> pokemons, TextureRegion _mapImage,
			TextureRegion _battleImage, Position position) {
		this._game = _game;
		this.name = name;
		this.pokemons = pokemons;
		this._mapImage = _mapImage;
		this._battleImage = _battleImage;
		this.position = position;
	}
	
	public void update(float elapsedTime) {
		
	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public TextureRegion getMapImage() {
		return _mapImage;
	}
	
	public TextureRegion getBattleImage() {
		return _battleImage;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isPlayerInRange() {
		return position.distanceTo(_game.player.getPosition()) < 25;
	}
	
}
