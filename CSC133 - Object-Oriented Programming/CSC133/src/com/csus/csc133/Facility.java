//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import java.util.Random;

import com.codename1.ui.Display;

public abstract class Facility extends GameObject {
	static private Random rand = new Random();
	private GameModel gm;
	
	//Parent Constructor
	public Facility(GameModel gm) {
		super((rand.nextDouble()), rand.nextDouble());
		super.setGameModel(gm);
		super.setX(getX() * getGameModel().getWidth());
		super.setY(getY() * getGameModel().getHeight());
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = getClass().getSimpleName() + ", pos: (" + Math.round(getX()*10.0)/10.0 + "," + Math.round(getY()*10.0)/10.0 + ")";
		return gameInfo;
	}
}