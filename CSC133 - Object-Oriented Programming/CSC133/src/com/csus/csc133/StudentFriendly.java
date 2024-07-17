//CSC 133 - Assignment 1
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries


public class StudentFriendly extends Student{
	public StudentFriendly(GameModel gm) {
		super(gm);
		super.setTalkativeLevel(getTalkativeLevel() / 2);
	}
	
	// Print object information to console
	public String toString() {
		return super.toString();
	}
}	