//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public class WaterDispenser extends Facility {
	
	// Constructor
	public WaterDispenser(GameModel gm) {
		super(gm);
		super.setSize(40);
		super.setColor(0, 0, 255);
	}
	
	//Methods
	public void handleCollide(Student s) {
		double diff = s.getDEFAULTHYDRATION() - s.getHydration();
		s.setWaterIntake(diff);
		s.setHydration(s.getDEFAULTHYDRATION());
	}
	
	// Draw the waterdispenser objects (Filled Circle)
		public void draw(Graphics g, int relX, int relY) {
			int objSize = super.getSize();
			
//			int objX = (int) (this.getX() + relX - objSize/2);
//			int objY = (int) (this.getY() + relY - objSize/2);
//			
//			g.setColor(super.getColor());
//			
//			if (super.isSelected()) {
//				g.fillArc(objX,objY,objSize,objSize,0,360);
//				g.setColor(ColorUtil.rgb(255, 0, 0));
//				g.drawRect(objX, objY, objSize, objSize);
//			}
//			else {
//				g.fillArc(objX,objY,objSize,objSize,0,360);
//			}
			
			//g.fillArc(objX,objY,objSize,objSize,0,360);
		}

	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	