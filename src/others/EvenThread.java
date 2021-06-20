package others;

public class EvenThread extends Thread {

	Counter cnt;

	public EvenThread(Counter cnt) {
		this.cnt = cnt;
	}

	public void run() {
		try {
			int i = 0;
			while (i < 20) {
				cnt.printEven();
				i++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
