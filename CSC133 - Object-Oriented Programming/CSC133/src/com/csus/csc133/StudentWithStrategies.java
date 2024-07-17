//CSC 133 - Assignment 2
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import java.util.Random;

public class StudentWithStrategies extends Student {
	private IStrategy currStrategy;
	private Random rand = new Random();
	
	public StudentWithStrategies(GameModel gm) {
		super(gm);
		int randStrat = rand.nextInt(3);
		switch(randStrat) {
			case 0: this.currStrategy = new ConfusedStrat(); break;
			case 1: this.currStrategy = new HorizontalStrat(); break;
			case 2: this.currStrategy = new VerticalStrat(); break;
		}
	}
	
	public void setStrategy(int type) {
		switch(type) {
			case 0: currStrategy = new ConfusedStrat(); break;
			case 1: currStrategy = new HorizontalStrat(); break;
			case 2: currStrategy = new VerticalStrat(); break;
		}
	}
	
	@Override
	// Override the move method
	public void move(int tickRate, GameModel gm) {
		currStrategy.apply(this);
		super.move(tickRate, super.getGameModel());
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = super.toString();
		return gameInfo + ", " + currStrategy.getClass().getSimpleName();
	}
}