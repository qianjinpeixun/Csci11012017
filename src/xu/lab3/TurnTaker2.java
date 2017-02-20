package xu.lab3;
/*20170131 Jiawen Xu B00742689 Lab3 E1c
   This program will show love from Romeo if turn is odd
   and love from Juliet if turn is even,love from both at end */
   
   import java.util.Scanner;//use scanner
   public class TurnTaker2{
      private static int turn = 0; 
      private int myTurn;
      private String name;
      
      public TurnTaker2(String n, int t) {
         name = n;
         myTurn = t; 
      }
      
      public String getName() {
         return name; 
      }
         
      public static int getTurn() {
         turn++;
         return turn; 
      }
         
      public boolean isMyTurn() {
         if (myTurn%2==0){return true; }//even
         else{return false;}//odd
      }
      
      public static void main(String[] args) {
         Scanner kb=new Scanner(System.in);//use scanner
         TurnTaker2 person1 = new TurnTaker2("Romeo", 1); 
         TurnTaker2 person2 = new TurnTaker2("Juliet", 2);
         
         //input turn
         System.out.print("How many turns? ");
         int t=kb.nextInt();
           
         for(int i = 1; i<t; i++) {
            System.out.println("Turn = " + i); 
               
            if (i%2==0){System.out.println("Love from "+ person2.getName());}
            else {System.out.println("Love from " + person1.getName());}            
         }
         System.out.println("Turn = "+t);
         System.out.print("Love from " + person1.getName()+"\nLove from " + person2.getName());
      }
   }