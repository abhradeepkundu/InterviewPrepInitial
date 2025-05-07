package essentials;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9,15,20,25,28,34,39,41,42,48,50,51};
		System.out.println(a.length);
		System.out.println(binarySearch(a, 80));
	}
	
	static int binarySearch(int[] a, int k) {
		int left = 0;
		int right = a.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(a[mid] == k) {
				return mid;
			} else if(a[mid] > k) {
				right = mid;
			} else {
				left = mid + 1;
			}
			System.out.println(mid);
		}
		return left;
	}

}
