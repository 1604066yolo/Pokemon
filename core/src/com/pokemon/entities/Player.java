package com.pokemon.entities;

import java.util.ArrayList;
import java.util.List;

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
	private static final int PLAYER_SPEED = 1;
	
	private Animation<TextureRegion> left;
	private Animation<TextureRegion> right;
	private Animation<TextureRegion> up;
	private Animation<TextureRegion> down;
	private Animation<TextureRegion> still;
	
	private List<Position> leftSide;
	private List<Position> rightSide;
	private List<Position> topSide;
	private List<Position> bottomSide;
	
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
		
		this.leftSide = new ArrayList<Position>(16);
		this.rightSide = new ArrayList<Position>(16);
		this.topSide = new ArrayList<Position>(16);
		this.bottomSide = new ArrayList<Position>(16);
		for(int i = 0; i < 16; i++) {
			leftSide.add(new Position(position.x, position.y));
			rightSide.add(new Position(position.x, position.y));
			topSide.add(new Position(position.x, position.y));
			bottomSide.add(new Position(position.x, position.y));
		}
	}
	
	@Override
	public void update(float elapsedTime) {
		int velx = 0, vely = 0;
		
		if (!canMove)
			walkState = WalkState.STILL;
		
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
		
		for(int i = 0; i < 16; i++) {
			leftSide.get(i).setXY(position.x - 1, position.y + i);
			rightSide.get(i).setXY(position.x + 15 + 1, position.y + i);
			topSide.get(i).setXY(position.x + i, position.y + 15 + 1);
			bottomSide.get(i).setXY(position.x + i, position.y - 1);
		}
	}
	
	public void setWalkState(WalkState walkState) {
		this.walkState = walkState;
	}
	
	public TextureRegion getCurrentWalkFrame() {
		return currentWalkFrame;
	}
	
	public void resetPlayer() {
		currentWalkFrame = down.getKeyFrame(0);
		canMove = true;
		
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
	
	public List<Position> getLeftSide() {
		return leftSide;
	}
	
	public List<Position> getRightSide() {
		return rightSide;
	}
	
	public List<Position> getTopSide() {
		return topSide;
	}
	
	public List<Position> getBottomSide() {
		return bottomSide;
	}
	
}
