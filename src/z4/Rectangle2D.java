package z4;

/*this program will determine a point and a rectangle is inside a rectangle or not, and find its area and permimeter
 * <zishen cao><B00723808><Jan 28th>*/
public class Rectangle2D {
	// create variables
	private double xpos;
	private double ypos;
	private double width;
	private double height;

	// create constructor
	public Rectangle2D(double x, double y, double w, double h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
	}

	// set methods
	public void setXpos(double x) {
		xpos = x;
	}

	public void setYpos(double y) {
		ypos = y;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setHeight(double h) {
		height = h;
	}

	// get methods
	public double getXpos() {
		return xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	// find area of rectangle

	// 函数参数或者参数中的局部变量和成员变量同名的情况下，成员变量被屏蔽，此时要访问成员变量则需要用"this.成员变量名"来访问成员变量

	public double getArea(double w, double h) {
		return this.getWidth() * this.getHeight();
	}

	// find permimeter of a rectangle
	public double getPerimeter(double w, double h) {
		return (this.getWidth() + this.getHeight()) * 2;
	}

	// determine a point weather in the rectangle or not
	
	
	public boolean contains(double x, double y) {
		if (x > this.xpos && y > this.ypos && (x < (this.xpos + x)) && (y < (this.width + this.height)))
			return true;
		else
			return false;
	}

	// determine a rectangle is in the rectangle or not
	//&   &&的区别
	public boolean contains(Rectangle2D r) {
		return ((r.getXpos()) >= this.xpos & (r.getYpos()) >= this.getYpos()
				&& (r.xpos + r.getWidth()) <= (this.xpos + this.getWidth())
				&& (r.getYpos() + r.getHeight()) <= (this.ypos + this.height));

	}// end method
}// end class
