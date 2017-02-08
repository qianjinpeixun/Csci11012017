package z4;

public class MyInteger {
	//instance variable, 不是静态变量
	private static int value;

	public MyInteger(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public static boolean isEven(MyInteger i) {
		if (i.getValue() % 2 == 0)
			return true;
		else
			return false;
	}

	public boolean isEven(int num) {
		if (num % 2 == 0)
			return true;
		else
			return false;
	}

	public static boolean isOdd(int m) {
		if (m % 2 == 1)
			return true;
		else
			return false;
	}

	public static boolean isOdd(MyInteger i) {
		if (i.getValue() % 2 == 1)
			return true;
		else
			return false;
	}

	public boolean isPrime(MyInteger i) {
		int to = 0;
		for (int count = 2; count < i.getValue(); count++) {
			if (i.getValue() % count == 0)
				return false;
		}
		return true;
	}

	public static boolean isPrime(int num) {
		for (int count = 2; count < value; count++) {
			if (value % count == 0 && count != value)
				return true;
		}
		return false;
	}

	public boolean equals(int w) {

		return !(w == getValue());

	}

	public boolean equals(MyInteger i) {
		return !(value == i.getValue());
	}

	public static int parseInt(char[] chars) {
		return Integer.parseInt(new String(chars));
	}

	public static int parseInt(String s) {
		return Integer.parseInt(s);
	}
}
