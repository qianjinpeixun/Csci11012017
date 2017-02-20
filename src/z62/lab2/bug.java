package z62.lab2;

public class bug {
	private int position;
	/*
	 * CSCI 1101-Lab 2-E1 The class write a class called Bug that models the
	 * bug¡¯s position and direction, and has the method move() in addition to
	 * other methods. <Wenyi Zhang><B00732630><2017.Jan.24>
	 */
	private int direction;
	private int moves;

	public bug(int pos, int dir) {
		position = pos;
		direction = dir;
	}

	public void setPosition(int pos) {
		position = pos;
	}

	public int getPosition() {
		return position;
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public int getDirection() {
		return direction;
	}

	public void setMoves(int mov) {
		moves = mov;
	}

	public int getMoves() {
		return moves;
	}

	public void move() {
		if (direction == 0 || position == 50) {
			direction = 0;
			position--;
		} else if (direction == 1 || position == 0) {
			direction = 1;
			position++;
		}
	}

	public String toString() {
		if (direction == 1)
			if ((position + moves) > 50) {
				position = 100 - (position + moves);
				direction = 0;
			} else {
				position = position + moves;
				direction = 1;
			}
		else if (direction == 0)
			if ((position - moves) > 0) {
				position = position - moves;
				direction = 0;
			} else {
				position = moves - position;
				direction = 1;
			}

		String Finaldirection = "";
		if (direction == 0)
			Finaldirection = "Left";
		else if (direction == 1)
			Finaldirection = "Right";
		return "Position:" + position + "\tdirection:" + Finaldirection;
	}
}
