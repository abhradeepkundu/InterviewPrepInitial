package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
//		Map<Integer, String> map = new HashMap<Integer, String> ();
//		int[] i = {1,2,3,4,5,6,7};
//		for(int j : i) {
//			//System.out.println(j);
//			//assert(j!=3);
//		}
//		
//		Integer[] A = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
//		List<Integer> B = Arrays.asList(A);
//		int k = kthsmallest(B, 9);
//		System.out.println();
//		System.out.println(k);
//		Arrays.sort(A);
//		
//		for(int j : A) {
//			System.out.print(j + ",");
//		}
		ExecutorService exec = Executors.newFixedThreadPool(5);
		int x = 1;
		for (int i = 0; i < 3; i++) {
		  x += 5 * i;
		}
		System.out.println(x);
	}
	
	public static int kthsmallest(final List<Integer> A, int B) {
        int kthSmall = 0;
        List<Integer> pos = new ArrayList<Integer>(B);
        for(int i = 0; i < B; i++) {
            int currentPass = Integer.MAX_VALUE;
            int currentPos = 0;
            for(int j = 0; j < A.size(); j++) {
                if(kthSmall <= A.get(j) && A.get(j) < currentPass && !pos.contains(j)) {
                    currentPass = A.get(j);
                    currentPos = j;
                }
                
            }
            kthSmall = currentPass;
            pos.add(i, currentPos); 
            System.out.print(kthSmall + ">");
        }
        return kthSmall;
    }

}
