package xu;
/*E3 R2D*/
public class Rectangle2D{
   private double xpos;
   private double ypos;
   private double width;
   private double height;
    
   //no arg constructor
   public Rectangle2D(){}
   
   //constructor
   public Rectangle2D(double x,double y,double w,double h){
      xpos=x;
      ypos=y;
      width=w;
      height=h;
   }
   
   //the method for create point 
   /*public Rectangle2D(double x,double y){
      xpos=x;
      ypos=y;
   } */
 
   //get
   public double getXpos(){return xpos;}
   public double getYpos(){return ypos;}
   public double getWidth(){return width;}
   public double getHeight(){return height;}
   
   //set
   public void setXpos(double x){xpos=x;}
   public void setYpos(double y){ypos=y;}
   public void setWidth(double w){width=w;}
   public void setHeight(double h){height=h;}
   
   //getArea
   public double getArea(){
      double area=width*height;
      return area;
   }
   
   //getPerimeter
   public double getPerimeter(){
      double p=((width+height)*2);
      return p;
   }
   
   //contanin(x,y)
   public boolean contain(double x,double y){
      if((x<(xpos+width)&&y<(ypos+height))&&(x>xpos&&y>ypos)){return true;}
      else{return false;}
   }
   
   //contain(R2D)
   public boolean contain(Rectangle2D r){
      //this.rectangle point p1(xpos,ypos)
      /*p2*/double x2=xpos+width;
            double y2=ypos;
      /*p3*/double x3=xpos;
            double y3=ypos+height;
      /*p4*/double x4=xpos+width;
            double y4=ypos+height;
      
      //rectangle r points
      /*p1*/double rx1=r.getXpos();
            double ry1=r.getYpos();
      /*p2*/double rx2=r.getXpos()+r.getWidth();
            double ry2=r.getYpos();
      /*p3*/double rx3=r.getXpos();
            double ry3=r.getYpos()+r.getHeight();
      /*p4*/double rx4=r.getXpos()+r.getWidth();
            double ry4=r.getYpos()+r.getHeight();
      
      if(xpos<=rx1&&ypos<=ry1&&x2>=rx2&&y2<=ry2&&x3<=rx3&&y3>=ry3&&x4>=rx4&&y4>=ry4){return true;}
      else{return false;}
   }
 }
   
   
   