package xu;
/* 20170117 Jiawen Xu B00742689 E1
   This program will show 2 rectangles area and perimeters */
   
   public class RectangleDemo{
      public static void main(String[] args){
         Rectangle rect1,rect2;
         rect1=new Rectangle();
         rect2=new Rectangle();
         rect1.setWidth(10);
         rect1.setHeight(30);
         rect2.setWidth(20);
         rect2.setHeight(25);
         System.out.println("Area (rectangle1): "+rect1.findArea()+" square units");
         System.out.println("Perimeter (rectangle1): "+rect1.findPerimeter()+" units");
         System.out.println("Area (rectangle2): "+rect2.findArea()+" square units");
         System.out.println("Perimeter (rectangl2): "+rect2.findPerimeter()+" units");
      }
   }
       