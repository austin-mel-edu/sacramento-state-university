package com.csus.csc133;

public class HorizontalStrat implements IStrategy{
	public void apply(StudentWithStrategies sws){
		// If heading is between 0 & 179 (Facing right)
		if(sws.getHead() >= 0 && sws.getHead() <= 179) {
			sws.setHead(90);
		}
		// Else heading is facing left
		else {
			sws.setHead(270);
		}
	}
}
