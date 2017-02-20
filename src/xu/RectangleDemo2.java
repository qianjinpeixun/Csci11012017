package xu;
/* 20170117 Jiawen Xu B00742689 E3
   This program will show rectangle's area and perimeters */
  
   import java.util.Scanner;
   public class RectangleDemo2{
      public static void main(String[] args){
         int width,height;
         Rectangle2 rect1;
         Scanner input=new Scanner(System.in);
         System.out.print("Enter width and height of the rectangle:");
         width=input.nextInt();
         height=input.nextInt();
         
         rect1=new Rectangle2(width,height);
         
         System.out.println("");
         System.out.println(rect1);
         System.out.println("Area: "+rect1.findArea()+" square units");
         System.out.println("Perimeter: "+rect1.findPerimeter()+" units");
      }
   }
     