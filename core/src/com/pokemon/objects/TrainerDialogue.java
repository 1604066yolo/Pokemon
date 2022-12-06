package com.pokemon.objects;

public class TrainerDialogue {
	
	public String start, classification, end, after;
	
	public TrainerDialogue() {
		
	}
	
	public String toString() {
		return String.format("%s\n%s\n%s\n%s", start, classification, end, after);
	}

}
