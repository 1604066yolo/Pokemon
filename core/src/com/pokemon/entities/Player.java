package com.pokemon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
	
	public enum WalkState {
		LEFT,
		RIGHT,
		UP,
		DOWN,
		STILL
	}
	
	public static final float ANIMATION_FRAME_TIME = 1 / 4f;
	public static final int PLAYER_SPEED = 10;
	
	private Animation<TextureRegion> left;
	private Animation<TextureRegion> right;
	private Animation<TextureRegion> up;
	private Animation<TextureRegion> down;
	private Animation<TextureRegion> still;
	
	private int x, y;
	private WalkState walkState;
	
	public Player() {
		this.initAnimations();
		
		this.x = 100;
		this.y = 100;
		this.walkState = WalkState.STILL;
	}
	
	private void initAnimations() {
		TextureAtlas charset = new TextureAtlas(Gdx.files.internal("characters.atlas"));
		
		up = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("up"));
		up.setFrameDuration(ANIMATION_FRAME_TIME);
		
		down = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("down"));
		down.setFrameDuration(ANIMATION_FRAME_TIME);
		
		left = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("left"));
		left.setFrameDuration(ANIMATION_FRAME_TIME);
		
		right = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("right"));
		right.setFrameDuration(ANIMATION_FRAME_TIME);
		
		still = new Animation<TextureRegion>(ANIMATION_FRAME_TIME, charset.findRegions("still"));
		still.setFrameDuration(ANIMATION_FRAME_TIME);
	}
	
	public TextureRegion animateWalk(float elapsedTime) {
		TextureRegion currentFrame;
		switch (walkState) {
		case LEFT:
			currentFrame = left.getKeyFrame(elapsedTime, true);
			break;
		case RIGHT:
			currentFrame = right.getKeyFrame(elapsedTime, true);
			break;
		case UP:
			currentFrame = up.getKeyFrame(elapsedTime, true);
			break;
		case DOWN:
			currentFrame = down.getKeyFrame(elapsedTime, true);
			break;
		default:
			currentFrame = still.getKeyFrame(elapsedTime, true);
			break;
		}
		return currentFrame;
	}
	
	public void move() {
		int velx = 0, vely = 0;
		
		if (walkState == WalkState.LEFT) {
			velx -= PLAYER_SPEED;
		}
		else if (walkState == WalkState.RIGHT) {
			velx += PLAYER_SPEED;
		}
		else if (walkState == WalkState.UP) {
			vely += PLAYER_SPEED;
		}
		else if (walkState == WalkState.DOWN) {
			vely -= PLAYER_SPEED;
		}
		
		this.x += velx;
		this.y += vely;
	}
	
	public void setWalkState(WalkState walkState) {
		this.walkState = walkState;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
