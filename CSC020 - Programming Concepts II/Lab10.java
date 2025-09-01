// Austin Melendez 

package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Lab10{
	public static void main(String[] args){
		// TEST PORTION (DO NOT MODIFY!)
		ArrayList<String> alist = new ArrayList<String>();	// Created array list
		Stack<Integer> st = new Stack<Integer>();			// Created stack
		final int n = 10;
		for(int i = 0; i < n; i++){
			alist.add(Integer.toString(i));
			st.push(i);
		}

		Iterator<String> it = alist.iterator();
		// 012345679
		while(it.hasNext()) {
			p(it.next());
		}
		pn("");
		Iterator<Integer> it2 = getStackIterator(st);
		//should be order if we popped, 9876543210
		while(it2.hasNext()) {
			p(it2.next());
		}
	}
	
	public static Iterator<Integer> getStackIterator(Stack<Integer> st){
		Iterator<Integer> it1 = st.iterator();
		int[] a = new int[st.size()];
		//NOT Following stack order, the array is 0-9 (FILO) 0123456789
		for(int i=0; i<a.length; i++) {
			a[i] = it1.next();
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		//al should be 9876543120
		while(!st.isEmpty()) {
			al.add(st.pop());
		}
		Iterator<Integer> it2 = al.iterator();
		//return LIFO order to the stack since it was deleted in the iterator.
		//push to orignial stack 0123456789 (so when popped again it is in LIFO order)
		for(int i=0; i<a.length; i++) {
			//adding in order 0123456789 to the stack so 9 would be LIFO
			st.push(a[i]);
		}
		return it2;
	}	

	/* Helper method for easy printing on same line */
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
	
	/* Helper method for easy printing with line return */
	public static <E> void pn(E item){
		System.out.println(item);
	}
}