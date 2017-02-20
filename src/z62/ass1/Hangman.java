package z62.ass1;

/*CSCI 1101-Assignment 1-E2
//This Robot class used random to help us run the robot game.
<Wenyi Zhang><B00732630><2017.Feb.4th>*/
import java.util.Random;
public class Hangman {
//This Hangman class save some value and let it be used in HangmanDemo by some methods.
   private String[] secretWordDictionary = {"bulbusaur","ivysaur", "charmander","charmeleon", "charizard", "squirtle", "wartotle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgee", "pidgeotto", "pidgeot","rattata", "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu"};
   private char[] secretWord; 
   private char[] disguisedWord; 
   private int numGuesses; 
   private int numIncorrect;
   private int maxNumGuesses;
   //No-args constructor method
   public Hangman() {
   }
   public Hangman(int mng) {
      maxNumGuesses = mng;
   }
   //get method
   private char[] getSecretWord() {
      return secretWord;
   }
   public char[] getDisguisedWord() {
      return disguisedWord;
   }
   public int getNumGuesses() {
      return numGuesses;
   }
   public int getNumIncorrect() {
      return numIncorrect;
   }
   public int getMaxNumGuesses() {
      return maxNumGuesses;
   }
   //set method
   public void setSecretWord(char[] s) {
      secretWord = s;
   }
   public void setDisguisedWord(char[] s) {
      disguisedWord = new char[s.length];
      for(int i=0; i<s.length; i++) {
         disguisedWord[i] = '?';
      }
   }
   public void setNumGuesses(int n) {
      numGuesses = n;
   }
   public void setNumIncorrect(int n) {
      numIncorrect = n;
   }
   public void setMaxNumGuesses(int m) {
      maxNumGuesses = m;
   }
   //generateSecretWord() method
   //in this method we used random to get the word from secretWordDictionary.
   public void generateSecretWord() {
      int r = (new Random()).nextInt(secretWordDictionary.length);
      setSecretWord(secretWordDictionary[r].toCharArray());
      setDisguisedWord(secretWord);
   }
   //makeGuess(char c) method
   public boolean makeGuess(char c) {
      boolean found = false;
      for(int i=0; i<secretWord.length; i++) {
         if (c == secretWord[i]) {
            disguisedWord[i] = c;
            found = true;
         }
      }
      setNumGuesses(++numGuesses);
      if (!found) {
         setNumIncorrect(++numIncorrect);
      } 
      return found;
   }
   //isFound method
   public boolean isFound() {
      if (numIncorrect >= maxNumGuesses) {
         System.out.println("The secret word was "+String.valueOf(getSecretWord()));
         return false;
      }
      return !String.valueOf(disguisedWord).contains("?");
   }
}//end

