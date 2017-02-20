package z62.lab1;

/*CSCI 1101-Lab 1-E4
This program determine the BMI of a person.
<Wenyi Zhang><B00732630><2017.Jan.19>*/
import java.util.Scanner;//BMIDemo.java

public class BMIDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String n = keyboard.nextLine();
		System.out.print("Enter the age: ");
		int a = keyboard.nextInt();
		System.out.print("Enter the weight (in pounds): ");
		double w = keyboard.nextDouble();
		System.out.print("Enter the height (in inches): ");
		double h = keyboard.nextDouble();
		Person pers = new Person(n, a, w, h);
		System.out.println(pers.calcBMI());
		System.out.println(pers.findStatus());
	}
}
