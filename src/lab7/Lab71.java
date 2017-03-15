package lab7;

import java.util.*;

public class Lab71 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter words on one line, end with -1");
		String word=scanner.next();
		ArrayList<String> list=new ArrayList<String>();
		while(!word.equals("-1")){
			list.add(word);
			word=scanner.next();
		}

		System.out.println("Here’s the original list:");
		System.out.println(list);
		
		for(int i=0;i<list.size();i++){
			String str=list.get(i);
			for(int j=i+1;j<list.size();j++ ){
				if(str.equals(list.get(j))){
					list.remove(j);
					j--;
				}
			}
			
		}
		
		System.out.println("Here’s the same list with no duplicates:");
		System.out.println(list);
	}

}
