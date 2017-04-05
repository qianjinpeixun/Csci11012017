package assignment2;

/**
 * this is a class used to implement a variety of different boards for different
 * games (e.g., a chess board, checkers board, and in our case a tic tac toe
 * board).
 *
 */
public class Board {

	/*
	 * This class has two private attributes: the number of rows and number of
	 * columns of the board.
	 */
	private int rows;
	private int cols;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	/*
	 * a constructor that takes in and initializes the rows and columns
	 */
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

}
