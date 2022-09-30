package com.pokemon.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
	
	private TextureRegion image;
	private TextureRegion collision;
	int width, height;
	
	public Background(String filename, int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.image = new TextureRegion(new Texture(Gdx.files.internal(filename + ".png")), x, y, width, height);
		this.collision = new TextureRegion(new Texture(Gdx.files.internal(filename + "collisionlayer.png")), x, y, width, height);
	}
	
	public TextureRegion getImage() {
		return image;
	}
	
	public TextureRegion getCollision() {
		return collision;
	}
	
	public int getScaledWidth() {
		return width * 5;
	}
	
	public int getScaledHeight() {
		return height * 5;
	}

}
