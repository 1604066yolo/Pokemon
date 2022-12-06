package com.pokemon.tools;

import java.util.HashMap;
import java.util.Map;

import com.pokemon.objects.Move;

public class Types {
	
	public enum Type {
		NORMAL(new float[]  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5f, 0, 1, 1, .5f, 1},
				new float[] {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}),
		FIRE(new float[]    {1, .5f, .5f, 2, 1, 2, 1, 1, 1, 1, 1, 2, .5f, 1, .5f, 1, 2, 1},
				new float[] {1, .5f, 2, .5f, 1, .5f, 1, 1, 2, 1, 1, .5f, 2, 1, 1, 1, .5f, .5f}),
		WATER (new float[] {1, 2, .5f, 1, .5f, 1, 1, 1, 2, 1, 1, 1, 2, 1, .5f, 1, 1, 1}, 
				new float[] {1, .5f, .5f, 2, 2, .5f, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5f, 1}),
		ELECTRIC (new float[] {1, 1, 2, .5f, .5f, 1, 1, 1, 0, 2, 1, 1, 1, 1, .5f, 1, 1, 1}, 
					new float[] {1, 1, 1, .5f, 1, 1, 1, 1, 2, .5f, 1, 1, 1, 1, 1, 1, .5f, 1}),
		GRASS (new float[] {1, .5f, 2, 1, .5f, 1, 1, .5f, 2, .5f, 1, .5f, 2, 1, .5f, 1, .5f, 1},
				new float[] {1, 2, .5f, .5f, .5f, 2, 1, 2, .5f, 2, 1, 2, 1, 1, 1, 1, 1, 1}),
	 	ICE (new float[] {1, .5f, .5f, 1, 2, .5f, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, .5f, 1},
	 			new float[] {1, 2, 1, 1, 1, .5f, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1}),
		FIGHTING (new float[] {2, 1, 1, 1, 1, 2, 1, .5f, 1, .5f, .5f, .5f, 2, 0, 1, 2, 2, .5f},
				new float[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, .5f, .5f, 1, 1, .5f, 1, 2}), 
		POISON (new float[] {1, 1, 1, 1, 2, 1, 1, .5f, .5f, 1, 1, 1, .5f, .5f, 1, 1, 0, 2},
				new float[] {1, 1, 1, 1, .5f, 1, .5f, .5f, 2, 1, 2, .5f, 1, 1, 1, 1, 1, .5f}),
		GROUND (new float[] {1, 2, 1, 2, .5f, 1, 1, 2, 1, 0, 1, .5f, 2, 1, 1, 1, 2, 1},
				new float[] {1, 1, 2, 0, 2, 2, 1, .5f, 1, 1, 1, 1, .5f, 1, 1, 1, 1, 1}),
		FLYING (new float[] {1, 1, 1, .5f, 2, 1, 2, 1, 1, 1, 1, 2, .5f, 1, 1, 1, .5f, 1},
				new float[] {1, 1, 1, 2, .5f, 2, .5f, 1, 0, 1, 1, .5f, 2, 1, 1, 1, 1, 1}),
		PSYCHIC (new float[] {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, .5f, 1, 1, 1, 1, 0, .5f, 1}, 
				new float[] {1, 1, 1, 1, 1, 1, .5f, 1, 1, 1, .5f, 2, 1, 2, 1, 2, 1, 1}),
		BUG (new float[] {1, .5f, 1, 1, 2, 1, .5f, .5f, 1, .5f, 2, 1, 1, .5f, 1, 2, .5f, .5f},
				new float[] {1, 2, 1, 1, .5f, 1, .5f, 1, .5f, 2, 1, 1, 2, 1, 1, 1, 1, 1}),
		ROCK (new float[] {1, 2, 1, 1, 1, 2, .5f, 1, .5f, 2, 1, 2, 1, 1, 1, 1, .5f, 1},
				new float[] {.5f, .5f, 2, 1, 2, 1, 2, .5f, 2, .5f, 1, 1, 1, 1, 1, 1, 2, 1}),
		GHOST (new float[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, .5f, 1, 1},
				new float[] {0, 1, 1, 1, 1, 1, 0, .5f, 1, 1, 1, .5f, 1, 2, 1, 2, 1, 1}),
		DRAGON (new float[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, .5f, 0},
				new float[] {1, .5f, .5f, .5f, .5f, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2}),
		DARK (new float[] {1, 1, 1, 1, 1, 1, .5f, 1, 1, 1, 2, 1, 1, 2, 1, .5f, 1, .5f},
				new float[] {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 2, 1, .5f, 1, .5f, 1, 2}), 
		STEEL (new float[] {1, .5f, .5f, .5f, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, .5f, 2},
				new float[] {.5f, 2, 1, 1, .5f, .5f, 2, 0, 2, .5f, .5f, .5f, .5f, 1, .5f, 1, .5f, .5f}),
		FAIRY (new float[] {1, .5f, 1, 1, 1, 1, 2, .5f, 1, 1, 1, 1, 1, 1, 2, 2, .5f, 1},
				new float[] {1, 1, 1, 1, 1, 1, .5f, 2, 1, 1, 1, .5f, 1, 1, 0, .5f, 2, 1});
		
		private Type(float[] attack, float[] defense) {
			this.attack = attack;
			this.defense = defense;
		}
		
		public float[] attack;
		public float[] defense;
	}
	
	private static Map<Type, Float> attackValues = new HashMap<>();
	private static Map<Type, Float> defenseValues = new HashMap<>();
	
	public static void initializeTypes() {
		for (Type type : Type.values()) {
			for (int i = 0; i < 18; i++) {
				attackValues.put(type, type.attack[i]);
				defenseValues.put(type, type.defense[i]);
			}
		}
	}
	
	public static Type getSimilar(Move._Type type) {
		return Type.values()[type.ordinal()];
	}

}
