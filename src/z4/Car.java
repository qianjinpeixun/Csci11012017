package z4;

//'car' class
public class Car {
	private double capacity;
	private double fuelRate;
	private double gas;

	public Car(double c, double f) {
		capacity = c;
		fuelRate = f;
		gas = 0;
	}

	// some 'set'methods to hold value
	public void setCapacity(double c) {
		capacity = c;
	}

	public void setFuelRate(double f) {
		fuelRate = f;
	}

	public void setGas(double g) {
		gas = g;
	}

	// some 'get' methods to hold value
	public double getCapacity() {

		return capacity;
	}

	public double getFuelRate() {
		return fuelRate;
	}

	public double getGas() {

		return gas;

	}

	// 'fill' method to calcuate gas
	//加油要考虑还有多少油？
	public void fill(double g) {
		if (g > capacity)
			System.out.println("Cannot fill,Eceed capacity.");
		else
			gas += g;
	}

	// 'drive' method to calcuate drving distance,gas remaining
	//gas是否大于或者等于d*fuelRate
	public void drive(double d) {
		if (d * fuelRate > capacity || gas == 0) {
			System.out.println("Cannot drive, no enough gas.");
		} else
			gas = gas - d * fuelRate;
		System.out.println("gas remaining in tank: " + gas);
	}// end method
}// end class