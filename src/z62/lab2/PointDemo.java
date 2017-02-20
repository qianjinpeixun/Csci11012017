package z62.lab2;

import java.util.Scanner;

public class PointDemo {
	// This question is finding the highest point in those four points, the
	// distance between point1 and point2, the distance between point3 and
	// point4, and the longer distance.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the x and y coordinates of point1: ");
		Point p1 = new Point(kb.nextInt(), kb.nextInt());
		System.out.print("Enter the x and y coordinates of point2: ");
		Point p2 = new Point(kb.nextInt(), kb.nextInt());
		System.out.print("Enter the x and y coordinates of point3: ");
		Point p3 = new Point(kb.nextInt(), kb.nextInt());
		System.out.print("Enter the x and y coordinates of point4: ");
		Point p4 = new Point(kb.nextInt(), kb.nextInt());
		// find some input point is equal
		if (p1.equals(p2) || p1.equals(p3) || p1.equals(p4) || p2.equals(p3) || p2.equals(p4) || p3.equals(p4))
			System.out.println(
					"There are more than one point in the same place. \nWe will report any one point of these, only if the point is the highest. ");
		//排序
		
		// the highest point
		if (p1.isHigher(p2) && p1.isHigher(p3) && p1.isHigher(p4))
			System.out.println(p1 + " is the highest point");
		else if (p2.isHigher(p1) && p2.isHigher(p3) && p2.isHigher(p4))
			System.out.println(p2 + " is the highest point");
		else if (p3.isHigher(p1) && p3.isHigher(p2) && p1.isHigher(p4))
			System.out.println(p3 + " is the highest point");
		else if (p4.isHigher(p1) && p4.isHigher(p2) && p4.isHigher(p3))
			System.out.println(p4 + " is the highest point");
		// the distance
		double d12 = Point.findDistance(p1, p2);
		double d34 = Point.findDistance(p3, p4);
		System.out.println("The distance between " + p1 + " and " + p2 + " is " + d12);
		System.out.println("The distance between " + p3 + " and " + p4 + " is " + d34);
		// the longer distance
		if (d12 > d34)
			System.out.println(p1 + " --> " + p2 + " is longer than " + p3 + " --> " + p4);
		else if (d34 > d12)
			System.out.println(p3 + " --> " + p4 + " is longer than " + p1 + " --> " + p2);
		else
			System.out.println("The distance between " + p1 + " and " + p2 + " is equal to the distance between " + p3
					+ " and " + p4);
	}
}// end
