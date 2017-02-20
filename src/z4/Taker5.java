package z4;

//怎么改类的名字

public class Taker5 {
	private static int turn = 0;
	private int myTurn;
	private String name;

	public Taker5(String n, int t) {
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
		return true;
	}

	public static void main(String[] args) {
		
		
		Taker5 person1 = new Taker5("Romeo", 1);
		
		
		
		Taker5 person2 = new Taker5("Juliet", 3);
		for (int i = 1; i <= 5; i++) {
			System.out.println("Turn = " + Taker5.getTurn());
			if (person1.isMyTurn())
				System.out.println("Love from " + person1.getName());
			if (person2.isMyTurn())
				System.out.println("Love from " + person2.getName());
		}
	}
}
