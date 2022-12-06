package com.pokemon.screens;

import java.util.Arrays;

import com.pokemon.PokemonMain;
import com.pokemon.entities.EncounterableEntity;
import com.pokemon.entities.Entity;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Position;
import com.pokemon.tools.Util;

public class DialogueScreen extends MenuScreen {
	
	public static final Position FIRST_LINE = new Position(8 * Assets.SCALE_FACTOR, 32 * Assets.SCALE_FACTOR);
	public static final Position SECOND_LINE = new Position(8 * Assets.SCALE_FACTOR, 16 * Assets.SCALE_FACTOR);
	public static final int LINE_LENGTH = 18;
	
	private final PokemonMain _game;
	private Entity _initiator;
	
	private String[] text;
	private Entity.EncounterType encounterType;
	
	public DialogueScreen(PokemonMain _game, String text) {
		this(_game, text, null, null);
	}
	
	public DialogueScreen(PokemonMain _game, String text, Entity.EncounterType encounterType) {
		this(_game, text, encounterType, null);
	}
	
	public DialogueScreen(PokemonMain _game, String text, Entity.EncounterType encounterType, EncounterableEntity _initiator) {
		this._game = _game;
		this.encounterType = encounterType;
		this._initiator = _initiator;
		
		this.text = Util.splitStringByNumber(text, LINE_LENGTH);

	}

	@Override
	public void update() {
		super.update();
	}
	
	public void draw() {
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		_game.batch.draw(Assets.dialougeBox, 0, 0, Assets.dialougeBox.getRegionWidth() * Assets.SCALE_FACTOR, 
				Assets.dialougeBox.getRegionHeight() * Assets.SCALE_FACTOR);
		_game.font.draw(_game.batch, text[0], FIRST_LINE.x, FIRST_LINE.y);
		
		if (text.length > 1)
			_game.font.draw(_game.batch, text[1], SECOND_LINE.x, SECOND_LINE.y);
		
		
		_game.batch.end();
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
		if (text.length >= 2)
			text = Arrays.copyOfRange(text, 1, text.length);
		else
			select();
	}

	@Override
	public void select() {
		switch (encounterType) {
			case BATTLE:
				_game.setScreen(new BattleScreen(_game, _initiator));
				break;
			case DIALOGUE:
				_game.setScreen(_game.lastScreen);
				break;
		}
	}
	
}
