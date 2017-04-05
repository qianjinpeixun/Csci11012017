package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * FriendList	is	a	new	social	media	tool.	
 * It	keeps	track	of	all	of	its	users	and	their	friends.	
 * It	can	calculate	the	total	users of	the	social	medial	tool,	
 * the	user	with	the	most	friends,	
 * the	user	with	the	oldest	friend,	
 * and	can	also	find	the	common friends	between	two	users.		
 * Users	can	also	be	added	and	removed	from	Friendlist.	
 * In	order	to	join	FriendList	a	user	must	be	at	least	13	years	old	
 * and	when	a	user	is	removed,	
 * not	only	is	the	user	removed	from	FriendList	but	also	from	any	user’s	friend	lists.	
 */
public class FriendList {

	private LinkedList2 allUsers;
	
	public void saveUsersToFile() throws IOException{
		String name;
		String filename;
		Scanner keyboard = new Scanner(System.in);
		filename = "users.txt";
		PrintWriter outputFile = new PrintWriter(new FileWriter(filename));
		for(int i=0;i<allUsers.size();i++){
			User u=allUsers.getUserAt(i);
			String line=u.getName()+" "+u.getLocation()+" "+u.getBirthYear();
			outputFile.println(line);
		}
		outputFile.close();
		System.out.println("Users data written to the file!");
		
	}
	

	public void saveFriendsToFile() throws IOException{
		String name;
		String filename;
		Scanner keyboard = new Scanner(System.in);
		filename = "friends.txt";
		PrintWriter outputFile = new PrintWriter(new FileWriter(filename));
		for(int i=0;i<allUsers.size();i++){
			User u=allUsers.getUserAt(i);
			String line="";
			line=""+u.getName()+" ";
			LinkedList2 list=u.getFriends();
			Node2 node=list.getFront();
			while(node!=null){
				line=line+node.getUser().getName()+" ";
				node=node.getNext();
			}
			outputFile.println(line);
		}
		outputFile.close();
		System.out.println("Friends data written to the file!");
		
	}

	public User getUserByName(String name) {
		User user = null;
		for (int i = 0; i < allUsers.size(); i++) {
			user = allUsers.getUserAt(i);
			if (user.getName().equals(name))
				break;
			else
				user = null;
		}
		return user;
	}

	public FriendList() {
		allUsers = new LinkedList2();
	}

	// adds a user after checking that they are at least 13 years old and do not
	// already exist
	public void addUser(User user) {
		if (user.getBirthYear() <= 2004) {

			allUsers.addToEnd(user);
		} else
			System.out.println("User:" + user.getName() + " is too young, only older than 13 years can play this!");
	}

	// remove user from FriendList and remove that user as a friend of any other
	// users
	public void removeUser(User user) {
		//Step 1, remove this user from list
		allUsers.removeByElement(user);
		//Step 2, remove this user as a friend of any ohter
		for(int i=0;i<allUsers.size();i++){
			User u=allUsers.getUserAt(i);
			if(u!=null){
				LinkedList2 list2=u.getFriends();
				Node2 node2=list2.getFront();
				while(node2!=null){
					if(user.getName().equals(node2.getUser().getName())){
						list2.removeByElement(node2.getUser());
					}
					node2=node2.getNext();
				}
			}
		}

	}

	// returns the total number of users on FriendList
	public int totalUsers() {
		int ret = 0;
		if (allUsers != null)
			ret = allUsers.size();
		return ret;
	}

	// returns the list of all users
	public LinkedList2 getUsers() {
		return allUsers;
	}

	/*
	 * returns the user who has the most friends. If two or more users have the
	 * 'most friends' (i.e., a tie for most friends, return the first User with
	 * that number (similar to how ArrayLists handle this case)
	 */
	public User mostFriends() {
		User user = null;
		int maxCount = -1;

		for (int i = 0; i < allUsers.size(); i++) {
			User u = allUsers.getUserAt(i);
			if (u.getFriends().size() > maxCount) {
				user = u;
				maxCount = u.getFriends().size();
			}
		}
		return user;
	}

	/*
	 * returns the user(s) with the oldest friend. If two or more users have
	 * 'the oldest' friend (i.e., same birthday – return the first User (similar
	 * to how ArrayLists handle this case)
	 */
	public User oldestFriend() {
		User user = null;
		int year = 9999;
		for (int i = 0; i < allUsers.size(); i++) {
			User u = allUsers.getUserAt(i);
			if (u.getBirthYear() < year) {
				user = u;
				year = u.getBirthYear();
			}
		}
		return user;
	}

	// find common friends between users and returns new list
	public LinkedList2 commonFriends(User u1, User u2) {
		LinkedList2 list = new LinkedList2();

		LinkedList2 list1 = u1.getFriends();
		LinkedList2 list2 = u2.getFriends();
		for (int i = 0; i < list1.size(); i++) {
			User u = list1.getUserAt(i);
			if (list2.contains(u) != -1) {
				list.addToFront(u);
			}
		}

		return list;
	}
}
