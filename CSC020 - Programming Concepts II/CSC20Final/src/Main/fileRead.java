//Austin Melendez

package Main;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename){
		lines = new ArrayList<>();
		try {
			File myDB = new File(filename);
			Scanner myReader = new Scanner(myDB);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				lines.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("If this prints something went wrong");
		}
	}
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		return lines.get(index);
	}
}
