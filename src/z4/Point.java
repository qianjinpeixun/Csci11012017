package z4;

/*this program will enter 4 points, than find the highest point and compare distance the line between 1st and 2nd,3rd and 4th
<zishen cao><B00723808><Jan 28th>*/
public class Point {
	private int xP;
	private int yP;

	public Point() {
	}

	// constructor
	public Point(int x, int y) {
		xP = x;
		yP = y;
	}

	// 'set' methods
	public void setXp(int x) {
		xP = x;
	}

	public void setYp(int y) {
		yP = y;
	}

	// 'get' methods
	public int getXp() {
		return xP;
	}

	public int getYp() {
		return yP;
	}

	// toString method
	public String toString(Point p) {
		return "The distance between " + "[" + this.xP + "," + this.yP + "] and [" + p.getXp() + "," + p.getYp()
				+ "] is " + findDistance(p);

	}

	// find higher point between two points
	public boolean isHigher(Point p) {
		if (this.yP < p.getYp())
			return true;
		else
			return false;
	}

	// find distance between each two points
	public double findDistance(Point p) {
		return Math.sqrt((this.yP - p.getYp()) * (this.yP - p.getYp()) + (this.xP - p.getYp()) * (this.xP - p.getYp()));

	}

	// determine if two points are the same
	public boolean equals(Point p) {
		if (this.yP == p.getYp() && this.xP == p.getXp())
			return true;
		else
			return false;
	}// end method
}// end class
