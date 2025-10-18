package Complete_Concurrent_Collections.thread_related;

public class ThreadLocalTest {
	private static ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

	public static void main(String[] args) {
		Runnable task = () -> {
			int count = threadLocalCounter.get();
			count++;
			threadLocalCounter.set(count);
			System.out.println("Thread " + Thread.currentThread().getId() + ": Counter = " + count);
		};

		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();
	}
}

