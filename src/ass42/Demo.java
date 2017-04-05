package ass42;


import java.io.*;
import java.util.*;

public class Demo {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to FriendList! What would you like to do(press a number)?");
		int num = 0;
		Scanner sc = new Scanner(System.in);
		FriendList fl = new FriendList();
		BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		try {
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] tokens = strLine.split(" ");
				User user = new User(tokens[0], tokens[1], (Integer.parseInt(tokens[2])));
				fl.addUser(user);
			}
			br.close();
		} catch (Exception e) {
			System.err.println("get users Error: " + e.getMessage());
		}

		BufferedReader br1 = new BufferedReader(new FileReader("friends.txt"));
		try {
			String strLine;
			while ((strLine = br1.readLine()) != null) {
				String[] tokens = strLine.split(" ");
				String name = tokens[0];
				for (int j = 0; j < fl.getUsers().count; j++) {
					User u = fl.getUsers().getUser(j);
					boolean isEqual = u.isEqual(name);
					if (isEqual) {
						// found which user needs to be added friends: u
						for (int i = 1; i < tokens.length; i++) {
							for (int k = 0; k < fl.getUsers().count; k++) {
								if (fl.getUsers().getUser(k).isEqual(tokens[i])) {
									User u2 = fl.getUsers().getUser(k);
									u.addFriend(u2);
								}
							}
						}

					}
				}
			}
			br1.close();
		} catch (Exception e) {
			System.err.println("get friends error: " + e.getMessage());
			e.printStackTrace();
		}

		while (num != 12) {
			System.out.println("1. Print out all the users");
			System.out.println("2. Print the total number of users");
			System.out.println("3. Print out all the friends of user");
			System.out.println("4. Add new user");
			System.out.println("5. Remove user");
			System.out.println("6. Add a friend");
			System.out.println("7. Remove a friend.");
			System.out.println("8. Print user with most friends");
			System.out.println("9. Find common friends between two friends");
			System.out.println("10. Print oldest friend");
			System.out.println("11. Find user with the oldest friend on friendlist");
			System.out.println("12. Quit");

			num = sc.nextInt();

			if (num == 1) {
				System.out.println("Users of FriendList:");
				fl.getUsers().enumerate();
			} else if (num == 2) {
				System.out.println("Total users on FriendList:" + fl.getUsers().getCount());
			} else if (num == 3) {
				System.out.print("Enter a user name:");
				String name = sc.next();
				System.out.println(name + "'s friends:");
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					if (fl.getUsers().getUser(i).isEqual(name)) {
						fl.getUsers().getUser(i).getFriends().enumerate();
					}
				}
			} else if (num == 4) {
				System.out.println("Enter the user's name, their home town, and year of birth: ");
				User u = new User(sc.next(), sc.next(), sc.nextInt());
				fl.addUser(u);
			} else if (num == 5) {
				String name = sc.next();
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					boolean bb=fl.getUsers().getUser(i).isEqual(name);
					if (bb) {
						fl.removeUser(fl.getUsers().getUser(i));
					}
				}
			} else if (num == 6) {
				System.out.println("To create a friend, you need to enter two user names");
				System.out.println("Enter the name of the the first user:");
				System.out.println("Enter the name of the second user:");
				String n1 = sc.next();
				String n2 = sc.next();
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					User u1 = fl.getUsers().getUser(i);
					if (u1.isEqual(n1)) {
						for (int j = 0; j < fl.getUsers().getCount(); j++) {
							User u2 = fl.getUsers().getUser(j);
							if (u2.isEqual(n2)) {
								u1.addFriend(u2);
							}
						}
					}
				}
				// add a friend n2 to n1
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					User u1 = fl.getUsers().getUser(i);
					if (u1.isEqual(n2)) {
						for (int j = 0; j < fl.getUsers().getCount(); j++) {
							User u2 = fl.getUsers().getUser(j);
							if (u2.isEqual(n1)) {
								u1.addFriend(u2);
							}
						}
					}
				}
			} else if (num == 7) {
				System.out.println("Enter the name of the the user:");
				System.out.println("Enter the name of the the friend:");
				String n1 = sc.next();
				String n2 = sc.next();
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					User user = fl.getUsers().getUser(i);
					if (user.isEqual(n1)) {
						for (int j = 0; j < fl.getUsers().getCount(); j++) {
							User u2 = fl.getUsers().getUser(j);
							if (u2.isEqual(n2)) {
								user.removeFriend(u2);
								break;
							}
						}
					}
				}

			} else if (num == 8) {
				System.out.println("User with the most friends is" + fl.mostFriends() + ", count of friends is:" + fl.mostFriends().getFriends().getCount());
			} else if (num == 9) {
				System.out.println("Enter the name of the the first user:");
				System.out.println("Enter the name of the second user:");
				String n1 = sc.next();
				String n2 = sc.next();
				User u1 = null;
				User u2 = null;
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					if (fl.getUsers().getUser(i).isEqual(n1)) {
						u1 = fl.getUsers().getUser(i);
						break;
					}
				}

				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					if (fl.getUsers().getUser(i).isEqual(n2)) {
						u2 = fl.getUsers().getUser(i);
						break;
					}
				}

				LinkedList2 ll = fl.commonFriends(u1, u2);
				System.out.println("Common Friends between " + n1 + " and " + n2 + " are ");
				ll.enumerate();

			} else if (num == 10) {
				System.out.println("Enter the user's name: ");
				String name = sc.next();
				User old = null;
				for (int i = 0; i < fl.getUsers().getCount(); i++) {
					User u = fl.getUsers().getUser(i);
					int years = 2014;
					if (u.isEqual(name)) {
						LinkedList2 ff = u.getFriends();

						for (int j = 0; j < ff.getCount(); j++) {
							User user = ff.getUser(j);
							if (user.getBirthYear() < years) {
								years = user.getBirthYear();
								old = user;
							}
						}
					}
				}
				System.out.println("the oldest friend of " + name + " is " + old);
			} else if (num == 11) {
				User old = fl.oldestFriend();
				System.out.print("User(s) have the oldest friend:");
				LinkedList2 l = fl.getUsersByFriend(old);
				l.enumerate();
				System.out.print("Their oldest friend is " + old);
				System.out.print(" who was born in " + old.getBirthYear());
				System.out.println("");
			}

		}

		BufferedWriter wt = new BufferedWriter(new FileWriter("users.txt"));
		PrintWriter pt = new PrintWriter(wt);
		// save users.txt
		for (int i = 0; i < fl.getUsers().getCount(); i++) {
			User user = fl.getUsers().getUser(i);
			pt.println(user.getName() + " " + user.getLocation() + " " + user.getBirthYear());
		}
		pt.close();
		wt.close();

		BufferedWriter wt1 = new BufferedWriter(new FileWriter("friends.txt"));
		PrintWriter pt1 = new PrintWriter(wt1);
		// save friends.txt
		for (int i = 0; i < fl.getUsers().getCount(); i++) {
			User user = fl.getUsers().getUser(i);
			pt1.print(user.getName()+" ");
			for (int j = 0; j < user.getFriends().getCount(); j++) {
				pt1.print(user.getFriends().getUser(j).getName()+" ");
			}
			pt1.println("");
		}
		pt1.close();
		wt1.close();

		
	}
}