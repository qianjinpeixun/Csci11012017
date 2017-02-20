package z4;

public class StaticTest {

	private int x;
	private static int y=5;
	public StaticTest(int value){
		x=value;
	}
	
	public void method1(){
		x++;
		y++;
		
	}
	public int method2(){
		return x+y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
