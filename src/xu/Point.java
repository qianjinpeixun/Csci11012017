package xu;
/*20160124 Jiawen Xu Lab2 E2
  This class  */
  
public class Point{
   private int xcoordinate;
   private int ycoordinate;
   
   //constructor 
   public Point(int x,int y){
      xcoordinate=x;
      ycoordinate=y; 
   }
   
   //get
   public int getX(){return xcoordinate;}
   public int getY(){return ycoordinate;}
   
   //set
   public void setX(int x){xcoordinate=x;}
   public void setY(int y){ycoordinate=y;}
   
   //equals
   public int equals(Point p){
      if(xcoordinate==p.getX()&&ycoordinate==p.getY()){return 1;}
      else{return -1;}
   }
   
   //isHigher
   public int isHigher(Point p){
      if(ycoordinate<p.getY()){return 1;}
      else{return -1;}
   }
   
   //findDistance
   public double findDistance(Point p){
      int x1=xcoordinate;
      int x2=p.getX();
      int y1=ycoordinate;
      int y2=p.getY();
      return (Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))));
   }
}
   