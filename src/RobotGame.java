

import java.io.*;


public class RobotGame {

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to the Robot Game Simulator!");

			System.out.println("Enter the name of the first robot:");
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			String firstName = "";
			while (true) {
				firstName = br.readLine();
				if (firstName != null && firstName.length() < 10) {
					break;
				} else {
					System.out.println("Enter the name of the first robot, maximum 10 letters!");
				}
			}

			System.out.println("Enter the direction of the first robot: Up, Right or Diagonal");
			String firstDirection = "";
			while (true) {
				firstDirection = br.readLine();
				if (firstDirection != null && (firstDirection.equals("Up") || firstDirection.equals("Right")
						|| firstDirection.equals("Diagonal"))) {
					break;
				} else {
					System.out.println("Enter the direction of the first robot: Up, Right or Diagonal");
				}
			}
			Robot firstRobot = new Robot(firstName, firstDirection);
			// System.out.println("First robot has been created:" + firstRobot);

			System.out.println("Enter the name of the second robot:");
			String secondName = "";
			while (true) {
				secondName = br.readLine();
				if (secondName != null && secondName.length() < 10) {
					break;
				} else {
					System.out.println("Enter the name of the second robot, maximum 10 letters!");
				}
			}

			System.out.println("Enter the direction of the second robot: Up, Right or Diagonal");
			String secondDirection = "";
			while (true) {
				secondDirection = br.readLine();
				if (secondDirection != null && (secondDirection.equals("Up") || secondDirection.equals("Right")
						|| secondDirection.equals("Diagonal"))) {
					break;
				} else {
					System.out.println("Enter the direction of the second robot: Up, Right or Diagonal");
				}
			}
			Robot secondRobot = new Robot(secondName, secondDirection);
			// System.out.println("Second robot has been created:" +
			// secondRobot);

			firstRobot.setCollectedPoints(2);
			secondRobot.setCollectedPoints(2);

			// System.out.println("firstRobotMoveNumber="+firstRobotMoveNumber);
			// System.out.println("secondRobotMoveNumber="+secondRobotMoveNumber);

			System.out.println("Simulation started!");
			System.out.println(firstRobot);
			System.out.println(secondRobot);

			boolean isFirstReach = false;
			boolean isSecondReach = false;
			boolean hasFirstQuit=false;
			boolean hasSecondQuit=false;
			int newSteps = 1;
			int newDirection = 1;
			
			while (true) {

				if(isFirstReach == true && isSecondReach == true)
					break;
				System.out.println("");
				System.out.println("Move!");
				if (isFirstReach == false) {
					newSteps = (int) (Math.random() * 3 + 1);
					newDirection = (int) (Math.random() * 3 + 1);
					firstRobot.setDirection(newDirection);
					int nextX=firstRobot.getNextX(newSteps,newDirection);
					int nextY=firstRobot.getNextY(newSteps,newDirection);
					
					if(nextX==secondRobot.getX()&& nextY==secondRobot.getY()){
						firstRobot.setCollectedPoints(firstRobot.getCollectedPoints()-(nextX+nextY));
						System.out.println(firstRobot.getMoveFailMessage());
					}else{
						firstRobot.move(newSteps, newDirection);
						System.out.println(firstRobot);
					}
					if (firstRobot.getX() == 8 && firstRobot.getY() == 8) {
						isFirstReach = true;
					}
				}
				if (isSecondReach == false) {
					newSteps = (int) (Math.random() * 3 + 1);
					newDirection = (int) (Math.random() * 3 + 1);
					
					secondRobot.setDirection(newDirection);
					int nextX=secondRobot.getNextX(newSteps,newDirection);
					int nextY=secondRobot.getNextY(newSteps,newDirection);
					
					if(nextX==firstRobot.getX()&& nextY==firstRobot.getY()){
						secondRobot.setCollectedPoints(secondRobot.getCollectedPoints()-(nextX+nextY));
						System.out.println(secondRobot.getMoveFailMessage());
					}else{
						secondRobot.move(newSteps, newDirection);
						System.out.println(secondRobot);
					}
					
					if (secondRobot.getX() == 8 && secondRobot.getY() == 8) {
						isSecondReach = true;
					}
				}

				if (isFirstReach == true && hasFirstQuit==false) {
					System.out.println(
							firstRobot.getName() + " has reached the goal (" + firstRobot.getCollectedPoints() + " points)");
					hasFirstQuit=true;
				}
				if (isSecondReach == true && hasSecondQuit==false) {
					System.out.println(
							secondRobot.getName() + " has reached the goal (" + secondRobot.getCollectedPoints() + " points)");
					hasSecondQuit=true;
				}

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
