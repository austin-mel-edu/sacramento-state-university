//CSC 133 - Assignment 2
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.Container;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

public class ViewStatus extends Container implements Observer {
	private GameModel gm;
	private Label lectureHall;
	private Label lectureTime;
	private Label gameTime;
	private Label absences;
	private Label hydration;
	private Label waterIntake;
	private Label timeRemain;
	
	public ViewStatus(GameModel gm) {
		this.gm = gm;
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		
		
		// Create a header label for each game stat
		Label lectureHeader = new Label("Lecture Hall: ");
		lectureHall = new Label();
		
		this.add(lectureHeader);
		this.add(lectureHall);
		
		// Create a header label for each game stat
		Label lectureTimeHeader = new Label("Lecture Time: ");
		lectureTime = new Label();
		
		this.add(lectureTimeHeader);
		this.add(lectureTime);
		
		// Create a header label for each game stat
		Label gameTimeHeader = new Label("Game Time: ");
		gameTime = new Label();
		
		this.add(gameTimeHeader);
		this.add(gameTime);
		
		// Create a header label for each game stat
		Label absencesHeader = new Label("Total Absences: ");
		absences = new Label();
		
		this.add(absencesHeader);
		this.add(absences);
		
		// Create a header label for each game stat
		Label hydrationHeader = new Label("Hydration: ");
		hydration = new Label();
		
		this.add(hydrationHeader);
		this.add(hydration);
		
		// Create a header label for each game stat
		Label waterIntakeHeader = new Label("Water Intake: ");
		waterIntake = new Label();
		
		this.add(waterIntakeHeader);
		this.add(waterIntake);
		
		// Create a header label for each game stat
		Label timeRemainHeader = new Label("Time Remaining: ");
		timeRemain = new Label();
		
		this.add(timeRemainHeader);
		this.add(timeRemain);
	}
	
	@Override
	public void update(Observable observable, Object data) {
		// Set the labels to the values using get methods
		lectureHall.setText(gm.getLectureHall());
		lectureTime.setText("" + (int) gm.getLectureTime());
		gameTime.setText("" + (int) (gm.getGametime() / 50));
		absences.setText("" + gm.getAbsences());
		hydration.setText("" + gm.getHydration() / 10);
		waterIntake.setText("" + gm.getWaterIntake() / 10);
		timeRemain.setText("" + gm.getTimeRemain() / 5);
		
		this.revalidate();
	}
	
}