//Austin Melendez

package Main;

public class Final {
	public static String filename = "db.txt";
	
	public static void main(String[] args) {
		// import database into project
		// create a fileWrite object so we have the array to store new entrys
		new Database(filename);
		new fileWrite(filename);
		// start w/ welcome message
		System.out.println("Welcome to the Ultimate Movie Database by Austin Melendez!");
		Program();
	}

	public static void Program() {
		boolean checkInput = false;
		// create keybaordInput object
		keyboardInput userInput = new keyboardInput();
		// request command input
		checkInput = true;
		System.out.println("Enter a command to start >");
		String userCommand = userInput.getKeyboardLine();

		do {
			// COMMAND LIST
			if (userCommand.equals("commands")) {
				System.out.println("Available commands:");
				System.out.println("new entry");
				System.out.println("search by actor");
				System.out.println("search by year");
				System.out.println("search by runtime");
				System.out.println("search by director");
				System.out.println("search by title");
				System.out.println("delete entry");
				System.out.println("save");
				System.out.println("quit" + "\n");
				// request user input again
				Program();
			}

			// NEW ENTRY
			else if (userCommand.equalsIgnoreCase("new entry")) {
				System.out.println("Enter title >");
				String newTitle = userInput.getKeyboardLine();
				if (isMinLength(newTitle) == false) {
					do {
						System.out.println("Error! Please enter a valid title (minimum of 3 characters).");
						System.out.println("Enter title >");
						newTitle = userInput.getKeyboardLine();
					} while (newTitle.length() < 3);
				}
				System.out.println("Enter year >");
				String newYear = userInput.getKeyboardLine();
				if (isNumeric(newYear) == false) {
					do {
						System.out.println("Error! Please enter a valid number.");
						System.out.println("Enter year >");
						newYear = userInput.getKeyboardLine();
					} while (isNumeric(newYear) == false);
				}
				System.out.println("Enter runtime (minutes) >");
				String newRuntime = userInput.getKeyboardLine();
				if (isNumeric(newRuntime) == false) {
					do {
						System.out.println("Error! Please enter a valid number.");
						System.out.println("Enter runtime (minutes) >");
						newRuntime = userInput.getKeyboardLine();

					} while (isNumeric(newRuntime) == false);
				}
				System.out.println("Enter actor 1 >");
				String newActor1 = userInput.getKeyboardLine();
				if(newActor1.equals("")) {
					newActor1 = "null";
				}
				System.out.println("Enter actor 2 >");
				String newActor2 = userInput.getKeyboardLine();
				if(newActor2.equals("")) {
					newActor2 = "null";
				}
				System.out.println("Enter director >");
				String newDirector = userInput.getKeyboardLine();
				if(newDirector.equals("")) {
					newDirector = "null";
				}
				// call add entry method to add new Movie object to database
				//replace the year/runtime with null if the information is left blank to prevent an error
				if(newYear.equals("") && newRuntime.equals("")){
					Database.addEntry(new Movie(newTitle, newActor1, newActor2, newDirector, null, null));
				}
				else if(newYear.equals("")) {
					Database.addEntry(new Movie(newTitle, newActor1, newActor2, newDirector, null, Integer.parseInt(newRuntime)));
				}
				else if(newRuntime.equals("")) {
					Database.addEntry(new Movie(newTitle, newActor1, newActor2, newDirector, Integer.parseInt(newYear), null));
				}
				else {
					Database.addEntry(new Movie(newTitle, newActor1, newActor2, newDirector, Integer.parseInt(newYear), Integer.parseInt(newRuntime)));
				}
				
				// stop loop
				checkInput = false;
				System.out.println("Entry successful! Database will update on SAVE or QUIT command.");
				Program();
			}

			// SEARCH BY ACTOR
			else if (userCommand.equalsIgnoreCase("search by actor")) {
				System.out.println("Enter actor to search >");
				String searchActor = userInput.getKeyboardLine();
				Database.searchByActor(searchActor);
				// stop loop
				checkInput = false;
				Program();
			}

			// SEARCH BY YEAR
			else if (userCommand.equalsIgnoreCase("search by year")) {
				System.out.println("Enter year to search >");
				String searchYear = userInput.getKeyboardLine();
				if (isNumeric(searchYear) == false) {
					do {
						System.out.println("Error! Please enter a valid number.");
						System.out.println("Enter year >");
						searchYear = userInput.getKeyboardLine();
					} while (isNumeric(searchYear) == false);
				}
				Database.searchByYear(Integer.parseInt(searchYear));
				// stop loop
				checkInput = false;
				Program();

			}

			// SEARCH BY RUNTIME
			else if (userCommand.equalsIgnoreCase("search by runtime")) {
				System.out.println("Enter runtime to search >");
				String searchTime = userInput.getKeyboardLine();
				if (isNumeric(searchTime) == false) {
					do {
						System.out.println("Error! Please enter a valid number.");
						System.out.println("Enter year >");
						searchTime = userInput.getKeyboardLine();
					} while (isNumeric(searchTime) == false);
				}
				Database.searchByRuntime(Integer.parseInt(searchTime));
				// stop loop
				checkInput = false;
				Program();
			}

			// SEARCH BY DIRECTOR
			else if (userCommand.equalsIgnoreCase("search by director")) {
				System.out.println("Enter director to search >");
				String searchDirector = userInput.getKeyboardLine();
				Database.searchByDirector(searchDirector);
				// stop loop
				checkInput = false;
				Program();
			}

			// SEARCH BY TITLE
			else if (userCommand.equalsIgnoreCase("search by title")) {
				System.out.println("Enter title to search >");
				String searchTitle = userInput.getKeyboardLine();
				if (isMinLength(searchTitle) == false) {
					do {
						System.out.println("Error! Please enter a valid title (minimum of 3 characters).");
						System.out.println("Enter title >");
						searchTitle = userInput.getKeyboardLine();
					} while (searchTitle.length() < 3);
				}
				Database.searchByTitle(searchTitle);
				// stop loop
				checkInput = false;
				Program();
			}

			// DELETE ENTRY **EXTRA CREDIT**
			else if (userCommand.equalsIgnoreCase("delete entry")) {
				System.out.println("Enter title to delete >");
				String deleteTitle = userInput.getKeyboardLine();
				Database.deleteEntry(deleteTitle);
				// stop loop
				checkInput = false;
				Program();
			}
			
			// SAVE FILE (WITHOUT QUITTING)
			else if(userCommand.equalsIgnoreCase("save")) {
				Database.saveFile();
				System.out.println("File saved @ " + "'" + filename + "'" + "\n");
				
				new Database(filename);
				// stop loop
				checkInput = false;
				Program();
			}

			// QUIT
			else if (userCommand.equalsIgnoreCase("quit")) {
				//save the file and push new entries to the end
				Database.saveFile();
				fileWrite.pushEntries(true);
				
				// stop loop
				checkInput = false;
				System.out.println("Program Ended.");
				System.exit(0);
			}
			
			// if command not found
			else {
				System.out.println("Error! Command not found.");
				System.out.println("Please try again, or look at the list of commands by typing 'commands'" + "\n");
				// request input again
				Program();
			}
		}
		while (checkInput);
	}

	public static boolean isNumeric(String strCheck) {
		if (strCheck.equals("")) {
			return true;
		}
		try {
			int check = Integer.parseInt(strCheck);
			// if parsing the string to an int throws an error, it is not a positive #.
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	// minimum length of a title is 3 characters
	public static boolean isMinLength(String strCheck) {
		if (strCheck.length() >= 3) {
			return true;
		} else
			return false;
	}
}