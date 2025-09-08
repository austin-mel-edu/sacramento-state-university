// Austin Melendez

package Main;

import add.Add;
import subtract.Subtract;
import multiply.Multiply;
import divide.Divide;
import modulo.Modulo;

public class Lab04{
	public static void main(String[] args){
		Add test1 = new Add(3,5);
		print(test1.toString());
		test1.changeVals(8,3);
		print(test1.toString());
		print("");
		
		Subtract test2 = new Subtract(9,7);
		print(test2.toString());
		test2.changeVals(19,6);
		print(test2.toString());
		print("");
		
		Multiply test3 = new Multiply(3,4);
		print(test3.toString());
		test3.changeVals(7,11);
		print(test3.toString());
		print("");
		
		Divide test4 = new Divide(81,9);
		print(test4.toString());
		test4.changeVals(21,4);
		print(test4.toString());
		print("");
		
		Modulo test5 = new Modulo(21,3);
		print(test5.toString());
		test5.changeVals(23,17);
		print(test5.toString());
		print("");
	}
	
	public static <E> void print(E output) {
		System.out.println(output);
	}
}