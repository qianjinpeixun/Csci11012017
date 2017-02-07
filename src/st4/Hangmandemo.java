package st4;

import java.util.Scanner;

public class Hangmandemo {

	public static void main(String[] args) {

		System.out.println("Welcome to the Hangman game.");
		System.out.println(
				"I have a secret Pokemon character name. You have to guess it. You are allowed only six incorrect guesses.");

		Hangman hangman = new Hangman();

		String disguisedWord = "";

		while (hangman.getNumIncorrect() <= 6) {

			disguisedWord = String.valueOf(hangman.getDisguisedWord());

			System.out.println("");
			System.out.println("Secret word: " + disguisedWord);
			System.out.print("Enter the guess: ");

			Scanner scanner = new Scanner(System.in);
			String userLetter = scanner.nextLine();
			
			

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

	}
}
