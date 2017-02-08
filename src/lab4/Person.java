package lab4;

public class Person {

	private String name;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public boolean hasSameName(Person anotherPerson) {
		boolean ret = false;
		if (anotherPerson.getName().equals(name))
			ret = true;
		return ret;
	}
}
