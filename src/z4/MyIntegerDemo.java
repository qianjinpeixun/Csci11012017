package z4;

public class MyIntegerDemo {
	public static void main(String[] args) {
		MyInteger n1 = new MyInteger(9);
		System.out.println("n1 is " + n1.getValue());
		System.out.println("n1 is even? " + n1.isEven(n1));
		System.out.println("n1 is odd? " + n1.isOdd(n1));
		System.out.println("n1 is prime? " + n1.isPrime(n1));
		System.out.println("15 is prime? " + MyInteger.isPrime(15));
		char[] chars = { '3', '5', '3', '9' };
		System.out.println(MyInteger.parseInt(chars));
		String s = "9786";
		System.out.println(MyInteger.parseInt(s));
		MyInteger n2 = new MyInteger(2);
		System.out.println("n2 is " + n2.getValue());
		System.out.println("n2 is odd? " + n2.isOdd(n2));
		System.out.println("44 is odd? " + MyInteger.isOdd(4));
		System.out.println("n1 is equal to n2? " + n1.equals(n2));
		System.out.println("n1 is equal to 9? " + n1.equals(9));
	}
}