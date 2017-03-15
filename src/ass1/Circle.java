package ass1;

import java.util.ArrayList;

public class Circle {
	private double cx;
	private double cy;
	double radius;

	public Circle(double cx, double cy, double radius) {
		this.cx = cx;
		this.cy = cy;
		this.radius = radius;
	}

	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
	}

	public double getCy() {
		return cy;
	}

	public void setCy(double cy) {
		this.cy = cy;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String toString() {
		ArrayList list=new ArrayList();
		
		
		return "Circle with center " + cx + "," + cy + " and radius " + radius;
	}

	public boolean encloses(Point p) {
		double d;

		d = Math.sqrt(((p.getPx() - cx) * (p.getPx() - cx)) + ((p.getPy() - cy) * (p.getPy() - cy)));
		if (d < radius)
			return true;
		else
			return false;
	}

	public boolean touchExternally(Circle c2) {
		boolean ret = false;
		double d = Math.sqrt(((c2.getCx() - cx) * (c2.getCx() - cx)) + ((c2.getCy() - cy) * (c2.getCy() - cy)));
		double radius_sum = radius + c2.getRadius();
		if (d == radius_sum)
			ret=true;
		else
			ret=false;
		return ret;
	}

	public boolean touchInternally(Circle c2) {
		boolean ret = false;
		double d = Math.sqrt(((c2.getCx() - cx) * (c2.getCx() - cx)) + ((c2.getCy() - cy) * (c2.getCy() - cy)));
		double radius_sum =Math.abs( radius - c2.getRadius());
		if (d == radius_sum)
			ret=true;
		else
			ret=false;
		return ret;
	}
}
