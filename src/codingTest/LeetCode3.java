package codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[][] mat = new int[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j=0; j < 4; j++) {
				
				if(i == j || (i == 1 && j == 2)) {
					mat[i][j] = 1;
				} else {
					mat[i][j] = 0;
				}
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("result");
		System.out.println(numSpecial(mat));
	}
	
	public static int numSpecial(int[][] mat) {
        int rowN = mat.length;
        int colN = mat[0].length;
        Map<Integer, Boolean> oneRow = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> oneCol = new HashMap<Integer, Boolean>();
        int ret = 0;
        for(int i=0; i < rowN; i++) {
            for(int j=0; j< colN; j++) {
                if(mat[i][j] == 1) {
                	
                    if(!oneRow.containsKey(i) && !oneCol.containsKey(j) && checkZeroForRowAndCol(mat, i, j)) {
                        ret++;
                    }
                    oneRow.put(i, true);
                    oneCol.put(j, true);
                }
            }
        }
        return ret;
    }

	private static boolean checkZeroForRowAndCol(int[][] mat, int i, int j) {
		int rowN = mat.length;
        int colN = mat[0].length;
		for(int k = 0; k < rowN; k++) {
			if(i != k && mat[k][j] == 1) {
				return false;
			}
		}
		for(int l = 0; l < colN; l++) {
			if(j != l && mat[i][l] == 1) {
				return false;
			}
		}
		return true;
	}
	
	// Failing for 
	// input 4
	// [[1,2,3],[3,2,0],[3,1,0],[1,2,0]]
	// [[0,1],[2,3]]
	
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int count = 0;
        int pairN = n/2;
        List<Integer> unhappy = new ArrayList<Integer>();
        List<Integer> mayBeUnhappy = new ArrayList<Integer>();
        for(int i = 0; i < pairN; i++) {
            int[] pair = pairs[i];
            int firstFriend = pair[0];
            int secondFriend = pair[1];
            if(checkIfUnhappy(preferences[firstFriend], secondFriend, firstFriend, unhappy, mayBeUnhappy)) {
                unhappy.add(firstFriend);
            }
            if(checkIfUnhappy(preferences[secondFriend], firstFriend, secondFriend, unhappy, mayBeUnhappy)) {
                unhappy.add(secondFriend);
            }
        }
        for(int i = (mayBeUnhappy.size() -1); i >= 0; i--) {
            int u = mayBeUnhappy.get(i);
            int[] pref = preferences[u];
            if(unhappy.contains(pref[0])) {
                unhappy.add(u);
            }
        }
        return unhappy.size();
    }
    
    private boolean checkIfUnhappy(int[] pref, int friend, int x, List<Integer> unhappy, List<Integer> mayBeUnhappy) {
        int i = pref[0];
        if(i == friend) {
            return false;
        } 
        if(unhappy.contains(i)) {
            return true;
        } else {
            mayBeUnhappy.add(x);
        }
        
        return false;
    }

}
