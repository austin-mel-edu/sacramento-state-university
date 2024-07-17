//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries
import java.util.Random;


public class StudentConfused extends Student{
	//Variables/Fields
	Random rand = new Random();
	private double random;
	private double random50;
	
	// Constructor
	public StudentConfused(GameModel gm) {
		super(gm);
	}
	
	// Override move method
	@Override
	public void move(int tickRate, GameModel gm) {
		random = rand.nextInt(20);
		random50 = rand.nextInt(100);
		if(random50 >= 50) {
			setHead(getHead() + random);
		}
		else {
			setHead(getHead() - random);
		}
		super.move(tickRate, super.getGameModel());
	}
	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	