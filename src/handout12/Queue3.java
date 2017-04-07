package handout12;
import java.util.*;
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
		System.out.println("Begin reverse");
		reverseQ(q1);
		System.out.println(q1);
		System.out.println("Start to printIO");
		printIO();
		System.out.println("Start to final question 15");
		q15();
	}
	
	public static void printIO(){
		String s="1 2 3 4 5 6";
		Scanner sc=new Scanner(s);
		int i=0;
		while(sc.hasNext()){
			String line=sc.next();
			i++;
			if(i%2==0)
				System.out.println(line);
		}
	}
	
	public static void reverseQ(Queue3 q){
		if(q==null) return;
		Stack1 s1=new Stack1(100);
		while(!q.isEmpth()){
			String s=q.dequeue();
			s1.push(s);
		}
		while(!s1.isEmpty()){
			q.enqueue(s1.pop());
		}
		System.out.println(q);
	}
	
	public static void q15(){
		Stack1 s=new Stack1(100);
		Queue3 q=new Queue3();
		
		s.push("J");
		s.push("A");
		s.push("V");
		s.push("A");
		for(int i=0;i<3;i++)
			q.enqueue(s.pop());
		String str=s.pop();
		for(int i=0;i<2;i++)
			s.push(q.dequeue());
		s.push(str);
		System.out.println(s);
		System.out.println(q);
		
		
	}

}
