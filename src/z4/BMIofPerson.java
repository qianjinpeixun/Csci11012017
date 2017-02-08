package z4;

/*CSCI1101-LAB1-E5
   this program will write a class(BMI...) to calcuate BMI value for a person then according data
   to tell them their health conditions
   <zishen cao><B00723808><Jan.20th>*/
//create Scanner to read input
import java.util.Scanner;

public class BMIofPerson {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		// create 'person' object
		person p = new person();
		// create some variables
		String name;
		int age;
		double w1, h1;
		System.out.println("Enter the name:");
		name = i.nextLine();
		System.out.println("Enter the age:");
		age = i.nextInt();
		System.out.println("Enter the weight in pounds:");
		w1 = i.nextDouble();
		System.out.println("Enter the height in inches:");
		h1 = i.nextDouble();

		// pass values into method
		p.setName(name);
		p.setAge(age);
		p.setWeight(w1);
		p.setHeight(h1);
		if (age < 20) {
			System.out.println("The minimum age should be 20 in order to calculate the BMI");
		} 
		//还有必要加if吗？
		else if (age >= 20) {
			System.out.println("The BMI of" + name + " is" + p.findBMI());
			if (p.findBMI() < 18.5)
				System.out.println("The BMI status is Underweight");
			else if (p.findBMI() >= 18.5 && p.findBMI() < 25)
				System.out.println("The BMI status is Normal");
			else if (p.findBMI() >= 25 && p.findBMI() < 30)
				System.out.println("The BMI status is Overweight");
			else if (p.findBMI() >= 30)
				System.out.println("The BMI status is Obese");
		}
	}// end method
}// end class