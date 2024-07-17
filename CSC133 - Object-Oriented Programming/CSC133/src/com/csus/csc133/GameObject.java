// CSC 133 - Assignment 1
// Austin Melendez

// Package
package com.csus.csc133;

import java.util.Vector;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.AffineTransform;

public abstract class GameObject implements ICollider, ISelectable {
	private static final int DEFAULT_COLOR = ColorUtil.rgb(255, 0, 0);
	// Location of GameObject in world
	private double x;
	private double y;
	private Transform translate;
	private Transform rotate;
	private int color;
	private int size;
	private boolean selected;
	private GameModel gm;
	private Vector<GameObject> collisionList;
	protected Transform myRotation, myTranslation, myScale;
	
	// Constructor
	public GameObject(double x, double y) {
		// Set object variables
		this.x = x;
		this.y = y;
		this.color = DEFAULT_COLOR;
		this.gm = gm;
		collisionList = new Vector<GameObject>();

		myRotation = Transform.makeIdentity();
		myTranslation = Transform.makeIdentity();
		myScale = Transform.makeIdentity();
	}
	
	public void draw(Graphics g, int relX, int relY) {
		Transform xForm = Transform.makeIdentity();
		xForm.concatenate(myTranslation);
		xForm.concatenate(myRotation);
		xForm.concatenate(myScale);
	}
	
	public void rotate (float degrees) {
		myRotation.rotate((float)Math.toRadians(degrees), 0, 0);
	}
	
	public void translate (float d, float e) {
		myTranslation.translate(d, e);
	}
	
	public void scale (float sx, float sy) {
		myScale.scale(sx, sy);
	}
	
	public void resetTransform() {
		myRotation.setIdentity();
		myTranslation.setIdentity();
		myScale.setIdentity();
	}
	
	// Methods
	public abstract void handleCollide(Student s);
	
	@Override
	public boolean collidesWith(GameObject object) {
		double L1 = getX() - getSize() / 2;
		double L2 = object.getX() - object.getSize() / 2;
		double R1 = getX() + getSize() / 2;
		double R2 = object.getX() + object.getSize() / 2;
		double T1 = getY() - getSize() / 2;
		double T2 = object.getY() - object.getSize() / 2;
		double B1 = getY() + getSize() / 2;
		double B2 = object.getY() + object.getSize() / 2;
		
		if ((R1 < L2) || (R2 < L1) || (T2 > B1) || (T1 > B2)) {
			return false;
		}
		return true;
	}
	
	@Override
	public void handleCollision(GameObject otherObject) {
		if (!(collisionList.contains(otherObject))) {
			if (this instanceof Student && otherObject instanceof Student) {
				Student s = (Student) otherObject;
				this.handleCollide(s);
				gm.setGameMessage(this.getClass().getSimpleName()+ " collided with " + otherObject.getClass().getSimpleName());
			}
			else if (this instanceof StudentPlayer && otherObject instanceof LectureHall) {
				LectureHall lh = (LectureHall) otherObject;
				Student s = (Student) this;
				lh.handleCollide(s);
				gm.setGameMessage(this.getClass().getSimpleName()+ " collided with " + otherObject.getClass().getSimpleName());
			}
			else if (this instanceof StudentPlayer && otherObject instanceof Restroom) {
				Restroom r = (Restroom) otherObject;
				Student s = (Student) this;
				r.handleCollide(s);
				gm.setGameMessage(this.getClass().getSimpleName()+ " collided with " + otherObject.getClass().getSimpleName());
			}
			else if (this instanceof StudentPlayer && otherObject instanceof WaterDispenser) {
				WaterDispenser wd = (WaterDispenser) otherObject;
				Student s = (Student) this;
				wd.handleCollide(s);
				gm.setGameMessage(this.getClass().getSimpleName()+ " collided with " + otherObject.getClass().getSimpleName());
			}
			collisionList.add(otherObject);
		}
	}
	
	public void removeObject(GameObject otherObject) {
		if (collisionList.contains(otherObject)) {
			collisionList.remove(otherObject);
		}
	}
	
	public boolean contains(int ptrX, int ptrY, int relX, int relY) {
		int objectSize = getSize();
		
		double pointerX = ptrX;
		double pointerY = ptrY;
		double objectX = this.getX() + relX - objectSize / 2;
		double objectY = this.getY() + relY - objectSize / 2;
		
		boolean leftSide = pointerX >= objectX;
		boolean rightSide = pointerX <= objectX + objectSize;
		boolean topSide = pointerY >= objectY;
		boolean botSide = pointerY <= objectY + objectSize;
		
		if (leftSide && rightSide && topSide && botSide) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public boolean isSelected() {
		return selected;
	}
	
	@Override
	public void setSelected(boolean y) {
		selected = y;
	}
	
	public double getX() {
		return this.x;
		//return translation.getTranslateX();
	}
	public double getY() {
		return this.y;
		//return translation.getTranslateY();
	}
	public void setLocation(double x, double y) {
		//translation.setToIdentity();
		//translation.translate(x,y);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
	}
	public int getColor() {
		return this.color;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return this.size;
	}
	public void setGameModel(GameModel gm) {
		this.gm = gm;
	}
	public GameModel getGameModel() {
		return this.gm;
	}
	
	public Vector<GameObject> getCollisionList(){
		return this.collisionList;
	}
}
