package com.pokemon.tools;

public class Position {
	
	public int x;
	public int y;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(int x, int y) {
		return Math.sqrt(Math.pow(this.x-x, 2)+ Math.pow(this.y-y, 2));
	}

}
