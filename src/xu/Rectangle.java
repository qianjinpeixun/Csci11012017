package xu;
/* 20170117 Jiawen Xu B00742689 E1
   This is the object for showing 2 rectangles' area and perimeters */
   
   public class Rectangle{
      private int width;
      private int height;
      
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
   }