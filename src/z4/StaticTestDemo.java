package z4;

public class StaticTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0;i<4;i++){
			StaticTest o1=new StaticTest(10);
			o1.method1();
			System.out.println(o1.method2());
		}
	}

}
