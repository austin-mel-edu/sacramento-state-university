//Austin Melendez 
//CSC130 SECTION 08

package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//LINKED LIST CLASSES
class Assign2 {
	static class StringList{
		Node head1 = null;
		Node tail1 = null;

		//NODE CLASS
		class Node {

			private String value;
			private Node next;

			private Node(String value) {
				this.value = value;
			}
			private Node Next() {
				return this.next;
			}
			private String Value() {
				return this.value;
			}
		}
		private void addHead(String value) {
			//Create a new node with given value
			Node new_node = new Node(value);

			if(this.isEmpty()) {
				head1 = new_node;
				tail1 = new_node;
			}
			else {
				Node temp = head1;
				//new node will become head of list
				head1 = new_node;
				//previous head added after new head
				head1.next = temp;
			}
		}
		private void addTail(String value) {
			Node new_node = new Node(value);

			//if list is empty
			if(this.isEmpty()) {
				head1 = new_node;
				tail1 = new_node;
			}
			else {
				//new node added after tail
				tail1.next = new_node;
				//new node will become new tail of list
				tail1 = new_node;
			}
		}
		private String removeHead() {
			//if list in empty (null) return 0.0
			if(this.isEmpty()) {
				return null;
			}
			else {
				Node temp = head1;
				//set next value in list to new head
				head1 = head1.next;

				//return old head value
				return temp.value;
			}
		}
		private Boolean isEmpty() {
			if(head1 == null) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	static class DoubleList{
		Node head2 = null;
		Node tail2 = null;

		//NODE CLASS
		class Node {

			private Double value;
			private Node next;

			private Node(Double value) {
				this.value = value;
			}
			private Node Next() {
				return this.next;
			}
			private Double Value() {
				return this.value;

			}
		}
		private void addHead(Double value) {
			//Create a new node with given value
			Node new_node = new Node(value);

			if(this.isEmpty()) {
				head2 = new_node;
				tail2 = new_node;
			}
			else {
				Node temp = head2;
				//new node will become head of list
				head2 = new_node;
				//previous head added after new head
				head2.next = temp;
			}
		}
		private void addTail(Double value) {
			Node new_node = new Node(value);

			//if list is empty
			if(this.isEmpty()) {
				head2 = new_node;
				tail2 = new_node;
			}
			else {
				//new node added after tail
				tail2.next = new_node;
				//new node will become new tail of list
				tail2 = new_node;
			}
		}
		private Double removeHead() {
			//if list in empty (null) return 0.0
			if(this.isEmpty()) {
				return null;
			}
			else {
				Node temp = head2;
				//set next value in list to new head
				head2 = head2.next;

				//return old head value
				return temp.value;
			}
		}
		private Boolean isEmpty() {
			if(head2 == null) {
				return true;
			}
			else {
				return false;
			}
		}
	}	

	private static class Stack{
		DoubleList stack = new DoubleList();

		void push(Double item) {
			stack.addHead(item);
		}
		Double pop() {
			return stack.removeHead();
		}
		Boolean isEmpty() {
			return stack.isEmpty();
		}
	}

	private static class Queue{
		StringList queue = new StringList();

		void enqueue(String item) {
			queue.addTail(item);
		}
		String dequeue() {
			return queue.removeHead();
		}
		Boolean isEmpty() {
			return queue.isEmpty();
		}
	}

	static double Evaluate(String text) {
		double result;

		Stack stack = new Stack();
		Queue inputQueue = new Queue();

		String[] splitStr = text.split("\\s+");
		for(int i=0; i<splitStr.length; i++) {
			inputQueue.enqueue(splitStr[i]);
		}

		while(inputQueue.isEmpty() != true) {
			String next = inputQueue.dequeue();
			//if the next character is an operator
			if(next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/") || next.equals("%") || next.equals("^")){
				//pop last 2 numbers off of the stack
				double num1 = stack.pop();
				double num2 = stack.pop();
				//carry out operation on two numbers and push result back to stack
				if(next.equals("+")) {
					double tempresult = num2 + num1;
					stack.push(tempresult);
				}
				else if(next.equals("-")) {
					double tempresult = num2 - num1;
					stack.push(tempresult);
				}
				else if(next.equals("*")) {
					double tempresult = num2 * num1;
					stack.push(tempresult);
				}
				else if(next.equals("/")) {
					double tempresult = num2 / num1;
					stack.push(tempresult);
				}
				else if(next.equals("%")) {
					double tempresult = num2 % num1;
					stack.push(tempresult);
				}
				else if(next.equals("^")) {
					double tempresult = Math.pow(num2, num1);
					stack.push(tempresult);
				}
			}
			//if the next character is a number, push to stack
			else {
				stack.push(Double.valueOf(next));
			}
		}
		result = stack.pop();
		return result;
	}

	public class Tester{
		public static void main(String [] args) {
			
			//Mapped to my local directory, file is named testing.txt
			String path = "../CSC130Labs/src/Main/testing.txt";
			
			try {
				File myFile = new File(path);
				Scanner myReader = new Scanner(myFile);
				while(myReader.hasNextLine()) {
					String data = myReader.nextLine();
					//End of expressions in test file
					if(data.equals("END")) {
						System.out.println("END");
						break;
					}
					else {
						//Print next equation in postfix notation
						System.out.println(data);
						//Print solution to equation
						System.out.println("= " + Evaluate(data) + "\n\n");
					}
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error file not found.");
			}
		}
	}
}

