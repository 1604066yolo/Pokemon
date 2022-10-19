package com.pokemon.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector3;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Entity;
import com.pokemon.entities.Player;
import com.pokemon.entities.Pokemon;
import com.pokemon.entities.Trainer;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Background;
import com.pokemon.tools.Position;
import com.pokemon.tools.WorldRenderer;

public class GameScreen extends ScreenAdapter {
	
	public enum GameState {
		RUNNING,
		PAUSED,
		DIALOGUE;
	}
	
	public enum MainMenuOption {
		POKEDEX,
		POKEMON,
		PACK,
		POKEGEAR,
		GOLD,
		SAVE,
		OPTION,
		EXIT;
	}

	private final PokemonMain _game;
	
	private GameState gameState;
	private MainMenuOption currentOption;
	private Background currentBackground;
	private WorldRenderer worldRenderer;
	private List<Entity> entities;
	
	private float elapsedTime;
	
	public GameScreen(PokemonMain _game) {
		this._game = _game;
		
		gameState = GameState.RUNNING;
		currentOption = MainMenuOption.POKEDEX;
		currentBackground = Assets.route01;
		
				
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(Assets.pikachu);
		entities = new ArrayList<Entity>();
		entities.add(new Trainer(_game, "Chinese Lady", pokemons, Assets.chineseLady_world, Assets.chineseLady_battle, new Position(200, 200)));
		
		worldRenderer = new WorldRenderer(_game, currentBackground, entities);
	}
	
	public void update(float delta) {
		elapsedTime += delta;
		
		switch (gameState) {
			case RUNNING:
				updateRunning(delta);
				break;
			case PAUSED:
				updatePaused();
				break;
			case DIALOGUE:
				_game.setScreen(new DialogueScreen(_game));
				break;
		}
	}
	
	public void updateRunning(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
			gameState = GameState.PAUSED;
			return;
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			_game.player.setWalkState(Player.WalkState.LEFT);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			_game.player.setWalkState(Player.WalkState.RIGHT);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			_game.player.setWalkState(Player.WalkState.UP);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			_game.player.setWalkState(Player.WalkState.DOWN);
		}
		else {
			_game.player.setWalkState(Player.WalkState.STILL);
		}
		
		_game.player.setCanMove(!calculatePlayerCollision());
		_game.player.update(elapsedTime);
		
		for (Entity e : entities) {
			e.update(elapsedTime);
			
			if (e instanceof Trainer && ((Trainer) e).isPlayerInRange()) {
				gameState = GameState.DIALOGUE;
				
			}
		}
	}
	
	public void updatePaused() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			navigateUp();
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			navigateDown();
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			select();
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
			gameState = GameState.RUNNING;
		}
	}
	
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		worldRenderer.render();
		
		_game.guiCamera.update();
		_game.batch.setProjectionMatrix(_game.guiCamera.combined);
		_game.batch.enableBlending();
		
		_game.batch.begin();
		
		switch (gameState) {
			case RUNNING:
				presentRunning();
				break;
			case PAUSED:
				presentPaused();
				break;
			case DIALOGUE:
				break;
		}
		
		_game.batch.end();
	}
	
	public void presentRunning() {
		return;
	}
	
	public void presentPaused() {
		_game.batch.draw(Assets.mainMenu, 0, 0, Assets.mainMenu.getRegionWidth() * Assets.SCALE_FACTOR, Assets.mainMenu.getRegionHeight() * Assets.SCALE_FACTOR);
		_game.batch.draw(Assets.selectionIconFilled, 88 * Assets.SCALE_FACTOR, 120 * Assets.SCALE_FACTOR - currentOption.ordinal() * 80, 
				Assets.selectionIconFilled.getRegionWidth() * Assets.SCALE_FACTOR, Assets.selectionIconFilled.getRegionHeight() * Assets.SCALE_FACTOR);
	}

	@Override
	public void render(float delta) {
		update(delta);
		draw();
	}

	private boolean calculatePlayerCollision() {
		// prepare the texture for conversion into a pixmap
		if (!currentBackground.getCollision().getTexture().getTextureData().isPrepared())
			currentBackground.getCollision().getTexture().getTextureData().prepare();
		
		Pixmap pixmap = currentBackground.getCollision().getTexture().getTextureData().consumePixmap();
		List<Position> pixels;
		switch(_game.player.getWalkState()) {
			case LEFT:
				pixels = _game.player.getLeftSide();
				break;
			case RIGHT:
				pixels = _game.player.getRightSide();
				break;
			case UP:
				pixels = _game.player.getTopSide();
				break;
			case DOWN:
				pixels = _game.player.getBottomSide();
				break;
			default:
				return false;
		}
		
		for (int i = 0; i < 16; i++) {
			int x = pixels.get(i).x + 8;
			int y = -pixels.get(i).y + 598;
			Color c = new Color(pixmap.getPixel(x, y));
			if (c.r == Assets.collisionColor.r && c.g == Assets.collisionColor.g && c.b == Assets.collisionColor.b) {
				// System.out.println("Fail Index Pixels[i] -> i = " + i);
				// System.out.println("Fail Pixel Position: " + pixels.get(i));
				// System.out.println();
				return true;
			}
		}
		
		// System.out.println("Player Position: " + _game.player.getPosition());
		// System.out.println("Pixels[0] Position: " + pixels.get(0));
		// System.out.println();
		
		return false;
	}
	
	public void navigateUp() {
		currentOption = MainMenuOption.values()[(currentOption.ordinal() == 0  
				? MainMenuOption.values().length - 1 : (currentOption.ordinal() - 1))];
	}

	public void navigateDown() {
		currentOption = MainMenuOption.values()[(currentOption.ordinal() == MainMenuOption.values().length - 1  
				? 0 : (currentOption.ordinal() + 1))];
	}
	
	public void select() {
		switch(currentOption) {
			case POKEMON:
				_game.lastScreen = this;
				_game.setScreen(new PokemonSelectScreen(_game));
				break;
			default:
				System.out.println("not implemented yet");
				break;
		}
	}

}
