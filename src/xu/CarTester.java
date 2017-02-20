package xu;
/* 20170117 Jiawen Xu B00742689 E5
   This program will check gas and distance of the cars */
   
   import java.util.Scanner;
   public class CarTester{
      public static void main(String[]args){
         Scanner input=new Scanner(System.in);
         
         Car c;
         double tc;//tank capacity
         double agt;//amount of gas in tank
         double fcr;//fuel consumption rate      
         double d;//distance to drive
         double g;//fill gas
         
         System.out.print("Enter the capacity (in liters): ");
         tc=input.nextDouble();
         System.out.print("Enter the fuel consumption rate (in lt/km): ");
         fcr=input.nextDouble();
         System.out.print("Enter the amount of gas to fill: ");
         g=input.nextDouble();
         System.out.print("Enter the distance to drive: ");
         d=input.nextDouble();
         
         c=new Car(tc,fcr);
         
         //can/not fill more gas
         c.fill(g);
         //drive/not and remind gas in tank
         c.drive(d);
      }
   }
      
         
             
         
