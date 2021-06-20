package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Election {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> voteList = new ArrayList<String>();
		
		voteList.add("Abhradeep Kundu");
		voteList.add("Suniti Kundu");
		voteList.add("Arnadeep Kundu");
		voteList.add("Abhradeep Kundu");
		voteList.add("Abhradeep Kundu");
		voteList.add("Arnadeep Kundu");
		voteList.add("Arnadeep Kundu");
		voteList.add("Suniti Ghosh");
		
		Map<String, Integer > wordCounter = voteList.stream()
	            .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
		
		System.out.println(wordCounter);
		
		
		wordCounter.forEach((k, v) -> {
			
		});
	}
	
	class Candidate {
		String firstName;
		String lastName;
		int voteCount;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getVoteCount() {
			return voteCount;
		}
		public void setVoteCount(int voteCount) {
			this.voteCount = voteCount;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Candidate other = (Candidate) obj;
			
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			return true;
		}
		
		
		
	}

}
