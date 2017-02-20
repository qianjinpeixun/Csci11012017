package lab5;

import java.util.Scanner;

public class LotteryDemo {

	public static void main(String[] args) {
		Lottery lottery=new Lottery();
		System.out.print(lottery);
		int[] userArray=new int[5];
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the five numbers:");
		userArray[0]= scanner.nextInt();
		userArray[1]= scanner.nextInt();
		userArray[2]= scanner.nextInt();
		userArray[3]= scanner.nextInt();
		userArray[4]= scanner.nextInt();
		
		lottery.setUserArray(userArray);
		lottery.printPrize();

	}

}
