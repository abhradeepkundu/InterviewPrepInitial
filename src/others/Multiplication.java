package others;

public class Multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiplication mult = new Multiplication();
		System.out.println("REC: " + mult.multiplyRec(8, 8));
		System.out.println("Non REC: "+mult.multiplyNonRec(8, 7));
	}
	
	public int multiplyRec(int m, int n) {
		if(m == 0) return 0;
		if(m == 1) return n;
		if(n == 1) return m;
		int small = m > n ? n : m;
		int big = m > n ? m : n;
		int half = small >> 1;
		
		half = multiplyRec(half, big);
		System.out.println(half +"|"+ big);
		if(small %2 == 0) {
			return half + half;
		} else {
			return half + half + big;
		}
	}
	
	public int multiplyNonRec(int m, int n) {
		if(m == 0) return 0;
		if(m == 1) return n;
		if(n == 1) return m;
		int small = m > n ? n : m;
		int big = m > n ? m : n;
		int prod = big;
		while(small > 1) {
			int half = small >> 1;
			if(small %2 == 0) {
				prod = prod + prod;
			} else {
				prod = prod + prod + big;
			}
			small = half;
		}
		return prod;
	}

}
