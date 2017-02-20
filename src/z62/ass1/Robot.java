package z62.ass1;

/*CSCI 1101-Assignment 1-E1
//This Robot class used random to help us run the robot game.
<Wenyi Zhang><B00732630><2017.Feb.4th>*/
import java.util.Random;
public class Robot{
//This class will give the data and be used the methods in RobotGame class.
   private String name;
   private int xpos;
   private int ypos;
   private String direction;
   private int points;
   Random Input = new Random();
   //constructor method
   public Robot(String name, String direction) {
      this.name = name;
      this.direction = direction;
      this.xpos = 1;
      this.ypos = 1;
      this.points = 2;
   }
   //get methods
   public int getXpos() {
      return xpos;
   }
   public int getYpos() {
      return ypos;
   }
   public int getPoints() {
      return points;
   }
   public String getName() {
      return name;
   }
   public String getDirection() {
      return direction;
   }
   //set methods
   public void setXpos(int xpos) {
      this.xpos = xpos;
   }
   public void setYpos(int ypos) {
      this.ypos = ypos;
   }
   public void setPoints(int points) {
      this.points = points;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setDirection() {
      this.direction= "Up";
      this.direction="Right";
      this.direction="Diagonal";
   }
   //move method
   public void move() {
      int steps=Input.nextInt(3)+1;
      System.out.println("[debug]move steps=" + steps);
      if(direction.equals("Up") && ypos<8)
         ypos+= steps;
      if(direction.equals("Right") && xpos<8)
         xpos+= steps;
      if(direction.equals("Diagonal")) {
         if(xpos < 8)
            xpos+= steps;
         if(ypos < 8)
            ypos+= steps;
      }
      if(xpos >= 8)
         xpos = 8;
      if(ypos >= 8)
         ypos = 8; 
      points+= xpos + ypos;  
   } 
   //toString method
   public String toString() {
      String result = name+" ("+xpos+","+ypos+")\t"+direction+"\t";
      result+= points+" points";
      return result;
   }
   //amIAhead method
   public boolean amIAhead(Robot t) {
      return (this.getXpos()+this.getYpos() > t.getXpos()+t.getYpos());
   }
}//end
