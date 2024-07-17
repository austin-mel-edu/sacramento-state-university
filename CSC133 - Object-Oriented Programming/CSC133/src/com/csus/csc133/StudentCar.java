//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentCar extends Student{
	public StudentCar(GameModel gm) {
		super(gm);
		super.setSpeed(getSpeed() * 5);
		super.setSweatingRate(0.0);
	}
	
	// Override move method
	@Override
	public void move(int tickRate, GameModel gm) {
		// If heading is between 0 & 179 (Facing right)
		if(getHead() >= 0 && getHead() <= 179) {
			setHead(90);
		}
		// Else heading is facing left
		else {
			setHead(270);
		}
		super.move(tickRate, super.getGameModel());
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = super.toString();
		return gameInfo + ", Driving";
	}
}	