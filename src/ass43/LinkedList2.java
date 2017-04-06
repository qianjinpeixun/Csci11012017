package ass43;

// LinkedList class.
public class LinkedList2 {
	private Node2 front;
	private int count;

	// constructor
	public LinkedList2() {
		front = null;
		count = 0;
	}

	// add a node to the front of the linked list
	public void addNodeToFront(User user) {
		Node2 n;
		n = new Node2(user, front);// deep copy
		front = n;
		count++;
	}

	// get the current size of the list
	public int size() {
		return count;
	}

	// check if the list is empty
	public boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	// clear the list
	public void clear() {
		front = null;
		count = 0;
	}

	// get the content of the first node
	public User getFrontData() {
		if (front == null)
			return null;
		else
			return front.getData();
	}

	// new method added - get the first node
	public Node2 getFront() {
		return front;
	}

	// scan the list and print contents
	public void enumerate() {
		Node2 curr = front;
		while (curr != null) {
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println(".");
	}

	// remove front node
	public void removeFront() {
		if (front == null) {
			System.out.println("Empty list");
		} else {
			front = front.getNext();
			count--;
		}
	}

	// add a node to the end
	public void addToEnd(User user) {
		Node2 n = new Node2(user, null);
		Node2 curr = front;
		if (front == null)
			front = n;
		else {
			while (curr.getNext() != null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;
	}

	// remove last node
	public void removeLast() {
		if (front == null) {
			System.out.println("Empty list");
		} else if (front.getNext() == null) {
			front = null;
			count--;
		} else {
			Node2 curr = front;
			while (curr.getNext().getNext() != null)
				curr = curr.getNext();
			curr.setNext(null);
			count--;
		}

	}

	// search for a given data and return the index of the node (first
	// occurrence)
	// return -1 if not found
	public int contains(User user) {
		Node2 curr = front;
		boolean found = false;
		int index = -1;
		while (curr != null && !found) {
			index++;
			if (curr.getData().getName().equals(user.getName())) {
				found = true;
			}

			curr = curr.getNext();
		}

		if (!found)
			return -1;
		else
			return index;

	}

	/*
	 * //add a node at a given index public void add(int index, String d) { if
	 * (index<0 || index>size()) System.out.println(
	 * "Can't add. Index out of bounds"); else {
	 * 
	 * if (index==0) addToFront(d); else { Node curr = front;// find the front
	 * for(int i=0; i<index-1; i++)// run through the linked list curr =
	 * curr.getNext(); Node n = new Node(d,curr.getNext()); curr.setNext(n);
	 * count++; } }
	 * 
	 * }
	 */
	// remove a node at a given index
	public void remove(int index) {
		if (index < 0 || index >= size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index == 0)// if only one node
			removeFront();
		else if (index == size() - 1)// remove the last node.
			removeLast();
		else {
			Node2 curr = front;
			for (int i = 0; i < index - 1; i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());// remove the node at
													// specific location and
													// link the one next to it.
			count--;
		}
	}

	// get a node data given an index
	public User getUserAt(int index) {
		Node2 curr = front;
		int i = 0;
		while (curr != null && i != index) {
			curr = curr.getNext();
			i++;
		}
		if (curr == null)
			return null;
		else
			return (curr.getData());
	}

	// get a node data given a user's name
	public User getUserWithName(String name) {
		Node2 curr = front;
		while (curr != null) {
			if (curr.getData().getName().trim().equalsIgnoreCase(name.trim()))
				break;
			curr = curr.getNext();
		}
		if (curr == null)
			return null;
		else
			return (curr.getData());
	}

}