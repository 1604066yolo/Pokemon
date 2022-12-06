package com.pokemon.objects;

import com.pokemon.tools.Types;
import com.pokemon.tools.Types.Type;

public class Move {
	
	public enum Category {
		PHYSICAL,
		SPECIAL,
		STATUS;
	}
	
	public enum _Type {
		GRASS,
		POISON;
	}
	
	private String name;
	private String description;
	private Category category;
	private Type type;
	private int power;
	private int startingPP;
	private float accuracy;
	
	public Move() {
		
	}
	
	public String toString() {
		return String.format("Name: %s, \nDesc: %s \nCategory: %s \nType: %s \n", name, description, category, type);
	}

}
