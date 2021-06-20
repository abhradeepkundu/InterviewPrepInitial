package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class WaysToReachTraget {
	static int combination(int[] s, int index, int target, List<String> soln) {
		if (target == 0) {
			System.out.println(soln);
			return 1;
		}
		if (index < 0)
			return 0;
		int exclude = combination(s, index - 1, target, soln);
		soln.add("(+)" + s[index]);
		int incl1 = combination(s, index - 1, target - s[index], soln);
		soln.remove(soln.size() - 1);

		soln.add("(-)" + s[index]);
		int incl2 = combination(s, index - 1, target + s[index], soln);
		soln.remove(soln.size() - 1);

		return exclude + incl1 + incl2;
	}

	public static void main(String[] args) {

		// input array and target number
				int[] arr = { 5, 3, -6, 2 };
				int target = 6;

				int count = combination(arr, arr.length -1, target, new ArrayList<>());
				System.out.println(count);
	}

}
