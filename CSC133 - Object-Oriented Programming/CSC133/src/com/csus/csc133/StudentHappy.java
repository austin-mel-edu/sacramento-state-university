//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries
import java.util.Random;

public class StudentHappy extends Student{
	// Variables/Fields
	Random rand = new Random();
	private double random = rand.nextDouble();
	
	// Constructor
	public StudentHappy(GameModel gm) {
		super(gm);
	}
	
	// Override move method
	@Override
	public void move(int tickRate, GameModel gm) {
		if(random < 0.25) {
			setSpeed(getSpeed() * 10);
			super.move(tickRate, super.getGameModel());
			setSpeed(getSpeed() / 10);
		}
		else {
			super.move(tickRate, super.getGameModel());
		}
	}
	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	