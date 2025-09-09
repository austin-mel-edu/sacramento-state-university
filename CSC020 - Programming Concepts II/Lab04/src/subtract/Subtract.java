// Austin Melendez

package subtract;

public class Subtract{
	private int num1;
	private int num2;
	
	public Subtract(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int getResult() {
		return num1 - num2;
	}
	
	public void changeVals(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String toString() {
		return num1 + " - " + num2 + " = " + getResult();
	}
}