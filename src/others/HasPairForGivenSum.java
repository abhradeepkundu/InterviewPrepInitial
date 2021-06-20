package others;

import java.util.HashSet;
import java.util.Set;

public class HasPairForGivenSum {
	static boolean findPairWithSum(int[] a, int sum) {
		Set<Integer> s = new HashSet<>();
		int n = a.length;
		int count = 0;
		while(count < n) {
			if(s.contains(a[count])) {
				System.out.println(count);
				return true;
			}
			s.add(sum - a[count]);
			count++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int sum = 8;
		int[] a = {1,2,3,4, 5};
		boolean found = findPairWithSum(a, sum);
		System.out.println(found);
	}

}
