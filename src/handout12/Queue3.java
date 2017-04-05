package handout12;

import assignment4.LinkedList;

public class Queue3 {

	private LinkedList queue;
	
	public Queue3(){
		queue =new LinkedList();
	}
	
	public boolean isEmpth(){
		boolean ret=false;
		ret=queue.isEmpty();
		return ret;
	}
	public void enqueue(String x){
		queue.addToEnd(x);
	}
	public String dequeue(){
		String ret="";
		ret=queue.getFrontData();
		queue.removeFront();
		return ret;
	}
	public String peek(){
		String ret="";
		ret=queue.getFrontData();
		return ret;
	}
	
	public String toString(){
		queue.enumerate();
		return "";
	}
	
	
	public static void main(String[] args) {
		Queue3 q1=new Queue3();
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
