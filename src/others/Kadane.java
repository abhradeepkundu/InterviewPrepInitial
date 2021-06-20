package others;

public class Kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int algo(int[] a) {
		if(a == null) return -1;
		int size = a.length;
		
		int currentMax = a[0];
		int maxSoFar = a[0];
		
		for(int i=1; i<size; i++) {
			currentMax = Math.max(currentMax, currentMax+a[i]);
			maxSoFar = Math.max(maxSoFar, currentMax);
		}
		return maxSoFar;
	}

}
