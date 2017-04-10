package handout12;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack1 {

	//overloading
	//override
	
	public String toString() {
		return Arrays.toString(stack);
	}

	private String[] stack;
	private int top;

	public Stack1(int capacity) {
		stack = new String[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		boolean ret = false;
		if (top == -1)
			ret = true;
		return ret;
	}

	public void push(String x) {
		if (top == stack.length - 1) {
			System.out.println("Stack is full!");
		} else {
			top = top + 1;
			stack[top] = x;
		}

	}

	public String pop() {
		String ret = "";
		if (top == -1) {
			System.out.println("stack is empty");
		} else {
			ret = stack[top];
			stack[top] = null;
			top = top - 1;
		}
		return ret;
	}

	public String peek() {
		String ret = "";
		if (top == -1)
			System.out.println("stack is empty");
		else {
			ret = stack[top];
		}
		return ret;
	}

	public static String nbl(String ff) {
		String ret = "";

		return ret;
	}

	public static void main(String[] args) {
		
		
		
		Stack1 stack1 = new Stack1(5);
		System.out.println("stack1 tostring is:" + stack1);

		stack1.push("11");
		stack1.push("12");
		stack1.push("13");
		System.out.println(stack1);
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1);

		System.out.println("Begin to calculate:");
		String ff = "1+((2+3)*4)-5";
		String hf = "123+4*+5-";
		Stack1 s1 = new Stack1(100);
		for (int i = 0; i < hf.length(); i++) {
			char c = hf.charAt(i);
			if (c >= '0' && c <= '9') {
				s1.push(String.valueOf(c));
			} else {
				int n1 = Integer.parseInt(s1.pop());
				int n2 = Integer.parseInt(s1.pop());
				int v = 0;
				if (c == '+') {
					v = n1 + n2;
				} else if (c == '-') {
					v = n2 - n1;
				} else if (c == '*') {
					v = n1 * n2;
				} else if (c == '/') {
					v = n2 / n1;
				}
				s1.push(String.valueOf(v));
			}

		}
		System.out.println(s1);

		System.out.println("begin to check");
		String ss = "(())((()))";
		s1 = new Stack1(100);
		for (int i = 0; i < ss.length(); i++) {
			char c = ss.charAt(i);
			if (c == '(')
				s1.push(String.valueOf(c));
			else if (c == ')') {
				if (!s1.pop().equals("(")) {
					System.out.println("error format");
					break;
				}
			}
		}
		System.out.println(s1);

//		ArrayList<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		for (int i = 1; i < list.size(); i++) {
//			System.out.println(i);
//			list.add(i, "+");
//		}
//		System.out.println(list);

	}

}
