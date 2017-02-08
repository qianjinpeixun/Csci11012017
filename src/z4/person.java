package z4;

//类名大写
//'person' class
public class person {
	private String name;
	private int age;
	private double weight;
	private double height;

	// some 'set'methods to hold value
	
	public void setAge(int a) {
		age = a;
	}
	//setName是eclipse自动生成的
	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double w1) {
		weight = w1;
	}

	public void setHeight(double h1) {
		height = h1;
	}

	// some 'get' methods to hold value
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public double findBMI() {
		//一般不建议直接返回语句，应该返回变量
		return 703 * weight / height / height;
	}// end method
}// end class
