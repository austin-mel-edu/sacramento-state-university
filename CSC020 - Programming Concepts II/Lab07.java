//Austin Melendez

package Main;

public class Lab07{
	public static void main(String[] args){
		// Do NOT modify this method! This portion is provided just so you can see how I will grade the assignment. 
		int[] a = {9,1,8,2,7,3,6,4,5};
		System.out.println(linearSearch(a, 0));		// This should return false
		System.out.println(linearSearch(a, 3));		// This should return true
		selectionSort(a);							// This should sort the array
		System.out.println(binarySearch(a, 0));		// This should return -1
		System.out.println(binarySearch(a, 3));		// This should return 2 (the index of value 3 once array is sorted)
		// END OF TEST DATA
	}
	
	////////////// DO ALL OF YOUR CODING BELOW THIS LINE! //////////////////////////////////
	
	public static boolean linearSearch(int[] a, int value){
		//search through array if value = current element then true
		for(int i=0; i<a.length; i++) {
			if(a[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	public static void selectionSort(int[] a){
		int index;
		int temp;
		//loop entire array
		for (int i=0; i<a.length-1; i++)  
        {  
			index = i;  
			//loop to the right of index
            for (int j = index+1; j<a.length; j++){
            	//if value is > than value @ index replace it
                if (a[j]<a[index]){  
                    index = j;  
                }  
            }
            //swap values
            temp = a[index];   
            a[index] = a[i];  
            a[i] = temp;  
        }  
    }  
	
	public static int binarySearch(int[] a, int value){
		//start, pivot, end
		int S = 0;
		int E = a.length-1;
		int P = a.length/2;
		//boolean run = true;
		
		//I tried using a boolean to run until finished but it doesn't loop through the if statements properly?? 
		//It causes an infinite loop and the boolean never gets updated to stop the loop
		//I also tried having a loop while (a[P] != value) 
		//But that loops cuts off as soon as the value is equal so it can never return
		//Is there another way I'm supposed to set up the loop besides the way I did?
		
		//if S value gets to be greater than the E value, we have checked the entire array
		while (S <= E) {
			//if value = pivot
			if(a[P] == value) {
				//run = false;
				return P;
			}
			//if value < pivot
			else if (a[P] > value) {
				//set end to current pivot-1 since current pivot != value
				//change pivot using equation given
				E=P-1;
				P = ((E-S) / 2) + S;
			}
			//if value > pivot
			else if (a[P] < value) {
				//set start to current pivot+1 since current pivot != value
				//change pivot using equation given
				S=P+1;
				P = ((E-S) / 2) + S;
			}
		}
		//value not found so return -1
		//run = false;
		return -1;
	}
}