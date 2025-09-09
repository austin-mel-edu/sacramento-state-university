// Austin Melendez

package Main;

import java.util.ArrayList;

public class StackList{
	// Fields
	private ArrayList<String> a; // Declared object
	//index is the current element in the array
	public int index = -1;
	
	// Constructor
	public StackList(){
		a = new ArrayList<String>();
	}
	
	// Methods
	public void push(String item){
		a.add(item);
		index++;
	}
	
	public String pop(){
		//check bounds
			if(a.isEmpty() != true) {
				a.remove(index);
				return "REMOVED TOP ITEM, INDEX #" + index + ", ITEM NUMBER #" + (a.size()+1); 
			}
		return "EMPTY!";
	}
	
	public String peek(){
		//check bounds
		if(a.isEmpty() != true) {
			return "'" + a.get(index) + "'";
			
		}
	return "EMPTY!";
	}
	
	public boolean isEmpty(){
		if(a.size() <= 0 && index <= 0) {
			return true;
		}
		return false;
	}
	
	public int size(){
		if(a.isEmpty() != true) {
			return a.size();
		}
	return 0;
	}
	
	public void clear(){
		a.clear();
		index = -1;
	}
}