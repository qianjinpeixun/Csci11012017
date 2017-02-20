package z62.lab2;

/*CSCI 1101-Lab 2-E4
The program creates a Rectangle2D object and tests various methods.
<Wenyi Zhang><B00732630><2017.Jan.24>*/  
public class Rectangle2D {
   private double xpos = 0.0;
   private double ypos = 0.0;
   private double width = 0.0;
   private double height = 0.0;
   //no-arg constructor method
   public Rectangle2D() {
   }
   //constructor method
   public Rectangle2D(double x, double y, double w, double h) {
      xpos = x;
      ypos = y;
      width = w;
      height = h;
   }
   //Get and set methods
   public double getX() {
      return xpos;
   }
   public double getY() {
      return ypos;
   }
   public double getWidth() {
      return width;
   }
   public double getHeight() {
      return height;
   }
   public void setX(double x) {
      xpos = x;
   }
   public void setY(double y) {
      ypos = y;
   }
   public void setWidth(double w) {
      width = w;
   }
   public void setHeight(double h) {
      height = h;
   }
   //toString method
   public String toString() {
      return "[["+xpos+","+ypos+"],width="+width+",height="+height+"]";
   }
   //getArea method
   public double getArea() {
      return width * height;
   }
   //getPerimeter method
   public double getPerimeter() {
      return 2 * (width + height);
   }
   //method contains(x, y)
   public boolean contains(double x, double y) {
      return (x >= xpos) && (x <= xpos + width) && (y >= ypos) && (y <= ypos + height);
   }
   //method contains(Rectangle2D r)
   public boolean contains(Rectangle2D r) {
      return (r.getX() >= xpos) && (r.getY() >= ypos) && (r.getX() + r.getWidth() <= xpos + width) && (r.getY() + r.getHeight() <= ypos + height);
   }
}//end
