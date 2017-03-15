package abs;

/*
 * The only information that is maintained in this class is the airport name, 
 * which must be three alphabetic characters. 
 * No two airports can have the same name.
 */
public class Airport {

	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public Airport(String name) {
		this.name = name;
	}

}
