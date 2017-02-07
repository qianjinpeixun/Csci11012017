package st4;

public class Robot {
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	private String name;
	private int x;
	private int y;
	private int direction;
	private int points;

	// sets the name and the direction it faces to user-given values.
	public Robot(String name1, int direction1) {
		this.name = name1;
		this.direction = direction1;
		// set the x and y positions to (1,1) and the points collected to 0.
		this.x = 1;
		this.y = 1;
		this.points = 0;
	}

	public void move(int numberOfSteps) {

		// moves the robot by the given number of steps in the direction it
		// faces
		if (direction == 1)
			y = y + numberOfSteps;
		else if (direction == 2)
			x = x + numberOfSteps;
		else {
			x = x + numberOfSteps;
			y = y + numberOfSteps;
		}

	}

	public String toString() {
		if (direction == 1)
			return name + "   (" + x + "," + y + ")   Up    " + points + " points";
		else if (direction == 2)
			return name + "   (" + x + "," + y + ")   Right " + points + " points";
		else
			return name + "   (" + x + "," + y + ")   Diag  " + points + " points";
	}

	public boolean amIAhead(int x1, int y1) {
		// add the x and y values and see which is larger.
		if ((x + y) > (x1 + y1))
			return true;
		else
			return false;
	}

}
