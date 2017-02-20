package xu;
/*E3*/
import java.util.Scanner;
public class StockDemo{
   public static void main(String[] args){
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
      
      //continue the rest of the code here
      System.out.println("\nI have the following stocks: "+s1);
      System.out.println("\nI have the following stocks: "+s2);
      
      int c=s1.compareTo(s2);
      if(c==-1){
         System.out.println("\nThe value of "+sym2+" is higher than "+sym1);
      }
      
      else if(c==1){
         System.out.println("\nThe value of "+sym2+" is lower than "+sym1);
      }
      
      else{
         System.out.println("\nThe value of "+sym2+" equals "+sym1);
      }
      
      double v1=prc1*sh1;
      double v2=prc2*sh2;
      System.out.print("The total value of my portfolio is: $"+(v1+v2));
      
   }
}