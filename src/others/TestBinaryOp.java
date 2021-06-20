package others;

public class TestBinaryOp {
	static int get_bit(int num, int bit) {
		  int temp = (1 << bit);
		  System.out.println(temp);
		  temp = temp & num;
		 
		  if (temp == 0) {
	    	  return 0;
	  	  }
		  return 1;
	  }
	
	public static void main(String[] args) {
		System.out.println(get_bit(3, 0));
	}

}
