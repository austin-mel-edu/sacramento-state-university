//Austin Melendez

package Main;

public class StackInt{
	// Fields
	private int[] a;			// Array to hold the stack items behind the scenes
	private int top;			// This is the "top" of the stack
	private final int n = 256;	// This is going to be the fixed size of the stack
	private int index = 0;
		
	// Constructor
	public StackInt(){
		// Initialize the private fields (except the final constant "n")
		a = new int[n];
	}
	
	// Methods
	public void push(int item){
		// Add the item to the stack based on how stacks are supposed to work
		// Check to see if index is at max size, if not add to stack and increment index
		if (index < n ) {
			top = item;
			a[index] = item;
			index++;
		}
		else {
			System.out.println("Error. The stack is full!");
		}
	}
	
	public int pop(){
		// Remove and return the item at the top of the stack. If stack is empty, return -1
		int popStr;
		// If the array is empty and the index isn't 0 (since thats how we "clear" the array)
		// then turn top and remove from array, decrease index so the next push overrides that slot
		// change the top variable to a[index-1], so if we peek after a push it ignores the "cleared" item
		if(isEmpty() == false && index >= 0) {
			popStr = top;
			index--;
			top = a[index];
		}
		else {
			popStr = -1;
		}
		return popStr;
	}
	
	public int peek(){
		// Return the item at the top of the stack. If stack is empty, return -1
		// If the array is empty and the index isn't 0 (since thats how we "clear" the array), then return top
		int peekStr;
		if(isEmpty() == false && index > 0) {
			peekStr = top;
		}
		else {
			peekStr = -1;
		}
		return peekStr;
	}
	
	public boolean isEmpty(){
		// Return whether the stack is empty (true if empty) or not (false if stack is not empty)
		// Scan array for numbers other than 0 (all 0's is empty), if true and index > 0 the array is not empty
		// Otherwise the array is empty
		boolean empty = true;
		for(int i=0; i<size(); i++) {
			if(a[i] != 0 && index > 0) {
				empty = false;
				break;
			}
		}
		return empty;
	}
	
	public int size(){
		// Return how many items are currently in the stack; Return 0 if stack is empty
		// Return the index # since it increments with every push
		return index;
	}
	
	public void clear(){
		// Find a way to clear access to the stack so it appears empty to the user (Consider "Lazy Evaluation" for efficiency)
		// Reset index to 0 so when we push a new item, it overrides the first slot again
		// Reset top so if we peek the "empty" array it doesn't give an output
		index = 0;
		top = 0;
	}
	
	public String toString(){
		// Return the String with the format of [1,2,3,4] as an example. Have stack items separated by commas, enclosed inside brackets, and no comma at the end!
		// For every number we pushed, add it to a String with a ,
		// Substring the output to cut off the last character
		String output = "";
		for(int i=0; i<size(); i++) {
			output += a[i]+",";
		}
		return "[" + output.substring(0,output.length()-1) + "]"; 
	}
}