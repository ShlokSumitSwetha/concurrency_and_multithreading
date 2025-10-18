package Complete_Concurrent_Collections.Thread_specific_order;

public class WaitThreadSequence {
	private static final Object lock = new Object();
	private static int currentThread = 1;

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			synchronized (lock) {
				while (currentThread != 1) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("Thread 1 is running.");
				// Thread 1 logic
				currentThread = 2;
				lock.notifyAll();
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (lock) {
				while (currentThread != 2) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("Thread 2 is running.");
				// Thread 2 logic
				currentThread = 3;
				lock.notifyAll();
			}
		});

		Thread thread3 = new Thread(() -> {
			synchronized (lock) {
				while (currentThread != 3) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("Thread 3 is running.");
				// Thread 3 logic
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

