package z4;

public class Circle {
	// instance variables
	private double cx;
	private double cy;
	private double radius;

	// constructor
	public Circle(double cx, double cy, double radius) {
		this.cx = cx;
		this.cy = cy;
		this.radius = radius;
	}

	// get and set methods
	public void setCX(double cx) {
		this.cx = cx;
	}

	public void setCY(double cy) {
		this.cy = cy;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getCX() {
		return cx;
	}

	public double getCY() {
		return cy;
	}

	public double getRadius() {
		return radius;
	}

	// Point class
	// Defines a point with coordinates px and py
	public class Point {
		private double px;
		private double py;

		// constructor
		public Point(double px, double py) {
			this.px = px;
			this.py = py;
		}

		// get and set methods
		public void setX(double px) {
			this.px = px;
		}

		public void setY(double py) {
			this.py = py;
		}

		public double getX() {
			return px;
		}

		public double getY() {
			return py;
		}

		// toString method
		public String toString() {
			return "[px = " + px + ",py = " + py + "]";
		}
	}

	public String toString() {
		return "Circle with center " + cx + "," + cy + " and radius " + radius;
	}

	// encloses,if distance between two circles is equal to sum of circle's
	// radius,or difference is equal to the subtraction of circle's radius
	public boolean encloses(Circle c) {
		double d;
		d = Math.sqrt(((c.getCX() - cx) * (c.getCX() - cx)) + ((c.getCY() - cy) * (c.getCY() - cy)));
		if (d == this.radius + c.getRadius()
				|| d == Math.max(this.radius, c.getRadius()) - Math.min(this.radius, c.getRadius()))
			return true;
		else
			return false;
	}
}
