package lab9;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Lab92 {

	public static void main(String[] args) throws IOException{
		String url_path="http://liveexample.pearsoncmg.com/data/Lincoln.txt";
		String str="";
		URL url = new URL(url_path);
		Scanner input = new Scanner(url.openStream());
		while (input.hasNext()) {
			str=str+input.nextLine();
		}
		input.close();
		System.out.println(str);
		ArrayList<String> list=new ArrayList<String>();
		while(str.indexOf(" ")!=-1){
			String word=str.substring(0,str.indexOf(" "));
			list.add(word);
			str=str.substring(str.indexOf(" "));
			str=str.trim();
			
		}
		System.out.println(list);
		
	}

}
