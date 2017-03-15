package lab8;

public class LinkedList {
	private Node front;
	private int count;

	// constructor
	public LinkedList() {
		front = null;
		count = 0;
	}

	// add a node to the front of the linked list
	public void addToFront(String d) {
		Node n;
		n = new Node(d, front);
		front = n;
		count++;
	}

	// get the current size of the list
	public int size() {
		return count;
	}

	// check if the list is empty
	public boolean isEmpty() {
		return (count == 0);
	}

	// clear the list
	public void clear() {
		front = null;
		count = 0;
	}

	// get the content of the first node
	public String getFrontData() {
		if (front == null)
			return "Empty list";
		else
			return front.getData();
	}

	// new method added - get the first node
	public Node getFront() {
		return front;
	}

	// scan the list and print contents
	public void enumerate() {
		Node curr = front;
		while (curr != null) {
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println(".");
	}
}