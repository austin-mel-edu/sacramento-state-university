// Austin Melendez

package divide;

public class Divide{
	private int num1;
	private int num2;
	
	public Divide(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	//Parse both ints to Doubles in case they don't divide evenly
	public Double getResult() {
		return Double.valueOf(num1) / Double.valueOf(num2);
	}
	
	public void changeVals(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String toString() {
		return num1 + " / " + num2 + " = " + getResult();
	}
}