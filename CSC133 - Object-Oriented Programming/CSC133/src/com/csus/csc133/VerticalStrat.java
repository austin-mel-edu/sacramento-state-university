package com.csus.csc133;

public class VerticalStrat implements IStrategy{
	public void apply(StudentWithStrategies sws){
		// If heading is between 0-90 & 270-359 (Facing up)
		if(sws.getHead() >= 0 && sws.getHead() <= 90 && sws.getHead() >= 270 && sws.getHead() <= 359) {
			sws.setHead(0);
		}
		// Else heading is facing down
		else {
			sws.setHead(180);
		}
	}
}
