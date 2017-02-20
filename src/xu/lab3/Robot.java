package xu.lab3;
/*20170204 Jiawen Xu B00742689 A1-Q1
   this object get and set x,y,d,n and move method,
   check who is closer with8,8; toString method */
   
   public class Robot{
      private String name;
      private int xp;
      private int yp;
      private String direction;
      private int pointsc;//pointscollected
      private int step;
      
      //constructor
      public Robot(String n,String d){
         name=n;
         direction=d;
         xp=1;
         yp=1;
         pointsc=2;
      }
      
      //get method
      public String getName(){return name;}
      public int getX(){return xp;}
      public int getY(){return yp;}
      public String getDirection(){return direction;}
      public int getPoints(){return pointsc;}
      
      //set method
      public void setName(String n){name=n;}
      public void setX(int x){xp=x;}
      public void setY(int y){yp=y;}
      public void setDirection(String d){direction=d;}
      public void setpoints(int p){pointsc=p;}
      
      //move method and call pointsc method for each move
      public void Move(int s){
         /*if the direct is Up*/
         if (direction.equals("Up")&&(yp+s)<=8){
            yp=yp+s;
            Pointsc();  
         } 
         /*if the direct is Right*/
         else if(direction.equals("Right")&&(xp+s)<=8){
           xp=xp+s;
           Pointsc();
         }
         /*if the direct is Diag*/
         else if(direction.equals("Diag")&&(xp+s)<=8&&(yp+s)<=8){
           xp=xp+s;
           yp=yp+s;
           Pointsc();
         }
         
         
      }
      
      //points method
      public int Pointsc(){
         
         pointsc=pointsc+xp+yp;
         return pointsc;
      }
      
      //toString
      public String toString(){
         return name+" ("+xp+","+yp+") "+direction+" "+pointsc+" points";
      }
      
      //amIAhead
      public int amIAhead(Robot r2){
         
         int dis1=xp+yp;//distance between r1
         int dis2=r2.getX()+r2.getY();//disstance between r2
         
         if(dis1>dis2){return 1;}
         else if (dis1<dis2){return 2;}
         else {return 3;}//when they equals
     
      }
      
      //done method checks if robot reach the goal
      public boolean done(){
         if(xp==8&&yp==8){return true;}
         else{return false;}
      }
      
      
     
      

   }
   
             
       
       
      
      
      
      