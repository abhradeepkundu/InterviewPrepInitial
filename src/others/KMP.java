package others;

public class KMP {
	
	private void makeLPS(int[] lps, String s) {
		int M = s.length();
		int j=0;
		int i = 1;
		lps[0] = 0;
		while(i < M) {
			if(s.charAt(j) == s.charAt(i)) {
				j++;
				lps[i] = j;
				i++;
			}else {
				if(j!=0) {
					j = lps[j-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		
	}

}
