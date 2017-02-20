package xu;
/*E2*/
import java.util.Scanner;
public class PointDemo{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      //input value for four points
      System.out.print("Enter the x and y coordinates of point1: ");
      int x1=kb.nextInt();
      int y1=kb.nextInt();
      System.out.print("Enter the x and y coordinates of point2: ");
      int x2=kb.nextInt();
      int y2=kb.nextInt();
      System.out.print("Enter the x and y coordinates of point3: ");
      int x3=kb.nextInt();
      int y3=kb.nextInt();
      System.out.print("Enter the x and y coordinates of point4: ");
      int x4=kb.nextInt();
      int y4=kb.nextInt();
      
      Point p1=new Point(x1,y1);
      Point p2=new Point(x2,y2);
      Point p3=new Point(x3,y3);
      Point p4=new Point(x4,y4);
      
      //fiid the highest point
      //if higher return 1, not return -1
      if(p1.isHigher(p2)==1&&p1.isHigher(p3)==1&&p1.isHigher(p4)==1){
         System.out.println("["+x1+","+y1+"]"+" is the highest point");
      }
      else if(p2.isHigher(p1)==1&&p2.isHigher(p3)==1&&p2.isHigher(p4)==1){
         System.out.println("["+x2+","+y2+"]"+" is the highest point");
      }
      else if(p3.isHigher(p1)==1&&p3.isHigher(p2)==1&&p3.isHigher(p4)==1){
         System.out.println("["+x3+","+y3+"]"+" is the highest point");
      }
      else{//(p4.isHigher(p1)==1&&p4.isHigher(p2)==1&&p4.isHigher(p3)==1)
         System.out.println("["+x4+","+y4+"]"+" is the highest point");
      }
      
      
      
      //find distance between p1&p2 and p3&p4
      double d1=p1.findDistance(p2);
      double d2=p3.findDistance(p4);
      System.out.println("The distance between "+"["+x1+","+y1+"]"+"["+x2+","+y2+"] is "+d1);
      System.out.println("The distance between "+"["+x3+","+y3+"]"+"["+x4+","+y4+"] is "+d2);
      
      //find d1 d2 who is longer
      if(d1==d2){
         System.out.print("["+x1+","+y1+"]-->["+x2+","+y2+"] is same with ["+x3+","+y3+"]-->["+x4+","+y4+"]");
      }
      else if(d1>d2){
         System.out.print("["+x1+","+y1+"]-->["+x2+","+y2+"] is longer than ["+x3+","+y3+"]-->["+x4+","+y4+"]");
      }
      else{//d2>d1
         System.out.print("["+x3+","+y3+"]-->["+x4+","+y4+"] is longer than ["+x1+","+y1+"]-->["+x2+","+y2+"]");
      }
   }
}

      

      

      
                 
            
         
            
           
         
         
      



      
      
