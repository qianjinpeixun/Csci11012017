package lab9;
import java.io.*;
import java.net.*;
import java.util.*;
public class ReadFileFromURL {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String URLString = keyboard.nextLine();
		URL url = new URL(URLString);
		int count = 0;
		Scanner input = new Scanner(url.openStream());
		while (input.hasNext()) {
			String line = input.nextLine();
			System.out.println(line);
			count += line.length();
		}
		System.out.println("The file size is : " + count + " characters");
	}
}
