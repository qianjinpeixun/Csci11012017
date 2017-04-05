package handout12;

import assignment4.LinkedList;
import assignment4.Node;

public class Stack3 {

	private LinkedList stack;

	public Stack3() {
		stack = new LinkedList();

	}

	public boolean isEmpty() {
		boolean ret = false;
		if (stack.isEmpty())
			ret = true;
		return ret;
	}

	public void push(String x) {
		stack.addToFront(x);
	}

	public String pop() {
		String ret = "";
		if (this.isEmpty() == true) {
			System.out.println("stack is empty");
		} else {
			ret = stack.getFrontData();
			stack.removeFront();
		}
		return ret;
	}

	public String peek() {
		String ret = "";
		ret = stack.getFrontData();
		return ret;
	}
	public static void main(String[] args) {
		Stack3 stack1 = new Stack3();
		stack1.push("11");
		stack1.push("12");
		stack1.push("14");
		System.out.println(stack1);
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1.peek());
		System.out.println(stack1);
	}
		
}
