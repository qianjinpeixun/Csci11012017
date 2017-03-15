package lab8;

public class Demo {

	public static void main(String[] args) {

		
		
		LinkedList list1=new LinkedList();
		LinkedList list2=new LinkedList();
		list1.addToFront("F");
		list1.addToFront("E");
		list1.addToFront("D");
		list1.addToFront("C");
		list1.addToFront("B");
		list1.addToFront("A");
		
		list2.addToFront("Z");
		list2.addToFront("Y");
		list2.addToFront("X");
		list2.addToFront("W");
		
		LinkedList list3=interleave(list1, list2);
		System.out.println("Start to question 1:");
		list1.enumerate();
		list2.enumerate();
		list3.enumerate();
		
		System.out.println("Start to question 2:");
		
		reverse(list3);
		list3.enumerate();
		reverse(list3);
		list3.enumerate();
		
		System.out.println("Start to question 3:");
		chopSkip(list3);
		list3.enumerate();
		
		
	}

	public static LinkedList interleave(LinkedList list1, LinkedList list2) {
		LinkedList list3 = new LinkedList();
		Node curr1=list1.getFront();
		Node curr2=list2.getFront();
		Node curr3=list3.getFront();
		int max_size=list1.size();
		if(max_size<list2.size())
			max_size=list2.size();
		
		for(int i=0;i<max_size;i++){
			if(curr1!=null){
				list3.addToFront(curr1.getData());
				curr1=curr1.getNext();
			}
			if(curr2!=null){
				list3.addToFront(curr2.getData());
				curr2=curr2.getNext();
			}
		}
		LinkedList list4=new LinkedList();
		curr3=list3.getFront();
		while(curr3!=null){
			list4.addToFront(curr3.getData());
			curr3=curr3.getNext();
		}
		return list4;
	}

	public static void chopSkip(LinkedList list) {
		
		Node curr=list.getFront();
		Node pre=list.getFront();
		int i=1;
		while(curr!=null){
			if(i%2==0){
				pre.setNext(curr.getNext());
			}
			pre=curr;
			curr=curr.getNext();
			i++;
		}

	}

	public static void reverse(LinkedList list) {
		int size = list.size();
		for (int i = 0; i < size / 2; i++) {
			swap(i, size - i - 1, list.getFront());
		}

	}

	private static void swap(int x, int y, Node front) {

		Node current = front;
		String s1 = "";
		int i = x;
		while (i > 0) {
			current = current.getNext();
			i--;
		}
		s1 = current.getData();

		current = front;
		i = y;
		while (i > 0) {
			current = current.getNext();
			i--;
		}
		String s2 = current.getData();
		current.setData(s1);

		current = front;
		i = x;
		while (i > 0) {
			current = current.getNext();
			i--;
		}
		current.setData(s2);
	}

}
