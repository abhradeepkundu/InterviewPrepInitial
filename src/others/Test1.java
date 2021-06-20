package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {
	public static void main(String[] args) {
		Map<String, Integer> voteCount = new HashMap<String, Integer>();
		List<String> ballot = new ArrayList<String>();
		ballot.add("ABHRA");
		ballot.add("Suniti");
		ballot.add("Arna");
		ballot.add("Ajit");
		ballot.add("ABHRA");
		ballot.add("Suniti");
		ballot.add("Arna");
		ballot.add("Ajit");
		ballot.add("ABHRA");
		ballot.add("Suniti");
		ballot.add("Arna");
		ballot.add("Ajit");
		ballot.add("ABHRA");
		ballot.add("Suniti");
        for(String candidate : ballot) {

            if(null != voteCount.get(candidate)) {
                int vote = voteCount.get(candidate);
                voteCount.put(candidate, vote+1);
            } else {
                voteCount.put(candidate, 1);
            }
        }
        
        int maxVote = 0;
        String winner = "";
        
        Map<String, Integer> count = ballot.stream().collect(Collectors.toMap(m -> m, m->1, Integer::sum));
        System.out.println(count);

        for(Map.Entry<String,Integer> entry : voteCount.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            if(val > maxVote) {
                maxVote = val;
                winner = key;
            } else if(val == maxVote && winner.compareTo(key) < 0) {
                winner = key;
            }

        }
        System.out.println(winner);
	}

}
