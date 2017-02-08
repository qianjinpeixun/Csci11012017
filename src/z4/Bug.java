package z4;

/*this program will create a bug to walk on a line,length of line is 50,two walls at 0 and 50,
 * ex:bug walks toward right for certain steps hit the wall than go to oppsite direction(left) 
 * <zishen cao><B00723808><Jan 28th>*/
public class Bug {
	// three 'private' variables to determine initial positon,direction and how
	// many moves to go
	private int position;
	private int direction;
	private int moves;

	// 'bug'constructor
	public Bug(int pos, int dir) {
		position = pos;
		direction = dir;
	}

	// 'set'methods
	public void setPosition(int pos) {
		position = pos;
	}

	public int getPosition() {
		return position;
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	// 'get' methods
	public int getDirection() {
		return direction;
	}

	public void setMoves(int mov) {
		moves = mov;
	}

	public int getMoves() {
		return moves;
	}

	// 'move' method :if a bug is at 0,make it go to position 1,at 50,go to 49
	public void move()

	{
		
		//啥意思？

		if (direction == 0 || position == 50) {
			direction = 0;
			position--;
		}

		else if (direction == 1 || position == 0) {
			direction = 1;
			position++;
		}
	}

	// to return final position of a bug, and determine final direction
	public String toString() {
		if (direction == 1)

			if ((position + moves) > 50) {

				position = 100 - (position + moves);

				direction = 0;

			}

			else {

				position = position + moves;

				direction = 1;

			}

		else if (direction == 0)

			if ((position - moves) > 0) {

				position = position - moves;

				direction = 0;

			}

			else {

				position = moves - position;

				direction = 1;

			}

		String directionFinal = "";

		if (direction == 0)

			directionFinal = "Left";

		else if (direction == 1)

			directionFinal = "Right";

		return "Position:" + position + "\tdirection:" + directionFinal;

	}

	// main method
	public static void main(String[] args)

	{

		// randomly set the initial position(between 0 and 50) and direction
		int initialPos = (int) (Math.random() * 51);

		int initialDir = (int) (Math.random() * 2);

		Bug bugsy = new Bug(initialPos, initialDir);

		System.out.println(bugsy);

		// display the line with the bug

		for (int i = 0; i <= 50; i++)

		{

			if (i == bugsy.getPosition())

				System.out.print("X");

			else

				System.out.print("-");

		}

		System.out.println();

		// make the bug move a random number of times

		int moves = (int) (Math.random() * 51);

		System.out.println("Moves: " + moves);

		for (int i = 1; i <= moves; i++)

			bugsy.move();

		System.out.println(bugsy);

		// display the line with the bug

		for (int i = 0; i <= 50; i++)

		{

			if (i == bugsy.getPosition())

				System.out.print("X");

			else

				System.out.print("-");

		}

		System.out.println();

	}// end method

}// end class
