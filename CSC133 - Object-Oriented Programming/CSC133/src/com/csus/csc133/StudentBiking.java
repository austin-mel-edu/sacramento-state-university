//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentBiking extends Student{
	public StudentBiking(GameModel gm){
		super(gm);
		super.setSpeed(getSpeed() * 3);
		super.setSweatingRate(getSweatingRate() * 2);
	}

	// Print object information to console
	public String toString() {
		String gameInfo = super.toString();
		return gameInfo + ", Biking";
	}
}	