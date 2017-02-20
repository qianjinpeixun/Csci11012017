package z62.lab2;

import java.util.Scanner; 
public class Rectangle2DDemo{
//this question shows a rectangle's area and perimeter, and then find if a point and another rectangle is in this rectangle or not. 
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in); 
      System.out.print("Enter the xpos, ypos, width and height of the rectangle: ");
      Rectangle2D rect = new Rectangle2D(kb.nextDouble(), kb.nextDouble(), kb.nextDouble(), kb.nextDouble());
      System.out.print("Enter xpos and ypos for a point: ");
      double x = kb.nextDouble();
      double y = kb.nextDouble();
      //or we can just change the data in the java
      System.out.println("The perimeter of the rectangle is "+rect.getPerimeter());
      System.out.println("The area of the rectangle is "+rect.getArea());
      //output a point in the rectangle or not.
      if(rect.contains(x,y))
         System.out.println("Rectangle "+rect+" contains point ["+x+","+y+"]");
      else 
         System.out.println("Rectangle "+rect+" does not contain point ["+x+","+y+"]");
      //output a rectangle in the rectangle or not. 
      if(rect.contains(new Rectangle2D(4, 5, 10.5, 3.2)))
         System.out.println("Rectangle "+rect+" contains Rectangle "+new Rectangle2D(4, 5, 10.5, 3.2));
      else 
         System.out.println("Rectangle "+rect+" does not contain Rectangle "+new Rectangle2D(4, 5, 10.5, 3.2));
   }
}//end
