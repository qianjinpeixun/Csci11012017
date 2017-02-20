package xu;
/* 20170117 Jiawen Xu B00742689 E2
   This program shows circle's area and circumference */
   
   import java.util.Scanner;
   public class CircleDemo{
      public static void main(String[]args){
         Circle circ1;
         double r;
         Scanner input=new Scanner(System.in);
         System.out.print("Enter the radius: ");
         r=input.nextDouble();
         circ1=new Circle(r);
         System.out.println("Area of the circle is: "+circ1.findArea()+" square units");
         System.out.println("Circumference of the circle is: "+circ1.findCirc()+" units");
      }
   }
   