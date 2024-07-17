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
import com.codename1.ui.plaf.Border;

public class ViewMessage extends Container implements Observer {
	private GameModel gm;
	private Label gameMessage;
	
	public ViewMessage(GameModel gm) {
		this.gm = gm;
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		
		gameMessage = new Label();
		this.add(gameMessage);
	}
	
	@Override
	public void update(Observable observable, Object data) {
		gameMessage.setText(gm.getGameMessage());
		
		this.revalidate();
	}
	
}