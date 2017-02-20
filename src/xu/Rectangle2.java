package xu;
/* 20170117 Jiawen Xu B00742689 E3
   This is the object for showing 2 rectangles' area and perimeters */
   
   public class Rectangle2{
      private int width;
      private int height;
      
      //constructor
      public Rectangle2(int w,int h){
         width=w;
         height=h;
      }
      public void setWidth(int w){
         width=w;
      }
      
      public void setHeight(int h){
         height=h;
      }
      
      public int getWidth(){
         return width;
      }
      
      public int getHeight(){
         return height;
      }
      
      public int findArea(){
         return height*width;
      }
      
      public int findPerimeter(){
         return 2*(width+height);
      }
      
      //new toString method to display height and width
      public String toString(){
         return "Rectangle:[Width: "+width+", Hieght: "+height+"]";
      }
   }