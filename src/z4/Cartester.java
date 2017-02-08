package z4;

/*CSCI1101-LAB1-E5
   this program will write a class(Cartester) to give some instructions to do
   <zishen cao><B00723808><Jan.20th>*/
import java.util.Scanner;

//create Scanner to read input
public class Cartester {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);

		// create some variables
		double capacity, fuelRate, gas, distance;
		System.out.println("Enter the capacity (in liters):");
		capacity = i.nextDouble();
		System.out.println("Enter the fuel consumption rate (in lt/km):");
		fuelRate = i.nextDouble();
		System.out.println("Enter the amount of gas to fill:");
		gas = i.nextDouble();
		System.out.println("Enter the distance to drive:");
		distance = i.nextDouble();

		// pass value into 'car' method
		Car c1 = new Car(capacity, fuelRate);

		// pass value to 'fill','drive' method
		c1.fill(gas);
		c1.drive(distance);
	}// end method
}// end class
