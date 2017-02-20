package xu.lab3;
/*20170131 Jiawen Xu B00742689 Lab3 E1b
   This program will show the number of turn and where love from both people 
   if number of turn and number of loop are equally*/
   
   public class TurnTaker1{
      private static int turn = 0; 
      private int myTurn;
      private String name;
      
      //constructor
      public TurnTaker1(String n, int t) {
         name = n;
         myTurn = t; 
      }
      
      //get
      public String getName() {return name;} 
      public static int getTurn() {
         turn++;
         return turn; 
      }
      
      //check turns
      public boolean isMyTurn() {
         if (turn==myTurn){return true; }
         else{return false;}
      }

      public static void main(String[] args) {
         TurnTaker1 person1 = new TurnTaker1("Romeo", 1); 
         TurnTaker1 person2 = new TurnTaker1("Juliet", 2);
         TurnTaker1 person3 = new TurnTaker1("Juliet", 3);
         TurnTaker1 person4 = new TurnTaker1("Juliet", 4);
         TurnTaker1 person5 = new TurnTaker1("Juliet", 5);
            
         for(int i = 1; i<= 5; i++) {
            System.out.println("Turn = " + TurnTaker1.getTurn()); 
               
            if (person1.isMyTurn()){System.out.println("Love from "+ person1.getName()+"\nLove from "+person2.getName());}
            if (person2.isMyTurn()){System.out.println("Love from " + person1.getName()+"\nLove from "+person2.getName());}
            if (person3.isMyTurn()){System.out.println("Love from " + person1.getName()+"\nLove from "+person2.getName());}
            if (person4.isMyTurn()){System.out.println("Love from " + person1.getName()+"\nLove from "+person2.getName());}
            if (person5.isMyTurn()){System.out.print("Love from " + person1.getName()+"\nLove from "+person2.getName());}
            

         }
      }
   }