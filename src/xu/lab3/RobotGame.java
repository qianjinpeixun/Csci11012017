package xu.lab3;
/*20170204 Jiawen Xu B00742689 A1-Q1
   this program  */
   
   import java.util.Scanner;
      public class RobotGame{
         public static void main(String[] args) {
         Scanner kb = new Scanner(System.in);
            
            System.out.println("Welcome to the Robot Game Simulator!");
            System.out.print("\n");
            
            //creat two rebots
            /*r1 name and direction */
            String n1="";
            String d1="";
            System.out.print("Enter the name of the first robot: ");
            n1=kb.next();
            System.out.print("Enter the direction of the first robot: ");
            d1=kb.next();
            Robot r1=new Robot(n1,d1);
            
            System.out.print("\n");
            /*r2 name and direction */
            String n2="";
            String d2="";
            System.out.print("Enter the name of the second robot: ");
            n2=kb.next();
            System.out.print("Enter the direction of the second robot: ");
            d2=kb.next();
            Robot r2=new Robot(n2,d2);
            System.out.print("\n");
            
            //origal position
            System.out.println("Simulation started!");
            System.out.println(r1);
            System.out.print(r2);
            System.out.print("\n");
            
            //for check if they print and output total points
            boolean r2print =false;
            boolean r1print=false;
            
            //run until reach (8,8)
            while(!r1.done()||!r2.done()){
               System.out.print("\n");
               System.out.println("Move!");
               
               //move r1 r2 robots 1/2/3 steps by random
               int s1=(int)(Math.random()*3+1);
               int s2=(int)(Math.random()*3+1);
               
               //when r1 didnt reach goal
               if(!r1.done()){
                  r1.Move(s1);
                  System.out.println(r1);  
               }
               //r2 didnt reach the goal 
               if(!r2.done()){
                  r2.Move(s2);
                  System.out.println(r2);  
               }
               
               //r1 reached the goral check for the total point
               if(!r1print&&r1.done()){
                  System.out.println("\n"+n1+" has reached the goal ("+r1.Pointsc()+" points)");
                  r1print=true;
               }
               //r2 reached the goal and check for the total point
               if(!r2print&&r2.done()){
                  System.out.println("\n"+n2+" has reached the goal ("+r2.Pointsc()+" points)");
                  r2print=true;
               }
               
               
               //change diection randomly
               //r1
               int d3=(int)(Math.random()*3+1);
               if(d3==1){r1.setDirection("Up");}
               else if(d3==2){r1.setDirection("Right");}
               else{r1.setDirection("Diagonal");}
               //r2
               int d4=(int)(Math.random()*3+1);
               if(d4==1){r2.setDirection("Up");}
               else if(d4==2){r2.setDirection("Right");}
               else{r2.setDirection("Diagonal");}
               
               //check who is ahead
               /*r1*/
               if((r1.amIAhead(r2))==1&&!r1.done()&&!r2.done()){
                  System.out.println(n1+" ahead!");
               }
               /*r2*/
               else if((r2.amIAhead(r1))==2&&!r2.done()&&!r1.done()){
                  System.out.println(n2+" ahead!");
               }
               /*same*/
               else if(r1.amIAhead(r2)==3&&!r1.done()&&!r2.done()){
                  System.out.println("Both are at the same distance from the goal!");
               }
              
            }
            
            System.out.println("\nGame over!");
        }
    }
      
      