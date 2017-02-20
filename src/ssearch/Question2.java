package ssearch;

import java.util.Arrays;
import java.util.HashMap;

public class Question2 {

	private static int size_sequential_list = 100000;
	private static int size_sequential_number_range = 100000000;

	public static int comoparisionNumber = 0;

	public int[] generateSequentialList() {
		int[] list = new int[size_sequential_list];
		HashMap map = new HashMap();

		for (int i = 0; i < size_sequential_list; i++) {

			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range));
			while (true) {
				String currentInt = (String) map.get(randomInt);
				if (currentInt == null) {
					map.put(randomInt, "hasValue");
					break;
				} else {
					randomInt = Math.abs((int) (Math.random() * size_sequential_number_range));
				}
			}
			list[i] = randomInt;

		}
		return list;
	}

	public int[] sequentialSearch(int[] list, int target) {
		int ret = -1;
		for (int i = 0; i < list.length; i++) {
			comoparisionNumber++;
			if (list[i] == target) {
				int temp = list[0];
				list[0] = list[i];
				list[i] = temp;
				return list;
			}
		}
		return list;
	}

	public void question2B() {
		int[] list1 = generateSequentialList();
		int[] list2 = new int[size_sequential_list];
		int[] list3 = new int[size_sequential_list];

		for (int i = 0; i < size_sequential_list; i++) {
			list2[i] = list1[i];
		}

		for (int i = 0; i < size_sequential_list; i++) {
			list3[i] = list1[i];
		}

		int[] sequence1 = new int[1000];
		int[] sequence2 = new int[1000];
		int[] sequence3 = new int[1000];

		// sequence1 has zero probability
		for (int i = 0; i < 1000; i++) {
			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range) + 90100000);
			sequence1[i] = randomInt;
		}

		// sequence2 has 25% probability to find
		for (int i = 0; i < 250; i++) {
			int randomInt = Math.abs((int) (Math.random() * size_sequential_list));
			sequence2[i] = list2[randomInt];
		}
		for (int i = 250; i < 1000; i++) {
			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range) + 90100000);
			sequence2[i] = randomInt;

		}

		// sequence3 has 75% probability to find
		for (int i = 0; i < 750; i++) {
			int randomInt = Math.abs((int) (Math.random() * size_sequential_list));
			sequence3[i] = list3[randomInt];
		}
		for (int i = 750; i < 1000; i++) {
			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range) + 90100000);
			sequence3[i] = randomInt;

		}

		// generate the 75% *75% in the first half of in the list
		comoparisionNumber = 0;
		for (int i = 0; i < 1000; i++) {
			list1 = sequentialSearch(list1, sequence1[i]);
			// System.out.println(ret);
		}
		System.out.println("comoparisionNumber with probability   0: " + comoparisionNumber / 1000);

		comoparisionNumber = 0;
		for (int i = 0; i < 1000; i++) {
			list2 = sequentialSearch(list2, sequence2[i]);
			// System.out.println(ret);
		}
		System.out.println("comoparisionNumber with probability 25%: " + comoparisionNumber / 1000);

		comoparisionNumber = 0;
		for (int i = 0; i < 1000; i++) {
			list3 = sequentialSearch(list3, sequence3[i]);
			// System.out.println(ret);
		}
		System.out.println("comoparisionNumber with probability 75%: " + comoparisionNumber / 1000);
		comoparisionNumber = 0;

	}

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		q2.question2B();
		
		double ret=0;
		for (int i = 1; i <= size_sequential_list; i++) {
			double rate=0.75;
			ret = ret + (rate*i);
		}
		System.out.println("calculateComparisonNumber with 25% shoule be almost:" + ret / size_sequential_list);

		
		ret=0;
		for (int i = 1; i <= size_sequential_list; i++) {
			double rate=0.25;
			ret = ret + (rate*i);
		}
		System.out.println("calculateComparisonNumber with 75% shoule be almost:" + ret / size_sequential_list);

	}

}
