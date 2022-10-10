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
	
	public double distanceTo(Position p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2)+ Math.pow(this.y - p.y, 2));
	}
	
	@Override
	public String toString() {
		return "X: " + x + "	Y: " + y;
	}

}
