package z4;

import java.util.Scanner;

public class StockDemo {
	public static void main(String[] args) {
		Scanner I = new Scanner(System.in);
		String sym1, sym2;
		double prc1, prc2;
		int sh1, sh2;
		// get the values for two stocks
		System.out.print("Enter the symbols for the two stocks: ");
		sym1 = I.next();
		sym2 = I.next();
		System.out.print("Enter their prices: ");
		prc1 = I.nextDouble();
		prc2 = I.nextDouble();
		System.out.print("Enter the number of shares for the two stocks: ");
		sh1 = I.nextInt();
		sh2 = I.nextInt();
		// create the first Stock
		Stock s1 = new Stock(sym1, prc1, sh1);
		// create the second Stock
		Stock s2 = new Stock(sym2, prc2, sh2);
		// continue the rest of the code here
		System.out.println("I have the following stocks:");
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		// compare two stocks
		if (s1.compareTo(s2) == -1)
			System.out.println("The value of " + sym1 + " is higher than " + sym2);
		else if (s1.compareTo(s2) == 1)
			System.out.println("The value of " + sym2 + " is higher than " + sym1);
		//最后一个else 不用if
		else
			System.out.println("The value of " + sym1 + " is equals to " + sym2);

		System.out.println("The total value of my portfolio is " + (prc1 * sh1 + prc2 * sh2));

	}// end method
}// end class