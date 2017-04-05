package handout12;

import java.util.ArrayList;

public class Queue2 {

	private ArrayList<String> queue;
	private int front,rear;
	
	public Queue2(){
		queue=new ArrayList<String>();
		front=0;
		rear=-1;
	}
	
	public boolean isEmpth(){
		boolean ret=false;
		ret=queue.isEmpty();
		return ret;
	}
	public void enqueue(String x){
		queue.add(x);
	}
	public String dequeue(){
		String ret="";
		ret=queue.get(0);
		queue.remove(0);
		return ret;
	}
	public String peek(){
		String ret="";
		ret=queue.get(0);
		return ret;
	}
	
	public String toString(){
		for(String s:queue){
			System.out.print(s+"-");
		}
		System.out.println("");
		return "";
	}
	
	public static void main(String[] args) {
		Queue2 q1=new Queue2();
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
