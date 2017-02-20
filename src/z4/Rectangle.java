package z4;



public class Rectangle {
	
	public Rectangle(){
		
	}
	public Rectangle(double width,double height){
		this.height=height;
		this.width=width;
	}

	
	private double width;
	private double height;

	// some 'set' methods to hold value
	public void setWidth(double w1) {
		width = w1;
	}

	public void setHeight(double h1) {
		height = h1;
	}

	// some 'get' methods to hold value
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	// 'findArea' method to calcuate area of a circle
	public double findArea() {
		return height * width;
	}

	// 'findP' method to find perimeter
	public double findPerimeter() {
		return 2 * width + 2 * height;
	}

	public String toString1111() {
		return "Height="+height + " Width="+width;
	}// end method
}// end class
