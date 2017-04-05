

public class LinkedList2 {
	Node2 front;
	int count;

	public LinkedList2() {
		front = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int getCount() {
		return count;
	}

	public void clear() {
		front = null;
	}

	public void addNodeToFront(User u) {
		Node2 nptr = new Node2(u, null);
		count++;
		if (front == null) {
			front = nptr;

		} else {
			nptr.setNext(front);
			front = nptr;
		}
	}

	public Node2 getFront() {
		return front;
	}

	public void enumerate() {
		if (count == 0) {
			System.out.print("empty\n");
			return;
		}
		if (front.getNext() == null) {
			System.out.println(front.getUser());
			return;
		}
		Node2 ptr = front;
		System.out.print(front.getUser() + " -> ");
		ptr = front.getNext();
		while (ptr.getNext() != null) {
			System.out.print(ptr.getUser() + " -> ");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getUser() + "\n");
	}

	public void removeFront() {
		if (front == null) {
			System.out.println("Empty");
		}
		front = front.getNext();
		count--;
	}

	public void removeLast() {
		Node2 s = front;
		Node2 t = front;
		while (s != null) {
			t = s;
			s = s.getNext();
		}
		t.setNext(null);
		count--;
	}

	public void addNodetoEnd(User u) {
		Node2 nptr = new Node2(u, null);
		count++;
		if (front == null) {
			front = nptr;

		} else {
			Node2 s = front;
			Node2 t = front;
			while (s != null) {
				t = s;
				s = s.getNext();
			}
			t.setNext(nptr);
		}
	}

	public int contains(User u) {
		int index = 0;
		Node2 s = front;
		Node2 t = front;
		while (s != null) {
			index++;
			t = s;
			s = s.getNext();
			if (t.user.isEqual(u))
				return index;
		}
		return -1;

	}

	public void removeNode(int pos) {
		
		if (pos == 1) {
			front = front.getNext();
			count--;
			return;
		} else if (pos == count) {
			Node2 s = front;
			Node2 t = front;
			while (s.getNext() != null) {
				t = s;
				s = s.getNext();
			}
			t.setNext(null);
			count--;
			return;
		}
		Node2 ptr = front;
		pos = pos - 1;
		for (int i = 1; i < count - 1; i++) {
			if (i == pos) {
				Node2 tmp = ptr.getNext();
				tmp = tmp.getNext();
				ptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		count--;
	}

	public User getUser(int pos) {
		Node2 ptr = front;
		for (int i = 0; i < count; i++) {
			if (i == pos) {
				return ptr.user;

			}
			ptr = ptr.getNext();
		}
		return null;
	}

	public String toString() {
		String st = null;
		Node2 s = front;
		Node2 t = front;
		while (s != null) {

			t = s;
			s = s.getNext();
			st = t.getUser() + "->";
		}
		return st;
	}
}
