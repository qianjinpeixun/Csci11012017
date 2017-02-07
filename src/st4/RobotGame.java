package st4;

import java.util.Scanner;

public class RobotGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the first robot: ");
		String nameOne = scanner.nextLine();
		System.out.println("Enter the direction of the first robot: ");
		String directionOne = scanner.nextLine();
		System.out.println("Enter the name of the second robot: ");
		String nameTwo = scanner.nextLine();
		System.out.println("Enter the direction of the second robot: ");
		String directTwo = scanner.nextLine();

		Robot robotOne;
		if (directionOne.equals("Up"))
			robotOne = new Robot(nameOne, 1);
		else if (directionOne.equals("Right"))
			robotOne = new Robot(nameOne, 2);
		else
			robotOne = new Robot(nameOne, 3);

		Robot robotTwo;
		if (directionOne.equals("Up"))
			robotTwo = new Robot(nameTwo, 1);
		else if (directionOne.equals("Right"))
			robotTwo = new Robot(nameTwo, 2);
		else
			robotTwo = new Robot(nameTwo, 3);

		robotOne.setPoints(2);
		robotTwo.setPoints(2);

		System.out.println("Simulation started!");
		System.out.println(robotOne.toString());
		System.out.println(robotTwo.toString());
		System.out.println("");

		boolean showOneReach = false;
		boolean showTwoReach = false;
		boolean showAheadOne=false;
		boolean showAheadTwo=false;
		while (true) {

			if (robotOne.getX() == 8 && robotOne.getY() == 8 && robotTwo.getX() == 8 && robotTwo.getY() == 8)
				break;
			System.out.println("move!");

			int min = 1;
			int max = 3;
			int newDirectionOne = (int) (Math.random() * (max - min) + 1) + min;
			int newDirectionTwo = (int) (Math.random() * (max - min) + 1) + min;
			int stepsOne = (int) (Math.random() * (max - min) + 1) + min;
			int stepsTwo = (int) (Math.random() * (max - min) + 1) + min;

			//System.out.println("d1="+newDirectionOne+",d2="+newDirectionTwo+",s1="+stepsOne+",s2="+stepsTwo);
			
			
			int newXOne = robotOne.getX();
			int newYOne = robotOne.getY();
			int newXTwo = robotTwo.getX();
			int newYTwo = robotTwo.getY();
			robotOne.setDirection(newDirectionOne);
			robotTwo.setDirection(newDirectionTwo);

			// Robot One start to move
			if (newDirectionOne == 1) {
				if ((robotOne.getY() + stepsOne) >= 8)
					newYOne = 8;
				else
					newYOne = robotOne.getY() + stepsOne;
			} else if (newDirectionOne == 2) {
				if ((robotOne.getX() + stepsOne) >= 8)
					newXOne = 8;
				else
					newXOne = robotOne.getX() + stepsOne;
			} else {
				if ((robotOne.getY() + stepsOne) >= 8)
					newYOne = 8;
				else
					newYOne = robotOne.getY() + stepsOne;

				if ((robotOne.getX() + stepsOne) >= 8)
					newXOne = 8;
				else
					newXOne = robotOne.getX() + stepsOne;
			}

			// If a robot A’s move falls into a box (x,y) which is already
			// occupied by another robot,
			// deduct x+y points from A and do not move A from its current
			// position

			if (newXOne == 8 && newYOne == 8) {
				robotOne.setX(8);
				robotOne.setY(8);
				robotOne.setPoints(robotOne.getPoints() + (8 - robotOne.getX()) + (8 - robotOne.getY()));
				if (showOneReach == false) {
					System.out.println(
							robotOne.getName() + " has reached the goal" + "(" + robotOne.getPoints() + " points)");
					showOneReach = true;
				}
			} else {
				if (newXOne == robotTwo.getX() && newYOne == robotTwo.getY()) {
					robotOne.setPoints(robotOne.getPoints() - newXOne - newYOne);
				} else {

					robotOne.move(stepsOne);
					if (robotOne.getX() > 8)
						robotOne.setX(8);
					if (robotOne.getY() > 8)
						robotOne.setY(8);
					//??? if getX==8 && direction=Right 
					robotOne.setPoints(robotOne.getPoints() + newXOne + newYOne);
					System.out.println(robotOne.toString());

				}
			}

			// RobotTwo
			if (newDirectionTwo == 1) {
				if ((robotTwo.getY() + stepsTwo) >= 8)
					newYTwo = 8;
				else
					newYTwo = robotTwo.getY() + stepsTwo;
			} else if (newDirectionTwo == 2) {
				if ((robotTwo.getX() + stepsTwo) >= 8)
					newXTwo = 8;
				else
					newXTwo = robotTwo.getX() + stepsTwo;
			} else {
				if ((robotTwo.getY() + stepsTwo) >= 8)
					newYTwo = 8;
				else
					newYTwo = robotTwo.getY() + stepsTwo;

				if ((robotTwo.getX() + stepsTwo) >= 8)
					newXTwo = 8;
				else
					newXTwo = robotTwo.getX() + stepsTwo;
			}

			// If a robot A’s move falls into a box (x,y) which is already
			// occupied
			// by another robot,
			// deduct x+y points from A and do not move A from its current
			// position

			if (newXTwo == 8 && newYTwo == 8) {
				robotTwo.setX(8);
				robotTwo.setY(8);

				robotTwo.setPoints(robotTwo.getPoints() + newXTwo + newYTwo);
				if (showTwoReach == false) {
					System.out.println(
							robotTwo.getName() + " has reached the goal" + "(" + robotTwo.getPoints() + " points)");
					showTwoReach = true;
				}
			} else {
				if (newXTwo == robotOne.getX() && newYTwo == robotOne.getY()) {
					robotTwo.setPoints(robotTwo.getPoints() - newXTwo - newYTwo);
				} else {
					robotTwo.move(stepsTwo);
					if (robotTwo.getX() > 8)
						robotTwo.setX(8);
					if (robotTwo.getY() > 8)
						robotTwo.setY(8);
					robotTwo.setPoints(robotTwo.getPoints() + newXTwo + newYTwo);
					System.out.println(robotTwo.toString());

				}
			}

			if (robotOne.amIAhead(robotTwo.getX(), robotTwo.getY()) == true  ) {
				if(showOneReach==false){
					System.out.println(robotOne.getName() + " ahead!");
				}
			} else if (robotTwo.amIAhead(robotOne.getX(), robotOne.getY()) == true ) {
				if(showTwoReach==false){
					System.out.println(robotTwo.getName() + " ahead!");
				}
			} else{
				if(showOneReach==false||showTwoReach==false)
				System.out.println("Both are at the same distance from the goal!");
			}
			System.out.println("");
		}
		
		System.out.println("Game over!");

	}

}
