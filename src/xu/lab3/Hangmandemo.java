package xu.lab3;
/*20170204 Jiawen Xu B00742689 A1-Q2
   this program  */
 
   import java.util.Scanner;
      public class Hangmandemo{
         public static void main(String[] args) {
         Scanner kb = new Scanner(System.in);
         
         System.out.println("Welcome to the Hangman game.");
         System.out.println("I have a secret Pokemon character name.");
         System.out.println("You have to guess it. You are allowed only six incorrect guesses.");
         System.out.println("Please enter each letter once.");
         
         //creat a player
         Hangman h=new Hangman();
         //call method for the secretword
         h.generateSecretWord();
                         
         //call for ?????? word
         String s1=new String(h.getDisW());
         System.out.println("Secret Word: "+s1);
         
         //six limit time to guess
         for(int i=1;i<=6;i++){
         
            System.out.print("Enter the guess:");
            String s=kb.next();
            char c=s.charAt(0);
            //make string to char
             
             //check if guess correctly 
            if(h.makeGuess(c)){
               System.out.println("Correct.");
               i--;
            }
            //if incorrectly i++
            else{
               System.out.println("Incorrect.You have "+(6-i)+" incorrect guesses left.");
            }
            System.out.print("\n");
            
            //word be discovered after each guess
            String ss=new String (h.getDisW());
            System.out.println("Secret Word: "+ss);
            
            
         }
         
         //check win or lose
         if(h.isFound()){//win
           
            System.out.println("Secret Word: "+s1);
            System.out.println("win");
         }
         else{//lose
            System.out.println("The secret word was "+h.toString()); 
            System.out.println("You lose!");
         }
      }
   }
       
         
         
        
         