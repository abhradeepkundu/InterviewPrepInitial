
public class Test {

	public static void main(String[] args) {
		assert true;
		System.out.println("here 1");
		assert false;
		System.out.println("here 2");
		
		Test t = new Test();
		t.some();
		
	}
	
	public void some() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "someTest";
	}
}
