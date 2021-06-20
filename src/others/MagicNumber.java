package others;

public class MagicNumber {
	
	int magicFast(int[] array) {
		return magicFast(array, 0, array.length -1);
	}

	private int magicFast(int[] array, int start, int end) {
		if(end < start) return -1;
		int midIndex = start + end /2;
		int midValue = array[midIndex];
		if(midIndex == midValue) return midIndex;
		
		int leftIndex = Math.min(midIndex -1 , midValue);
		int left = magicFast(array, start, leftIndex);
		if(left >= 0) return left;
		int rightIndex = Math.max(midIndex+1, midValue);
		return magicFast(array, rightIndex, end);
	}

}
