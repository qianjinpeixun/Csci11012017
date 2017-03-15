package lab6;

import java.util.*;

public class Lab61 {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter words on one line, end with -1");
		String word=scanner.next();
		ArrayList<String> list1=new ArrayList<String>();
		while(!word.equals("-1")){
			list1.add(word);
			word=scanner.next();
		}
		System.out.println(list1);
		
		
		System.out.print("Enter words on one line, end with -1");
		word=scanner.next();
		ArrayList<String> list2=new ArrayList<String>();
		while(!word.equals("-1")){
			list2.add(word);
			word=scanner.next();
		}
		System.out.println(list2);
		System.out.println("Array List with common strings:");
		ArrayList<String> list3=new ArrayList<String>();
		
		for(int i=0;i<list1.size();i++){
			String str=(String)list1.get(i);
			if(list2.contains(str)){
				list3.add(str);
			}
		}
		System.out.println(list3);
		
	}

}
