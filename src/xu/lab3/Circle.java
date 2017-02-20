package xu.lab3;

/*20170201 Jiawen Xu B00742689 Lab3 E4
   This object will check two circles touched externally or internally
   and checks if a point is enclosed within the circle*/

//Circle class
//Defines a circle object with center cx,cy and radius r
public class Circle{
   
   //instance variables
   private double cx;
   private double cy; 
   private double radius;
   
   //constructor
   public Circle(double cx, double cy, double radius){ 
      this.cx=cx;
      this.cy=cy;
      this.radius=radius; 
   }
   
   //get and set methods
   public void setCX(double cx){this.cx=cx;}
   public void setCY(double cy){this.cy=cy;}
   public void setRadius(double radius){this.radius=radius;} 
   public double getCX(){return cx;}
   public double getCY(){return cy;}
   public double getRadius(){return radius;}
   
   //toString method
   public String toString() {return "Circle with center " + cx +"," + cy + " and radius " + radius; }
   
      
   //external touch method
   public boolean touchExter(Circle c2){
      
      //d=distance between two center
      double d=Math.sqrt((c2.getCX()-cx)*(c2.getCX()-cx)+(c2.getCY()-cy)*(c2.getCY()-cy));
      
      //sum of two radius
      double sumofr=radius+c2.getRadius();
      
      if(d==sumofr){return true;}//touched externally
      else{return false;}
   }
   
   //internal touch method
   public boolean touchInter(Circle c2){
      
      //d=distance between two center
      double d=Math.sqrt((c2.getCX()-cx)*(c2.getCX()-cx)+(c2.getCY()-cy)*(c2.getCY()-cy));
      
      //distance of two radius
      //use absolute to make sure its a positive number
      double dr=Math.sqrt((radius-c2.getRadius())*(radius-c2.getRadius()));
      
      if(d==dr){return true;}//touched internally
      else{return false;}
   }
}