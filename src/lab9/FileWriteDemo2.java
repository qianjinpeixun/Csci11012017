package lab9;
import java.io.*;
import java.net.*;
import java.util.*;
public class FileWriteDemo2 {

	public static void main(String[] args) throws IOException {
		String name;
		String filename;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name of the file to write to:");
		filename = keyboard.nextLine();
		PrintWriter outputFile = new PrintWriter(new FileWriter(filename));
		System.out.println("Enter names, end with quit");
		name = keyboard.nextLine();
		outputFile.println("C:/work-train/workspaces/Assign1/src/lab9/lab9.txt");
		while (!name.equals("quit")) {
			outputFile.println(name);
			name = keyboard.nextLine();
		}
		outputFile.close();
		System.out.println("Data written to the file");
	}
}
