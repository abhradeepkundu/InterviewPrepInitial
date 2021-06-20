package com.interview.dynamic;

import java.util.ArrayList;
import java.util.List;

// Given a set and a sum find if exist a subset whose sum is equal to sum
public class SubSetSum {

	public static boolean checkSubSet(int A[], int sum, int n, List<Integer> sol) {
		// base case
		if (sum == 0) {
			System.out.println(sol);
			return true;
		}
		if (n < 0 || sum < 0) {
			//sol.clear();
			return false;
		}

		
		boolean exclude = checkSubSet(A, sum, n - 1, sol);
		sol.add(A[n]);
		boolean include = checkSubSet(A, (sum - A[n]), n - 1, sol);
		sol.remove(sol.size()-1);

		
		return include || exclude;
	}

	public static void main(String[] args) {
		// Input: set of items and a sum
		int[] A = {2, 5, 8, 4, 6, 11 };
		int sum = 13;
		List<Integer> sol = new ArrayList<Integer>();

		if (checkSubSet(A, sum, A.length-1, sol )) {
			
			System.out.print("Yes >>" + sol);
		} else {
			System.out.print("No");
		}
	}
}
