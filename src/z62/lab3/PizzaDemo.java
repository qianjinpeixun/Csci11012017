package z62.lab3;

import java.util.Scanner;
import java.util.ArrayList;

public class PizzaDemo {
	// This class use the data set from PizzaStand class to claculate the total
	// pizza and total sales.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ArrayList<Pizza> pizza = new ArrayList<Pizza>();
		int num, stand, totalNum;
		double cost, totalSales;
		System.out.print("The cost of pizza : ");
		cost = kb.nextDouble();
		Pizza.setCost(cost);
		System.out.print("How many stands? ");
		stand = kb.nextInt();
		// initialize Pizza
		for (int i = 0; i < stand; i++) {
			pizza.add(new Pizza());
		}
		System.out.println("Pizza sales : ");
		for (int i = 0; i < pizza.size(); i++) {
			System.out.print((i + 1) + "\t");
			num = kb.nextInt();
			pizza.get(i).justSold(num);
		}
		System.out.println("Total pizza sold : " + Pizza.getTotalNum());
		System.out.println("Total sales : $" + Pizza.getTotalSales());
		System.out.println("\nProcess completed.");
	}
} // end
