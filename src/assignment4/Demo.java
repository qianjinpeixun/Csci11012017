package assignment4;

import java.util.*;
import java.io.*;

/*
 * This	demo	program	that reads	data	from	two text	files,	
 * users.txt	and	friends.txt	and	creates	the	FriendList.	
 * The	file	users.txt	contains	the	name,	
 * location	and	year	of	birth	of	each	user,	
 * one	on	each	line.	
 * The	file	friends.txt	contains	a	list	of	friends	of	each	user.	
 * The	first	word	in	each	line	is	the	name	of	the	user	
 * and	the	remaining	words	are	the	friends.	
 * Sample	users.txt	and	friends.txt	files	are	given	below.	
 * You	may	assume	that	the	names	are	not	repeated,	
 * that	is,	each	user	is	unique.
 */
public class Demo {

	private static FriendList friendList = new FriendList();
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		File file = new File("");
		String currentDirectory = file.getAbsolutePath();
		// String user_file_name = currentDirectory +
		// "/src/assignment4/users.txt";
		String user_file_name = "users.txt";
		File usersFile = new File(user_file_name);
		Scanner scanner = new Scanner(usersFile);
		// Start to create Users object, store them in an arrayList
		ArrayList<User> userList = new ArrayList<User>();
		while (scanner.hasNext()) {
			String name = scanner.next();
			String location = scanner.next();
			int birth = scanner.nextInt();
			User user = new User(name, location, birth);
			// System.out.print("read file users:"+user);
			userList.add(user);
		}

		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			user = addFriends(user, userList);
			// System.out.print("start to add friends:"+user+", his/her friends
			// are:");
			// user.getFriends().enumerate();
			friendList.addUser(user);
		}
		// Start to print menu and listen the user's choice
		String command = "1";
		while (!command.equals("12")) {
			printMenu();
			command = keyboard.nextLine();
			if (command.equals("1"))
				command1();
			else if (command.equals("2"))
				command2();
			// Print out all the friends of a user.
			else if (command.equals("3"))
				command3();
			// command4 add a user
			else if (command.equals("4"))
				command4();
			// command5 remove a user
			else if (command.equals("5"))
				command5();
			// command6 add a friend to one user
			else if (command.equals("6"))
				command6();
			// command7 remove a friend to one user
			else if (command.equals("7"))
				command7();
			// command8 Print the user with most friends.
			else if (command.equals("8"))
				command8();
			// 9. Find common friends between two friends.
			else if (command.equals("9"))
				command9();
			// 10. Find the oldest friend for a user.
			else if (command.equals("10"))
				command10();
			// 11. Find the user with the oldest friend on FriendList.
			else if (command.equals("11"))
				command11();
			else if (command.equals("12")) {
				command12();
				break;
			}
		}
	}

	/*
	 * After you run the program (see the below table with Sample output) and
	 * the user chooses to quit the program, you should rewrite the two files
	 * (users.txt and friends.txt) so that the changes are saved.
	 */
	public static void command12() throws Exception {
		friendList.saveUsersToFile();
		friendList.saveFriendsToFile();
	}

	public static void command11() {
		LinkedList2 ll = friendList.getUsers();
		int oldestYear=2015;
		User oldestUser=null;
		for (int i = 0; i < ll.size(); i++) {
			User user = ll.getUserAt(i);
			User old=user.oldestFriend();
			if(old.getBirthYear()<oldestYear){
				oldestYear=old.getBirthYear();
				oldestUser=user;
			}
		}
		System.out.println("The user with the oldest friend on FriendList is:" + oldestUser.getName());
	}

	public static void command10() {
		System.out.println("Enter the name of user: ");
		String name = keyboard.next();
		User user = null;
		user = friendList.getUserByName(name);
		user = user.oldestFriend();
		System.out.println("The oldest friend for " + name + " is " + user);
	}

	public static void command9() {
		System.out.println("Enter the name of the first user: ");
		String firstName = keyboard.next();
		System.out.println("Enter the name of the second user: ");
		String secondName = keyboard.next();
		User firstUser = friendList.getUserByName(firstName);
		User secondUser = friendList.getUserByName(secondName);
		System.out.println("Common Friends between " + firstName + " and " + secondName + " are");
		LinkedList2 list = friendList.commonFriends(firstUser, secondUser);
		list.enumerate();
	}

	public static void command8() {
		User user = friendList.mostFriends();
		System.out.println("User with the most friends is:" + user);
		user.getFriends().enumerate();
	}

	public static void command7() {
		/*
		 * remove user from FriendList and remove that user as a friend of any
		 * other users
		 */
		System.out.println("To remove a friend, you need to enter two user names");
		String userName = command3();
		System.out.print("Enter the friend name:");
		String friendName = keyboard.next();
		User firstUser = friendList.getUserByName(userName);
		User sceondUser = friendList.getUserByName(friendName);
		firstUser.removeFriend(sceondUser);
		sceondUser.removeFriend(firstUser);

	}

	public static void command6() {
		/*
		 * If a user adds another user as a friend, then the other user will
		 * also add this user as a friend (that is, if A is a friend of B, then
		 * automatically B is a friend of A - similar to Facebook).
		 */
		System.out.println("To create a friend, you need to enter two user names");
		System.out.print("Enter the name of the the first user: ");
		System.out.println("");
		System.out.print("Enter the name of the second user: ");
		String firstUserName = keyboard.next();
		String sceondUserName = keyboard.next();
		User firstUser = friendList.getUserByName(firstUserName);
		User sceondUser = friendList.getUserByName(sceondUserName);
		firstUser.addFriend(sceondUser);
		sceondUser.addFriend(firstUser);

	}

	public static void command5() {
		System.out.print("Enter the user's name:");
		String name = keyboard.next();
		User user = friendList.getUserByName(name);
		friendList.removeUser(user);

	}

	public static void command4() {
		System.out.print("Enter the user's name, their home town, and year of birth:");
		String name = keyboard.next();
		String location = keyboard.next();
		int birth = keyboard.nextInt();
		User user = new User(name, location, birth);
		friendList.addUser(user);
	}

	public static User addFriends(User user, ArrayList<User> userList) throws IOException {
		File file = new File("");
		String currentDirectory = file.getAbsolutePath();
		// String user_file_name = currentDirectory +
		// "/src/assignment4/friends.txt";
		String user_file_name = "friends.txt";
		File usersFile = new File(user_file_name);
		Scanner scanner2 = new Scanner(usersFile);
		while (scanner2.hasNext()) {
			String line = scanner2.nextLine();
			// System.out.println("newline:"+line);
			Scanner scanner4 = new Scanner(line);
			String owner = scanner4.next();
			if (owner.equals(user.getName())) {
				while (scanner4.hasNext()) {
					String name = scanner4.next();
					User friend = null;
					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).getName().equalsIgnoreCase(name)) {
							user.addFriend(userList.get(i));
							// System.out.println(user.getName()+" add
							// friend:"+userList.get(i));
						}
					}
				}
			}
		}

		return user;
	}

	public static String command3() {
		System.out.print("Enter a user name:");
		String name = keyboard.next();
		System.out.println("");
		System.out.println(name + "'s friends:");
		LinkedList2 users = friendList.getUsers();
		Node2 curr = users.getFront();

		while (curr != null) {
			String currentName = curr.getUser().getName();
			if (currentName.equals(name)) {
				break;
			} else {
				curr = curr.getNext();
			}
		}
		if (curr != null) {
			User user = curr.getUser();
			LinkedList2 list = user.getFriends();
			list.enumerate();
		}
		return name;

	}

	public static void command2() {
		System.out.print("Total users on FriendList:" + friendList.totalUsers());
		System.out.println("");
	}

	public static void command1() {
		LinkedList2 list = friendList.getUsers();
		System.out.println("Users of FriendList:");
		list.enumerate();
	}

	private static void printMenu() {
		System.out.println("");
		System.out.println("Welcome to FriendList! What would you like to do (press a number)?");
		System.out.println("1. Print out all the users.");
		System.out.println("2. Print the total number of users.");
		System.out.println("3. Print out all the friends of a user.");
		System.out.println("4. Add a new user.");
		System.out.println("5. Remove a user.");
		System.out.println("6. Add a friend.");
		System.out.println("7. Remove a friend.");
		System.out.println("8. Print the user with most friends.");
		System.out.println("9. Find common friends between two friends.");
		System.out.println("10. Find the oldest friend for a user.");
		System.out.println("11. Find the user with the oldest friend on FriendList.");
		System.out.println("12. Quit.");
		System.out.println("");
	}
}
