package assignment3;

/*
 * This class maintains information about seats. 
 * Each seat has an identifier (a seat is identified by a row number and a column character,
 *  which is a letter from A to F), 
 *  and a status which indicates if the seat is booked or available.
 */
public class Seat {

	private String identifier;
	private boolean is_booked;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public boolean isIs_booked() {
		return is_booked;
	}

	public void setIs_booked(boolean is_booked) {
		this.is_booked = is_booked;
	}

	@Override
	public String toString() {
		return "Seat [identifier=" + identifier + ", is_booked=" + is_booked + "]";
	}

	public Seat(String identifier) {
		this.identifier = identifier;
	}

}
