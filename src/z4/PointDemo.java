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

		/*
		 * Point highestPoint; if(point1.isHigher(point2)) highestPoint=point1;
		 * else highestPoint=point2;
		 * 
		 * if(point3.isHigher(highestPoint)) highestPoint=point3;
		 * if(point4.isHigher(highestPoint)) highestPoint=point4;
		 * 
		 * System.out.println("["+highestPoint.getXp()+","+highestPoint.getYp()
		 * +"] is highest!");
		 * 
		 */
		if ((point1.isHigher(point2) && point3.isHigher(point4) && point1.isHigher(point3))
				|| (point1.isHigher(point2) && point4.isHigher(point3) && point1.isHigher(point4)))
			System.out.println("Point 1 is the highest point.");
		else if ((point1.isHigher(point2) && point3.isHigher(point4) && point3.isHigher(point1))
				|| (point1.isHigher(point2) && point3.isHigher(point4) && point3.isHigher(point1)))
			System.out.println("Point 3 is the highest point.");
		else if ((point2.isHigher(point1) && point3.isHigher(point4) && point2.isHigher(point3))
				|| (point2.isHigher(point1) && point4.isHigher(point3) && point2.isHigher(point4)))
			System.out.println("Point 2 is the highest point.");
		else if ((point1.isHigher(point2) && point4.isHigher(point3) && point4.isHigher(point1))
				|| (point2.isHigher(point1) && point4.isHigher(point3) && point4.isHigher(point2)))
			System.out.println("Point 4 is the highest point.");

		System.out.println(point1.toString(point2));
		System.out.println(point3.toString(point4));
		// conditions to find longer distance between the line 1st and 2nd ,3rd
		// and 4th
		if (point1.findDistance(point2) > point3.findDistance(point4))
			System.out.println("[" + x1 + "," + y1 + "]" + "-->" + "[" + x2 + "," + y2 + "] is longer than " + "[" + x3
					+ "," + y3 + "]-->" + "[" + x4 + "," + y4 + "]");
		else if (point1.findDistance(point2) == point3.findDistance(point4))
			System.out.println("[" + x1 + "," + y1 + "]" + "-->" + "[" + x2 + "," + y2 + "] equals " + "[" + x3 + ","
					+ y3 + "]-->" + "[" + x4 + "," + y4 + "]");
		else if (point1.findDistance(point2) < point3.findDistance(point4))
			System.out.println("[" + x3 + "," + y3 + "]" + "-->" + "[" + x4 + "," + y4 + "] is longer " + "[" + x1 + ","
					+ y1 + "]-->" + "[" + x2 + "," + y2 + "]");
	}
}
