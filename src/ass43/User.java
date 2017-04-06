package ass43;

public class User {
	private String name;
	private String location;
	private int birthYear;
	private LinkedList2 friends;

	public User(String n, String l, int bY) {
		name = n;
		location = l;
		birthYear = bY;
		friends = new LinkedList2();
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

	public boolean isEqual(User u) {
		boolean result = false;
		if (u.equals(getName())) {
			result = true;
		}
		return result;

	}

	public LinkedList2 getFriends() {
		return friends;// ?

	}

	public int getNumFriend() {
		int num = friends.size();
		return num;

	}

	public String toString() {
		return name + " from " + location;
	}

	public void addFriend(User u) {
		if (birthYear < 2004) {
			if (friends.contains(u) == -1)
				friends.addToEnd(u);
			else
				System.out.println("they are already friends!");
		} else
			System.out.println("the user must be at least 13 years old");
	}

	public void removeFriend(User u) {
		if (friends.contains(u) != -1) {
			friends.remove(friends.contains(u));
		} else {
			System.out.println("not exit");
		}

	}

	public User oldestFriends() {
		User u=null;
		int oldestBirthData = 2017;
		for (int i = 0; i < friends.size(); i++) {
			User user=friends.getUserAt(i);
			if(user.getBirthYear()<oldestBirthData){
				oldestBirthData=user.getBirthYear();
				u=user;
			}
		}
		return u;
	}

}
