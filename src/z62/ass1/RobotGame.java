package z62.ass1;

import java.util.Scanner;

public class RobotGame {
	// The RobotGame class used the data and methods from Robot class
	// we will decide and input the name and the first time's direction
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the Robot Game Simulator!");
		System.out.print("\nEnter the name of the first robot: ");
		String name1 = kb.nextLine();
		System.out.print("Enter the direction of the first robot: ");
		String direction1 = kb.nextLine();
		System.out.print("Enter the name of the second robot: ");
		String name2 = kb.nextLine();
		System.out.print("Enter the direction of the second robot: ");
		String direction2 = kb.nextLine();
		Robot r1 = new Robot(name1, direction1);
		Robot r2 = new Robot(name2, direction2);
		System.out.println("\nSimulation started!");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println();
		// here I used n to replace the number 8 because it will be easier to
		// change the number of grid
		int n = 8;
		// here I used while loops to run the game
		while (r1.getXpos() < n || r1.getYpos() < n || r2.getXpos() < n || r2.getYpos() < n) {
			if (r1.getXpos() < n || r1.getYpos() < n) {
				r1.move();
				r1.setDirection();
			}
			if (r2.getXpos() < n || r2.getYpos() < n) {
				r2.move();
				r2.setDirection();
			}
			System.out.println("\nMove!");
			System.out.println(r1);
			System.out.println(r2);
			System.out.println();
			if (r1.amIAhead(r2)) {
				System.out.println(r1.getName() + " ahead!");
				System.out.println();
			}
			if (r2.amIAhead(r1)) {
				System.out.println(r2.getName() + " ahead!");
				System.out.println();
			}
			if (r1.getXpos() + r1.getYpos() == r2.getXpos() + r2.getYpos()) {
				System.out.println("Both are at the same distance from the goal!");
				System.out.println();
			}
			// because of the break,I need to show if they reach the goal at
			// same time
			if (r1.getXpos() == n && r1.getYpos() == n) {
				System.out.println(r1.getName() + " has reached the goal." + "(" + r1.getPoints() + " points)");
				if (r2.getXpos() == n && r2.getYpos() == n)
					System.out.println(r2.getName() + " has reached the goal." + "(" + r2.getPoints() + " points)");
				break;
			}
			if (r2.getXpos() == n && r2.getYpos() == n) {
				System.out.println(r2.getName() + " has reached the goal." + "(" + r2.getPoints() + " points)");
				break;
			}
		}
		// here I repeat the while loops to make sure all the robot have got the
		// goal
		while (r1.getXpos() < n || r1.getYpos() < n || r2.getXpos() < n || r2.getYpos() < n) {
			System.out.println("\nMove!");
			if (r1.getXpos() < n || r1.getYpos() < n) {
				r1.move();
				r1.setDirection();
				System.out.println(r1);
				System.out.println();
				if (r1.getXpos() == n && r1.getYpos() == n) {
					System.out.println(r1.getName() + " has reached the goal." + "(" + r1.getPoints() + " points)");
					System.out.println();
				}
			}
			if (r2.getXpos() < n || r2.getYpos() < n) {
				r2.move();
				r2.setDirection();
				System.out.println(r2);
				System.out.println();
				if (r2.getXpos() == n && r2.getYpos() == n) {
					System.out.println(r2.getName() + " has reached the goal." + "(" + r2.getPoints() + " points)");
					System.out.println();
				}
			}
		}
		System.out.println("Game over!");
	}
}// end
