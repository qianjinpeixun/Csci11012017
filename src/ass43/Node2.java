package ass43;

public class Node2<next>
{
	private User user;
	private Node2 next;
	public Node2(User u, Node2 front)
	{
		user = u;
		next = front;
	}
	public User getData()
	{
		return user;
	}
	public Node2 getNext()
	{
		return next;
	}
	public void setData(User u)
	{
		user = u;
	}
	public void setNext(Node2 n)
	{
		next = n;
	}
	public String toString()
	{
		return user + " --> ";
	}
}