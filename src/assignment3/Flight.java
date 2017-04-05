package assignment3;

import java.util.Arrays;

/*
 * a flight given an airline name, the name of the originating airport, 
 * the name of a destination airport, 
 * and a flight number: A flight has an identifier that is a string of alphanumeric characters.
 * This class maintains information about flights. It has the following attributes:
	a. Airline
	b. Flight id
	c. Seats: An 2d array of Seat objects.
 */
public class Flight {

	private Airline company;
	private String id;
	private Airport from_airport;
	private Airport to_airport;
	private Seat[][] seats;
	private int rows;

	public Airport getFrom_airport() {
		return from_airport;
	}

	public Airport getTo_airport() {
		return to_airport;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Airline getCompany() {
		return company;
	}

	public String getId() {
		return id;
	}

	public void DisplaySeatDetails() {
		String booked = "O";
		String unbooked = "-";
		System.out.println("");
		if (seats != null) {
			for (int i = 0; i < seats.length; i++) {
				System.out.println("");
				for (int j = 0; j < seats[0].length; j++) {
					if (seats[i][j].isIs_booked()) {
						System.out.print("	" + booked);
					} else {
						System.out.print("	" + unbooked);
					}
				}
			}
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		String ret = "";
		if (seats == null)
			ret = company + ", id=" + id + ", from_airport=" + from_airport + ", to_airport=" + to_airport
					+ ", not init seats, rows=" + rows;
		else {
			ret = company + ", id=" + id + ", from_airport=" + from_airport + ", to_airport=" + to_airport + ", seats="
					+ seats.length * seats[0].length + ", rows=" + rows;
		}
		return ret;
	}

	public Flight(Airline company, Airport from_airport, Airport to_airport, String id) {
		this.company = company;
		this.from_airport = from_airport;
		this.to_airport = to_airport;
		this.id = id;
		this.rows = 0;
		this.seats = null;
	}
}
