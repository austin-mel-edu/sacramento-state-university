package com.csus.csc133;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.plaf.Border;

public class MenuButton extends Button {
	
	// Constructor
    public MenuButton(String command) {
    	
    	// Pass string to the parent constructor for label on button
        super(command);
        super.getAllStyles().setBgTransparency(255);
        super.getAllStyles().setBgColor(ColorUtil.BLUE);
        super.getAllStyles().setFgColor(ColorUtil.WHITE);
        super.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
    }
}