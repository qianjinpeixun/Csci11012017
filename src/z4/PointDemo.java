package z4;

//Scanner to read input
import java.util.Scanner;

public class PointDemo {
	public static void main(String[] args) {
		Point point1, point2, point3, point4;
		Scanner i = new Scanner(System.in);
		System.out.println("Enter the X and Y coordinate for point1: ");
		int x1 = i.nextInt();
		int y1 = i.nextInt();
		
		point1 = new Point(x1, y1);

		
		System.out.println("Enter the X and Y coordinate for point2: ");
		int x2 = i.nextInt();
		int y2 = i.nextInt();
		point2 = new Point(x2, y2);
		System.out.println("Enter the X and Y coordinate for point3: ");
		int x3 = i.nextInt();
		int y3 = i.nextInt();
		point3 = new Point(x3, y3);
		System.out.println("Enter the X and Y coordinate for point4: ");
		int x4 = i.nextInt();
		int y4 = i.nextInt();
		// create point object
		point4 = new Point(x4, y4);
		// conditions to find highest point
		// 排序问题，可以优化
		
		Point point5;
		if(point1.isHigher(point2))
			point5=point1;
		else 
			point5=point2;
		
		if(point3.isHigher(point5))
			point5=point3;
		
		if(point4.isHigher(point5))
			point5=point4;
		System.out.println(point5);
		
//		point5 is highest

	}
}
