
public class Hangman {

	private String[] secretWordDictionary = { "bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon",
			"charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna",
			"beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok",
			"pikachu" };
	private char[] secretWord;
	private char[] disguisedWord;
	private int numGuesses;
	private int numIncorrect;

	public Hangman(){
		numGuesses=0;
		numIncorrect=0;
		
	}
	
	public char[] generateSecretWord(){
		int wordIndex=(int)(Math.random()	*25);
		String currentWord=secretWordDictionary[wordIndex];
		secretWord=currentWord.toCharArray();
		disguisedWord=new char[currentWord.length()];
		for(int i=0;i<currentWord.length();i++){
			disguisedWord[i]='?';
		}
		return currentWord.toCharArray();
	}
	
	public boolean makeGuess(char c){
		boolean ret=false;
		for(int i=0;i<secretWord.length;i++){
			if(secretWord[i]==c){
				ret=true;
				disguisedWord[i]=c;
			}
		}
		return ret;
	}
	
	public boolean isFound(){
		boolean ret=false;
		String disguisedStr=String.valueOf(disguisedWord);
		String secretStr=String.valueOf(secretWord);
		if(disguisedStr.equals(secretStr))
			ret=true;
		return ret;
	}

	public char[] getDisguisedWord() {
		return disguisedWord;
	}

	public void setDisguisedWord(char[] disguisedWord) {
		this.disguisedWord = disguisedWord;
	}

	public int getNumGuesses() {
		return numGuesses;
	}

	public void setNumGuesses(int numGuesses) {
		this.numGuesses = numGuesses;
	}

	public int getNumIncorrect() {
		return numIncorrect;
	}

	public void setNumIncorrect(int numIncorrect) {
		this.numIncorrect = numIncorrect;
	}
	
	
}
