//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentRunning extends Student{
	public StudentRunning(GameModel gm) {
		super(gm);
		super.setSweatingRate(getSweatingRate() * 2);
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = super.toString();
		return gameInfo + ", Running";
	}
}	