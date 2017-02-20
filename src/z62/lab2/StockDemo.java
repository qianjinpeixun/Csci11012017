package z62.lab2;

import java.util.Scanner; 
public class StockDemo{
//This question shows values of two stocks,and find they are equal or one of them is higher.
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in); 
      String sym1, sym2;
      double prc1, prc2;
      int sh1, sh2;
      //get the values for two stocks
      System.out.print("Enter the symbols for the two stocks: "); 
      sym1 = keyboard.next();
      sym2 = keyboard.next();
      System.out.print("Enter their prices: ");
      prc1 = keyboard.nextDouble();
      prc2 = keyboard.nextDouble();
      System.out.print("Enter the number of shares for the two stocks: ");
      sh1 = keyboard.nextInt();
      sh2 = keyboard.nextInt();
      //create the first Stock
      Stock s1 = new Stock(sym1,prc1,sh1);
      //create the second Stock
      Stock s2 = new Stock(sym2,prc2,sh2);
      // continue the rest of the code here
      System.out.println("\nI have the following stocks:");
      //String the value in the output
      System.out.println(s1.toString());
      System.out.println(s2.toString());
      //compare two value
      if (s1.compareTo(s2) == 1) 
         System.out.println("The value of " + s1.getSymbol() + " is higher than " + s2.getSymbol());
      else if (s1.compareTo(s2) == -1) 
         System.out.println("The value of " + s1.getSymbol() + " is lower than " + s2.getSymbol());
      else 
         System.out.println("Both the values are the same.");
      //the total value
      System.out.println("The total value of my portfolio is: $ " + (s1.calcValue() + s2.calcValue()));
      System.out.println("\nProcess completed.");
   }
}//end

