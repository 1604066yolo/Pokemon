package com.pokemon.tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Util {
	
	public static String[] splitStringByNumber(String s, int size) {
	    if(s == null || size <= 0)
	        return null;
	    int chunks = s.length() / size + ((s.length() % size > 0) ? 1 : 0);
	    String[] arr = new String[chunks];
	    for(int i = 0, j = 0, l = s.length(); i < l; i += size, j++)
	        arr[j] = s.substring(i, Math.min(l, i + size));
	    return arr;
	}
	
	
	/**
	 * @param batch
	 * @param x unscaled bottom left pixel x value
	 * @param y unscaled bottom left pixel y value
	 */
	public static void draw(SpriteBatch batch, TextureRegion t, int x, int y) {
		batch.draw(t, x * Assets.SCALE_FACTOR, y * Assets.SCALE_FACTOR,
				t.getRegionWidth() * Assets.SCALE_FACTOR, t.getRegionHeight() * Assets.SCALE_FACTOR);
	}

}
