package abs;

import java.util.ArrayList;

/*
 * This is the main class that aggregates the other classes 
 * and provides functionality to the client program. 
 * A client program with a main method accesses this ABS class.
 * The ABS allows a client program to create airports, airlines, and flights. 
 * Each flight has an originating airport (origin) and a destination airport (destination). 
 * The origin and destination cannot be the same. 
 * Each flight consists of seats organized in rows. 
 * Each row has six seats (“A”, “B”, “C”, “D”, “E”, “F”).
 */
public class ABS {

	// This ArrayList will store the current airports
	private ArrayList<Airport> list_airport;

	// This ArrayList will store the current airlines;
	private ArrayList<Airline> list_airline;

	// This ArrayList will store the current flights
	private ArrayList<Flight> list_flight;

	/*
	 * This class has the following attributes: list_airport – an arraylist of
	 * airport objects, initially empty. list_airline – an arraylist of airline
	 * objects, initially empty. list_flight – an arraylist of flight objects,
	 * initially empty.
	 */
	public ABS() {
		list_airport = new ArrayList<Airport>();
		list_airline = new ArrayList<Airline>();
		list_flight = new ArrayList<Flight>();
	}

	/*
	 * Books seat in given row and column on flight fl of airline air, if that
	 * particular seat is still available.
	 */
	public void bookSeat(String air, String fl, int row, char column) {
		boolean found = false;
		// the input of col of one seat will be: A B C D E F, so needs to change
		// this char to int firstly
		int col = (int) (column - 'A');

		// searchedFlight will be the query airline
		Flight searchedFlight = null;
		// Start to find correct ariline
		for (int i = 0; i < list_flight.size(); i++) {
			Flight flight = list_flight.get(i);
			if (flight.getCompany().getName().toLowerCase().equals(air.toLowerCase())
					&& flight.getId().toLowerCase().equals(fl.toLowerCase())) {
				searchedFlight = flight;
				break;
			}
		}
		if (searchedFlight == null) {
			System.out.println("No flights with " + air + " " + fl + " , please try other cities!");
		} else {
			// found the correct airline
			Seat[][] seats = searchedFlight.getSeats();
			if (seats == null) {
				System.out.println("This flight has not been init the seats!");
			} else {
				if (row >= seats.length) {
					System.out.println("invalid – row " + row + " doesn’t exist");

				} else if (col >= 6) {
					System.out.println("invalid – col " + column + " doesn’t exist");
				} else {
					Seat seat = seats[row-1][col];
					if (seat.isIs_booked()) {
						System.out.println("Seat " + row +  column + " has been booked by others!");
					} else {
						seat.setIs_booked(true);
						System.out.println("Seat " + row + column + " has been booked sucessfully!");
						searchedFlight.DisplaySeatDetails();
					}
				}

			}
		}

	}

	/*
	 * inquery in the flight list, try to find the same orig and dest flights
	 */
	public void findAvailableFlights(String orig, String dest) {

		boolean found = false;
		for (int i = 0; i < list_flight.size(); i++) {
			Flight flight = list_flight.get(i);
			if (flight.getFrom_airport().getName().toLowerCase().equals(orig.toLowerCase())
					&& flight.getTo_airport().getName().toLowerCase().equals(dest.toLowerCase())) {
				System.out.print("From " + orig + " to " + dest + ": ");
				System.out.println(flight);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No flights from " + orig + " to " + dest + " , please try other cities!");
		}
	}

	/*
	 * This method will init the seats for one flight
	 */
	public void createSeats(String air, String flID, int rows) {
		Flight foundFlight = null;
		for (int i = 0; i < list_flight.size(); i++) {
			Flight flight = list_flight.get(i);
			if (flight.getCompany().getName().toLowerCase().equals(air.toLowerCase())) {
				if (flight.getId().equals(flID)) {
					// found the flight, begin to set seats
					foundFlight = flight;
					break;
				}
			}
		}

		Seat[][] seats = new Seat[rows][6];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 6; j++) {
				char identifier = (char) ('A' + j);
				String id = String.valueOf(i) + String.valueOf(identifier);
				Seat seat = new Seat(id);
				seat.setIs_booked(false);
				seats[i][j] = seat;
			}
		}
		foundFlight.setSeats(seats);
		foundFlight.setRows(rows);
	}

	/*
	 * Creates a flight for an airline named aname, from an originating airport
	 * (orig) to a destination airport (dest). The flight has an identifier
	 * (id).
	 */
	public void createFlight(String aname, String orig, String dest, String id) {
		// Firstly, checking the ariline name
		boolean is_a_correct_airline_name = false;
		Airline airline = null;
		for (int i = 0; i < list_airline.size(); i++) {
			String currentName = list_airline.get(i).getName();
			if (currentName.toLowerCase().equals(aname.toLowerCase())) {
				is_a_correct_airline_name = true;
				airline = list_airline.get(i);
				break;
			}
		}
		if (!is_a_correct_airline_name) {
			System.out.println("Wrong airline name, please enter again!");
			return;
		}

		// Secondly, checking the origina airport name
		Airport orgi_airport = null;
		boolean is_a_correct_airport_name = false;
		for (int i = 0; i < list_airport.size(); i++) {
			String currentName = list_airport.get(i).getName();
			if (currentName.toLowerCase().equals(orig.toLowerCase())) {
				is_a_correct_airport_name = true;
				orgi_airport = list_airport.get(i);
				break;
			}
		}
		if (!is_a_correct_airport_name) {
			System.out.println("Wrong original airport name, please enter again!");
			return;
		}

		// Thirdly, checking the dest aripot name
		Airport dest_airport = null;
		is_a_correct_airport_name = false;
		for (int i = 0; i < list_airport.size(); i++) {
			String currentName = list_airport.get(i).getName();
			if (currentName.toLowerCase().equals(dest.toLowerCase())) {
				is_a_correct_airport_name = true;
				dest_airport = list_airport.get(i);
				break;
			}
		}
		if (!is_a_correct_airport_name) {
			System.out.println("Wrong dest airport name, please enter again!");
			return;
		}

		// Finally, checking the if the id has existed
		if (list_flight.isEmpty()) {
			Flight flight = new Flight(airline, orgi_airport, dest_airport, id);
			list_flight.add(flight);
			return;
		}
		boolean has_same_id = false;
		for (int i = 0; i < list_flight.size(); i++) {
			Flight ff = list_flight.get(i);
			if (ff.getCompany().getName().toLowerCase().equals(aname.toLowerCase())) {
				if (ff.getId() == id) {
					has_same_id = true;
					break;
				}
			}
		}
		if (has_same_id) {
			System.out.println("Exist the same id:"+id+" under airline company:"+aname+", please enter again!");
			return;
		} else {
			Flight flight = new Flight(airline, orgi_airport, dest_airport, id);
			list_flight.add(flight);
		}
		return;
	}

	/*
	 * Creates an airline object with name n and updates the appropriate
	 * arraylist. An airline has a name that must have a length less than 6. No
	 * two airlines can have the same name.
	 */
	public boolean createAirline(String name) {
		boolean ret = false;
		/*
		 * Firstly, check if the input airline name is empty or if the length is
		 * less than 6
		 */
		if (name == null || name.equals("") || name.trim().equals("") || name.length() >= 6) {
			System.out.println("Invalid airline name, must have a length less than 6.!");
			return false;
		} else {
			// Secondly, if it's the first airline, create it directly
			if (list_airline.isEmpty()) {
				Airline airline = new Airline(name);
				list_airline.add(airline);
				return true;
			} else {
				// Thirdly, check if the name is unique
				boolean hasSameName = false;
				for (int i = 0; i < list_airline.size(); i++) {
					Airline airline = list_airline.get(i);
					if (airline.getName().toLowerCase().equals(name.toLowerCase())) {
						hasSameName = true;
						break;
					}
				}
				// Finally,if it's a new name, create a new airline company
				if (!hasSameName) {
					Airline airline = new Airline(name);
					list_airline.add(airline);
					ret = true;
				}
			}
		}

		return ret;
	}

	/*
	 * This method will create a new airport, if name is exact 3 character, and
	 * no exists name, it will create a new object and put it into current
	 * arrayList and return ture; otherwise, it will print the error message and
	 * return with false
	 */
	public boolean createAirport(String name) {
		boolean ret = true;

		/*
		 * Firstly, check if the input aiport name is empty or if the length is
		 * exact 3
		 */
		if (name == null || name.equals("") || name.trim().equals("") || name.length() != 3) {
			System.out.println("Invalid airport name: "+name+", must have exactly three alphabetic characters!");
			return false;
		} else {
			// Secondly, check if all the three char is a-z or A-Z
			boolean isThreeChar = false;
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				isThreeChar = false;
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					isThreeChar = true;
				} else {
					isThreeChar = false;
					break;
				}
			}
			if (!isThreeChar) {
				System.out.println("Invalid airport name "+name+", no alphabetic characters is invalid!");
				return false;
			}
		}

		// Thirdly, start to check if the same name exists
		if (list_airport.isEmpty()) {
			name = name.toUpperCase();
			Airport airport = new Airport(name);
			list_airport.add(airport);
		} else {
			for (int i = 0; i < list_airport.size(); i++) {
				String current_name = list_airport.get(i).getName();
				if (current_name.toLowerCase().equals(name.toLowerCase())) {
					System.out.println("Invalid Airport name, a same one exists!");
					ret = false;
					break;
				}
			}
			if (ret == true) {
				// Finally, create a new airport object, put it in Arraylist
				name = name.toUpperCase();
				Airport airport = new Airport(name);
				list_airport.add(airport);
			}
		}
		return ret;
	}

	/*
	 * Displays attribute values for all objects (e.g., airports, flights) in
	 * the system.
	 */
	public void displaySystemDetails() {
		System.out.println("Now, ABS has " + list_airport.size() + " Airports:");
		for (int i = 0; i < list_airport.size(); i++) {
			System.out.print("	" + list_airport.get(i).getName());
		}
		System.out.println("");
		System.out.println("Now, ABS has " + list_airline.size() + " Airline companies:");
		for (int i = 0; i < list_airline.size(); i++) {
			System.out.print("	" + list_airline.get(i).getName());
		}
		System.out.println("");
		System.out.println("Now, ABS has " + list_flight.size() + " Flights:");
		for (int i = 0; i < list_flight.size(); i++) {
			System.out.println("	" + list_flight.get(i));
		}
		System.out.println("");
	}

}
