//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentNonstop extends Student{
	public StudentNonstop(GameModel gm) {
		super(gm);
	}
	
	// Override collision method so they can't collide
	@Override
	public void handleCollide(Student s) {

	}
	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	