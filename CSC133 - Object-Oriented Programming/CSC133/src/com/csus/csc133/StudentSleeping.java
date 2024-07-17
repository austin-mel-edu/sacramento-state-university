//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentSleeping extends Student{
	public StudentSleeping(GameModel gm) {
		super(gm);
		super.setSweatingRate(0.0);
	}
	
	// Override the move method
	@Override
	public void move(int tickRate, GameModel gm) {
		
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = super.toString();
		return gameInfo + ", zzzZZZ!";
	}
}	