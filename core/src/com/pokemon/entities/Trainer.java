package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.screens.DialogueScreen;
import com.pokemon.tools.Position;

public class Trainer implements Entity {
	
	private final PokemonMain _game;
	
	private List<Pokemon> pokemons;
	private String name;
	private TextureRegion mapImage;
	private TextureRegion battleImage;
	private Position position;
	
	public Trainer(PokemonMain _game, String name, List<Pokemon> pokemons, TextureRegion mapImage,
			TextureRegion battleImage, Position position) {
		this._game = _game;
		this.name = name;
		this.pokemons = pokemons;
		this.mapImage = mapImage;
		this.battleImage = battleImage;
		this.position = position;
	}
	
	public void update(float elapsedTime) {
		if (position.distanceTo(_game.player.getPosition()) < 25) {
			_game.player.setWalkState(Player.WalkState.STILL);
			_game.setScreen(new DialogueScreen(_game));
		}
	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public String getName() {
		return name;
	}

	public TextureRegion getMapImage() {
		return mapImage;
	}
	
	public TextureRegion getBattleImage() {
		return battleImage;
	}
	
	public Position getPosition() {
		return position;
	}
	
}
