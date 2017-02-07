package st4;

import java.util.Scanner;

public class Hangmandemo {

	public static void main(String[] args) {

		System.out.println("Welcome to the Hangman game.");
		System.out.println(
				"I have a secret Pokemon character name. You have to guess it. You are allowed only six incorrect guesses.");

		Hangman hangman = new Hangman();
		char[] generatedWord = hangman.generateSecretWord();
		hangman.setSecretWord(generatedWord);

		System.out.println(generatedWord);
		String disguisedWord = "";
		String inputWord = "";

		while (hangman.getNumIncorrect() < 6) {
			hangman.setNumGuesses(hangman.getNumGuesses() + 1);
			disguisedWord = String.valueOf(hangman.getDisguisedWord());

			System.out.println("");
			System.out.println("Secret word: " + disguisedWord);
			System.out.print("Enter the guess: ");

			Scanner scanner = new Scanner(System.in);
			String userLetter = scanner.nextLine();
			char[] inputChars = inputWord.toCharArray();
			boolean needBreak = false;
			for (int i = 0; i < inputChars.length; i++) {
				if (userLetter.toCharArray()[0] == inputChars[i]) {
					System.out.println(userLetter + " has been gusested!");
					needBreak = true;
					break;
				}
			}
			if (needBreak == true)
				continue;
			inputWord = inputWord + userLetter;

			if (hangman.makeGuess(userLetter.toCharArray()[0]) == true) {
				System.out.println("Correct.");

			} else {
				hangman.setNumIncorrect(hangman.getNumIncorrect() + 1);
				System.out.println("Incorrect. You have " + String.valueOf(6 - hangman.getNumIncorrect())
						+ " incorrect guesses left.");

			}

			if (hangman.isFound()) {
				System.out.println("");
				System.out.println("Secret word: " + String.valueOf(generatedWord));
				System.out.println("You win!");
				break;
			}

		}

		if (!hangman.isFound()) {
			System.out.println("");
			System.out.println("The secret word was " + String.valueOf(generatedWord));
			System.out.println("You lose!");
		}

	}
}
