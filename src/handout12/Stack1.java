package handout12;

import java.util.Arrays;

public class Stack1 {

	public String toString(){
		return Arrays.toString(stack);
	}
	private String[] stack;
	private int top;

	public Stack1(int capacity) {
		stack = new String[capacity];
		top = -1;
	}

	public boolean isEmpty(){
		boolean ret=false;
		if(top==-1) ret=true;
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
			stack[top]=null;
			top = top - 1;
		}
		return ret;
	}

	public String peek() {
		String ret = "";
		if(top==-1)
			System.out.println("stack is empty");
		else{
			ret=stack[top];
		}
		return ret;
	}

	public static void main(String[] args) {
		Stack1 stack1 = new Stack1(5);
		stack1.push("11");
		stack1.push("12");
		stack1.push("13");
		System.out.println(stack1);
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1);
		
	}

}
