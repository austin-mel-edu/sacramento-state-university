//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries
import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public abstract class Student extends GameObject implements IMoveable, ITransformable {
	
	//Default Fields
	private static final double DEFAULT_SPEED = 500.0;
	private static final double DEFAULT_TALKATIVELEVEL = 20.0;
	private static final double DEFAULT_HYDRATION = 4000.0;
	private static final double DEFAULT_WATERINTAKE = 0.0;
	private static final double DEFAULT_ABSENCETIME = 0.0;
	//Variables/Fields
	private double head;
	private double speed;
	private double talkativeLevel;
	private double timeRemain;
	private double hydration;
	private double waterIntake;
	private double sweatingRate;
	private double absenceTime;
	private GameModel gm;
	// Generate random coordinates
	static private Random rand = new Random();
	//private Transform localXform = Transform.makeIdentity();
//	private Transform myRotation, myTranslation, myScale;
	private int[] xPt, yPt;
	private int objSize = super.getSize();
	
	//Parent Constructor
	public Student(GameModel gm) {
		//Create object with random coordinates and random size 40-60
		super((rand.nextDouble()), rand.nextDouble());
		super.setGameModel(gm);
		super.setX(getX() * getGameModel().getWidth());
		super.setY(getY() * getGameModel().getHeight());
		super.setSize(rand.nextInt(40) + 40);
		this.head = 0.0;
		this.speed = DEFAULT_SPEED;
		this.talkativeLevel = DEFAULT_TALKATIVELEVEL;
		this.timeRemain = 0.0;
		this.hydration = DEFAULT_HYDRATION;
		this.waterIntake = DEFAULT_WATERINTAKE;
		this.sweatingRate = 1.0;
		this.absenceTime = DEFAULT_ABSENCETIME;
		
		xPt = new int[] {0,objSize/2,-objSize/2};
		yPt = new int[] {objSize/2,-objSize/2,-objSize/2};
		
//		int color = super.getColor();
//		myRotation = Transform.makeIdentity();
//		myTranslation = Transform.makeIdentity();
//		myScale = Transform.makeIdentity();
	}
	
	//Methods
	public void move(int tickRate, GameModel gm) {
		//currentObject.rotate(10);
		// Student loses hydration based on sweating rate
		
		//TODO: LOWER STUDENTS HYDRATION
		if(speed != 0) {
			setHydration((getHydration() - getSweatingRate()));
		}
		
		
		
		super.setColor(255,0,0);
		double radians = Math.toRadians(90.0 - getHead());
		double newX = super.getX() + (Math.cos(radians) * getSpeed() * tickRate/1000);
		double newY = super.getY() + (Math.sin(radians) * getSpeed() * tickRate/1000);

		if(getTimeRemain() > 0) {
			// Set color to pink
			super.setColor(255,182,193);
			timeRemain -= 1;
			newX = super.getX();
			newY = super.getY();
		}
		
		super.setX(newX);
		super.setY(newY);

		checkBoundary();
	}
	
	// Draw the student objects (Unfilled triangle)
		public void draw(Graphics g, int relX, int relY) {
			g.setColor(super.getColor());
						
			int objSize = super.getSize();
			
			int objX = (int) (this.getX() + relX - objSize/2);
			int objY = (int) (this.getY() + relY - objSize/2);
			
			int[] objXPoints = {objX, objX + objSize, objX + objSize/2};
			int[] objYPoints = {objY, objY, objY + objSize};
			
			if (super.isSelected()) {
				g.drawPolygon(objXPoints, objYPoints, 3);
				g.setColor(ColorUtil.rgb(255, 0, 0));
				g.drawRect(objX, objY, objSize, objSize);
			}
			else {
				g.drawPolygon(objXPoints, objYPoints, 3);
			}
		}
	
	// Check to see if player is out of bounds
	public void checkBoundary() {		
		// Right of screen
		if(super.getX() > getGameModel().getWidth()) {
			setHead(getHead() + 180);
			super.setX(getGameModel().getWidth());
		}
		// Left of screen
		else if(super.getX() < 0) {
			setHead(getHead() - 180);
			super.setX(0);
		}
		// Top of screen
		else if(super.getY() < 10) {
			setHead(getHead() + 180);
			super.setY(10);
		}
		// Bot of screen
		else if(super.getY() > getGameModel().getHeight()) {	
			setHead(getHead() - 180);
			super.setY(getGameModel().getHeight());
		}
	}
	
	// If Student object hits another Student object
	public void handleCollide(Student s) {
		// Determine maximum talkative level
			if(getTalkativeLevel() > s.getTalkativeLevel()) {
				 setTimeRemain(getTalkativeLevel());
				 s.setTimeRemain(getTalkativeLevel());
			}
			else {
				setTimeRemain(s.getTalkativeLevel());
				s.setTimeRemain(s.getTalkativeLevel());
			}
	}
	
	// Print object information to console
	public String toString() {
		String gameInfo = getClass().getSimpleName() + ", pos: (" + Math.round(getX()*10.0)/10.0 + "," + Math.round(getY()*10.0)/10.0 + 
							"), head: " + Math.round(getHead()*10.0)/10.0 + 
							", speed: " + Math.round(getSpeed()*10.0)/10.0 + 
							", hydration: " + Math.round(getHydration()*10.0)/10.0 + 
							", talkativeLevel: " + Math.round(getTalkativeLevel()*10.0)/10.0 + 
							", timeRemain: " + Math.round(getTimeRemain()*10.0)/10.0;
		return gameInfo;
	}
	
	public double getHead() {
		return this.head;
	}
	
	public void setHead(double head) {
		this.head = head;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getTalkativeLevel() {
		return this.talkativeLevel;
	}
	
	public void setTalkativeLevel(double level) {
		this.talkativeLevel = level;
	}
	
	public double getTimeRemain() {
		return this.timeRemain;
	}
	
	public void setTimeRemain(double time) {
		this.timeRemain = time;
	}
	
	public double getHydration() {
		return this.hydration;
	}
	
	public void setHydration(double hydration) {
		this.hydration = hydration;
	}
	
	public double getWaterIntake() {
		return this.waterIntake;
	}
	
	public void setWaterIntake(double intake) {
		this.waterIntake = intake;
	}
	
	public double getSweatingRate() {
		return this.sweatingRate;
	}
	
	public void setSweatingRate(double sweat) {
		this.sweatingRate = sweat;
	}
	
	public double getAbsenceTime() {
		return this.absenceTime;
	}
	
	public void setAbsenceTime(double time) {
		this.absenceTime = time;
	}
	
	public double getDEFAULTSPEED() {
		return DEFAULT_SPEED;
	}
	
	public double getDEFAULTHYDRATION() {
		return DEFAULT_HYDRATION;
	}
}	
