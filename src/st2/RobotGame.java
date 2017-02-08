package st2;

import java.util.Scanner;

//Robot Demo
public class RobotGame {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Weclome to the Robot Game Simulator! ");
		// create two robots
		System.out.print("Enter the name of frist Robot: ");
		String n = kb.nextLine();
		System.out.print("Enter the direction of frist Robot: Up,Right,Dig");
		String dir = kb.nextLine();
		int d;// for print direction
		if (dir == "Up")
			d = 0;
		else if (dir == "Right")
			d = 1;
		else
			d = 2;
		Robot r1 = new Robot(n, d);
		System.out.print("Enter the name of second Robot: ");// same for robot 2
		n = kb.nextLine();
		System.out.print("Enter the direction of second Robot: ");
		dir = kb.nextLine();
		if (dir == "Up")
			d = 0;
		else if (dir == "Right")
			d = 1;
		else
			d = 2;
		Robot r2 = new Robot(n, d);
		// move!
		r1.move(0);// get frist 2 points before move
		r2.move(0);
		System.out.println("Simulation started!");
		System.out.println(r1);
		System.out.println(r2);
		while (r1.getX() != 8 || r1.getY() != 8 || r2.getX() != 8 || r2.getY() != 8) {
			System.out.println("Move!");// move
			if (r1.getX() != 8 || r1.getY() != 8) {
				int r1move = (int) (Math.random() * 2);// get random move
				r1.move(r1move + 1);
				r1.deDuct(r2, r1move);// check if need deduct
				int r1d = (int) (Math.random() * 3);// change direction
				r1.setDirection(r1d);
				System.out.println(r1);
			}
			if (r2.getX() != 8 || r2.getY() != 8) {// same for robot2
				int r2move = (int) (Math.random() * 2);
				r2.move(r2move + 1);
				r2.deDuct(r1, r2move);
				int r2d = (int) (Math.random() * 3);
				r2.setDirection(r2d);
				System.out.println(r2);
			}
			if ((r1.getX() == 8 && r1.getY() == 8) || (r2.getX() == 8 && r2.getY() == 8)) {
				// check
				// if
				// one
				// robot
				// have
				// reach
				// the
				// goal
				if (r1.getX() == 8 && r1.getY() == 8)
					System.out.println(r1.getName() + " has reach the goal (" + r1.getNumOfPoint() + " points)");
				else if (r2.getX() == 8 && r2.getY() == 8)
					System.out.println(r2.getName() + " has reach the goal (" + r2.getNumOfPoint() + " points)");
			} else {
				if (r1.amIAhead(r2))// check which is ahead
					System.out.println(r1.getName() + " ahead!");
				else if (r2.amIAhead(r1))
					System.out.println(r2.getName() + " ahead!");
				else
					System.out.println("Both are at the same distance from the goal!");
				// r1
				// not
				// closer
				// than
				// r2
				// and
				// r2
				// not
				// closer
				// than
				// r1,
				// so
				// thaey
				// are
				// equal
			}
		}
		System.out.println("Game Over!");// end
	}
}
