package Complete_Concurrent_Collections.count_down_latch;

import java.util.*;
import java.util.concurrent.*;
	public class CountDownLatchExample implements Runnable {
		private static final int NUMBER_OF_THREADS = 3;
		private static final CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);
		private static Random random = new Random(System.currentTimeMillis());
		public static void main(String[] args) {
			ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
			for (int i = 0; i < NUMBER_OF_THREADS; i++) {
				executorService.execute(new CountDownLatchExample());
			}
			executorService.shutdown();
		}
		public void run() {
			try {
				System.out.println("[" + Thread.currentThread().getName() + "Sleeping for 2 sec");
				Thread.sleep(2000);
				latch.countDown();
				System.out.println("[" + Thread.currentThread().getName() + "Waiting for latch.");
				latch.await();
				System.out.println("[" + Thread.currentThread().getName() + "Finished.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
