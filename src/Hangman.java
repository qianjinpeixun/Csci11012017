
/**
 * In this question, you are required to construct a class that could be used to
 * play a game of hangman.
 * 
 * @author ST1
 *
 */
public class Hangman {

	/*
	 * We will simplify the game a bit. Rather than randomly generating a secret
	 * word from a large dictionary, we will use the words from a much smaller
	 * dictionary of 25 words. These will be the names of the first 25 Pokemon
	 * characters. These 25 words will be stored in a String array, and each
	 * time the game is played, a word is randomly selected from this array.
	 */
	private String[] secretWordDictionary = { "bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon",
			"charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna",
			"beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok",
			"pikachu" };

	private char[] secretWord;
	/*
	 * The disguised word (another array of char), in which each unknown letter
	 * in the secret word is replaced with a question mark (?). For example, if
	 * the secret word is abracadabra and the letters a and b have been guessed,
	 * the disguised word would be ab?a?a?ab?a.
	 */
	private char[] disguisedWord;

	// The number of guesses made
	private int numGuesses;

	// The number of incorrect guesses.
	private int numIncorrect;

	// No-args constructor: creates an empty Hangman object
	public Hangman() {
		numGuesses = 0;
		numIncorrect = 0;

	}

	/*
	 * Generate a random number from 0 to 24 and select the appropriate word
	 * from the secretWordDictionary. Convert it into a char array and store in
	 * char[] word.
	 */
	public char[] generateSecretWord() {
		int wordIndex = (int) (Math.random() * 25);
		String currentWord = secretWordDictionary[wordIndex];
		secretWord = currentWord.toCharArray();
		disguisedWord = new char[currentWord.length()];
		for (int i = 0; i < currentWord.length(); i++) {
			disguisedWord[i] = '?';
		}
		return currentWord.toCharArray();
	}

	/*
	 * guesses that character c is in the word..
	 */
	public boolean makeGuess(char c) {
		boolean ret = false;
		for (int i = 0; i < secretWord.length; i++) {
			if (secretWord[i] == c) {
				ret = true;
				disguisedWord[i] = c;
			}
		}
		return ret;
	}

	/*
	 * returns true if the hidden word has been discovered.
	 */
	public boolean isFound() {
		boolean ret = false;
		String disguisedStr = String.valueOf(disguisedWord);
		String secretStr = String.valueOf(secretWord);
		if (disguisedStr.equals(secretStr))
			ret = true;
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
