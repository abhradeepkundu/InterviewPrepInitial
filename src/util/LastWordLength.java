package util;

public class LastWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello World  ";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s) {
        int ans = 0;
        int n = s.length() - 1;
        int i = n;
        while(i >= 0 && s.charAt(i) == ' ') {
        	i--;
        }
        
        while(i >= 0 && s.charAt(i) != ' ') {
        	ans++;
        	i--;
        }

        
        return ans;

        
    }
}
