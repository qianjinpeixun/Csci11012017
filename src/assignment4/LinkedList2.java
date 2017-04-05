package assignment4;

public class LinkedList2 {

	private Node2 front;
	private int count;

	// constructor
	public LinkedList2() {
		front = null;
		count = 0;
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

	// add a node to the front of the linked list
	public void addToFront(User user) {
		Node2 n;
		n = new Node2(user, front);
		front = n;
		count++;
	}

	// get the content of the first node
	public Node2 getFrontData() {
		if (front == null)
			return null;
		else
			return front.getNext();
	}

	// new method added - get the first node
	public Node2 getFront() {
		return front;
	}

	// scan the list and print contents
	public void enumerate() {
		Node2 curr = front;
		while (curr != null) {
			System.out.print(curr.getUser());
			curr = curr.getNext();
			System.out.print("--> ");
		}
		System.out.println("");

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

	// search for a given data and return the index of the node (first
	// occurrence)
	// return -1 if not found
	public int contains(User user) {
		Node2 curr = front;
		boolean found = false;
		int index = -1;
		while (curr != null && !found) {
			index++;
			if (curr.getUser().equals(user))
				found = true;
			curr = curr.getNext();
		}
		if (!found)
			return -1;
		else
			return index;

	}

	public void removeByElement(User user) {
		Node2 curr = front;
		boolean found = false;
		int index = -1;
		while (curr != null && !found) {
			index++;
			if (curr.getUser().equals(user)) {
				found = true;
				break;
			}
			curr = curr.getNext();
		}
		if (found) {
			removeNode(index);
		}
	}

	// add a node at a given index
	public void add(int index, User user) {
		if (index < 0 || index > size())
			System.out.println("Can't add. Index out of bounds");
		else {

			if (index == 0)
				addToFront(user);
			else {
				Node2 curr = front;
				for (int i = 0; i < index - 1; i++)
					curr = curr.getNext();
				Node2 n = new Node2(user, curr.getNext());
				curr.setNext(n);
				count++;
			}
		}

	}

	// remove a node at a given index
	public void removeNode(int index) {
		if (index < 0 || index >= size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index == 0)
			removeFront();
		else if (index == size() - 1)
			removeLast();
		else {
			Node2 curr = front;
			for (int i = 0; i < index - 1; i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());
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
			return (curr.getUser());
	}
}
