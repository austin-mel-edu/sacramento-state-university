// CSC 133 - Assignment 1
// Austin Melendez

//Package
package com.csus.csc133;
// Importing Libraries
import java.util.Vector;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.util.Observable;
import java.util.Random;

public class GameModel extends Observable {
	
	// Height of game area
	private int height;
	// Width of game area
	private int width;
	// Current game time
	private double gametime;
	// Game message
	private String gameMessage;
	private boolean paused = false;
	private boolean moveable = true;
	private boolean activeLecture = false;
	// Vector of all GameObjects created;
	//private Vector<GameObject> objects;
	private GameObjectCollection objects;
	// Random constructor
	static private Random rand = new Random();
	
	// Constructor
	public GameModel() {
		this.gameMessage = "Game Start!";
	}
	
	//Initialize the world
	public void init(){
		// Initialize object list
		//objects = new Vector<GameObject>();
		objects = new GameObjectCollection();
		
		// Create the player
		objects.add(StudentPlayer.getPlayer(this));
		
		//Create instances of every player type
		// Create 1-2 random objects
		int randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentAngry(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentBiking(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentCar(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentConfused(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentFriendly(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentHappy(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentNonstop(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentRunning(this));
		}
		
		randObjects = rand.nextInt(2) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new StudentSleeping(this));
		}
		
		// Create world objects
		randObjects = rand.nextInt(4) + 1;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new LectureHall(this, "RVR" + (i+1) + "000"));
		}
		
		// Create 2-4 random objects
		randObjects = rand.nextInt(3) + 2;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new Restroom(this));
		}
		
		randObjects = rand.nextInt(3) + 2;
		for (int i = 0; i < randObjects; i++) {
			objects.add(new WaterDispenser(this));
		}
		
		// Create 3 StudentWithStrategy objects
		for (int i = 0; i < 3; i++) {
			objects.add(new StudentWithStrategies(this));
		}
		
		
		this.setChanged();
		this.notifyObservers(this);
	}
	
	
	// Player commands
	// "w"
	public void forward() {
		this.gameMessage = "Student started moving!";
		Student player = StudentPlayer.getPlayer(this);
		
		((StudentPlayer) player).forward();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	// "s"
	public void stop() {
		this.gameMessage = "Student stopped!";
		Student player = StudentPlayer.getPlayer(this);
		
		((StudentPlayer) player).stop();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	// "a"
	public void left() {
		this.gameMessage ="Student turned left!";
		Student player = StudentPlayer.getPlayer(this);
		
		((StudentPlayer) player).left();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	// "d"
	public void right() {
		this.gameMessage = "Student turned right!";
		Student player = StudentPlayer.getPlayer(this);
		
		((StudentPlayer) player).right();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	// "m"
	public void displayStatistics() {
		System.out.println("Time: " + getGametime() + " =======================");
		
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
				
		// Check if iterator has objects
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
					
			System.out.println(currentObject);
		}
		System.out.println("=======================\n");
	}
	// "i"
	public void displayAuthor() {
		System.out.println("\n\nAustin Melendez\n\n");
	}
	// "f"
	public void nextFrame() {
		
		// Variables for player and lecture for easy access
		Student player = StudentPlayer.getPlayer(this);
		
		// Set player variable
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		int lectures = 0;
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			
			if(currentObject instanceof LectureHall) {
				Lecture lecture = ((LectureHall) currentObject).getLecture();
				if(lecture != null) {
					lectures++;
				}
			}
		}
		
		if(lectures > 0) {
			activeLecture = true;
		}
		else {
			activeLecture = false;
		}
		
		// Check if game is active
		if(((StudentPlayer) player).checkGameActive() == true){
			// Increase game time
			setGametime(getGametime() + 1);
			iterator = objects.getIterator();
			// Check if player is alive and move all objects
			while(iterator.hasNext()) {
				// Create temporary object of next object in collection
				GameObject currentObject = iterator.getNext();

				if(currentObject instanceof Student) {
					((Student) currentObject).move(20, this);
				}
				else if(!activeLecture && currentObject instanceof LectureHall) {
					if(rand.nextInt(500) == 7) {
						Lecture newLecture = new Lecture(rand.nextInt(30)+30);
						((LectureHall) currentObject).setLecture(newLecture);
						activeLecture = true;
					}
				}
				else if(activeLecture && currentObject instanceof LectureHall) {
					Lecture lecture = ((LectureHall) currentObject).getLecture();
					if(lecture != null) {
						lecture.setTime(lecture.getTime() - 1 * 0.02);
						
						if (lecture.getTime() <= 0) {
							double currAbs = player.getAbsenceTime();
							player.setAbsenceTime(currAbs + 1);
							activeLecture = false;
							((LectureHall) currentObject).setLecture(null);
						}
					}
				}
			}
		}
		// Game over!
		else {
			this.gameMessage = "Gameover! Time: " + getGametime() + "\n\n\n";
			Command cConfirm = new Command("Confirm");
			Command[] cmds = new Command[]{cConfirm};
			Container dialogBody = new Container(new BoxLayout(BoxLayout.Y_AXIS),"Dialog Body");
			Label popupLabel = new Label("Time: " + getGametime() * 0.02 + "\n\n\n");
			Command c = Dialog.show("Game Over!", dialogBody, cmds);
			if(c == cConfirm) {
				Display.getInstance().exitApplication();
			}
		}
		
		checkCollisions();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void checkCollisions() {
		// Create an iterator to keep track of the objects
		IIterator iterator1 = objects.getIterator();
		
		while(iterator1.hasNext()) {
			GameObject currentObject = iterator1.getNext();
			
			if (currentObject instanceof Student) {
				// Create an iterator to keep track of the objects
				IIterator iterator2 = objects.getIterator();
				
				while(iterator2.hasNext()) {
					GameObject tempObject = iterator2.getNext();
					
					if ((currentObject != tempObject) && (currentObject.collidesWith(tempObject))) {
						currentObject.handleCollision(tempObject);
						//this.gameMessage = currentObject.getClass().getSimpleName()+ " collided with " + tempObject.getClass().getSimpleName();
					}
					else {
						currentObject.removeObject(tempObject);
					}
				}
			}
		}
	}
	
	public void exit() {
		Boolean okBtn = Dialog.show("Confirm quit?", "Are you sure you want to quit?", "Yes", "No");
		
		if (okBtn) {
			Display.getInstance().exitApplication();
		}
	}
	
	public void changePos() {
		if(moveable == false) {
			moveable = true;
		}
		else {
			moveable = false;
		}
	}
	
	public void changeStrategy() {
		this.gameMessage = "StudentWithStrategies changed Strategies!";
		
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the Strat object
			if(currentObject instanceof StudentWithStrategies) {
				int randStrat = rand.nextInt(3);
				((StudentWithStrategies) currentObject).setStrategy(randStrat);
			}
		}
	}
	
	public void about() {
		Dialog.show("A2","Austin Melendez \n Summer 2024 Semester","Confirm",null);
	}
	
	public String getLectureHall() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof LectureHall) {
				if(((LectureHall) currentObject).getLecture() != null) {
					return ((LectureHall) currentObject).getName();
				}
			}
		}
		
		// Return the default if there is no value found
		return "No class scheduled";
	}
	
	public double getLectureTime() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof LectureHall) {
				if(((LectureHall) currentObject).getLecture() != null) {
					return ((LectureHall) currentObject).getLecture().getTime();
				}
			}
		}
		
		// Return the default if there is no value found
		return 0.0;
	}
	
	public double getAbsences() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof StudentPlayer) {
				return ((Student) currentObject).getAbsenceTime();
			}
		}
		
		// Return the default if there is no value found
		return 0.0;
	}
	
	public double getHydration() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof StudentPlayer) {
				//System.out.println(((Student) currentObject).getHydration());
				return ((Student) currentObject).getHydration();
			}
		}
		
		// Return the default if there is no value found
		return 200.0;
	}
	
	public double getWaterIntake() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof Student) {
				return ((Student) currentObject).getWaterIntake();
			}
		}
		
		// Return the default if there is no value found
		return 0.0;
	}
	
	public double getTimeRemain() {
		// Create an iterator to keep track of the objects
		IIterator iterator = objects.getIterator();
		
		// Here we check to see if the iterator that we are using has a next object
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext();
			// Here we check to see if that object is an instance of the object
			if(currentObject instanceof Student) {
				return ((Student) currentObject).getTimeRemain();
			}
		}
		
		// Return the default if there is no value found
		return 0.0;
	}
	
	public String getGameMessage() {
		return this.gameMessage;
	}
	
	public void setGameMessage(String message) {
		this.gameMessage = message;
	}
		
	public double getGametime() {
		return this.gametime;
	}

	public void setGametime(double gametime) {
		this.gametime = gametime;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean getPaused() {
		return this.paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	public boolean getMoveable() {
		return this.moveable;
	}
	
	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	
	public IIterator getIterator() {
		IIterator iterator = objects.getIterator();
		return iterator;
	}
}
