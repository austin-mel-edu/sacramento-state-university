import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.util.Scanner;

public class Recognizer {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a filename: ");
		String fileName = scanner.next();
		
		File currentFile = new File(fileName);
		
		if (currentFile.exists()) {
			Scanner fileScanner = new Scanner(currentFile);
			while (fileScanner.hasNextLine()) {
				String fileInput2 = fileScanner.nextLine();
				
				ANTLRInputStream input = new ANTLRInputStream(fileInput2);
				
				morsecodeLexer lexer = new morsecodeLexer(input);

				CommonTokenStream tokens = new CommonTokenStream(lexer);

				morsecodeParser parser = new morsecodeParser(tokens);
				
				try {					
					ParseTree tree = parser.morsecode(); // begin parsing (if error throws RecognitionException?)

					System.out.println(tree.getText());
					System.out.println(tree.toStringTree(parser));
				}
				catch (RecognitionException re) {
					System.out.println(re);
				}
			}
			fileScanner.close();
		} else {
			System.out.println("The file \"" + currentFile + "\" doesn't exist!");
			System.exit(1);
		}
		scanner.close();
	}
}