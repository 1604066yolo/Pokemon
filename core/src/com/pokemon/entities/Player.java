package com.pokemon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.tools.Position;

public class Player implements Entity{
	
	public enum WalkState {
		LEFT,
		RIGHT,
		UP,
		DOWN,
		STILL
	}
	
	private static final float ANIMATION_FRAME_TIME = 1 / 4f;
	private static final int PLAYER_SPEED = 2;
	
	private Animation<TextureRegion> left;
	private Animation<TextureRegion> right;
	private Animation<TextureRegion> up;
	private Animation<TextureRegion> down;
	private Animation<TextureRegion> still;
	
	private Position position;
	private WalkState walkState;
	private TextureRegion currentWalkFrame;
	private boolean canMove = true;
	
	public Player() {
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
		
		position = new Position(100, 100);
		this.walkState = WalkState.STILL;
		this.currentWalkFrame = still.getKeyFrame(0, true);
	}
	
	@Override
	public void update(float elapsedTime) {
		int velx = 0, vely = 0;
		
		if (!canMove)
			return;
		
		switch (walkState) {
			case LEFT:
				currentWalkFrame = left.getKeyFrame(elapsedTime, true);
				velx -= PLAYER_SPEED;
				break;
			case RIGHT:
				currentWalkFrame = right.getKeyFrame(elapsedTime, true);
				velx += PLAYER_SPEED;
				break;
			case UP:
				currentWalkFrame = up.getKeyFrame(elapsedTime, true);
				vely += PLAYER_SPEED;
				break;
			case DOWN:
				currentWalkFrame = down.getKeyFrame(elapsedTime, true);
				vely -= PLAYER_SPEED;
				break;
			default:
				currentWalkFrame = still.getKeyFrame(elapsedTime, true);
				break;
		}
		position.x += velx;
		position.y += vely;
	}
	
	public void setWalkState(WalkState walkState) {
		this.walkState = walkState;
	}
	
	public TextureRegion getCurrentWalkFrame() {
		return currentWalkFrame;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public WalkState getWalkState() {
		return walkState;
	}
	
	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}
	
	public Position getTopLeft() {
		return new Position(position.x, position.y + 15);
	}
	
	public Position getBottomLeft() {
		return position;
	}
	
	public Position getTopRight() {
		 return new Position(position.x + 15, position.y + 15);
	}
	
	public Position getBottomRight() {
		return new Position(position.x + 15, position.y); 
	}
	
}
