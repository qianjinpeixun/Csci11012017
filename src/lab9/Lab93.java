package lab9;

import java.io.*;
import java.util.*;

public class Lab93 {

	public static void main(String[] args) throws Exception {

		String filename = "C:/work-train/workspaces/Assign1/src/lab9/lab93.txt";
		PrintWriter outputFile = new PrintWriter(new FileWriter(filename));
		for (int i = 0; i < 100; i++) {
			int number = (int) (Math.random() * 10000);
			outputFile.println(number);
		}
		outputFile.close();

		File inFile = new File(filename);
		Scanner scanner = new Scanner(inFile);
		int[] unsort = new int[100];
		int index = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			unsort[index] = (Integer.parseInt(line));
			index++;
		}

		System.out.println(Arrays.toString(unsort));

		for (int i = 0; i < unsort.length; i++) {
			for (int j = i; j < unsort.length; j++) {
				if (unsort[i] < unsort[j]) {
					int temp = unsort[i];
					unsort[i]=unsort[j];
					unsort[j]=temp;
				}

			}
		}
		System.out.println(Arrays.toString(unsort));

	}
}
