//Austin Melendez 
//CSC130 SECTION 08

package Main;

//LINKED LIST CLASS
class LinkedList {

	Node head = null;
	Node tail = null;

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
		private Double sum() {
			Double total = this.value;
			//if there are more elements in list (ends recursion when list is exhausted)
			if(this.next != null) {
				//total += next value in list (then recursively call sum on next value)
				total += this.next.sum();
			}
			return total;

		}
		private void writeValues() {
			//if there are more elements in list (ends recursion when list is exhausted)
			if(this.next != null) {
				//print current value
				System.out.print(this.value + ", ");
				//recursively call function to print next values
				this.next.writeValues();
			}
			else {
				//print last value in list
				System.out.println(this.value);
			}
		}
	}	

	private String about() {
		return "Written by Austin Melendez";
	}

	private void addHead(Double value) {
		//Create a new node with given value
		Node new_node = new Node(value);

		if(this.isEmpty()) {
			head = new_node;
			tail = new_node;
		}
		else {
			Node temp = head;
			//new node will become head of list
			head = new_node;
			//previous head added after new head
			head.next = temp;
		}
	}

	private void addTail(Double value) {
		Node new_node = new Node(value);

		//if list is empty
		if(this.isEmpty()) {
			head = new_node;
			tail = new_node;
		}
		else {
			//new node added after tail
			tail.next = new_node;
			//new node will become new tail of list
			tail = new_node;
		}
	}

	private Double removeHead() {
		//if list in empty (null) return 0.0
		if(this.isEmpty()) {
			return 0.0;
		}
		else {
			Node temp = head;
			//set next value in list to new head
			head = head.next;

			//return old head value
			return temp.value;
		}
	}

	private Boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	private Double sum() {
		if(this.isEmpty()) {
			return 0.0;
		}
		else {
			return head.sum();
		}
	}

	private void writeValues() {
		if(this.isEmpty()) {
			System.out.println("The list is empty.");
		}
		else {
			head.writeValues();
		}
	}

	public static class Stack{
		LinkedList stack = new LinkedList();

		String about() {
			return stack.about();
		}
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

	public static class Queue{
		LinkedList queue = new LinkedList();

		String about() {
			return queue.about();
		}
		void enqueue(Double item) {
			queue.addTail(item);
		}
		Double dequeue() {
			return queue.removeHead();
		}
		Boolean isEmpty() {
			return queue.isEmpty();
		}
	}

	public class Tester{
		public static void main(String[] args) {
			System.out.println("Linked List Tests");
		//LINKED LIST EXAMPLES
			LinkedList list = new LinkedList();
			list.addHead(10.0);
			list.addHead(25.0);
			list.writeValues();
		//SHOULD PRINT 25, 10
			list.addTail(30.0);
		//SHOULD PRINT 25, 10, 30
			list.writeValues();
			list.removeHead();
		//SHOULD PRINT 10, 30
			list.writeValues();
			
			System.out.println("\n\nStack Tests");
		//STACK EXAMPLES
			Stack stack = new Stack();
		//SHOULD PRINT "List is empty"
			stack.stack.writeValues();
			stack.push(100.0);
			stack.push(125.0);
		//SHOULD PRINT 125, 100
			stack.stack.writeValues();
			stack.pop();
		//SHOULD PRINT 100
			stack.stack.writeValues();
			stack.push(140.0);
			stack.push(170.0);
		//SHOULD PRINT 170, 140, 100
			stack.stack.writeValues();
		//SHOULD PRINT "Written by Austin Melendez"
			System.out.println(stack.about());

			System.out.println("\n\nQueue Tests");
		//QUEUE EXAMPLES
			Queue queue = new Queue();
			queue.enqueue(210.0);
			queue.enqueue(230.0);
		//SHOULD PRINT 210, 230
			queue.queue.writeValues();
			queue.dequeue();
			queue.enqueue(250.0);
		//SHOULD PRINT 230, 250
			queue.queue.writeValues();
			queue.enqueue(275.0);
			queue.enqueue(285.0);
			queue.dequeue();
		//SHOULD PRINT 250, 275, 285
			queue.queue.writeValues();
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
		//SHOULD PRINT "List is empty"
			queue.queue.writeValues();
		//SHOULD PRINT "Written by Austin Melendez"
			System.out.println(queue.about());
		}
	}
}

