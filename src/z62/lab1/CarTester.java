package z62.lab1;

/*CSCI 1101-Lab 1-E5
This program models the amount of gas required by the car to drive a certain distance.
<Wenyi Zhang><B00732630><2017.Jan.19>*/
import java.util.Scanner;

public class CarTester {// the methord
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double c, f;
		System.out.print("Enter the capacity (in liters): ");// enter the
																// capacity
		c = kb.nextDouble();
		System.out.print("Enter the fuel consumption rate (in lt/km): ");// enter
																			// the
																			// fuel
		f = kb.nextDouble();
		Car car = new Car(c, f);
		double fill, distance;
		System.out.print("Enter the amount of gas to fill: ");// enter the fill
		fill = kb.nextDouble();
		System.out.print("Enter the distance to drive: ");// enter the distance
		distance = kb.nextDouble();
		System.out.println("");
		car.fill(fill);
		car.drive(distance);
	}
}// end