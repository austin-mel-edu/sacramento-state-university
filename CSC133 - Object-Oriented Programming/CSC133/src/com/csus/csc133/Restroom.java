  //CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public class Restroom extends Facility {
	
	// Constructor
	public Restroom(GameModel gm) {
		super(gm);
		super.setSize(90);
		super.setColor(0, 255, 0);
	}
	
	// Draw the restroom objects (Filled Square)
		public void draw(Graphics g, int relX, int relY) {
			int objSize = super.getSize();
			
//			int objX = (int) (this.getX() + relX - objSize/2);
//			int objY = (int) (this.getY() + relY - objSize/2);
//			
//			g.setColor(super.getColor());
//			
//			if (super.isSelected()) {
//				g.fillRect(objX,objY,objSize,objSize);
//				g.setColor(ColorUtil.rgb(255, 0, 0));
//				g.drawRect(objX, objY, objSize, objSize);
//			}
//			else {
//				g.fillRect(objX,objY,objSize,objSize);
//			}
			
			//g.fillRect(objX,objY,objSize,objSize);
		}

	
	//Methods
	public void handleCollide(Student s) {
		s.setWaterIntake(0.0);
	}
	
//	@Override
//	public void handleCollision(GameObject otherObject) {
//		if (this instanceof Restroom && otherObject instanceof StudentPlayer) {
//			StudentPlayer player = (StudentPlayer) otherObject;
//			player.setWaterIntake(0.0);
//		}
//	}
//	
//	@Override
//	public boolean collidesWith(GameObject object) {
//		double L1 = this.getX() - this.getSize() / 2;
//		double L2 = object.getX() - object.getSize() / 2;
//		double R1 = this.getX() + this.getSize() / 2;
//		double R2 = object.getX() + object.getSize() / 2;
//		double T1 = this.getY() - this.getSize() / 2;
//		double T2 = this.getY() - this.getSize() / 2;
//		double B1 = this.getY() + this.getSize() / 2;
//		double B2 = this.getY() + this.getSize() / 2;
//		
//		if ((R1 < L2) || (R2 < L1) || (T2 > B1) || (T1 > B2)) {
//			return false;
//		}
//		return true;
//	}
	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	