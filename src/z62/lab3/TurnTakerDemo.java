package z62.lab3;

public class TurnTakerDemo {
	// This class use the method in TurnTaker class and set the data.
	public static void main(String[] args) {
		TurnTaker person1 = new TurnTaker("Romeo", 1);
		TurnTaker person2 = new TurnTaker("Juliet", 3);
		for (int i = 1; i <= 5; i++) {
			System.out.println("Turn = " + TurnTaker.getTurn());
			if (person1.isMyTurn())
				System.out.println("Love from " + person1.getName());
			if (person2.isMyTurn())
				System.out.println("Love from " + person2.getName());
		}
	}
}
