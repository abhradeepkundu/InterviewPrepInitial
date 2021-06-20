package threadkb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	ReentrantLock rl = new ReentrantLock();
	Map<String,String> mp = new HashMap<String, String>();
	long ttl = 10000;
	
	public void something() {
		rl.lock();
		//doSomething;
		rl.unlock();
	}
	
	class CleanupThread implements Runnable {
		public void run() {
			while (true) {
				clean();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void clean() {
			long currTime = System.currentTimeMillis();
			
			for (String  key : mp.keySet()) {
				String val = mp.get(key);
				//cleanup map
			}
		}
	}

}

