package others;

public class ThreeWayPartition {

	public static void main(String[] args) {
		char[] a = {'A','B','C','A','C'};
		partition(a);
		for(char i : a)
		System.out.println(i + ",");

	}
	
	public static void partition(char[] a) {
		int length = a.length;
		int low = 0;
		int mid = 0;
		int high = length -1;
		char temp = 'A';
		System.out.println("mid:"+mid);
		
		while(mid <= high) {
			switch(a[mid]) {
			case 'A' :
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
				break;
			case 'B':
				mid++;
				break;
			case 'C':
				temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
				break;
			}
		}
		
	}

}
