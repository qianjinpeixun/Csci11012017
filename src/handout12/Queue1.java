package handout12;

import java.util.Arrays;

public class Queue1 {

	public String toString(){
		return Arrays.toString(queue);
		
	}
	private String[] queue;
	private int front, rear;

	public Queue1(int capacity) {
		queue = new String[capacity];
		front = 0;
		rear = -1;
	}

	public boolean isEmpth() {
		boolean ret = false;
		if (front == queue.length)
			ret = true;
		return ret;
	}

	public void enqueue(String x) {
		rear=rear+1;
		queue[rear]=x;
	}

	public String dequeue() {
		String ret = "";
		ret=queue[front];
		queue[front]=null;
		front=front+1;
		return ret;
	}

	public String peek() {
		String ret = "";
		ret=queue[front];
		return ret;
	}

	public static void main(String[] args) {
		Queue1 q1=new Queue1(100);
		q1.enqueue("10");
		q1.enqueue("11");
		q1.enqueue("12");
		q1.enqueue("13");
		q1.enqueue("14");
		q1.enqueue("15");
		System.out.println(q1);
		System.out.println(q1.peek());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		q1.enqueue("16");
		System.out.println(q1);
	}

}
