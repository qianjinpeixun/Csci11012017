package z4;

//Scanner to read input
import java.util.Scanner;
public class Rectangle2DDemo {
public static void main(String []args){
	Scanner i = new Scanner(System.in);
	double x,y,w,h;
    
    System.out.println("Enter the xpos,ypos,width,height for this rectangle:");
    x = i.nextDouble();
    y = i.nextDouble();
	w = i.nextDouble();
	h = i.nextDouble();
	//create rectangle object
	Rectangle2D rt = new Rectangle2D(x,y,w,h);
	System.out.println("The perimeter of the rectangle is "+rt.getPerimeter(w,h));
	System.out.println("The area of the rectangle is "+rt.getArea(w,h));
	//conditions to find a point is inside a rectangle or not
	if(rt.contains(3,3)==true)
    System.out.println("Rectangle [["+x+","+y+"],width="+w+",height="+h+"] contains point [3,3]");
	else
	System.out.println("Rectangle [["+x+","+y+"],width="+w+",height="+h+"] does not contain point [3,3]");
	Rectangle2D rt2 = new Rectangle2D(4,5,10.5,3.2);
	//conditions to find  a rectangle is inside a rectangle or not
	if(rt.contains(rt2))
	System.out.println("Rectangle [["+x+","+y+"],width="+w+",height="+h+"] contains Rectangle [[4.0,5.0],width=10.5,height=3.2]");
	else
    System.out.println("Rectangle [["+x+","+y+"],width="+w+",height="+h+"] does not contain Rectangle [[4.0,5.0],width=10.5,height=3.2]");
}
}


