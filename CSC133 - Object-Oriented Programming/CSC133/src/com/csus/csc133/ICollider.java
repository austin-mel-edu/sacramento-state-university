package com.csus.csc133;

public interface ICollider {
	boolean collidesWith(GameObject otherObject);
	
	void handleCollision(GameObject otherObject);
}