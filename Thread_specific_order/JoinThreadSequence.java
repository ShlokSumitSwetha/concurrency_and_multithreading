package Complete_Concurrent_Collections.Thread_specific_order;


public class JoinThreadSequence {
	public static void main(String[] args) {
		Object lock = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Thread 1 is running.");
				// Thread 1 logic
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				thread1.join(); // Wait for Thread 1 to complete
				synchronized (lock) {
					System.out.println("Thread 2 is running.");
					// Thread 2 logic
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread thread3 = new Thread(() -> {
			try {
				thread2.join(); // Wait for Thread 2 to complete
				synchronized (lock) {
					System.out.println("Thread 3 is running.");
					// Thread 3 logic
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

