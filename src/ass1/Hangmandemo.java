package ass1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * a demo class by writing a demo program Hangmandemo.java and simulate the game
 * of hangman.
 * 
 * @author ST1
 *
 */
public class Hangmandemo {

	public static void main(String[] args) {

		System.out.println("Welcome to the Hangman game.");
		System.out.println(
				"I have a secret Pokemon character name. You have to guess it. You are allowed only six incorrect guesses.");

		try {
			Hangman hangman = new Hangman();
			char[] realWord = hangman.generateSecretWord();
			String currentWord = "";

			/*
			 * Keep a limit of six on the number of incorrect guesses, and quit
			 * the game if the user doesn’t get the word right within the limit.
			 */
			int max_attemp_times = 6;

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			String inputChar = "";

			/*
			 * Using enteredLetters to keep track of the letters that were
			 * guessed, both for correct guesses and for incorrect guesses. this
			 * to prompt the user that they cannot pick a letter that was
			 * already guessed
			 */
			String enteredLetters = "";

			//Start the game
			while (hangman.getNumIncorrect() < max_attemp_times) {
				
				//Got the current disguised word
				currentWord = String.valueOf(hangman.getDisguisedWord());
				
				System.out.println("");
				System.out.println("Secret word: " + currentWord);
				System.out.print("Enter the guess: ");
				inputChar = br.readLine();
				if (enteredLetters.contains(inputChar)) {
					System.out.println("You already guessed " + String.valueOf(inputChar) + ". Choose another letter.");
					continue;
				}
				boolean isCorrect = hangman.makeGuess(inputChar.charAt(0));
				hangman.setNumGuesses(hangman.getNumGuesses() + 1);
				if (isCorrect == true) {
					System.out.println("Correct.");
				} else {
					hangman.setNumIncorrect(hangman.getNumIncorrect() + 1);
					System.out.println(
							"Incorrect. You have " + String.valueOf(max_attemp_times - hangman.getNumIncorrect())
									+ " incorrect guesses left.");
				}
				enteredLetters = enteredLetters + String.valueOf(inputChar);

				if (hangman.isFound()) {
					System.out.println("");
					System.out.println("Secret word: " + String.valueOf(realWord));
					System.out.println("You win!");
					break;
				}
			}

			if (!hangman.isFound()) {
				System.out.println("");
				System.out.println("The secret word was " + String.valueOf(realWord));
				System.out.println("You lose!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
