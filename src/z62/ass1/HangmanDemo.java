package z62.ass1;

import java.util.Scanner;
public class HangmanDemo{
//This HangmanDemo class used the data from Hangman class to play the game.
   public static void main(String[] args){
      Scanner kb = new Scanner (System.in);
      Hangman hangman = new Hangman(6);
      hangman.generateSecretWord();
      System.out.println("Welcome to the Hangman game.\nI have a secret Pokemon character name. You have to guess it. You are allowed only six incorrect guesses.\n");
      boolean x=false;
      //we used while loops to repeat the steps
      while (!x && hangman.getNumIncorrect()<hangman.getMaxNumGuesses()) {
         System.out.println("Secret word: " + String.valueOf(hangman.getDisguisedWord()));
         System.out.print("Enter the guess: ");
         String s = kb.nextLine();
         char c = s.charAt(0);
         if (String.valueOf(hangman.getDisguisedWord()).contains(String.valueOf(c))) {
            System.out.println("You already guessed "+c+". Choose another letter.");
            continue;
         }
         boolean b = hangman.makeGuess(c);
         if (b) {
            System.out.println("Correct.");
         } 
         else {
            System.out.println("Incorrect. you have "+(hangman.getMaxNumGuesses()-hangman.getNumIncorrect())+" incorrect guesses left.");
         }
         x = hangman.isFound();
      }
      //we used if/else statement to show the final result
      if (x) {
         System.out.println("Secret word: " + String.valueOf(hangman.getDisguisedWord()));
         System.out.println("You win!");
      } 
      else {
         System.out.println("you lose!");
      }
   }
}//end
