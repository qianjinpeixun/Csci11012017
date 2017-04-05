package assignment3;

/*
 * TAn airline has a name that must have length less than 6 alphabetic characters. 
 * No two airlines can have the same name.
 */
public class Airline {

	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Airline name=" + name;
	}

	public Airline(String name) {
		this.name = name;
	}

}
