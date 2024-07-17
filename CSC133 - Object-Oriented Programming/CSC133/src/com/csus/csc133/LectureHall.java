//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public class LectureHall extends Facility{
	
	// Variables/Fields
	private String name;
	private Lecture lecture;
	
	// Constructor
	public LectureHall(GameModel gm, String name) {
		super(gm);
		super.setSize(90);
		this.name = name;
		super.setColor(0, 0, 255);
		this.lecture = null;
		
	}
	
	// Draw the lecturehall objects (Filled Square)
		public void draw(Graphics g, int relX, int relY) {
			int objSize = super.getSize();
			
			int objX = (int) (this.getX() + relX - objSize/2);
			int objY = (int) (this.getY() + relY - objSize/2);
			
			g.setColor(super.getColor());
			
			if (super.isSelected()) {
				g.fillRect(objX,objY,objSize,objSize);
				g.setColor(ColorUtil.rgb(255, 0, 0));
				g.drawRect(objX, objY, objSize, objSize);
			}
			else {
				g.fillRect(objX,objY,objSize,objSize);
			}
			
			//g.fillRect(objX,objY,objSize,objSize);
			if (this.lecture != null) {
				g.drawString(this.name, objX - 15, objY + 85);
			}
		}

	
	// Methods
	public void handleCollide(Student s) {
		// If Player end Lecture immediately
		if(s instanceof StudentPlayer) {
			setLecture(null);
		}
	}
	
//	@Override
//	public void handleCollision(GameObject otherObject) {
//		if (this instanceof LectureHall && otherObject instanceof StudentPlayer) {
//			setLecture(null);
//		}
//	}
	
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
		if(getLecture() == null) {
			String gameInfo = super.toString(); 
			return gameInfo + ", name: " + getName() + ", lecture time: null";
		}
		else {
			String gameInfo = super.toString(); 
			return gameInfo + ", name: " + getName() + ", lecture time: " + getLecture().getTime();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Lecture getLecture() {
		return this.lecture;
	}
	
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
}	