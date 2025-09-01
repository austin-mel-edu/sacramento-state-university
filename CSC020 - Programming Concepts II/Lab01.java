//Austin Melendez

package Main;

public class Lab01{
	
	public static void main(String[] args){
		// TESTER: DO NOT MODIFY!!!
		int[] a = {2,5,3,4,9,8,6,7,1,0};
		int[] b = {5,4,6,3,7,2,8,-1,1,9};
		Lab01 lab = new Lab01(a);			// Declare and initialize class object
		p(lab.getSize());					// Should return 10
		p(lab.getElement(0));				// Should return 2
		p(lab.getMax());					// Should return 9
		p(lab.getSum());					// Should return 45
		p(Lab01.getStaticMin(b));			// Should return -1
		// END OF TEST!!!
	}
	// HELPER METHOD FOR TEST: DO NOT MODIFY!!!
	public static <E> void p(E item){
		System.out.println(item);
	}

	private int[] list;
		
	private Lab01(int[] array) {
		this.list = array;
	}
	
	private int getSize(){
		int l = list.length;
		return l;
	}
	
	public int getElement(int i) {
 		int e = -1;
		e = list[i];
		return e;
	}
	
	private int getMax() {
		int max = -1;
		max = list[0];
		for (int i=1; i<list.length; i++) {
			if(list[i] > max) {
				max = list[i];
			}
		}
		return max;
	}
	
	private int getSum() {
		int sum = 0;
		for (int i=0; i<list.length; i++ ) {
			sum += list[i];
		}
		
		return sum;
	}
	 
	public static int getStaticMin(int[] array) {
		int min = -1;
		min = array[0];
		for (int i=1; i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}