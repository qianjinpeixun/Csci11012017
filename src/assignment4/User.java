package assignment4;

/*
 * 
 */
public class User {

	/*
	 * returns the friend who is the oldest (e.g., 30 years old). If there is
	 * tie (i.e., same birthday) return the first friend with that birthdate
	 */
	public User oldestFriend() {
		User user=null;
		int oldestYear=2015;
		Node2 node=friends.getFront();
		while(node!=null){
			User u=node.getUser();
			int currentYear=u.getBirthYear();
			if(currentYear<oldestYear){
				oldestYear=currentYear;
				user=u;
			}
			node=node.getNext();
		}
		return user;
	}

	/*
	 * Each user has a name, their current location (name of the city or town),
	 * and birth year.
	 */
	private String name;
	private String location;
	private int birthYear; // this is where they currently live (city or town)
	LinkedList2 friends; // this is a LinkedList that holds Nodes of Users who
							// are their friends

	public boolean isEqual(User user) {
		boolean ret = false;

		return ret;
	}

	public int getNumFriends() {
		int ret = 0;
		ret = friends.size();
		return ret;
	}

	/*
	 * Users also have a list of friends (a linked list of a User’s friends). If
	 * a user adds another user as a friend, then the other user will also add
	 * this user as a friend (that is, if A is a friend of B, then automatically
	 * B is a friend of A - similar to Facebook).
	 */
	public void addFriend(User user) {
		/*
		 * you should not add a user to FriendList if they already exist.
		 */
		boolean isFriend = false;
		for (int i = 0; i < friends.size(); i++) {
			if (friends.getUserAt(i).getName().equals(user.getName())) {
				isFriend = true;
				break;
			}
		}
		if (isFriend == false)
			friends.addToEnd(user);
	}

	public void removeFriend(User user) {
		friends.removeByElement(user);
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public LinkedList2 getFriends() {
		return friends;
	}

	public void setFriends(LinkedList2 friends) {
		this.friends = friends;
	}

	public User(String name, String location, int birthYear) {
		super();
		this.name = name;
		this.location = location;
		this.birthYear = birthYear;
		this.friends = new LinkedList2();
	}

	@Override
	public String toString() {
		return name + " from " + location;
	}

}
