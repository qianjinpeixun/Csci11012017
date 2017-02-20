package duotai;

public class CatDemo {

	public static void main(String[] args) {
		Animal am = new Cat();
		am.eat();
		am.sleep();
		am.run();
		// am.catchMouse();
		// System.out.println(am.name);
		System.out.println(am.num);
		System.out.println(am.age);
	}
}
