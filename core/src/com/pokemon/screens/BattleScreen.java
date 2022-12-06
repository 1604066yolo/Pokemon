package com.pokemon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Entity;
import com.pokemon.entities.Entity.EncounterType;
import com.pokemon.entities.Pokemon;
import com.pokemon.entities.Trainer;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Util;

public class BattleScreen extends MenuScreen {
	
	public enum BattleState {
		INTRO,
		DIALOGUE,
		POKEMON_SELECT,
		FIGHT_MENU,
		MOVES_MENU
	}
	
	private DialogueScreen dialogueScreen;

	private final PokemonMain _game;
	private Trainer _initiator;
	
	private Pokemon personal, opponent;
	
	private BattleState battleState;
	
	public BattleScreen(PokemonMain _game, Entity _initiator) {
		this._game = _game;
		
		this.battleState = BattleState.INTRO;
		
		if (_initiator instanceof Trainer) {
			this._initiator = (Trainer) _initiator;
		}
	}
	
	private void updateDialogue() {
		personal = _game.player.getTeam().get(0);
		opponent = _initiator.getPokemons().get(0);
	}
	
	@Override
	public void update() {
		super.update();
		
		switch (battleState) {
			case DIALOGUE:
				updateDialogue();
				if (dialogueScreen == null) {
					dialogueScreen = new DialogueScreen(_game, _initiator.getDisplayName() + " sent out " + opponent.getName(), EncounterType.DIALOGUE);
				}
				break;
			default:
				break;
		}
	}
	
	private void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(Assets.battleScreenIntro, 0, 0, Assets.battleScreenIntro.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.battleScreenIntro.getRegionHeight() * Assets.SCALE_FACTOR);
		switch (battleState) {
			case INTRO:
				drawIntro();
				break;
			case DIALOGUE:
				drawDialogue();
				break;
			default:
				break;
		}
		
		_game.batch.end();
	}
	
	private void drawIntro() {
		_game.batch.draw(_game.player.getBattleImage(), 16 * Assets.SCALE_FACTOR, 720 - 96 * Assets.SCALE_FACTOR, 
				_game.player.getBattleImage().getRegionWidth() * Assets.SCALE_FACTOR, _game.player.getBattleImage().getRegionHeight() * Assets.SCALE_FACTOR);
		_game.batch.draw(_initiator.getBattleImage(), 96 * Assets.SCALE_FACTOR, 720 - 56 * Assets.SCALE_FACTOR,
				_initiator.getBattleImage().getRegionWidth() * Assets.SCALE_FACTOR, _initiator.getBattleImage().getRegionHeight() * Assets.SCALE_FACTOR);
		
		_game.font.draw(_game.batch, _initiator.getDisplayName(), 8 * Assets.SCALE_FACTOR, 32 * Assets.SCALE_FACTOR);
		
		int teamSize = _game.player.getTeam().size();
		for (int i = 0; i < 6; i++) {
			Util.draw(_game.batch, i < teamSize ? Assets.pokeballFilled : Assets.pokeballUnfilled, 88 + 8*i, 56);
			Util.draw(_game.batch, i < _initiator.getPokemons().size() ? Assets.pokeballFilled : Assets.pokeballUnfilled, 24 + 8*i, 120);
		}
	}
	
	private void drawDialogue() {
		Util.draw(_game.batch, personal.getBackBattleImage(), 16, 48);
		Util.draw(_game.batch, opponent.getBattleImage(), 96, 88);
	}
	
	@Override
	public void render(float delta) {
		update();
		draw();
	}
	
	@Override
	public void navigateUp() {
		
	}

	@Override
	public void navigateDown() {
		select();
	}

	@Override
	public void select() {
		switch (battleState) {
			case INTRO:
				battleState = BattleState.DIALOGUE;
				System.out.println("select(): INTRO");
				break;
			case DIALOGUE:
				battleState = BattleState.FIGHT_MENU;
				System.out.println("select(): DIALOGUE");
				// TODO incomplete
			default:
				break;
		}
	}
	

}
