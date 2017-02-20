package z62.lab3;

/*CSCI 1101-Lab 3-E2
This class set data for PizzaDemo class.
<Wenyi Zhang><B00732630><2017.Feb.1st>*/
public class Pizza {
	private int number;
	private static double cost = 0.0;
	private static int totalNum;
	private static double totalSales;

	// constructor method
	public Pizza() {
		number = 0;
	}

	// set method
	public void setNumber(int n) {
		number = n;
	}

	public static void setCost(double c) {
		cost = c;
	}

	// justSold method
	public void justSold(int num) {
		number += num;
		totalNum += num;
		totalSales += num * cost;
	}

	// get method
	public int getNumber() {
		return number;
	}

	public static double getCost() {
		return cost;
	}

	public static int getTotalNum() {
		return totalNum;
	}

	public static double getTotalSales() {
		return totalSales;
	}
}// end
