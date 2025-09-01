// Austin Melendez

package Main;

import java.lang.Math;

//I'm not very creative I couldn't come up with a new method besides basic math
//So I just created a "scenario" of a car in a game 
interface Car{
	int speedUp(int cSpeed, int increase);
	int slowDown(int cSpeed, int decrease);
}	

//If remainder after dividing 2 numbers (modulo) are 0 then they are multiples of each other
interface Multiples{
	default String checkMultiples(int num1, int num2) {
		String output;
		if(num1 % num2 == 0) {
			output = "The numbers " + num1 +" and " + num2 + " are multiples!";
		}
		else if(num2 % num1 == 0) {
			output = "The numbers " + num1 +" and " + num2 + " are multiples!";
		}
		else {
			output = "The numbers " + num1 +" and " + num2 + " are NOT multiples!";
		}
		return output;
	}
}

interface sqRoot{
	static double findRoot(int input) {
		double output;
		output = Math.sqrt(input);
		return output;
	}
}


public class Lab03 implements Car, Multiples, sqRoot{
	public static void main(String[] args){
			Lab03 lab = new Lab03();
			print(lab.speedUp(25, 5));
			print(lab.speedUp(45, 9));
			print(lab.slowDown(45, 7));
			print(lab.slowDown(75, 3));
			print(lab.checkMultiples(9, 126));
			print(lab.checkMultiples(15, 32));
			print(lab.checkMultiples(12, 3));
			print(sqRoot.findRoot(77));
			print(sqRoot.findRoot(81));
	}

	public static <E> void print(E output) {
		System.out.println(output);
	}
	
	public int speedUp(int cSpeed, int increase) {
		return cSpeed + increase;
	}
	public int slowDown(int cSpeed, int decrease) {
		return cSpeed - decrease;
	}
}

