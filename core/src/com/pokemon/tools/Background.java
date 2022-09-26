package com.pokemon.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
	
	TextureRegion image;
	int width, height;
	
	public Background(String filename, int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.image = new TextureRegion(new Texture(Gdx.files.internal(filename)), x, y, width, height);
	}
	
	public TextureRegion getImage() {
		return image;
	}
	
	public int getScaledWidth() {
		return width * 5;
	}
	
	public int getScaledHeight() {
		return height * 5;
	}

}
