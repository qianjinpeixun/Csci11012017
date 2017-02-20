package z62.lab1;

/*CSCI 1101-Lab 1-E5
This program models the amount of gas required by the car to drive a certain distance.
<Wenyi Zhang><B00732630><2017.Jan.19>*/
public class Car {
	private double capacity;
	private double amount;
	private double fuel;

	public Car(double c, double f) {// double three data
		capacity = c;
		fuel = f;
		amount = 0;
	}

	public void setCapacity(double c) {
		capacity = c;
	}

	public void setAmount(double a) {
		amount = a;
	}

	public void setFuel(double f) {
		fuel = f;
	}

	public double getCapacity() {// return the capacity
		return capacity;
	}

	public double getAmount() {// return the amount
		return amount;
	}

	public double getFuel() {// return the fuel
		return fuel;
	}
	
	//为什么是g〉cpacity呢？
	

	public void fill(double g) {// if, else
		if (g > capacity)
			System.out.println("Cannot fill, Exceed capacity.");
		else
			amount += g;
	}

	//没有考虑amount
	public void drive(double d) {
		if (d * fuel > capacity || amount == 0) {
			System.out.println("Cannot drive. Not enough gases.");
		} else
			amount = (d * fuel);
		System.out.println("Gas remaining in tank: " + amount);
	}
}// end