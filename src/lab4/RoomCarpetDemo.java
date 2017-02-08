package lab4;

import java.util.Scanner;

public class RoomCarpetDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the dimensions of the first room:");
		double length1 = scanner.nextDouble();
		double width1 = scanner.nextDouble();
		
		System.out.print("Enter the cost per square foot of carpet:");
		double cost1 = scanner.nextDouble();
		
		System.out.print("Enter the dimensions of the second room:");
		double length2 = scanner.nextDouble();
		double width2 = scanner.nextDouble();
		
		System.out.print("Enter the cost per square foot of carpet:");
		double cost2 = scanner.nextDouble();
		
		RoomDimension roomDimension1=new RoomDimension(length1,width1);
		RoomDimension roomDimension2=new RoomDimension(length2,width2);
		
		RoomCarpet roomCarpet1=new RoomCarpet(roomDimension1,cost1);
		RoomCarpet roomCarpet2=new RoomCarpet(roomDimension2,cost2);
		
		if(roomCarpet1.costsMore(roomCarpet2)){
			System.out.println(roomCarpet1);
			System.out.println("costs more than");
			System.out.println(roomCarpet2);
			
		}else if(roomCarpet2.costsMore(roomCarpet1)){
			System.out.println(roomCarpet2);
			System.out.println("costs more than");
			System.out.println(roomCarpet1);
		}else{
			System.out.println(roomCarpet1);
			System.out.println(roomCarpet2);
			System.out.println("cost the same");

		}

	
	}

}
