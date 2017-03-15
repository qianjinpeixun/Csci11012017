package abs;

import java.util.Scanner;

/*
 * This is a sample client program with a main method that calls operations in the ABS system
*/

public class Client {

	public static void main(String[] args) {
		ABS abs = new ABS();

		// Firstly, start to add SOME airports
		System.out.println("ABS started!");
		System.out.println("Firstly, ABS will create 7 different airports.");
		abs.createAirport("YHZ");
		abs.createAirport("YYZ");
		abs.createAirport("YYC");
		abs.createAirport("YVR");
		abs.createAirport("YUL");
		abs.createAirport("BOS");
		abs.createAirport("PRI");
		abs.displaySystemDetails();

		System.out.println("Now, try to create an illegal airport: HALIFAX");
		abs.createAirport("HALIFAX");
		System.out.println("Now, try to create an illegal airport: BC");
		abs.createAirport("BC");
		System.out.println("Now, try to create an illegal airport: 123");
		abs.createAirport("123");
		System.out.println("");
		
		// Secondly, start to add 3 airline companies
		System.out.println("Secondly, ABS will create 5 different airline companies:");
		abs.createAirline("AC");
		abs.createAirline("DELTA");
		abs.createAirline("WSJET");
		abs.createAirline("CA");
		abs.createAirline("UA");
		abs.displaySystemDetails();

		System.out.println("Now, try to create an illegal airline: LARGERAIRLINE");
		abs.createAirline("LARGERAIRLINE");
		System.out.println("");
		
		// Thirdly, create some flight for test
		System.out.println("Thirdly, ABS will create some flights:");
		abs.createFlight("AC", "YHZ", "YYZ", "123");
		abs.createFlight("DELTA", "YHZ", "YYZ", "125");
		abs.createFlight("UA", "YHZ", "YYZ", "126");
		abs.createFlight("AC", "BOS", "YYZ", "223");
		abs.createFlight("DELTA", "BOS", "YYZ", "225");
		abs.createFlight("UA", "BOS", "YYZ", "226");
		abs.displaySystemDetails();
		System.out.println("");

		System.out.println("Try to create another flight withe the same airline and id: AC 123");
		abs.createFlight("AC", "YHZ", "YYZ", "123");
		System.out.println("");

		System.out.println("Fourthly, ABS will create seats for AC223,AC123,DELTA125 and UA126:");
		abs.createSeats("AC", "223", 10);
		abs.createSeats("AC", "123", 5);
		abs.createSeats("DELTA", "125", 20);
		abs.createSeats("UA", "126", 10);
		abs.displaySystemDetails();

		System.out.println("");
		System.out.println("Then, begin to query flights from BOS to YYZ:");
		abs.findAvailableFlights("BOS", "YYZ");

		System.out.println("");
		System.out.println("Next, try to book a set for 5A in AC223:");
		abs.bookSeat("AC", "223", 5, 'A');
		System.out.println("Next, try to book a set for 5B in AC223:");
		abs.bookSeat("AC", "223", 5, 'B');
		System.out.println("Next, try to book a set for 5C in AC223:");
		abs.bookSeat("AC", "223", 5, 'C');
		
		System.out.println("Next, try to book 5A in AC223 for other person:");
		abs.bookSeat("AC", "223", 5, 'A');

	}

}
