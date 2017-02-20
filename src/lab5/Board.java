package lab5;

import java.util.Arrays;
import java.util.Random;

/**
 * this is a class used to implement a variety of different boards for different
 * games (e.g., a chess board, checkers board, and in our case a tic tac toe
 * board).
 *
 */
public class Board {

	public static void main(String[] args) {

		int[][] board = new int[8][8];

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Random random = new Random();
				boolean ret = random.nextBoolean();
				if (ret == true)
					board[i][j] = 0;
				else
					board[i][j] = 1;

			}

		for (int i = 0; i < 8; i++)
			System.out.println(Arrays.toString(board[i]));

		System.out.println("All zeros:");
		for (int i = 0; i < 8; i++) {
			boolean rowIsOne = false;
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 1) {
					rowIsOne = true;
					break;
				}
			}
			if (rowIsOne == false) {
				System.out.println("Row " + i);
			}
		}

		for (int i = 0; i < 8; i++) {
			boolean coloumIsOne = false;
			for (int j = 0; j < 8; j++) {
				if (board[j][i] == 1) {
					coloumIsOne = true;
					break;
				}
			}
			if (coloumIsOne == false) {
				System.out.println("Column " + i);
			}
		}

		boolean DigonalIsOne = false;
		for (int i = 0; i < 8; i++) {

			if (board[i][i] == 1) {
				DigonalIsOne = true;
				break;
			}
		}
		if (DigonalIsOne == false) {
			System.out.println("Sub-diagonal left to right");
		}

		DigonalIsOne = false;
		for (int i = 7; i >= 0; i--) {
			if (board[7 - i][i] == 1) {
				DigonalIsOne = true;
				break;
			}
		}
		if (DigonalIsOne == false) {
			System.out.println("Sub-diagonal right to left");
		}

	}

}
