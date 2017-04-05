package assignment2;

/*
 * This class extends the Board class.
 * 
 */

import java.util.Arrays;

public class TicTacToeBoard extends Board {

	/*
	 * The constructor takes in two ints representing the rows and columns. It
	 * initializes the 2D array to the size of rows and columns, and sets count
	 * of turns to 0.
	 */
	public TicTacToeBoard(int rows, int cols) {
		super(rows, cols);
		board = new XO[rows][cols];
		turnCnt = 0;
	}

	/*
	 * check if no more places to put an XO, return false
	 */
	public boolean isFull() {
		boolean ret = true;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == null) {
					ret = false;
					break;
				}
			}
		return ret;
	}

	/*
	 * The add method will add a new XO object onto the board (add to the 2D
	 * array). The method takes in two numbers representing which row and column
	 * you want to add the object. It returns a boolean if the object was
	 * successfully added. It will need to make sure that the passed in rows and
	 * columns are within the size restrictions of the board. It will also need
	 * to make sure that the place on the board doesn't already have an XO
	 * object.
	 */
	public boolean add(int row, int col) {
		boolean isAdded = false;
		if (row > board.length) {
			System.out.print("the passed in row is not within the size restrictions of the board");
		} else if (col > board[0].length) {
			System.out.print("the passed in column is not within the size restrictions of the board");
		} else if (board[row - 1][col - 1] != null) {
			System.out.print("the place on the board already has an XO object.");
		} else {
			isAdded = true;
			XO xo = new XO();
			board[row - 1][col - 1] = xo;
		}
		return isAdded;
	}

	/*
	 * The winner method checks to see if there is a winner (returns true or
	 * false). The method will need to check for wins by rows, columns and
	 * across the diagonals.
	 */

	public boolean winner() {
		boolean isWin = false;
		boolean allIsTheSame = true;

		// Start to check if all of items in one row is the same xo
		for (int i = 0; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				// if one grid of board is empty, means that this row is not
				// filled with fully
				if (board[i][j] == null || board[i][j - 1] == null) {
					allIsTheSame = false;
				} else if (!board[i][j].equals(board[i][j - 1])) {
					// if one grid is X another is O, means in this row, nobody
					// win
					allIsTheSame = false;
					break;
				}
			}
			// if found one row is filled with the same XO, return true
			if (allIsTheSame == true) {
				isWin = true;
				return isWin;
			}
		}

		// if all of rows are different XO objects, start to check if all of one
		// column is the same xo

		allIsTheSame = true;
		for (int j=0; j < board.length; j++) {
			for (int i = 1; i < board.length; i++) {
				// if one grid is empty, means that this columns is not filled
				// with the same xo
				if (board[i][j] == null || board[i-1][j] == null) {
					allIsTheSame = false;
				} else if (!board[i][j].equals(board[i-1][j])) {
					allIsTheSame = false;
					break;
				}
			}
			// if found one column is filled with the same xo, return true
			if (allIsTheSame == true) {
				isWin = true;
				return isWin;
			}
		}

		allIsTheSame = true;
		// Start to check if the Dignoal is the same
		// Firstly, check the dignoal from left to right
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i + 1][i + 1] == null || board[i][i] == null) {
				allIsTheSame = false;
			} else if (!board[i + 1][i + 1].equals(board[i][i])) {
				allIsTheSame = false;
				break;
			}
		}
		if (allIsTheSame == true) {
			isWin = true;
			return isWin;
		}

		allIsTheSame = true;
		// Start to check if the Dignoal is the same, from right to left
		for (int i = board.length - 1; i >= 1; i--) {
			if (board[board.length - (i + 1)][i] == null || board[board.length - i][i - 1] == null) {
				allIsTheSame = false;
			} else if (!board[board.length - (i + 1)][i].equals(board[board.length - i][i - 1])) {
				allIsTheSame = false;
				break;
			}
		}
		if (allIsTheSame == true) {
			isWin = true;
			return isWin;
		}

		return isWin;
	}

	/*
	 * A toString method that prints out what the current board looks like. The
	 * toString method should print out the board similar to the sample output
	 * (at the end of the assignment). And as XOs are added to the board, these
	 * should also be printed.
	 */
	public String toString() {
		//test to see 
		// for (int i = 0; i < board.length; i++)
		// System.out.println(Arrays.toString(board[i]));
		String ss = "";
		// Start to print the head row
		System.out.println("            Col");
		String str = "            ";
		for (int i = 0; i < board.length; i++) {
			str = str + (i + 1) + "    ";
		}
		System.out.println(str);
		for (int i = 0; i < board.length; i++) {
			String s = "    ";
			if (i == 0) {
				s = "Row " + s;
			} else {
				s = "    " + s;
			}
			s = s + (i + 1) + "   ";
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != null)
					s = s + board[i][j].getName() + "   ";
				else
					s = s + "    ";
			}
			System.out.println(s);
		}

		return ss;
	}

	public XO[][] getBoard() {
		return board;
	}

	public void setBoard(XO[][] board) {
		this.board = board;
	}

	public int getTurnCnt() {
		return turnCnt;
	}

	public void setTurnCnt(int turnCnt) {
		this.turnCnt = turnCnt;
	}

	/*
	 * A 2D array made up of XO objects with the size of Boards' rows and
	 * columns
	 */
	private XO[][] board;

	/*
	 * An int that keeps track of how many turns (e.g., how many X's and O's
	 * have currently been placed on the board.)
	 */
	private int turnCnt;

}
