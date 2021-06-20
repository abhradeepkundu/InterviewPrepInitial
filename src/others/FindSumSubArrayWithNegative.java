package others;

import java.util.HashMap;
import java.util.Map;

public class FindSumSubArrayWithNegative {

	public static void main(String[] args) {
		int[] a = {10, 2, -2, -20, 10};
		int sum = 5;
		findSubArray(a, sum);
	}

	private static void findSubArray(int[] a, int sum) {
		Map<Integer, Integer> trackSum = new HashMap<>();
		int currSum = 0;
		int start = 0;
		int end = -1;
		for(int i = 0; i < a.length; i++) {
			currSum = a[i] + currSum;
			if(currSum == sum) {
				start = 0;
				end = i;
				break;
			}
	 		
			if(trackSum.containsKey(currSum-sum)) {
				start = trackSum.get(currSum-sum) + 1;
				end = i;
				break;
			}
			trackSum.put(currSum, i);
		}
		if(end == -1 ) {
			System.out.println("No solution");
			return;
		}
		for(int i = start; i <= end; i++) {
			System.out.println(a[i]);
		}

		
	}

}
