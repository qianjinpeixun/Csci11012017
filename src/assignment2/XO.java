package assignment2;
/*
 * this class will hold information about an "X" or an "O" object.
 */

public class XO {

	/*
	 * This class have two attributes: a name (which is a String “X” or
	 * “O”),static int variable that is either set to 0 or 1 (it should be
	 * initialized to 1). You will use this variable to determine which name to
	 * give the object when it is created (e.g., if it is 1, set the name to
	 * "X").
	 */
	private String name;
	private static int turn = 1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int turn) {
		XO.turn = turn;
	}

	/*
	 * a no args constructor that sets the name of the object to either X or O
	 * based on the static variable (and update the variable).
	 */
	public XO() {
		if (turn == 1) {
			name = "X";
			turn = 0;
		} else {
			name = "O";
			turn = 1;
		}
	}

	/*
	 * a toString method that returns the name of the XO object
	 */
	@Override
	public String toString() {
		return "XO [name=" + name + "]";
	}

	/*
	 * an equals method to see if this XO object is the same as another XO
	 * object
	 */
	public boolean equals(XO anotherXO) {
		if (anotherXO.getName().equals(this.getName()))
			return true;
		else
			return false;
	}

}
