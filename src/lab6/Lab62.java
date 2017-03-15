package lab6;

import java.util.*;
import java.util.Scanner;

public class Lab62 {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter words on one line, end with -1");
		String word=scanner.next();
		ArrayList<String> list1=new ArrayList<String>();
		while(!word.equals("-1")){
			list1.add(word);
			word=scanner.next();
		}
		System.out.println(list1);
		
		
		System.out.println("Array List with no duplicates:");
		HashSet set1=new HashSet(list1);
		ArrayList<String> list2=new ArrayList<String>(set1);
		System.out.println(list2);
		
	}

}
