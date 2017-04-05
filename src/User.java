

public class User {
	String name;
	String location;
	int birthYear;
	LinkedList2 friend;

	public User(String n, String loc, int year) {
		name = n;
		location = loc;
		birthYear = year;
		friend=new LinkedList2();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public LinkedList2 getFriends() {
		return friend;
	}

	public boolean isEqual(User u) {
		if (this.name.trim() .equals(u.name.trim()) && this.location.trim().equals(u.location.trim()) && this.birthYear == u.birthYear)
			return true;
		return false;
	}
	
	public boolean isEqual(String name) {
		if (this.name.trim().equals(name.trim()))
			return true;
		return false;
	}

	public int getNumFriends() {
		return friend.getCount();
	}

	public String toString() {
		return name + " from " + location;
	}

	public void addFriend(User u) {
		friend.addNodetoEnd(u);
	}

	public void removeFriend(User u) {
		int pos = friend.contains(u);
		if (pos != -1)
			friend.removeNode(pos);
	}

	public User oldestFriend() {
		int age = 0;
		User u = null;
		for (int i = 0; i < friend.getCount(); i++) {
			if (2017 - friend.getUser(i).birthYear > age) {
				age = 2017 - friend.getUser(i).birthYear;
				u = friend.getUser(i);
			}
		}
		return u;
	}
}
