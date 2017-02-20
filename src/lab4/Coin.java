package lab4;

public class Coin {
	private String name;
	private int value;
	
	
	public Coin(){
		
	}
	
	public Coin(String n){
		this.name=n;
	}

	
	public Coin(String name, int value) {
		this.name = name;
		this.value = value;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Coin [name=" + name + ", value=" + value + "]";
	}
	

	
	
}
