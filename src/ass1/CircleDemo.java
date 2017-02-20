package ass1;
import java.util.Scanner;

public class CircleDemo {

	public static void main(String[] args) {
		Scanner keyboard =new Scanner(System.in);
		System.out.println("Enter the center coordinates (x,y) of the first circle and its radius: ");
		Circle c1=new Circle(keyboard.nextDouble(),keyboard.nextDouble(),keyboard.nextDouble());
		System.out.println("Enter the center coordinates (x,y) of the second circle and its radius: ");
		Circle c2=new Circle(keyboard.nextDouble(),keyboard.nextDouble(),keyboard.nextDouble());

		if(c1.touchExternally(c2)){
			System.out.println(c1+" touches "+c2+" externally");
		}else{
			System.out.println(c1+" does not touch "+c2+" externally");
		}
	
		if(c1.touchInternally(c2)){
			System.out.println(c1+" touches "+c2+" internally");
		}else{
			System.out.println(c1+" does not touch "+c2+" internally");
		}
	}

}
