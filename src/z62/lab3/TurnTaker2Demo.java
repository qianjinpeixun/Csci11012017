package z62.lab3;

import java.util.Scanner;

public class TurnTaker2Demo {
	// This class use the method in TurnTaker class and set the data.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("How many turns? ");
		int t = kb.nextInt();
		for (int i = 1; i <= t; i++) {
			TurnTaker person1 = new TurnTaker("Romeo", i);
			TurnTaker person2 = new TurnTaker("Juliet", i);
			System.out.println("Turn = " + TurnTaker.getTurn());
			if (person1.isMyTurn()) {
				if (i % 2 != 0 && i != t)
					System.out.println("Love from " + person1.getName());
			}
			if (person2.isMyTurn()) {
				if (i % 2 == 0 && i != t)
					System.out.println("Love from " + person2.getName());
			}
			if (i == t) {
				System.out.println("Love from " + person1.getName());
				System.out.println("Love from " + person2.getName());
			}
		}
	}
}
