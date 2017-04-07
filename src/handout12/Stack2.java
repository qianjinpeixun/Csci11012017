package handout12;

import java.util.ArrayList;

public class Stack2 {

	
	private ArrayList<String> stack;
	private int top;

	public Stack2(int capacity) {
		stack = new ArrayList<String>();
	}

	public boolean isEmpty() {
		boolean ret = false;
		ret = (stack.size() == 0);
		return ret;
	}

	public void push(String x) {
		stack.add(x);
	}

	public String pop() {
		String ret = "";
		if (this.isEmpty() == true) {
			System.out.println("stack is empty");
		} else {
			ret = stack.remove(stack.size() - 1);
		}
		return ret;
	}

	public String peek() {
		String ret = "";
		if (this.isEmpty() == true) {
			System.out.println("stack is empty");
		} else {
			return stack.get(stack.size() - 1);
		}
		return ret;
	}

	public static void main(String[] args) {
		Stack2 stack1 = new Stack2(5);
		stack1.push("11");
		stack1.push("12");
		stack1.push("14");
		System.out.println(stack1);
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1);
		
	}
}
