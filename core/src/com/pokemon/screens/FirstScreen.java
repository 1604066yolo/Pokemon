package com.pokemon.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.pokemon.PokemonMain;
import com.pokemon.entities.Player;
import com.pokemon.entities.Pokemon;
import com.pokemon.entities.Trainer;
import com.pokemon.tools.Background;
import com.pokemon.tools.PlayerInputProcessor;
import com.pokemon.tools.Position;

/**
 * @author karth
 *
 */
public class FirstScreen implements Screen {
	
	private static Color collisionColor;
	
	private final PokemonMain _game;
	private OrthographicCamera camera;
	private float elapsedTime;
	private Background route01;

	private Trainer trainer;
	
	private PlayerInputProcessor playerInputProcessor;

	
	public FirstScreen(PokemonMain _game) {
		this._game = _game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 720);
		
		route01 = new Background("route01", 8, 23, 320, 576);
		
		collisionColor = new Color(255f / 255f, 216f / 255f, 0f / 255f, 255f / 255f);
		
		playerInputProcessor = new PlayerInputProcessor(_game);
		
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(new Pokemon("Pikachu"));
		trainer = new Trainer(_game, "Chinese Lady", pokemons, 
				new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16),
				new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16),
				new Position(200, 200));
	}

	/**
	 * @param camera
	 * @param bg
	 * @return
	 */
	private Vector3 calculatePlayerCameraPosition(OrthographicCamera camera, Background bg) {
		Vector3 cameraPosition = camera.position;
		boolean lockX = false, lockY = false;
		if (_game.player.getPosition().x * 5 < 360 || _game.player.getPosition().x * 5 + 440 > 5 * bg.getWidth())
			lockX = true;
		if (_game.player.getPosition().y * 5 < 320 || _game.player.getPosition().y * 5 + 400 > 5 * bg.getHeight())
			lockY = true;
		
		if (!lockX)
			cameraPosition.x = _game.player.getPosition().x * 5 + 40;
		if (!lockY)
			cameraPosition.y = _game.player.getPosition().y * 5 + 40;
		
		return cameraPosition;
	}

	/**
	 * @return
	 */
	private boolean calculatePlayerCollision() {
		// prepare the texture for conversion into a pixmap
		if (!route01.getCollision().getTexture().getTextureData().isPrepared())
			route01.getCollision().getTexture().getTextureData().prepare();
		
		Pixmap pixmap = route01.getCollision().getTexture().getTextureData().consumePixmap();
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
			if (c.r == collisionColor.r && c.g == collisionColor.g && c.b == collisionColor.b) {
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
	
	@Override
	public void dispose() {
		
	}
	
	@Override
	public void hide() {
		
	}
	
	@Override
	public void pause() {
		
	}

	@Override
	public void render(float delta) {
		camera.update();
		_game.batch.setProjectionMatrix(camera.combined);
		camera.position.set(calculatePlayerCameraPosition(camera, route01));
		
		
		elapsedTime += delta;
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_game.player.setCanMove(!calculatePlayerCollision());
		_game.player.update(elapsedTime);
		trainer.update(elapsedTime);
		TextureRegion currentPlayerFrame = _game.player.getCurrentWalkFrame();
		
		_game.batch.begin();
		
		_game.batch.draw(route01.getImage(), 0, 0, 5 * route01.getWidth(), 5 * route01.getHeight());
		_game.batch.draw(currentPlayerFrame, _game.player.getPosition().x * 5, _game.player.getPosition().y * 5, 
				currentPlayerFrame.getRegionWidth() * 5f, currentPlayerFrame.getRegionHeight() * 5f);
		_game.batch.draw(trainer.getMapImage(), trainer.getPosition().x * 5, trainer.getPosition().y * 5, 16*5, 16*5);
		
		_game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(playerInputProcessor);
	}

}
