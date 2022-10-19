package com.pokemon.entities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Position;

public class Player implements Entity {
	
	public enum WalkState {
		LEFT,
		RIGHT,
		UP,
		DOWN,
		STILL
	}
	
	private static final int PLAYER_SPEED = 1;
	
	private List<Position> leftSide;
	private List<Position> rightSide;
	private List<Position> topSide;
	private List<Position> bottomSide;
	
	private List<Pokemon> pokemons;
	
	private Position position;
	private WalkState walkState;
	private TextureRegion currentWalkFrame;
	private boolean canMove = true;
	
	public Player() {
		
		position = new Position(100, 100);
		this.walkState = WalkState.STILL;
		this.currentWalkFrame = Assets.playerStill.getKeyFrame(0, true);
		
		this.leftSide = new ArrayList<Position>(16);
		this.rightSide = new ArrayList<Position>(16);
		this.topSide = new ArrayList<Position>(16);
		this.bottomSide = new ArrayList<Position>(16);
		for (int i = 0; i < 16; i++) {
			leftSide.add(new Position(position.x, position.y));
			rightSide.add(new Position(position.x, position.y));
			topSide.add(new Position(position.x, position.y));
			bottomSide.add(new Position(position.x, position.y));
		}
		
		pokemons = new ArrayList<Pokemon>();
		pokemons.add(Assets.bulbasaur);
		pokemons.add(Assets.charmander);
	}
	
	@Override
	public void update(float elapsedTime) {
		int velx = 0, vely = 0;
		
		if (!canMove)
			walkState = WalkState.STILL;
		
		switch (walkState) {
			case LEFT:
				currentWalkFrame = Assets.playerLeft.getKeyFrame(elapsedTime, true);
				velx -= PLAYER_SPEED;
				break;
			case RIGHT:
				currentWalkFrame = Assets.playerRight.getKeyFrame(elapsedTime, true);
				velx += PLAYER_SPEED;
				break;
			case UP:
				currentWalkFrame = Assets.playerUp.getKeyFrame(elapsedTime, true);
				vely += PLAYER_SPEED;
				break;
			case DOWN:
				currentWalkFrame = Assets.playerDown.getKeyFrame(elapsedTime, true);
				vely -= PLAYER_SPEED;
				break;
			default:
				currentWalkFrame = Assets.playerStill.getKeyFrame(elapsedTime, true);
				break;
		}
		
		position.x += velx;
		position.y += vely;
		
		for (int i = 0; i < 16; i++) {
			leftSide.get(i).setXY(position.x - 1, position.y + i);
			rightSide.get(i).setXY(position.x + 15 + 1, position.y + i);
			topSide.get(i).setXY(position.x + i, position.y + 15 + 1);
			bottomSide.get(i).setXY(position.x + i, position.y - 1);
		}
	}
	
	public void setWalkState(WalkState walkState) {
		this.walkState = walkState;
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
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	@Override
	public TextureRegion getMapImage() {
		return currentWalkFrame;
	}
	
}
