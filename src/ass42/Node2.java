package ass42;


public class Node2 {
	User user;
	Node2 next;

	/* Constructor */
	public Node2() {
		next = null;

	}

	/* Constructor */
	public Node2(User ud, Node2 n) {
		user = ud;
		next = n;
	}

	/* Function to set link to next Node2 */
	public void setNext(Node2 n) {
		next = n;
	}

	/* Function to set data to current Node2 */
	public void setUserData(User ud) {
		user = ud;
	}

	/* Function to get link to next Node2 */
	public Node2 getNext() {
		return next;
	}

	/* Function to get data from current Node2 */
	public User getUser() {
		return user;
	}

	public String toString() {
		return user.toString();
	}
}
