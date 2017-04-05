package assignment4;

import java.util.Scanner;

public class LinkedListDemo2 {
	public static void main(String[] args) {
		LinkedList names = new LinkedList();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name or done: ");
		String d = keyboard.nextLine();
		while (!d.equals("done")) {
			names.addToEnd(d);
			System.out.print("Enter name or done: ");
			d = keyboard.nextLine();
		}
		System.out.println("Number of names entered: " + names.size());
		names.enumerate();

		System.out.println("Removing first and last names");
		names.removeFront();
		names.removeLast();
		names.enumerate();

		System.out.print("Enter name to search: ");
		String key = keyboard.nextLine();
		int pos = names.contains(key);
		if (pos == -1)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found at index " + pos);

		System.out.print("Enter name to add: ");
		d = keyboard.nextLine();
		System.out.print("Where to add? 0 to " + names.size() + " :");
		pos = keyboard.nextInt();
		names.add(pos, d);
		names.enumerate();

		System.out.println("Current size is : " + names.size());

		System.out.print("Which index to get? 0 to " + (names.size() - 1) + " :");
		pos = keyboard.nextInt();
		System.out.println(names.get(pos));

		System.out.print("Which index to remove? ");
		pos = keyboard.nextInt();
		names.remove(pos);
		names.enumerate();
	}
}
