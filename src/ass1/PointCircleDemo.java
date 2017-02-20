package ass1;
import java.util.Scanner;

public class PointCircleDemo {

	
	
	public static void main(String[] args) {
		Scanner keyboard =new Scanner(System.in);
		System.out.println("Enter the x and y coordinates of the point: ");
		Point p=new Point(keyboard.nextDouble(),keyboard.nextDouble());
		System.out.println("Enter the center corrdinates (x,y) of circle and its radius: ");
		Circle c=new Circle(keyboard.nextDouble(),keyboard.nextDouble(),keyboard.nextDouble());
		if(c.encloses(p))
			System.out.println(c+ " encloses "+p);
		else
			System.out.println(c+"does not enclose "+p);
	}

}
