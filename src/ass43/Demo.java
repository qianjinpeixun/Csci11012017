package ass43;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
		int num = 0;
		FriendList list = new FriendList();
		// load the users information from users.txt
		list.loadUsersFromFile();
		// load the friend relationship information from friends.txt
		list.loadFriendsFromFile();
		// Start to receive user's choice
		while (num != 12) {
			printMessages();
			num = kb.nextInt();
			if (num == 1) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("Users of FriendList:");
				list.getUsers();
			} else if (num == 2) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("Total users on FriendList:" + list.getNumFriends());
			} else if (num == 3) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.print("Enter a user name:");
				String username = kb.next();
				System.out.println(username + "'s friends:");
				list.getAllUser().getUserWithName(username).getFriends().enumerate();
			} else if (num == 4) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.print("Enter the user's name, their home town, and year of birth:");
				String username = kb.next();
				String userhome = kb.next();
				int useryear = kb.nextInt();
				User user = new User(username, userhome, useryear);
				list.addUser(user);
			} else if (num == 5) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.print("Enter a user name:");
				String username = kb.next();
				list.removeUser(list.getAllUser().getUserWithName(username));
			} else if (num == 6) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("To create a friend, you need to enter two user names");
				System.out.print("Enter the name of the the first user: ");
				String first = kb.next();
				System.out.print("Enter the name of the second user: ");
				String sceond = kb.next();
				list.getAllUser().getUserWithName(first).addFriend(list.getAllUser().getUserWithName(sceond));
				list.getAllUser().getUserWithName(sceond).addFriend(list.getAllUser().getUserWithName(first));
			} else if (num == 7) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("To remove a friend, you need to enter two user names");
				System.out.print("Enter the name of the the first user: ");
				String first = kb.next();
				System.out.print("Enter the name of the second user: ");
				String sceond = kb.next();
				list.getAllUser().getUserWithName(first).removeFriend(list.getAllUser().getUserWithName(sceond));
				list.getAllUser().getUserWithName(sceond).removeFriend(list.getAllUser().getUserWithName(first));

			} else if (num == 8) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("the user with most friends is:" + list.mostFriend());
			} else if (num == 9) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.println("To find common friends between two friends, you need to enter two user names");
				System.out.print("Enter the name of the the first user: ");
				String first = kb.next();
				System.out.print("Enter the name of the second user: ");
				String second = kb.next();
				System.out.print("Common Friends between " + first + " and " + second + " are ");
				list.commonFriend(list.getAllUser().getUserWithName(first), list.getAllUser().getUserWithName(second)).enumerate();
			} else if (num == 10) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				System.out.print("Enter a user name:");
				String username = kb.next();
				System.out.println("the oldest friend for " + username + " is: " + list.getAllUser().getUserWithName(username).oldestFriends());
			} else if (num == 11) {
				System.out.println("");
				System.out.println("OUTPUT");
				System.out.println("");
				User old = list.oldestFriend();
				System.out.println("User(s) have the oldest friend:");
				for (int i = 0; i < list.getAllUser().size(); i++) {
					User u = list.getAllUser().getUserAt(i);
					if (u.getFriends().contains(old) != -1) {
						System.out.print(u.getFriends().getUserAt(u.getFriends().contains(old)));
					}
				}
				System.out.println("");
				System.out.print("Their oldest friend is " + old);
				System.out.println(" who was born in " + old.getBirthYear());
			} else if (num == 12) {
				list.writeUsersFile();
				list.writeFirendsToFile();
				System.out.println("Bye, all data have been updated into users.txt and friends.txt.");
				break;
			}
		}

	}

	// this method if for printing the menu in the screen
	// so the user can choose the functions
	public static void printMessages() {
		System.out.println("");
		System.out.println("Welcome to Friendlist! What would you like to do(Press a number)");
		System.out.println("1.  Print out all the users.");
		System.out.println("2.  Print the total number of users.");
		System.out.println("3.  Print out all the friends of a user.");
		System.out.println("4.  Add a new user.");
		System.out.println("5.  Remove a user.");
		System.out.println("6.  Add a friend.");
		System.out.println("7.  Remove a friend.");
		System.out.println("8.  Print the user with most friends.");
		System.out.println("9.  Find common friends between two friends");
		System.out.println("10. Find the oldest friend for a user..");
		System.out.println("11. Find the user with the oldest friend on FriendList.");
		System.out.println("12. Quit.");
	}

}
