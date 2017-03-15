package lab7;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.addToFront("Toronto");
		myList.addToFront("New York");
		myList.addToFront("Calgary");
		myList.addToFront("Halifax");
		myList.addToFront("St.John's");
		System.out.println("Number of nodes in the list: " + myList.size());
		myList.enumerate();
		myList.addToFront("Vancouver");
		myList.addToFront("Montreal");
		myList.enumerate();
		System.out.println("begin enumerateOddNodes");
		myList.enumerateOddNodes();
		
		LinkedList list2=new LinkedList();
		list2.addToFront("N");
		list2.addToFront("T");
		list2.addToFront("A");
		list2.addToFront("T");
		list2.listAllNodesWith("T");
		
	}
}