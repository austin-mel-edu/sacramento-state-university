package com.csus.csc133;

import java.util.Random;

public class ConfusedStrat implements IStrategy {
	Random rand = new Random();
	private double random = rand.nextInt(360);
	
	public void apply(StudentWithStrategies sws){
		sws.setHead(random);
	}
}
