package com.pokemon.tools;

import java.util.Map;

public enum Types {
	
	NORMAL(new float[]  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5f, 0, 1, 1, .5f, 1},
			new float[] {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}),
	FIRE(new float[]    {1, .5f, .5f, 2, 1, 2, 1, 1, 1, 1, 1, 2, .5f, 1, .5f, 1, 2, 1},
			new float[] {1, .5f, 2, .5f, 1, .5f, 1, 1, 2, 1, 1, .5f, 2, 1, 1, 1, .5f, .5f}),
	WATER,
	GRASS,
	ELECTRIC,
	ICE,
	FIGHTING,
	POISON,
	GROUND,
	FLYING,
	PSYCHIC,
	BUG,
	ROCK,
	GHOST,
	DRAGON,
	DARK,
	STEEL,
	FAIRY;
	
	private Map<Types, Float> attackValues;
	private Map<Types, Float> defenseValues;
	
	Types(float[] attack, float[] defense) {
		for (int i = 0; i < Types.values().length; i++) {
			attackValues.put(Types.values()[i], attack[i]);
			defenseValues.put(Types.values()[i], defense[i]);
		}
	}
	
	Types() {
		
	}

}
