package lab5;

import java.util.Arrays;

public class Lottery {

	@Override
	public String toString() {
		return "Lottery [lotteryNumbers=" + Arrays.toString(lotteryNumbers) + ", userArray="
				+ Arrays.toString(userArray) + ", matches=" + matches + "]";
	}

	private int[] lotteryNumbers = new int[5];
	private int[] userArray = new int[5];
	private int matches;

	public Lottery() {
		matches = 0;
		for (int i = 0; i < 5; i++) {
			int radomNumber = (int) (Math.random() * 9 + 1);
			lotteryNumbers[i]=radomNumber;
		}

	}
	
	public void setUserArray(int[] userArray){
		for(int i=0;i<5;i++){
			this.userArray[i]=userArray[i];
		}
		countMatchedNumber();
	}
	
	private void countMatchedNumber(){
		matches=0;
		for(int i=0;i<5;i++){
			if(lotteryNumbers[i]==userArray[i])
				matches++;
		}
	}
	
	public void printPrize(){
		System.out.println(Arrays.toString(lotteryNumbers));
		System.out.println(Arrays.toString(userArray));
		String prize="";
		if(matches==5)
			prize="Grand Prize ($1 million)";
		else if(matches==4)
			prize="$500,000 prize";
		else if(matches==3)
			prize="$1000 prize";
		else if(matches==2)
			prize="$10 prize";
		else if(matches==1)
			prize="$2 prize";
		else 
			prize="Sorry, nothing for you";
		System.out.println(prize);
		

	}

}
