package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.PokemonMain;
import com.pokemon.objects.TrainerDialogue;
import com.pokemon.screens.DialogueScreen;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Position;

public class Trainer implements EncounterableEntity {
	
	private final PokemonMain _game;
	private TextureRegion _mapImage;
	private TextureRegion _battleImage;
	
	private List<Pokemon> pokemons;
	private TrainerDialogue dialogue;
	private Position position;
	
	public Trainer(PokemonMain _game, String classification, List<Pokemon> pokemons, TextureRegion _mapImage,
			TextureRegion _battleImage, Position position) {
		this._game = _game;
		this.pokemons = pokemons;
		this._mapImage = _mapImage;
		this._battleImage = _battleImage;
		this.position = position;
		
		dialogue = Assets.trainerDialogue.get(classification);
	}
	
	public void update(float elapsedTime) {
		
	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
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
	
	public TrainerDialogue getDialogue() {
		return dialogue;
	}

	@Override
	public EncounterType getEncounterType() {
		return EncounterType.BATTLE;
	}
	
	@Override
	public String getDisplayName() {
		return dialogue.classification;
	}
	
}
