package z4;

/*CSCI1101-LAB1-E4
 this program will write a class(Rectangle) to calcuate area and perimeter of a square
    <zishen cao><B00723808><Jan.20th>*/
import java.util.Scanner;

//create Scanner to read input
public class RectangleDemo {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		// create some variables
		double w1, h1;
		// create 'rectangle' object
		Rectangle rt1;
		rt1 = new Rectangle();
		System.out.println("Enter width and height of the rectangle:");
		w1 = i.nextDouble();
		h1 = i.nextDouble();

		// pass value into method
		rt1.setWidth(w1);
		rt1.setHeight(h1);
		System.out.println(rt1.toString());
		System.out.println("Area (rectangle1): " + rt1.findArea() + " square units");
		System.out.println("Perimeter (rectangle1): " + rt1.findPerimeter() + " units");

	}// end method

}// end class
