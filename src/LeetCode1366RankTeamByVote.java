import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1366RankTeamByVote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] votes = {"WXYZ","XYZW"};
		
		System.out.println(rankTeams(votes));

	}
	
	public static String rankTeams(String[] votes) {
		if(votes == null || votes.length < 1) {
			return null;
		}
		if(votes.length == 1) {
			return votes[0];
		}
		
		int posArrLength = votes[0].length();
		Map<Character, int[]> teamVoteMap = new HashMap<>();
		
		for(String vote : votes) {
			for(int i = 0; i < posArrLength; i++) {
				char c = vote.charAt(i);
				teamVoteMap.computeIfAbsent(c, f -> new int[posArrLength])[i]++;
				
			}	
		}
		
		List<Character> standings = new ArrayList<>(teamVoteMap.keySet());
		
		Collections.sort(standings, (a,b) -> {
			for(int i = 0; i < posArrLength; i++) {
				if(teamVoteMap.get(a)[i] != teamVoteMap.get(b)[i]) {
					return teamVoteMap.get(b)[i] - teamVoteMap.get(a)[i];
				}
			}
			return a - b;
		});
		
		StringBuilder sb = new StringBuilder();
		for(char c : standings) {
			sb.append(c);
		}
		
		return sb.toString();
	}

}
