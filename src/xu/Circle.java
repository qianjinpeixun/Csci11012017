package xu;
/* 20170117 Jiawen Xu B00742689 E2
   This is the object for showing circle's area and circumference */
   
   public class Circle{
      private double radius;
      
      public Circle(double r){
         radius=r;
      }
      
      public void setRadius(double r){
         radius=r;
      }
      
      public double getRadius(){
         return radius;
      }
      
      public double findArea(){
         return Math.PI*radius*radius;
      }
      
      public double findCirc(){
         return 2*Math.PI*radius;
      }
   }
   