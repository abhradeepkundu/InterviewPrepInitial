package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	static int count = 1;
	static int combineCount = 1;
	static void rCombination(int arr[], int data[], int start, int end, int index, int r) {
		count++;
		// Current combination is ready to be printed, print it 
		if (index == r) {
			combineCount++;
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}

		// replace index with all possible elements. The condition 
		// "end-i+1 >= r-index" makes sure that including one element 
		// at index will make a combination with remaining elements 
		// at remaining positions 
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			rCombination(arr, data, i + 1, end, index + 1, r);
		}
	}

	// The main function that prints all combinations of size r 
	// in arr[] of size n. This function mainly uses combinationUtil() 
	static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one 
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]' 
		rCombination(arr, data, 0, n-1, 0, r);
	}
	
	static void generatePermutations(List<List<Character>> lists, List<String> result, int depth, String current) {
	    if (depth == lists.size()) {
	        result.add(current);
	        return;
	    }

	    for (int i = 0; i < lists.get(depth).size(); i++) {
	        generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
	    }
	}
	
	static void powerSet(String str, int index, String curr) {
		int n = str.length();

// base case  
		if (index == n) {
			return;
		}

// First print current subset  
		System.out.println(curr);

// Try appending remaining characters  
// to current subset  
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			powerSet(str, i, curr);

// Once all subsets beginning with  
// initial "curr" are printed, remove  
// last character to consider a different  
// prefix of subsets.  
			curr = curr.substring(0, curr.length() - 1);
			// System.out.println("curr:" +curr);
		}
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int r = 4;
		int n = arr.length;
		printCombination(arr, n, r);
		System.out.println(count + "/" + combineCount);
		List<String> result = new ArrayList<String>();
		List<List<Character>> lists = new ArrayList<List<Character>>();
		List<Character> a = new ArrayList<>();
		a.add('a');
		a.add('b');
		a.add('c');
		List<Character> b = new ArrayList<>();
		b.add('x');
		b.add('y');
		b.add('z');
		lists.add(a);
		lists.add(b);
		//generatePermutations(lists, result, 0, "");
		System.out.println(result);
		
		String str = "1234"; 
        int index = -1; 
        String curr = ""; 
        System.out.println("Generating power set");
        powerSet(str, index, curr); 
	}
}
