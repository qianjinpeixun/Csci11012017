package xu;
/*E3 R2DDemo*/
import java.util.Scanner;
public class Rectangle2DDemo{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      //input value for this.rectangle
      System.out.print("Enter the xpos, ypos, width and height of the rectangle: ");
      double xpos=kb.nextDouble();
      double ypos=kb.nextDouble();
      double width=kb.nextDouble();
      double height=kb.nextDouble();
      
      //creat 2 rectangle
      Rectangle2D r1=new Rectangle2D(xpos,ypos,width,height);
      double x1=4.0;
      double y1=5.0;
      double w=10.5;
      double h=3.2;
      Rectangle2D r2=new Rectangle2D(x1,y1,w,h);
      
      
      //findPerimeter
      System.out.println("The perimeter of the rectangle is "+r1.getPerimeter());
      //findArea
      System.out.println("The area of the rectangle is "+r1.getArea());
      
      //check if contain point     
      if(r1.contain(3.0,3.0)){System.out.println("Rectangle [["+xpos+","+ypos+"],width="+width+",height="+height+"] contains point [3.0,3.0]");}
      else{System.out.println("Rectangle [["+xpos+","+ypos+"],width="+width+",height="+height+"] does not contains point [3.0,3.0]");}
      
      //check if r1 contain r2
      if(r1.contain(r2)){System.out.print("Rectangle [["+xpos+","+ypos+"],width="+width+",height="+height+"] contains Rectangle [["+x1+","+y1+"],width="+w+",height="+h+"]");}
      else{System.out.print("Rectangle [["+xpos+","+ypos+"],width="+width+",height="+height+"] does not contains Rectangle [["+x1+","+y1+"],width="+w+",height="+h+"]");}
      
   }
}

      
