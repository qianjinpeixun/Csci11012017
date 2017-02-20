package z62.lab1;

/*CSCI 1101-Lab 1-E4
This program determine the BMI of a person.
<Wenyi Zhang><B00732630><2017.Jan.19>*/
public class Person {// Person.java
	private String name;
	private int age;
	private double weight; // in pounds
	private double height; // in inches
	private double bmi = 0.0;
	// constants for use in the formula
	public final double KILOGRAMS_PER_POUND = 0.45359237;
	public final double METERS_PER_INCH = 0.0254;

	public Person() {
	}

	public Person(String n, int a, double w, double h) {
		name = n;
		age = a;
		weight = w;
		height = h;
		this.bmi += bmi;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public double getBMI() {
		return bmi;
	}

	public void setName(String n) {
		name = n;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setWeight(double w) {
		weight = w;
	}

	public void setHeight(double h) {
		height = h;
	}

	// calculates the body mass index and sets the variable bmi to that value.
	public double calcBMI() {
		bmi = (weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH)));
		bmi = Math.round(bmi * 100) / 100.0;
		return bmi;
	}

	// method to returns the status
	public String findStatus() {
		if (age < 20)
			return "\nThe minimum age should be 20 in order to calculate the BMI.";
		else {
			if (bmi < 18.5)
				return "The BMI of " + name + " is " + bmi + "\nThe BMI status is Underweight.";
			else if (bmi >= 18.5 && bmi <= 25.0)
				return "The BMI of " + name + " is " + bmi + "\nThe BMI status is Normal.";
			else if (bmi >= 25.0 && bmi <= 30.0)
				return "The BMI of " + name + " is " + bmi + "\nThe BMI status is Overweight.";
			else
				return "The BMI of " + name + " is " + bmi + "\nThe BMI status is Obese.";
		}
	}
}
// end