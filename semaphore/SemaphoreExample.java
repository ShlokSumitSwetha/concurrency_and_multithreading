package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SemaphoreExample implements Runnable{

	private static final Semaphore semaphore = new Semaphore(2, true);
	private static final AtomicInteger counter = new AtomicInteger();
	private static final long endMillis = System.currentTimeMillis() + 10000;
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new SemaphoreExample());
		}
		executorService.shutdown();
	}
	public void run() {
		while(System.currentTimeMillis() < endMillis) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				System.out.println("["+Thread.currentThread().getName()+"Interrupted in acquire()");
			}
			int counterValue = counter.incrementAndGet();
			System.out.println("["+Thread.currentThread().getName()+":Semaphore acquired and count: "+counterValue);
			if(counterValue > 3) {
				throw new IllegalStateException("More than three threads acquired the lock.");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			counter.decrementAndGet();
			semaphore.release();
		}
	}
}
