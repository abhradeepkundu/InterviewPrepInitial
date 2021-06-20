package others;

public class Counter {
	private boolean odd = true;
	private int count = 1;
	public static void main(String[] args) {
		Counter c = new Counter();
		
		OddThread oddThread = new OddThread(c);
		EvenThread evenThread = new EvenThread(c);
		oddThread.start();
		evenThread.start();
	}
	
	public synchronized void printOdd() throws InterruptedException {
		if(!odd) {
			wait();
		}
		System.out.println("ODD:" + count);
		count++;
		odd = false;
		notify();
	}
	
	public synchronized void printEven() throws InterruptedException {
		if(odd) {
			wait();
		}
		System.out.println("EVEN:"+count);
		count++;
		odd = true;
		notify();
	}

}
