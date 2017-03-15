package lab7;

import java.util.*;


public class Lab72 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		while (word != null && !word.equals("")) {
			if (list.isEmpty()) {
				list.add(word);
			} else {
				boolean found=false;
				for(int i=0;i<list.size();i++){
					if(word.compareTo(list.get(i))<0){
						list.add(i,word);
						found=true;
						break;
					}
				}
				if(found==false){
					list.add(word);
				}
			}
			word=scanner.nextLine();
			System.out.println(list);
		}
	}
}
