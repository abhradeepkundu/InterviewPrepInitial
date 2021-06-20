package others;

import java.nio.ByteOrder;

public class host_byte_order {
	public static ByteOrder host_byte_order() {
	    
	    return ByteOrder.nativeOrder();
	  }
	  public static void main(String[] args) {
	    System.out.println(host_byte_order());
	    assert (host_byte_order().equals(ByteOrder.LITTLE_ENDIAN));
	  }
}
