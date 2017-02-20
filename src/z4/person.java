package z4;

//类名大写
//'person' class
public class person {
	private String name;
	private int age;
	private double weight;
	private double height;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}

	public String toString1(){
		return "haha";
	}

	public double findBMI() {
		//一般不建议直接返回语句，应该返回变量
		double finalBMI=703 * weight / height / height;
		System.out.println(finalBMI);
		return finalBMI;
	}// end method
}// end class
