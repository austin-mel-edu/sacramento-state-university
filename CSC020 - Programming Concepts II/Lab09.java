// Austin Melendez

package Main;

public class Lab09{
	public static void main(String[] args){
		// My tests (DO NOT MODIFY!)
		int[] a = {3,2,6,4,15,7,9,8,6};
		p(recurseSum(a));				// Sum should be 60
		p(recurseMax(a));				// Max should be 15
		// End of tests!
	}
	
	// Recursive methods below here...
	public static int recurseSum(int[] a){
		return sumHelper(a, a.length);
	}
	
	public static int recurseMax(int[] a){
		return maxHelper(a, a.length);
	}
	
	//
	private static int sumHelper(int[] a, int max) {
		//backwards through the array, if max == 0 (whole array is done)
		if(max <= 0) {
			return 0;
		}
		//call function but reduce max by 1 to loop through
		//add the value at the current index to the stack
		//return sum
		return sumHelper(a, max-1) + a[max-1];
	}
	
	private static int maxHelper(int[] a, int max) {
		//loop through entire array
		if(max <= 0) {
			return 0;
		}
		//call function w/ max reduced by 1
		//find max of current index and next iteration of the function so it loops
		//return max found
		return Math.max(a[max-1], maxHelper(a, max-1));
	}
	
	// End recursive methods
	
	/* Method to make printing text easy */
	public static <E> void p(E item){
		System.out.println(item);
	}
}