package z4;

import java.util.Scanner;

public class Taker {
	private static int turn = 0;
	private int myTurn;
	private String name;

	public Taker(String n, int t) {
		name = n;
		myTurn = t;
	}

	public String getName() {
		return name;
	}

	public static int getTurn() {
		turn++;
		return turn;
	}

	public boolean isMyTurn() {
		if (turn % 2 == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("How many times:");
		int times = k.nextInt();
		Taker person1 = new Taker("Romeo", 1);
		Taker person2 = new Taker("Juliet", 3);
		for (int i = 1; i <= times; i++) {
			System.out.println("Turn = " + Taker.getTurn());
			if (person1.isMyTurn() == true && turn != times)
				System.out.println("Love from " + person1.getName());
			if (person2.isMyTurn() == false && turn != times)
				System.out.println("Love from " + person2.getName());
			if (turn == times)
				System.out.println("Love from " + person1.getName() + "\nLove from " + person2.getName());
		}
	}
}