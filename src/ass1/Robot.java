package ass1;

/**
 * The objective is to build a simple robot game where the robots are modeled as
 * objects and move around in a 2- dimensional grid as shown in the diagram
 * below. The position of the robot is expressed as x- and ycoordinates, which
 * can take any value within the limits of the grid. The goal of the game is to
 * move the robot so that reaches the grid number (8,8) from grid number (1,1).
 * The robot also faces one of three directions (Up, Right or Diagonal). It can
 * move one, two or three steps in the direction it faces. It can also collect
 * points as it moves across the grid.
 * 
 * @author ST1
 *
 */

public class Robot {

	private String name = "";
	private int x = 1;
	private int y = 1;
	private int direction = 1;
	private int collectedPoints;

	/**
	 * 
	 * Constructor that sets the name and the direction it faces to user-given
	 * values. The constructor should also set the x and y positions to (1,1)
	 * and the points collected to 0.
	 * 
	 * @param name
	 * @param direction
	 */
	public Robot(String name, String direction) {
		this.name = name;
		if (direction.equals("Up"))
			this.direction = 1;
		else if (direction.equals("Right"))
			this.direction = 2;
		else if (direction.equals("Diagonal"))
			this.direction = 3;
		else // if the input is incorrect, set default direction to Up
			this.direction = 1;

		this.x = 1;
		this.y = 1;
		this.collectedPoints = 0;

	}

	/**
	 * According to the steps, calculate the next X point, need to considerate
	 * the direction
	 * 
	 * @param steps
	 * @return
	 */
	public int getNextX(int steps) {
		int newX = x;
		if (direction == 1) {
			newX = x;
		} else if (direction == 2) {
			newX = x + steps;
		} else {
			newX = x + steps;
		}
		return newX;
	}

	/**
	 * According to the steps, calculate the next Y point, need to considerate
	 * the direction
	 * 
	 * @param steps
	 * @return
	 */
	public int getNextY(int steps) {
		int newY = y;
		if (direction == 1) {
			newY = y + steps;
		} else if (direction == 2) {
			newY = y;
		} else {
			newY = y + steps;
		}
		return newY;
	}

	/**
	 * 
	 * moves the robot by the given number of steps in the direction it faces.
	 * 
	 * @param steps
	 * @param direction
	 */
	public void move(int steps) {
		if (direction == 1) {
			y = y + steps;
		} else if (direction == 2) {
			x = x + steps;
		} else {
			y = y + steps;
			x = x + steps;
		}
		if (x > 8)
			x = 8;
		if (y > 8)
			y = 8;
		collectedPoints = collectedPoints + x + y;
	}

	/**
	 * 
	 * compares the x and y coordinates of this robot with the x and y
	 * coordinates of another robot and returns true if this robot is closer to
	 * (8,8). A simple test is to just add the x and y values and see which is
	 * larger. For example, a robot at (3,3) is ahead than the robot at (1,4).
	 * As another example, a robot at (7,1) and another at (4,4) are at the same
	 * distance from (8,8).
	 * 
	 * @param anotherRobot
	 * @return
	 */
	public boolean AmIAhead(Robot anotherRobot) {
		boolean ret = false;
		int myDistance = this.x + this.y;
		int anohterDistance = anotherRobot.x + anotherRobot.y;
		if (myDistance > anohterDistance)
			ret = true;
		else
			ret = false;
		return ret;
	}

	@Override
	public String toString() {
		String nameStr = String.format("%-10s", name);
		String directionStr = "";
		if (direction == 1)
			directionStr = "Up";
		else if (direction == 2)
			directionStr = "Right";
		else
			directionStr = "Diagonal";

		directionStr = String.format("%-8s", directionStr);

		return nameStr + " (" + x + "," + y + ") " + directionStr + "    " + collectedPoints + " points";
	}

	/**
	 * If move fails, the next position has another robot, toString() is not
	 * suitable for print, in this case, toString can be replaced by this
	 * method.
	 * 
	 * @return
	 */
	public String getMoveFailMessage() {
		String nameStr = String.format("%-10s", name);
		String directionStr = String.format("%-8s", direction);

		return nameStr + " (" + x + "," + y + ") move fails   " + collectedPoints + " points";
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCollectedPoints() {
		return collectedPoints;
	}

	public void setCollectedPoints(int collectedPoints) {
		this.collectedPoints = collectedPoints;
	}

}
