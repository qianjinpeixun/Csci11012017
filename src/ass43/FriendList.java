package ass43;

import java.util.*;
import java.io.*;

public class FriendList {
	private LinkedList2 allUser;

	//if the user choose to quit this program
	//save the latest users into users.txt file
	public void writeUsersFile() throws IOException {
		File f = new File("users.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter w=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(w);
		Node2 curr=allUser.getFront();
		
		while (curr!=null) {
			pw.println(curr.getData().getName()+" "+curr.getData().getLocation()+" "+curr.getData().getBirthYear());
			curr=curr.getNext();
		}
		pw.close();
		w.close();
		fw.close();
	}
	
	//if the user quit this program, save the friend relationship to friends.txt file
	public void writeFirendsToFile() throws IOException {
		File f = new File("friends.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter w=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(w);
		
		for(int i=0;i<allUser.size();i++){
			User user=allUser.getUserAt(i);
			pw.print(user.getName()+" ");
			Node2 curr=user.getFriends().getFront();
			while(curr!=null){
				pw.print(curr.getData().getName()+" ");
				curr=curr.getNext();
			}
			pw.println("");
		}
		
		pw.close();
		w.close();
		fw.close();
		
	}
	//at the very beginning, read the users.txt in order to create allUser object
	public void loadUsersFromFile() throws IOException {
		File f = new File("users.txt");
		Scanner user = new Scanner(f);
		while (user.hasNext()) {
			String name = user.next();
			String loc = user.next();
			int year = user.nextInt();
			User u = new User(name, loc, year);
			allUser.addNodeToFront(u);
		}
	}

	//at the very beginning, read the friend relationship file 
	//in order to create relationship
	public void loadFriendsFromFile() throws IOException {
		File f = new File("friends.txt");
		Scanner ff = new Scanner(f);
		while (ff.hasNext()) {
			String ll = ff.nextLine();
			String[] friends = ll.split(" ");
			String name = friends[0];
			User user = allUser.getUserWithName(name);
			for (int i = 1; i < friends.length; i++) {
				User u = allUser.getUserWithName(friends[i]);
				user.addFriend(u);
			}
		}
	}


	public FriendList() {// constructor
		allUser = new LinkedList2();
	}

	public void addUser(User u) {
		if (u.getBirthYear() < 2005) {// check the age of user
			allUser.addNodeToFront(u);
		} else {
			System.out.println("the user must be at least 13 years old");
		}

	}

	public LinkedList2 getAllUser() {
		return allUser;
	}

	public void removeUser(User u) {
		if (allUser.contains(u) != -1) {
			allUser.remove(allUser.contains(u));// remove this one
		} else {// allUser.contains(u)=-1 mean cannot find the u in the allUser
				// list
			System.out.println("not exit");
		}
		
		//start to remove as friend
		for(int i=0;i<allUser.size();i++){
			User user=allUser.getUserAt(i);
			LinkedList2 list=user.getFriends();
			int pos=list.contains(u);
			if(pos!=-1){
				list.remove(list.contains(u));
			}
		}
	}

	public int totalUser() {// the total number of user is equal the size of
							// allUser list
		int tu = allUser.size();
		return tu;
	}

	public int getNumFriends() {
		return allUser.size();
	}

	public void getUsers() {
		allUser.enumerate();
	}

	public User mostFriend() {
		Node2 curr = allUser.getFront();
		int most = allUser.getFront().getData().getNumFriend();
		User m = allUser.getFront().getData();
		while (curr != null) {
			if (most < curr.getData().getNumFriend()) {
				most = curr.getData().getNumFriend();
				m = curr.getData();
			}
			curr = curr.getNext();
		}
		return m;
	}

	public User oldestFriend() {
		int oldest = allUser.getUserAt(0).getBirthYear();
		User m = allUser.getUserAt(0);
		for (int i = 1; i < allUser.size(); i++) {
			if (oldest > allUser.getUserAt(i).getBirthYear()) {
				oldest = allUser.getUserAt(i).getBirthYear();
				m = allUser.getUserAt(i);
			}
		}
		return m;
	}

	public LinkedList2 commonFriend(User U1, User U2) {
		LinkedList2 list = new LinkedList2();
		Node2 curr = U1.getFriends().getFront();
		while (curr != null) {
			if (U2.getFriends().contains(curr.getData()) != -1)
				list.addToEnd(curr.getData());
			curr = curr.getNext();
		}
		return list;
	}

	public void enumerate() {
		allUser.enumerate();
	}

}
