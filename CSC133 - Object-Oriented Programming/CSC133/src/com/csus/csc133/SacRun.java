package com.csus.csc133;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;

public class SacRun extends Form implements Runnable {
	
	private GameModel gm = new GameModel();
	private ViewMap map;
	private ViewMessage msg;
	private ViewStatus stat;
	private UITimer timer;
	
	private Button pauseBtn = new MenuButton("Pause");
	private Button chgposBtn = new MenuButton("ChangePos");
	
	private ActionCommand moveCmd = new ActionCommand(gm, "w");
	private ActionCommand stopCmd = new ActionCommand(gm, "s");
	private ActionCommand leftCmd = new ActionCommand(gm, "a");
	private ActionCommand rightCmd = new ActionCommand(gm, "d");
	
	public SacRun(){		
		// Change layout of the screen to border layout
		setLayout(new BorderLayout());
		
		// Initiate containers
		map = new ViewMap(gm);
		msg = new ViewMessage(gm);
		stat = new ViewStatus(gm);
		// Add observers of GameModel
		gm.addObserver(map);
		gm.addObserver(msg);
		gm.addObserver(stat);
		
		// Create west container
		Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		// Create buttons
		pauseBtn.setCommand(new SystemCommand(this, "Pause"));
		chgposBtn.setCommand(new SystemCommand(gm, "ChangePos"));
		chgposBtn.setEnabled(false);
		chgposBtn.setVisible(false);
		
		// Create buttons
		Button moveBtn = new MenuButton("Move");
		moveBtn.setCommand(new ActionCommand(gm, "Move"));
		
		Button stopBtn = new MenuButton("Stop");
		stopBtn.setCommand(new ActionCommand(gm, "Stop"));
		
		Button leftBtn = new MenuButton("Left");
		leftBtn.setCommand(new ActionCommand(gm, "Left"));
		
		Button rightBtn = new MenuButton("Right");
		rightBtn.setCommand(new ActionCommand(gm, "Right"));
		
		Button stratBtn = new MenuButton("Change Strategy");
		stratBtn.setCommand(new SystemCommand(gm, "Change Strategy"));
		
		Button lectureBtn = new MenuButton("Lecture Hall");
		lectureBtn.setCommand(new CollisionCommand(gm, "Lecture Hall"));
		
		Button restroomBtn = new MenuButton("Restroom");
		restroomBtn.setCommand(new CollisionCommand(gm, "Restroom"));
		
		Button waterDisBtn = new MenuButton("Water Dispenser");
		waterDisBtn.setCommand(new CollisionCommand(gm, "Water Dispenser"));
		
		Button studentBtn = new MenuButton("Student");
		studentBtn.setCommand(new CollisionCommand(gm, "Student"));


		// Create toolbar menu and add commands
		Toolbar toolBar = new Toolbar();
		this.setToolbar(toolBar);
		toolBar.addCommandToRightBar(new SystemCommand(gm, "About"));	
		toolBar.addCommandToSideMenu(new SystemCommand(gm, "About"));
		toolBar.addCommandToSideMenu(new SystemCommand(gm, "Exit"));

		// Add buttons to west container
		westContainer.add(pauseBtn);
		westContainer.add(chgposBtn);
		westContainer.add(moveBtn);
		westContainer.add(stopBtn);
		westContainer.add(rightBtn);
		westContainer.add(leftBtn);
		westContainer.add(stratBtn);
		westContainer.add(lectureBtn);
		westContainer.add(restroomBtn);
		westContainer.add(waterDisBtn);
		westContainer.add(studentBtn);

		
		this.addKeyListener('w', moveCmd);
		this.addKeyListener('a', leftCmd);
		this.addKeyListener('d', rightCmd);
		this.addKeyListener('s', stopCmd);
		
		
		// Use BorderLayout to position containers properly on screen
		this.add(BorderLayout.CENTER, map);
		this.add(BorderLayout.EAST, stat);
		this.add(BorderLayout.SOUTH, msg);
		this.add(BorderLayout.WEST, westContainer);
		
		this.show();
		
		gm.setWidth(map.getWidth());
		gm.setHeight(map.getHeight());
		
		gm.init();
		
		this.revalidate();
		
		timer = new UITimer(this);
		timer.schedule(20, true, this);
	}
	
	
	@Override
	public void run() {
		gm.nextFrame();
	}
	
	public void gamePausePlay() {
		if (gm.getPaused() == false) {
			pauseBtn.setText("Play");
			
			gm.setPaused(true);
			gm.setMoveable(false);
			timer.cancel();
			chgposBtn.setEnabled(true);
			chgposBtn.setVisible(true);
			
			removeKeyListener('w', moveCmd);
			removeKeyListener('a', leftCmd);
			removeKeyListener('s', rightCmd);
			removeKeyListener('d', stopCmd);
		}
		else {
			pauseBtn.setText("Pause");
			
			gm.setMoveable(true);
			gm.setPaused(false);
			timer.schedule(20, true, this);
			
			chgposBtn.setEnabled(false);
			chgposBtn.setVisible(false);
			
			addKeyListener('w', moveCmd);
			addKeyListener('a', leftCmd);
			addKeyListener('s', rightCmd);
			addKeyListener('d', stopCmd);
		}
	}
	
	@Override
	public void keyPressed (int keyCode) {
		switch((char) keyCode) {
			case 'w': moveCmd.actionPerformed(null); break;
			case 's': stopCmd.actionPerformed(null); break;
			case 'a': leftCmd.actionPerformed(null); break;
			case 'd': rightCmd.actionPerformed(null); break;
		}
	}
	
	@Override
	public void keyReleased (int keyCode) {
		switch((char) keyCode) {
		case 'w': break;
		case 's': break;
		case 'a': break;
		case 'd': break;
	}
	}
}
