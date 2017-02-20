
import java.util.Scanner;

/*
 * This class will allow users to play the game (e.g., the demo class). You will create a new TicTacToeBoard.
 */
public class Play {

	public static void main(String[] args) {

		/*
		 * use a Scanner object to get the names of your two players and to get
		 * the locations of their respective X and O's on the board.
		 */
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player 1 name: ");
		String name1 = keyboard.nextLine();

		System.out.print("Player 2 name: ");
		String name2 = keyboard.nextLine();

		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(3, 3);
		System.out.println(name1 + " - you are X's and you go first.");
		ticTacToeBoard.toString();
		boolean isFirstTurn = true;
		/*
		 * The game should continue until there is a winner or there is a tie
		 * (ie., no more places to put an XO).
		 */
		while (true) {
			
			String printedMessage = "";
			boolean hasAdded = false;
			while (hasAdded == false) {
				if (isFirstTurn) {
					printedMessage = "Please input a row# between 1-3 and column# between 1-3:";
					isFirstTurn = false;
				} else {
					printedMessage = name1 + " please input a row# between 1-3 and column# between 1-3:";
				}
				System.out.print(printedMessage);
				int x1 = keyboard.nextInt();
				int y1 = keyboard.nextInt();
				hasAdded = ticTacToeBoard.add(x1, y1);
				if (hasAdded)
					break;
			}
			ticTacToeBoard.toString();
			if (ticTacToeBoard.winner()) {
				System.out.println(name1 + " you win!");
				break;
			}
			if (ticTacToeBoard.isFull()) {
				System.out.println("There is no more place to put an XO, nobody win!");
				break;
			}

			// begin player 2
			hasAdded = false;
			while (hasAdded == false) {
				printedMessage = name2 + " please input a row# between 1-3 and column# between 1-3:";
				System.out.print(printedMessage);
				int x1 = keyboard.nextInt();
				int y1 = keyboard.nextInt();
				hasAdded = ticTacToeBoard.add(x1, y1);
				if (hasAdded)
					break;
			}
			ticTacToeBoard.toString();

			if (ticTacToeBoard.winner()) {
				System.out.println(name2 + " you win!");
				break;
			}

			if (ticTacToeBoard.isFull()) {
				System.out.println("There is no more place to put an XO, nobody win!");
				break;
			}
		}

	}

}
