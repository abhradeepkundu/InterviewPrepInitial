package DevideAndConquer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberFactor {
	
	// 1,3,4 combination how to get the N
	
	public static int waysToGetN(int n) {
		//Base Case
		if ((n==0) || (n==1) || (n==2)) {
			return 1; // {}, {1}, {1,1}
		}
		
		if(n==3) {
			return 2; // {1,1,1}, {3}
		}
		 
		int c1 = waysToGetN(n-1);
		int c2 = waysToGetN(n-3);
		int c3 = waysToGetN(n-4);
		
		return c1+c2+c3;
	}
	
	public static void main(String[] args) {
		int[] s =  {1,3,4};
		System.out.println(waysToGetN(5));
		List<Integer> sol = new ArrayList<>();
		int count = waysToGetNSoln(5, s, sol);
		System.out.println(count);
	}
	
	
	public static int waysToGetNSoln(int n, int[] s, List<Integer> sol) {
		if(n == 0) {
			for(int i : sol) System.out.print(i + ",");
			System.out.println();
			return 1;
		}
		if(n < 0) return 0 ;
		int count = 0;
		for(int i = 0; i < s.length; i++) {
			sol.add(s[i]);
			count += waysToGetNSoln(n-s[i], s, sol);
			sol.remove(sol.size()-1);
		}
		return count;
 	}

}
