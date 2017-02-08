package z4;

/*this program will create two robots then move in a two dimensional 8*8 square to see which one reach the goal first
 * <zishen cap><B00723808><Feb 6th>  */
//Scanner to read input
import java.util.Scanner;

public class RobitGame {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("Welcome to the Robot Game Simulator!");
		System.out.print("Enter the name of the first robot:");
		String n1 = k.nextLine();
		System.out.print("Enter the direction of the first robot:");
		String d1 = k.nextLine();
		System.out.print("Enter the name of the second robot:");
		String n2 = k.nextLine();
		System.out.print("Enter the direction of the second robot:");
		String d2 = k.nextLine();
		System.out.println("Simulation started");
		System.out.println(n1 + " (1,1) " + d1 + " 2 points");
		System.out.println(n2 + " (1,1) " + d2 + " 2 points");

		// create two robot objects then give name and direction,direction to
		// lowercase to make sure no matter user enter upper or lower case,both
		// works
		Robit r1 = new Robit(n1, d1.toLowerCase());
		Robit r2 = new Robit(n2, d2.toLowerCase());

		// condition:two robot have not reach the end yet,keep moving
		while (r1.getXpos() < 8 && r1.getYpos() < 8 && r2.getXpos() < 8 && r2.getYpos() < 8) {

			// random number to give moves between 1 to 3,direction between 1 to
			// 3,"1:up","2:right","3:diagonal"
			//一般要定义变量，方便调试，打印log
			//不能直接移动，要减分
			r1.Move((int) (Math.random() * 2), (int) (Math.random() * 3));
			r2.Move((int) (Math.random() * 2), (int) (Math.random() * 3));
			System.out.println("Move!");

			// print robit object and point collected
			System.out.println(r1 + " " + (r1.point() + 2) + " points.");
			System.out.println(r2 + " " + (r2.point() + 2) + " points.");
			System.out.print("\n");

			// if meet one of these conditions following ,then it reaches the
			// end (8,8)
			if (r1.getXpos() == 8 && r1.getYpos() < 8) {
				System.out.println(r1.getName() + " (8,8) " + r1.direction + (r1.point() + 2) + " points.");
				System.out.println(
						"r1 has reached the goal(" + (r1.point() + 2) + ") points.\n\nr2 (8,8) has reached the goal");
			} else if (r1.getYpos() == 8 && r1.getXpos() < 8) {
				System.out.println(r1.getName() + " (8,8) " + r1.direction + (r1.point() + 2) + " points.");
				System.out.println(
						"r1 has reached the goal(" + (r1.point() + 2) + ") points.\n\nr2 (8,8) has reached the goal");
			} else if (r2.getYpos() == 8 && r2.getXpos() < 8) {
				System.out.println(r2.getName() + " (8,8) " + r2.direction + (r2.point() + 2) + " points.");
				System.out.println(
						"r2 has reached the goal(" + (r2.point() + 2) + ") points.\n\nr1 (8,8) has reached the goal.");
			} else if (r2.getXpos() == 8 && r2.getYpos() < 8) {
				System.out.println(r2.getName() + " (8,8) " + r1.direction + (r2.point() + 2) + " points.");
				System.out.println(
						"r2 has reached the goal(" + (r1.point() + 2) + ") points.\n\nr1 (8,8) has reached the goal.");
			}
		}

	}
}
