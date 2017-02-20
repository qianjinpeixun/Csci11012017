package xu;
/*20160124 Jiawen Xu Lab2 E1
  This program will show where and how many way the bug goes*/

public class Bug{
   //TODO: add the attributes
   //an integer variable for position
   private int position;
   //another integer variable for direction (0 means left and 1 means right)
   private int direction;
   

   //TODO: add a constructor that sets the position and direction
   public Bug(int p,int d){
      position=p;
      direction=d;
   }
   
   //TODO: add the appropriate get and set methods
   public int getPosition(){return position;}
   public int getDirection(){return direction;}
   public void setPosition(int p){position=p;}
   public void setDirection(int d){direction=d;}
   
   //TODO: add the move method
   public void move(){
      if(position==0){
         direction=1;
         position=1+position;
      }
      else if(position==50){
         direction=0;
         position=position-1;
      }
      else if(direction==0&&position!=0){
         position=position-1;
      }
      else if(direction==1&&position!=0){
         position=position+1;
      }
         
      //Here the algorithm:
      /*if the direction is left, decrement the position by 1;
      if the direction is right, increment the position by 1;
      However, before you do the above, if the position is 0 and the direction
      is left, change the direction to right and increment the position by 1;
      Similarly, if the position is 50 and the direction is right, change the
      direction to left and decrement the position by 1
      */
      }
      
      public String toString(){
      //TODO: return a String that contains the Position and 
      //the Direction of the bug
         if(direction==0){
         return "Position: "+position+"   Direction: Left";
         }
         else{//direction==1
         return "Position: "+position+"   Direction: Right";
         }
      }

      //BUG TESTER MAIN METHOD
      public static void main(String[] args){
      //randomly set the initial position(between 0 and 50) and direction
      //(between 0 and 1)
          int initialPos = (int)(Math.random()*51);
          int initialDir = (int)(Math.random()*2);
          Bug bugsy = new Bug(initialPos, initialDir);
          System.out.println(bugsy);
   
         //display the line with the bug
         for(int i=0; i<=50;i++){
            if (i==bugsy.getPosition())
             System.out.print("X");
             else
             System.out.print("-");
         }
         System.out.println();

         //make the bug move a random number of times
         int moves = (int)(Math.random()*51);
         System.out.println("Moves: " + moves);
         for(int i=1;i<=moves;i++)
         bugsy.move();
         System.out.println(bugsy);

         //display the line with the bug
         for(int i=0; i<=50;i++){
            if (i==bugsy.getPosition())
            System.out.print("X");
            else
            System.out.print("-");
         }

         System.out.println();

     }
}