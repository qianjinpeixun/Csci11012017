package lab9;
import java.util.*;
import java.io.*;

public class Lab91 {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard =new Scanner(System.in);
		System.out.print("Enter the name of the file to read from:");
		String filename = keyboard.nextLine();
		File inFile = new File(filename);
		Scanner input = new Scanner(inFile);
		ArrayList<String> list=new ArrayList<String>();
		while(input.hasNext()){
			String line = input.nextLine();
			list.add(line);
			//System.out.println(line);
		}
		input.close();
		System.out.println(list);
		ArrayList<String> list2=new ArrayList<String>();
		System.out.print("Enter the String to remove:");
		String removedStr=keyboard.nextLine();
		for(int i=0;i<list.size();i++){
			String str=list.get(i);
			if(!str.equals(removedStr)){
				list2.add(str);
			}
		}
		System.out.println(list2);
		System.out.print("Enter the name of the file to write into:");
		String fileName=keyboard.nextLine();
		PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
		for(int i=0;i<list2.size();i++){
			outputFile.println(list2.get(i));
		}
		outputFile.close();
		System.out.println("Data written into "+fileName);
	}
}
