package st4;

public class Hangman {

	private String[] secretWordDictionary = { "bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon",
			"charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna",
			"beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok",
			"pikachu" };

	private char[] secretWord;
	private char[] disguisedWord;
	private int numGuesses;
	private int numIncorrect;
	
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

	public Hangman(){
		numGuesses = 0;
		numIncorrect = 0;
	
	}

	public void setSecretWord(char[] secretWord) {
		this.secretWord = secretWord;
	}

	public char[] generateSecretWord(){
		int min=0;
		int max=24;
		int word=(int)(Math.random() * (max-min)+1) + min;
		
		disguisedWord = new char[secretWordDictionary[word].length()];
		for (int i = 0; i < secretWordDictionary[word].length(); i++) {
			disguisedWord[i] = '?';
		}
		return secretWordDictionary[word].toCharArray();
		
	}
	
	public boolean makeGuess(char c){
		for(int i=0;i<secretWord.length;i++){
			if(c==secretWord[i])
				return true;
		}
		return false;
		
	}
	public boolean isFound(){
		if(secretWord.equals(disguisedWord)) return true;
		else return false;
	}
}
