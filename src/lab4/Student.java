package lab4;

public class Student extends Person {

	private int sutdentNumber;

	public Student() {

	}
	
	@Override
	public String getName(){
		return "Student name is:"+super.getName();
	}

	public void reset(String newName, int newNumber) {
		this.sutdentNumber = newNumber;
		setName(newName);
	}

	public int getSutdentNumber() {
		return sutdentNumber;
	}

	public void setSutdentNumber(int sutdentNumber) {
		this.sutdentNumber = sutdentNumber;
	}

	@Override
	public String toString() {
		return "Student [sutdentNumber=" + sutdentNumber + ", getName()=" + getName() + ", Person="
				+ super.toString() +"]";
	}

	public boolean equals(Student anotherstudent) {
		boolean ret = false;
		if (hasSameName(anotherstudent) == true)
			ret = true;
		else
			ret = false;
		return ret;
	}

}
