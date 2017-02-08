package z3;

import java.util.Scanner;

public class RobotGame {
	public static void main(String[] args) {
		int direct3, direct4;
		Scanner keyboard = new Scanner(System.in);// create a new Scanner object
		System.out.print("Enter the name of the first robot: ");
		String name1 = keyboard.nextLine();
		System.out.print("Enter the direction of the first robot: ");
		String direct1 = keyboard.nextLine();
		System.out.print("Enter the name of the second robot: ");
		String name2 = keyboard.nextLine();
		System.out.print("Enter the direction of the second robot: ");
		String direct2 = keyboard.nextLine();
		if (direct1.equals("Up")) {
			direct3 = 1;
			System.out.println("\nSimulation started!\n" + name1 + " (1,1) Up    2 points");
		} else if (direct1.equals("Right")) {
			direct3 = 2;
			System.out.println("\nSimulation started!\n" + name1 + " (1,1) Right 2 points");
		} else {
			direct3 = 3;
			System.out.println("\nSimulation started!\n" + name1 + " (1,1) Diag  2 points");
		}
		if (direct2.equals("Up")) {
			direct4 = 1;
			System.out.println("\nSimulation started!\n" + name2 + " (1,1) Up    2 points");
		} else if (direct2.equals("Right")) {
			direct4 = 2;
			System.out.println("\nSimulation started!\n" + name2 + " (1,1) Right 2 points");
		} else {
			direct4 = 3;
			System.out.println("\nSimulation started!\n" + name1 + " (1,1) Diag  2 points");
		}
		Robot r1 = new Robot(name1, direct3);
		Robot r2 = new Robot(name2, direct4);
		int move = (int) Math.random() * 3 + 1;
		int direct = (int) Math.random() * 3 + 1;
		while ((r1.getX() != 8 || r1.getY() != 8) || (r2.getY() != 8 || r2.getX() != 8)
				|| (r1.getX() != 8 || r1.getY() != 8 || r2.getY() != 8 || r2.getX() != 8)) {
			System.out.println("\nMove!");
			r1.move(move, direct);
			r2.move(move, direct);
			System.out.println(r1.toString());
			System.out.println(r2.toString());
			if (r1.amIAhead(r2)) {
				System.out.println(name1 + " ahead!");
			} else {
				if (Math.sqrt(Math.pow((r1.getX() - 8), 2) + Math.pow((r1.getY() - 8), 2)) == Math
						.sqrt(Math.pow((r2.getX() - 8), 2) + Math.pow((r2.getY() - 8), 2)))
					System.out.println("Both are at the same distance from the goal!");
				else
					System.out.println(name2 + "ahead!");
			}
		}
		if (r1.getX() != 8 || r1.getY() != 8 || r2.getY() != 8 || r2.getX() != 8) {
			System.out.println("\nMove!");
			System.out.println(r1.toString());
			System.out.println(r2.toString());
			System.out.println("Game over");
		} else if (r1.getX() != 8 || r1.getY() != 8) {
			System.out.println("\nMove!");
			System.out.println(r1.toString());
			System.out.println(r2.toString() + "\n");
			System.out.println(name1 + " has reached the goal (" + r1.getPoint() + " points)");
			while (r2.getX() != 8 || r2.getY() != 8) {
				r2.move(move, direct);
				System.out.println(r1.toString());
			}
			System.out.println("Game over");
		} else {
			System.out.println("\nMove!");
			System.out.println(r2.toString());
			System.out.println(r1.toString() + "\n");
			System.out.println(name1 + " has reached the goal (" + r1.getPoint() + " points)");
			while (r1.getX() != 8 || r1.getY() != 8) {
				r1.move(move, direct);
				System.out.println(r1.toString());
			}
			System.out.println("Game over");
		}
	}
}
