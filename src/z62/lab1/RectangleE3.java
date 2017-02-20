package z62.lab1;

/*CSCI 1101-Lab 1-E3
This program Make the following changes to Rectangle.java and RectangleDemo.java
<Wenyi Zhang><B00732630><2017.Jan.19>*/
public class RectangleE3 {
	private int width;
	private int length;

	public RectangleE3(int width, int length) {
		this.width = width;
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public int findArea() {
		return width * length;
	}

	public int findPerimeter() {
		return 2 * width + 2 * length;
	}

	public String toString() {
		return "Rectangle: [Length: " + length + ", Width: " + width + "]";
	}
}
