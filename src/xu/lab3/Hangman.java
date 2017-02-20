package xu.lab3;
/*20170204 Jiawen Xu B00742689 A1-Q2
   this object will choose a word randomly 
   and give a disguiseword to disconer; also check if guess correctly*/
   
   public class Hangman {
      private String[] secretWordDictionary = {"bulbasaur","ivysaur", "venusaur","charmander","charmeleon", "charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot","rattata", "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu"};
      private char[] secretWord; //the word be choosed by randomly
      private char[] disguisedWord; //the word by guess to discover
      private int numGuesses; 
      private int numIncorrect;
            
      //constructor
      public Hangman(){}
      
      //get methods
      public char[] getDisW(){return disguisedWord;}
      public int getNumGuess(){return numGuesses;}
      public int getNumIncor(){return numIncorrect;}
      
      //set methods
      public void setSecW(char[] sw){secretWord=sw;}
      public void setDisW(char[] dw){disguisedWord=dw;}
      public void setNumGuess(int ng){numGuesses=ng;}
      public void setNumIncor(int ni){numIncorrect=ni;}
      
      //generateSecretWord
      public char[] generateSecretWord(){
                  
         int r=(int)(Math.random()*25+0);
         String w=secretWordDictionary[r];//the word from thr array
         secretWord=w.toCharArray();//make string to char
 
         int l=secretWord.length;
         //set disguisedword to ????
         disguisedWord=new char[l];
         for(int i=0;i<l;i++){disguisedWord[i]='?';}
         
         return secretWord;
      }
      
      //makeGuess(char c) guesses that character c is in the word.
      public boolean makeGuess(char c){
         int l=secretWord.length;
         
         int q=0;//temp for return 
         
         for(int i=0;i<l;i++){
            
            if(c==(secretWord[i])){//when guess correctlly 
            q=1;
            disguisedWord[i]=c;
            }//true
            
         }
         
         if(q==1){return true;}//when guess correctly 
         else{return false;}
         
      }
              
      //isFound returns true if secretword=disguisedword
      public boolean isFound(){
         if(secretWord.equals(disguisedWord)){return true;}
         else{return false;}
      }
      
      //tostring
      public String toString(){
         String s=new String(secretWord);
         return s;
      }
   }
      
      
    
      
      
      
      