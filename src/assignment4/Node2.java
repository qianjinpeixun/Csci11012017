package assignment4;

public class Node2 {

	private User user;
	private Node2 next;
	public User getUser() {
		return user;
	}
	
	public void setUserData(User user){
		this.user=user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public Node2 getNext() {
		return next;
	}
	public void setNext(Node2 next) {
		this.next = next;
	}
	public Node2(User user, Node2 next) {
		super();
		this.user = user;
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node2 [user=" + user + ", next=" + next + "]";
	}
	
	
}
