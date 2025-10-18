package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.*;

import java.util.concurrent.Semaphore;

public class SemaphoreOrderedExecution {
	public static void main(String[] args) {
		Semaphore semaphore1 = new Semaphore(1);
		Semaphore semaphore2 = new Semaphore(0);
		Semaphore semaphore3 = new Semaphore(0);

		Thread thread1 = new Thread(() -> {
			try {
				semaphore1.acquire();
				System.out.println("Thread 1 is running.");
				// Thread 1 logic
				semaphore2.release();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				semaphore2.acquire();
				System.out.println("Thread 2 is running.");
				// Thread 2 logic
				semaphore3.release();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread thread3 = new Thread(() -> {
			try {
				semaphore3.acquire();
				System.out.println("Thread 3 is running.");
				// Thread 3 logic
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();

		semaphore1.release(); // Start the execution with Thread 1
	}
}
