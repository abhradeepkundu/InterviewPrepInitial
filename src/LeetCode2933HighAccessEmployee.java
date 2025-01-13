import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2933HighAccessEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] arr =  {{"wjmqm","0442"},{"wjmqm","0504"},{"r","0525"},{"va","0436"},{"r","0440"},{"va","0505"},{"va","0509"},{"r","0515"},{"r","0414"}};
		List<List<String>> access_times = new ArrayList<>();
		for(String[] a : arr) {
			access_times.add(Arrays.asList(a));
		}
		List<String> ans = findHighAccessEmployees(access_times);
		System.out.println(ans);
	}
	
	public static List<String> findHighAccessEmployees(List<List<String>> access_times) {

        Map<String, List<String>> cache = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(List<String> et : access_times) {
            String emp = et.get(0);
            String time = et.get(1);

//            List<String> empAccessTimes = cache.getOrDefault(emp, new ArrayList<>());
//            empAccessTimes.add(time);
//            cache.put(emp, empAccessTimes);
            cache.computeIfAbsent(emp, k -> new ArrayList<>()).add(time);
        }
        Comparator<String> c = Comparator.comparing(String::toString);
        for(String emp : cache.keySet()) {
            List<String> sortedAccessTimes = cache.get(emp);
            sortedAccessTimes.sort(c);
            System.out.println(sortedAccessTimes + " for emp " + emp );

            int high = 0;
            int low = 0;
            int count = 0;
            while(high < sortedAccessTimes.size()) {
                int startTime = Integer.parseInt(sortedAccessTimes.get(low));
                int endTime = Integer.parseInt(sortedAccessTimes.get(high));
                if(endTime - startTime < 100) {
                	count= high - low + 1;
                    high++;
                } else {
                    low++;
                    count = 0;
                }
                if(count >= 3) {
                    ans.add(emp);
                    break;
                }

            }
        }
        return ans;
        
    }

}


