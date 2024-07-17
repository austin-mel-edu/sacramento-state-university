package com.csus.csc133;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SystemCommand extends Command {
	private GameModel gm;
	private SacRun sc;
	
	// Constructor
    public SystemCommand(GameModel gm, String command) {
    	
    	// Pass string to the parent constructor for label on button
        super(command);
        
        this.gm = gm;
        
    }
    
    public SystemCommand(SacRun sc, String command) {
    	
    	// Pass string to the parent constructor for label on button
        super(command);
        
        this.sc = sc;
        
    }
    
    
    // This action will be performed when the command is pushed
    @Override
    public void actionPerformed(ActionEvent e) {
    	// Call appropriate method for each command
    	switch(getCommandName()) {
    		case "About": gm.about(); break;
    		case "Change Strategy": gm.changeStrategy(); break;
    		case "Pause": sc.gamePausePlay(); break;
    		case "ChangePos": gm.changePos(); break;
    		case "Exit": gm.exit(); break;
    	}
    }
    
}