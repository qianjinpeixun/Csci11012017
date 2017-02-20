package z62.lab2;

/*CSCI 1101-Lab 2-E2
The class Point gives the calculation to PointDemo.There are Constructor method,Get and set methods,Method equals,Method isHigher and Method findDistance.
<Wenyi Zhang><B00732630><2017.Jan.24>*/
public class Point {
	private int xpos;
	private int ypos;

	// Constructor method
	public Point(int x, int y) {
		xpos = x;
		ypos = y;
	}

	// Get and set methods
	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}

	public void setX(int x) {
		xpos = x;
	}

	public void setY(int y) {
		ypos = y;
	}

	// toString method
	public String toString() {
		return "[" + xpos + "," + ypos + "]";
	}

	// equals method
	public boolean equals(Point p) {
		return (this.xpos == p.getX() && this.ypos == p.getY());
	}

	// isHigher method
	public boolean isHigher(Point p) {
		return (ypos <= p.getY());
	}

	// findDistance method
	public static double findDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
}// end
