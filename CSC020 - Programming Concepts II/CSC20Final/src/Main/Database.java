//Austin Melendez

package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Database {
	// Fields
	private static ArrayList<Movie> movies;
	
	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		String[] titles = new String[fr.getNumberOfLines()];
		String[] star1 = new String[fr.getNumberOfLines()];
		String[] star2 = new String[fr.getNumberOfLines()];
		String[] director = new String[fr.getNumberOfLines()];
		Integer[] years = new Integer[fr.getNumberOfLines()];
		Integer[] runtimes = new Integer[fr.getNumberOfLines()];
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);

			StringTokenizer st = new StringTokenizer(raw, "%");
			
			String[] tokens = new String[st.countTokens()];
			for(int j=0; j < tokens.length; j++) {
				tokens[j] = st.nextToken();
			}
			titles[i] = tokens[0];
			star1[i] = tokens[1];
			star2[i] = tokens[2];
			director[i] = tokens[3];
			try {
				years[i] = Integer.parseInt(tokens[4]);
				// if the input is null, we can't parse it, so catch the error and set it = to null manually.
			} catch (NumberFormatException e) {
				years[i] = null;
			}
			try {
				runtimes[i] = Integer.parseInt(tokens[5]);
				// same as above
			} catch (NumberFormatException e) {
				runtimes[i] = null;
			}
			movies.add(new Movie(titles[i],star1[i],star2[i],director[i],years[i],runtimes[i]));
		}
	}
	
	// Methods	
	public static void searchByTitle(String title){
		int a = 0;
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getTitle().equalsIgnoreCase(title)) {
				a++;
				System.out.println("Actors: " + movies.get(i).getActor1() + ", " + movies.get(i).getActor2());
				System.out.println("Director: " + movies.get(i).getDirector());
				System.out.println("Year: " + movies.get(i).getYear());
				System.out.println("Runtime: " + movies.get(i).getRuntime() + " minutes.");
				System.out.println("");
			}
		}
		if(a == 0) {
			System.out.println("No info found for that title." + "\n");
		}
		a = 0;
	}
	
	public static void searchByActor(String actor){
		int a = 0;
		System.out.println("Movies with the actor " + actor.toUpperCase() + ": ");
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getActor1().equalsIgnoreCase(actor) || movies.get(i).getActor2().equalsIgnoreCase(actor)) {
				a++;
				System.out.println(movies.get(i).getTitle());
			}
		}
		System.out.println("");
		if(a == 0) {
			System.out.println("No titles found for that actor." + "\n");
		}
		a = 0;
	}
	
	public static void searchByDirector(String director){
		int a = 0;
		System.out.println("Movies from the director " + director.toUpperCase() + ": ");
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getDirector().equalsIgnoreCase(director)) {
				a++;
				System.out.println(movies.get(i).getTitle());
			}
		}
		System.out.println("");
		if(a == 0) {
			System.out.println("No titles found for that director." + "\n");
		}
		a = 0;
	}
	
	public static void searchByYear(int year){
		int a = 0;
		System.out.println("Movies from the year " + year + ": ");
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getYear() == year) {
				a++;
				System.out.println(movies.get(i).getTitle());
			}
		}
		System.out.println("");
		if(a == 0) {
			System.out.println("No titles found for that year." + "\n");
		}
		a = 0;
	}
	
	public static void searchByRuntime(int runtime){
		int a = 0;
		System.out.println("Movies with a runtime of " + runtime + ": ");
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getRuntime() == runtime) {
				a++;
				System.out.println(movies.get(i).getTitle());
			}
		}
		System.out.println("");
		if(a == 0) {
			System.out.println("No titles found for that runtime." + "\n");
		}
		a = 0;
	}
	
	public static void saveFile() {
		//create temp.txt
		//copy entries in movies to temp.txt
		//delete db.txt
		//rename temp to db.txt
		//also push any new entries to new db.txt
		
		File temp = new File("temp.txt");
		try {
			temp.createNewFile();
		} catch (IOException e) {
			System.out.println("You messed up somewhere");
		}
		
		for(int j=0; j<movies.size(); j++) {
			try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(temp, true));
					writer.write(movies.get(j).getTitle() + "%" + movies.get(j).getActor1() + "%" + movies.get(j).getActor2() + "%" + movies.get(j).getDirector() + "%" + movies.get(j).getYear() + "%" + movies.get(j).getRuntime());
					//no line on last entry (NO BLANKS)
					if(j == movies.size()-1) {
						
					}
					else {
					writer.newLine();
					}
					
					writer.close();
			} catch(IOException e) {
				System.out.println("You messed up somewhere");
			}
		}
		File f1 = new File("db.txt");
		f1.delete();
		temp.renameTo(f1);
		
		//push new entries but no quitting (so save message doesnt duplicate)
		fileWrite.pushEntries(false);
	}
	
	public static void addEntry(Movie newEntry) {
		String finalFormat;
		finalFormat = newEntry.getTitle() + "%" + newEntry.getActor1() + "%" + newEntry.getActor2() + "%" + newEntry.getDirector() + "%" + newEntry.getYear() + "%" + newEntry.getRuntime();
		fileWrite.writeLine(finalFormat);
	}
	
	public static void deleteEntry(String title) {
		int a = 0;
		for(int i=0; i < movies.size(); i++) {
			if(movies.get(i).getTitle().equalsIgnoreCase(title)) {
				a++;
				movies.remove(i);
				
				System.out.println("Entry deleted! Database will update on SAVE or QUIT command." + "\n");
			}
			
		}
		if(a == 0) {
			System.out.println("No entries found with that title." + "\n");
		}
	}
}