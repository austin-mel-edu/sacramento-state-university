//Austin Melendez

package Main;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileWrite {
	// Fields
	private static ArrayList<String> writeBuffer;
	private static String filename;
	
	// Constructor
	public fileWrite(String filename){
		fileWrite.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public static void writeLine(String newLine){
		writeBuffer.add(newLine);
	}
	
	public static void pushEntries(boolean exit){
		//add new entries to the end of the file
		for(int i=0; i<writeBuffer.size(); i++) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
				writer.newLine();
				writer.write(writeBuffer.get(i));
				
				
				writer.close();
			} catch(IOException e) {
				System.out.println("You messed up somewhere");
			}
		}
		writeBuffer.clear();
		//if exiting print saved message (so it doesn't duplicate if we are just saving the file)
		if(exit) {
		System.out.println("File saved @ '" + filename + "'");
		}
	}
}
