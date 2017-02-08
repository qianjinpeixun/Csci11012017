package z4;

/*this program will count pizza sold in different stands and add together
 * to calculate total money
 * <zishen cao><B00723808><Feb 4th>*/
import java.util.Scanner;

public class PizzaDemo {
	public static void main(String[] args) {
		// create a pizza object
		Pizza p = new Pizza(0, 0);

		Scanner k = new Scanner(System.in);

		System.out.println("Enter how many stands:");

		int stands = k.nextInt();

		System.out.println("Enter price for each pizza;");

		double price = k.nextDouble();

		p.setCost(price);

		System.out.println("Pizza Sales:");
		// for loop to track number of stands
		for (int i = 1; i <= stands; i++) {

			int number = 0;

			System.out.print(i + " ");
			number = k.nextInt();
			// new pizza object to add number together by using 'justSold'
			// method
			Pizza p1 = new Pizza(i, p.justSold(number));

		}
		// total number
		System.out.println("Total pizzas sold: " + p.justSold());
		// total money
		System.out.println("Total sales: $" + p.totalSale());
	}

}