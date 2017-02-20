package ass1;

import java.io.*;

/**
 * 
 * RobotGame.java class that contains the main method to test the above class
 * and run a simple simulation game using two robots as follows: Prompt the user
 * to enter the name and direction for two robots and create the two robots.
 * Next, move each robot 1, 2 or 3 steps by generating random numbers. Collect
 * points for each move according to the following rules: 1. At the start, each
 * robot earns 1+1=2 points for being in the box (1,1). 2. If a robot moves into
 * a box (x,y) collect x+y points for that robot and add it to the current
 * number of points. 3. If a robot A’s move falls into a box (x,y) which is
 * already occupied by another robot, deduct x+y points from A and do not move A
 * from its current position. After each move, change the robot’s direction by
 * generating another random number from 1 to 3. (1 means direction is Up, 2
 * means Right and 3 means Diagonal). After each move, print the attributes of
 * each robot using the toString method. Also print which robot is ahead by
 * comparing using the amIAhead method. If neither one is ahead, print that they
 * are at the same distance. If one robot reaches (8,8), remove it from further
 * moves (by using a boolean variable or otherwise). Play the game by putting
 * the moves in a loop and see which robot gets to (8,8) first and which robot
 * collects the most points!
 * 
 * @author ST1
 *
 */
public class RobotGame {

	public static void main(String[] args) {

		try {
			System.out.println("Welcome to the Robot Game Simulator!");
			System.out.print("Enter the name of the first robot:");
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			String firstName = "";
			while (true) {
				firstName = br.readLine();
				if (firstName != null && firstName.length() < 10) {
					break;
				} else {
					System.out.print("Enter the name of the first robot, maximum 10 letters:");
				}
			}

			System.out.print("Enter the direction of the first robot: Up, Right or Diagonal:");
			String firstDirection = "";
			while (true) {
				firstDirection = br.readLine();
				if (firstDirection != null && (firstDirection.equals("Up") || firstDirection.equals("Right")
						|| firstDirection.equals("Diagonal"))) {
					break;
				} else {
					System.out.print("Enter the direction of the first robot: Up, Right or Diagonal:");
				}
			}

			// Got name and default direction, create the first Robot
			Robot firstRobot = new Robot(firstName, firstDirection);

			System.out.print("Enter the name of the second robot:");
			String secondName = "";
			while (true) {
				secondName = br.readLine();
				if (secondName != null && secondName.length() < 10) {
					break;
				} else {
					System.out.print("Enter the name of the second robot, maximum 10 letters:");
				}
			}

			System.out.print("Enter the direction of the second robot: Up, Right or Diagonal:");
			String secondDirection = "";
			while (true) {
				secondDirection = br.readLine();
				if (secondDirection != null && (secondDirection.equals("Up") || secondDirection.equals("Right")
						|| secondDirection.equals("Diagonal"))) {
					break;
				} else {
					System.out.print("Enter the direction of the second robot: Up, Right or Diagonal:");
				}
			}

			// Got the name and default direction, create the second Robot
			Robot secondRobot = new Robot(secondName, secondDirection);

			// the default points are 2
			firstRobot.setCollectedPoints(2);
			secondRobot.setCollectedPoints(2);

			// Start to simulate the game
			System.out.println("");
			System.out.println("Simulation started!");
			System.out.println(firstRobot);
			System.out.println(secondRobot);

			// if one robot reach (8,8),this will be true
			boolean isFirstReach = false;
			boolean isSecondReach = false;

			// if one robot reach (8,8), then it will quit the game
			boolean hasFirstQuit = false;
			boolean hasSecondQuit = false;

			// before each move, steps and direction will be generated randomly
			int newSteps = 1;
			int newDirection = 1;

			// before move, calculate the next potential position, in order to
			// check if this position is available
			int nextX = 1;
			int nextY = 1;

			// Start to run this game
			while (true) {

				// if both of two robots reach (8,8), quit the game
				if (isFirstReach == true && isSecondReach == true)
					break;
				System.out.println("");
				System.out.println("Move!");

				// the first robot start to move
				if (isFirstReach == false) {
					newSteps = (int) (Math.random() * 3 + 1);
					newDirection = (int) (Math.random() * 3 + 1);
					firstRobot.setDirection(newDirection);

					// get the potential position
					nextX = firstRobot.getNextX(newSteps);
					nextY = firstRobot.getNextY(newSteps);

					/*
					 * if the nextX==8 && nextY==8, do not need to check if the
					 * potential position occupied by another, otherwise, need
					 * to check if the next position is available.
					 * 
					 */
					if ((nextX == secondRobot.getX() && nextY == secondRobot.getY()) && (nextX != 8 && nextY != 8)) {
						// If a robot A’s move falls into a box (x,y) which is
						// already occupied by another robot, deduct x+y points
						// from A and do not move A from its current position.
						firstRobot.setCollectedPoints(firstRobot.getCollectedPoints() - (nextX + nextY));
						System.out.println(firstRobot.getMoveFailMessage());
					} else {
						firstRobot.move(newSteps);
						System.out.println(firstRobot);
					}
					if (firstRobot.getX() == 8 && firstRobot.getY() == 8) {
						isFirstReach = true;
					}
				}

				// start to move second robot
				if (isSecondReach == false) {
					newSteps = (int) (Math.random() * 3 + 1);
					newDirection = (int) (Math.random() * 3 + 1);

					secondRobot.setDirection(newDirection);
					nextX = secondRobot.getNextX(newSteps);
					nextY = secondRobot.getNextY(newSteps);

					if ((nextX == firstRobot.getX() && nextY == firstRobot.getY()) && (nextX != 8 && nextY != 8)) {
						secondRobot.setCollectedPoints(secondRobot.getCollectedPoints() - (nextX + nextY));
						System.out.println(secondRobot.getMoveFailMessage());
					} else {
						secondRobot.move(newSteps);
						System.out.println(secondRobot);
					}
					if (secondRobot.getX() == 8 && secondRobot.getY() == 8) {
						isSecondReach = true;
					}
				}

				// only print once for reaching the goal
				if (isFirstReach == true && hasFirstQuit == false) {
					System.out.println(firstRobot.getName() + " has reached the goal ("
							+ firstRobot.getCollectedPoints() + " points)");
					hasFirstQuit = true;
				}
				if (isSecondReach == true && hasSecondQuit == false) {
					System.out.println(secondRobot.getName() + " has reached the goal ("
							+ secondRobot.getCollectedPoints() + " points)");
					hasSecondQuit = true;
				}

				/*
				 * print which robot is ahead by comparing using the amIAhead
				 * method. If neither one is ahead, print that they are at the
				 * same distance.
				 */
				if (isFirstReach == false && isSecondReach == false) {
					if (firstRobot.AmIAhead(secondRobot) == true) {
						System.out.println(firstRobot.getName() + " ahead!");
					} else if (secondRobot.AmIAhead(firstRobot) == true) {
						System.out.println(secondRobot.getName() + " ahead!");
					} else {
						System.out.println("Both are at the same distance from the goal!");
					}
				}

			}

			System.out.println("");
			System.out.println("Game over!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
