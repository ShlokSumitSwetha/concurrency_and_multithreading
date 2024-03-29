package Complete_Concurrent_Collections.count_down_latch;

import java.util.concurrent.CountDownLatch;

// Application should not start processing any thread until all service is up
// and ready to do there job.
// Countdown latch is idle choice here, main thread will start with count 3
// and wait until count reaches zero. each thread once up and read will do
// a count down. this will ensure that main thread is not started processing
// until all services is up.

//count is 3 since we have 3 Threads (Services)

public class CountDownExample3 {

	public static void main(String args[]) {
		final CountDownLatch latch = new CountDownLatch(2);

		for (int i = 1; i <= 2; i++) {
			Thread t = new Thread(new Service("Service" + i, 2000, latch));
			t.setName("Thread" + i);
			t.start();
		}
		try {
			latch.await();  //main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}
}

/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable {
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(String name, int timeToStart, CountDownLatch latch) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
		}
		System.out.println(Thread.currentThread().getName() + " is executing");
		System.out.println(name + " is Up");
		latch.countDown(); //reduce count of CountDownLatch by 1
		System.out.println("Count Down Latch after Count:" + latch.getCount());

	}
}