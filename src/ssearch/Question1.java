package ssearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Question1 {

	private static int size_sequential_list = 100000;
	private static int size_sequential_number_range = 100000000;

	public static double calculateComparisonNumber() {
		double ret = 0;
		for (int i = 1; i <= size_sequential_list; i++) {
			ret = ret + ((0.28125 * i + 0.1875 * i + 0.25 * size_sequential_list) / 3);
		}
		System.out.println("calculateComparisonNumber shoule be almost:" + ret / size_sequential_list);
		return ret;
	}

	public static int comoparisionNumber = 0;

	public int[] generateSequentialList() {
		int[] list = new int[size_sequential_list];
		HashMap map = new HashMap();

		for (int i = 0; i < size_sequential_list; i++) {

			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range));
			while (true) {
				String currentInt = (String) map.get(randomInt);
				if (currentInt == null){
					map.put(randomInt, "hasValue");
					break;
				}else{
					randomInt = Math.abs((int) (Math.random() * size_sequential_number_range));
				}
			}
			list[i] = randomInt;

		}
		return list;
	}

	public int sequentialSearch(int[] list, int target) {
		int ret = -1;
		for (int i = 0; i < list.length; i++) {
			comoparisionNumber++;
			if (list[i] == target)
				return i;
		}
		return -1;
	}

	public void question1D() {
		int[] list = generateSequentialList();
		int[] keys = new int[1000];

		// generate the 75% *75% in the first half of in the list
		for (int i = 0; i < 560; i++) {
			// select a target randomly
			int randomInt = Math.abs((int) (Math.random() * (size_sequential_list / 2)));
			keys[i] = list[randomInt];
		}

		// generate the 75% *25% in the in the list
		for (int i = 560; i < 750; i++) {
			// select a target randomly
			int randomInt = Math.abs((int) (Math.random() * size_sequential_list));
			keys[i] = list[randomInt];
		}

		// generate the 25% not in the list
		for (int i = 750; i < 1000; i++) {
			// select a target randomly
			int randomInt = Math.abs((int) (Math.random() * size_sequential_number_range) + 90100000);
			keys[i] = randomInt;
		}

		System.out.println("target keys are:" + Arrays.toString(keys));

		for (int i = 0; i < 1000; i++) {
			int ret = sequentialSearch(list, keys[i]);
			// System.out.println(ret);
		}
		System.out.println("comoparisionNumber=" + comoparisionNumber / 1000);
	}

	public static void main(String[] args) {

		Question1 q1 = new Question1();
		q1.calculateComparisonNumber();
		q1.question1D();
	}

}
