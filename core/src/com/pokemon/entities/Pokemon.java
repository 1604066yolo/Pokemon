package com.pokemon.entities;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pokemon.objects.Move;
import com.pokemon.tools.Assets;
import com.pokemon.tools.Position;

public class Pokemon {
	
	private String name;
	private int HP;
	private int level;
	private TextureRegion inventoryImage;
	private TextureRegion battleImage;
	private TextureRegion backBattleImage;
	private List<Move> moves;
	
	public Pokemon(String name, Position inventoryXY, Position battleXY, Position backBattleXY) {
		this.name = name;
		this.inventoryImage = new TextureRegion(Assets.pokemons, inventoryXY.x, inventoryXY.y, 16, 16);
		this.battleImage = new TextureRegion(Assets.pokemons, battleXY.x, battleXY.y, 56, 56);
		this.backBattleImage = new TextureRegion(Assets.pokemons, backBattleXY.x, backBattleXY.y, 48, 48);
	}
	
	public String getName() {
		return name;
	}
	
	public TextureRegion getInventoryImage() {
		return inventoryImage;
	}
	
	public TextureRegion getBattleImage() {
		return battleImage;
	}
	
	public TextureRegion getBackBattleImage() {
		return backBattleImage;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getLevel() {
		return level;
	}
	
}
