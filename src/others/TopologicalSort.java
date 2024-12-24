package others;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sort(List<List<Integer>> adjM, int v) {
		Stack<Integer> ans = new Stack<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		
		for(int i = 0; i < v; i++) {
			if(!visited.contains(i)) {
				topoSort(adjM, ans, visited,i);
			}
			
		}
		
	}
	
	public static void topoSort(List<List<Integer>> adjM, Stack<Integer> ans, Set<Integer> visited, int curr) {
		visited.add(curr);
		for(int i : adjM.get(curr)) {
			topoSort(adjM, ans, visited, i);
		}
		ans.add(curr);
	}

}
