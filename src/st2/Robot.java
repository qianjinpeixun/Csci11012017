package st2;

//The atiibute of Robot
public class Robot {
	// instance variable
	private String name;
	private int px;
	private int py;
	private int direction;
	private int numOfPoint;

	// constructors
	public Robot(String n, int d) {
		name = n;
		direction = d;
		px = 1;
		py = 1;
		numOfPoint = 0;
	}

	// getMethod(Accessor)
	public int getX() {
		return px;
	}

	public int getY() {
		return py;
	}

	public String getName() {
		return name;
	}

	public int getDirection() {
		return direction;
	}

	public int getNumOfPoint() {
		return numOfPoint;
	}

	// setMethod(Mutator)
	public void setX(int x) {
		px = x;
	}

	public void setY(int y) {
		py = y;
	}

	public void setDirection(int d) {
		direction = d;
	}

	public void setName(String n) {
		name = n;
	}

	public void setNumOfPoint(int p) {
		numOfPoint = p;
	}

	// move method
	public void move(int s) {
		if (direction == 0) {// move to up
			if (py + s <= 8)
				py += s;// make sure it is in box (8,8)
			numOfPoint = numOfPoint + px + py;// record points
		} else if (direction == 1) {// move to right
			if (px + s <= 8)
				px += s;
			numOfPoint = numOfPoint + px + py;
		} else if (direction == 2) {// move to diagonal
			if (py + s <= 8 && px + s <= 8) {
				py += s;
				px += s;
			}
			numOfPoint = numOfPoint + px + py;
		} else
			System.out.println("Error! Wrong direction!");
	}

	// toString
	public String toString() {
		String d;
		if (direction == 0)
			d = "up";
		else if (direction == 1)
			d = "right";
		else
			d = "diagonal";
		return name + "\t (" + px + "," + py + ")\t " + d + "\t" + numOfPoint + " points";
	}

	// amIAHead method
	public boolean amIAhead(Robot r) {
		return (this.px + this.py > r.getX() + r.getY());
	}

	// deDuct method happened when box is occupyed
	public void deDuct(Robot r, int s) {
		if (this.px != 8 && this.py != 8) {// make sure not in 8,8
			if (this.getX() == r.getX() && this.getY() == r.getY()) {
				if (direction == 0) {// move to up
					numOfPoint = numOfPoint - px - py;// deduct point
					py -= s;// back to last loaction
					numOfPoint = numOfPoint - px - py;// subract point added
				} else if (direction == 1) {// move to right
					numOfPoint = numOfPoint - px - py;
					px -= s;
					numOfPoint = numOfPoint - px - py;
				} else if (direction == 2) {// move to diagonal
					numOfPoint = numOfPoint - px - py;
					py -= s;
					px -= s;
					numOfPoint = numOfPoint - px - py;
				}
			}
		}
	}
}