package z62.lab2;


import java.util.Scanner;

public class bugDemo {
	public static void main(String[] args) {// bugDemo
		// between 0 and 50
		int initialPos = (int) (Math.random() * 51);
		int initialDir = (int) (Math.random() * 2);
		bug bugsy = new bug(initialPos, initialDir);
		System.out.println(bugsy);
		// display it
		for (int i = 0; i <= 50; i++) {
			if (i == bugsy.getPosition())
				System.out.print("X");
			else
				System.out.print("-");
		}
		System.out.println();
		// make the bug move a random number
		int moves = (int) (Math.random() * 51);
		System.out.println("Moves: " + moves);
		for (int i = 1; i <= moves; i++)
			bugsy.move();
		System.out.println(bugsy);
		// display it
		for (int i = 0; i <= 50; i++) {
			if (i == bugsy.getPosition())
				System.out.print("X");
			else
				System.out.print("-");
		}
		System.out.println();
	}
}
