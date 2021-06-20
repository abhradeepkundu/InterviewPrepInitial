package others;

public class OddThread extends Thread {

	Counter cnt;
	public  OddThread(Counter cnt) {
		this.cnt = cnt;
	}
	public void run() {
		try {
			int i = 0;
			while(i < 20) {
				cnt.printOdd();
				i++;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
