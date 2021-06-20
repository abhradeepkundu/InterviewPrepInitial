package others;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome lp = new LongestPalindrome();
		String c = lp.longestPalindrome("abb");
		System.out.println(c);
	}
	public String longestPalindrome(String A) {
        int len = A.length();
        String maxString = A.substring(0,1);
        for(int i = 0 ; i < len; i++) {
            String ln = checkPalin(A, i, i);
            if(ln.length() > maxString.length()) {
            	maxString = ln;
            }
            ln = checkPalin(A, i, i+1);
            if(ln.length() > maxString.length()) {
            	maxString = ln;
            }
        }
        return maxString;
    }
    public String checkPalin(String str, int start, int end) {
        while(start >= 0 && end < str.length()) {
            if(str.charAt(start)==str.charAt(end)) {
                start--;
                end++;
            } else {
            	break;
            }
        }
        return str.substring(start+1, end);
    }

}
