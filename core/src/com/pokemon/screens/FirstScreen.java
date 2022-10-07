package com.pokemon.screens;

import java.util.ArrayList;
import java.util.List;

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

public class FirstScreen implements Screen {
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float elapsedTime;
	private Player player;
	private Background route01;
	private Trainer trainer= createTrainerInMap();

	private static Color collisionColor;
	
	private static PlayerInputProcessor playerInputProcessor;

	
	public FirstScreen() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 720);
		player = PokemonMain.getPlayer();
		route01 = new Background("route01", 8, 23, 320, 576);
		
		collisionColor = new Color(255f / 255f, 216f / 255f, 0f / 255f, 255f / 255f);
		
		playerInputProcessor = new PlayerInputProcessor(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(playerInputProcessor);
	}

	@Override
	public void render(float delta) {
		batch.setProjectionMatrix(camera.combined);
		
		elapsedTime += delta;
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.setCanMove(!calculatePlayerCollision());
		player.update(elapsedTime);
		trainer.update(elapsedTime);
		TextureRegion currentPlayerFrame = player.getCurrentWalkFrame();
		
		camera.position.set(calculatePlayerCameraPosition(camera, route01));
		camera.update();
		
		batch.begin();
		
		
		batch.draw(route01.getImage(), 0, 0, 5 * route01.getWidth(), 5 * route01.getHeight());
		batch.draw(currentPlayerFrame, player.getPosition().x * 5, player.getPosition().y * 5, 
				currentPlayerFrame.getRegionWidth() * 5f, currentPlayerFrame.getRegionHeight() * 5f);
		batch.draw(trainer.getTrainerImage(), trainer.getX()*5, trainer.getY()*5, 16*5, 16*5);
		
		batch.end();
		
	}
	
	private Vector3 calculatePlayerCameraPosition(OrthographicCamera camera, Background bg) {
		Vector3 cameraPosition = camera.position;
		boolean lockX = false, lockY = false;
		if (player.getPosition().x * 5 < 360 || player.getPosition().x * 5 + 440 > 5 * bg.getWidth())
			lockX = true;
		if (player.getPosition().y * 5 < 320 || player.getPosition().y * 5 + 400 > 5 * bg.getHeight())
			lockY = true;
		
		if (!lockX)
			cameraPosition.x = player.getPosition().x * 5 + 40;
		if (!lockY)
			cameraPosition.y = player.getPosition().y * 5 + 40;
		
		return cameraPosition;
	}
	
	private boolean calculatePlayerCollision() {
		if (!route01.getCollision().getTexture().getTextureData().isPrepared())
			route01.getCollision().getTexture().getTextureData().prepare();
		Pixmap pixmap = route01.getCollision().getTexture().getTextureData().consumePixmap();
		List<Position> pixels;
		switch(player.getWalkState()) {
			case LEFT:
				pixels = player.getLeftSide();
				break;
			case RIGHT:
				pixels = player.getRightSide();
				break;
			case UP:
				pixels = player.getTopSide();
				break;
			case DOWN:
				pixels = player.getBottomSide();
				break;
			default:
				return false;
		}
		
		System.out.println("player.x " + player.getPosition().x + "   player.y " + player.getPosition().y);
		System.out.println("pixel.x " + pixels.get(0).x + "   pixel.y " + pixels.get(0).y);
		
		for (int i = 0; i < 16; i++) {
			int x = pixels.get(i).x + 8;
			int y = -pixels.get(i).y + 598;
			Color c = new Color(pixmap.getPixel(x, y));
			if (c.r == collisionColor.r && c.g == collisionColor.g && c.b == collisionColor.b) {
				System.out.println(i);
				System.out.println("pixel.x " + pixels.get(i).x + "   pixel.y " + pixels.get(i).y);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public Trainer createTrainerInMap() {
		List <Pokemon> pokemons= new ArrayList<Pokemon>();
		pokemons.add(new Pokemon("Pikachu"));
		Trainer t= new Trainer("Chinese Lady", pokemons, 
				new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16),
				new TextureRegion(new Texture(Gdx.files.internal("characters.png")), 9, 136, 16, 16),
				200,200
				);
		return t;
	}

}
