package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxMeetingCount {

	public static void main(String[] args) {
		// Starting time 
	    int s[] = { 1, 3, 0, 5, 8, 5 };  
	      
	    // Finish time 
	    int f[] = { 2, 4, 6, 7, 9, 9 };  
	      
	    // Number of meetings. 
	    int n = s.length;
	  
	    // Function call 
	    maxMeeting(s, f, n);
	    
	}

	private static void maxMeeting(int[] s, int[] f, int n) {
		Meeting[] meetings = new Meeting[n];
		for(int i = 0; i < n; i++) {
			int start = s[i];
			int end = f[i];
			Meeting meet = new MaxMeetingCount().new Meeting(start, end);
			meetings[i] = meet;
		}
		Arrays.sort(meetings);
		
		List<Meeting> schedule = new ArrayList<>();
		
		schedule.add(meetings[0]);
		int timeLim = meetings[0].end;
		for(int i = 1; i < n; i++) {
			if(meetings[i].start > timeLim) {
				schedule.add(meetings[i]);
				timeLim = meetings[i].end;
			}
		}
		
		for(int i = 0; i < schedule.size(); i++) {
			System.out.println(schedule.get(i));
		}
		
	}
	
	private class Meeting implements Comparable<Meeting>{
		private Integer start;
		private Integer end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			return end.compareTo(o.end);
		}
		@Override
		public String toString() {
			return "Start:"+start+"|End:"+end;
		}
		
	}

	
}
