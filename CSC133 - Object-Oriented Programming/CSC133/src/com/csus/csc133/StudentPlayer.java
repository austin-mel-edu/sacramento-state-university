// CSC 133 - Assignment 1
// Austin Melendez

// Package
package com.csus.csc133;
// Importing Libraries

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public class StudentPlayer extends Student {
	private static StudentPlayer studentPlayer;
	
	// Constructor
	private StudentPlayer(GameModel gm) {
		super(gm);
		super.setSpeed(0.0);
		super.setSize(50);
	}
	
	// Player moves forward
	public void forward() {
		setSpeed(getDEFAULTSPEED());
	}
	
	// Player stops
	public void stop() {
		setSpeed(0.0);
	}
	
	// Player turns left
	public void left() {
		setHead(getHead() + 10);
	}
	
	// Player turns right
	public void right() {
		setHead(getHead() - 10);
	}
	
	// Draw the student objects (Filled triangle)
		public void draw(Graphics g, int x, int y) {			
			
			int objSize = super.getSize();
			
			int objX = (int) (this.getX() + x - objSize/2);
			int objY = (int) (this.getY() + y - objSize/2);
			
			g.setColor(super.getColor());
			
			// Use an array to store coordinates of each corner
			int[] objXPoints = {objX, objX + objSize, objX + objSize/2};
			int[] objYPoints = {objY, objY, objY + objSize};
			
			g.fillPolygon(objXPoints, objYPoints, 3);
		}

	
	// Check to see if the game is over
	public boolean checkGameActive() {
		double hydration = getHydration();
		double absenceTime = getAbsenceTime();
		double waterIntake = getWaterIntake();
		// Game ending conditions
		if(hydration <= 0 || absenceTime >= 1 || waterIntake >= getDEFAULTHYDRATION()) {
			return false;
		}
		return true;
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = super.toString(); 
		return gameInfo + ", absence: " + Math.round(getAbsenceTime()*10.0)/10.0 + ", waterIntake: " + Math.round(getWaterIntake()*10.0)/10.0;
	}
	
	public static StudentPlayer getPlayer(GameModel gm) {
		if (studentPlayer == null) {
			studentPlayer = new StudentPlayer(gm);
		}
		return studentPlayer;
	}
}	
