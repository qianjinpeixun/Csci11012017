package z62.lab3;

/*CSCI 1101-Lab 3-E1(a)
This TurnTaker class gives TurnTakerDemo class the calculation and get the data.
<Wenyi Zhang><B00732630><2017.Feb.1st>*/
public class TurnTaker {
	private static int turn = 0;
	private int myTurn;
	private String name;

	public TurnTaker(String n, int t) {
		name = n;
		myTurn = t;
	}

	public String getName() {
		return name;
	}

	public static int getTurn() {
		turn++;
		return turn;
	}

	public boolean isMyTurn() {
		if (turn == myTurn)
			return true;
		else
			return false;
	}
}
