package com.csus.csc133;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollisionCommand extends Command {
	private GameModel gm;
	
	// Constructor
    public CollisionCommand(GameModel gm, String command) {
    	
    	// Pass string to the parent constructor for label on button
        super(command);
        
        this.gm = gm;
        
    }
    
//    // This action will be performed when the command is pushed
//    @Override
//    public void actionPerformed(ActionEvent e) {
//    	// Call appropriate method for each command
//    	switch(getCommandName()) {
//    		case "Lecture Hall": gm.collision('l'); break;
//    		case "Restroom": gm.collision('r'); break;
//    		case "Water Dispenser": gm.collision('w'); break;
//    		case "Student": gm.collision('s'); break;
//    	}
//    }
}