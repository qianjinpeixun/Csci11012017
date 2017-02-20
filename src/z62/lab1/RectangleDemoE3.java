package z62.lab1;

/*CSCI 1101-Lab 1-E3
This program Make the following changes to Rectangle.java and RectangleDemo.java
<Wenyi Zhang><B00732630><2017.Jan.19>*/
import java.util.Scanner;//RectangleDemo.java

public class RectangleDemoE3 {
	public static void main(String[] args) {
		RectangleE3 rect;
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter length and width of the rectangle: ");
		int length = kb.nextInt();
		int width = kb.nextInt();
		rect = new RectangleE3(length, width);
		System.out.println(rect);
		System.out.println("Area: " + rect.findArea());
		System.out.println("Perimeter: " + rect.findPerimeter());
	}
}
