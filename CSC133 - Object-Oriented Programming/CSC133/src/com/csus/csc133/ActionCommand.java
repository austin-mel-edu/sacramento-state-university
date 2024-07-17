package com.csus.csc133;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ActionCommand extends Command {
	private GameModel gm;
	
	// Constructor
    public ActionCommand(GameModel gm, String command) {
    	
    	// Pass string to the parent constructor for label on button
        super(command);
        
        this.gm = gm;
    }
    
    
    // This action will be performed when the command is pushed
    @Override
    public void actionPerformed(ActionEvent e) {
    	// Call appropriate method for each command
    	switch(getCommandName()) {
    		case "w": gm.forward(); break;
    		case "s": gm.stop(); break;
    		case "a": gm.left(); break;
    		case "d": gm.right(); break;
    	}
    }
    
}