package ass1;

import java.util.ArrayList;

public class Test111 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		
		System.out.println(list);
		list.remove(new Integer(10));
		System.out.println(list);
		
		
	}

}
