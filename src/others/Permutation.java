package others;

public class Permutation {
	
	public static void main(String[] args) {
		perm("","abc");
	}
	
	public static void perm(String prefix, String str) {
		if(str.length() == 0) {
			System.out.println(prefix);
			return;
		}
		System.out.println(prefix);
		for(int i = 0; i < str.length(); i++) {
			perm(str.charAt(i)+prefix, str.substring(0,i)+str.substring(i+1,str.length()));
		}
	}

}
