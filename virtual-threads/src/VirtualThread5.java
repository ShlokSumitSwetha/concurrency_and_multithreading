import java.util.concurrent.*;

public class VirtualThread5 {

	public static void main(String[] args) throws InterruptedException {
		ThreadFactory factory = Thread.ofVirtual().factory();
		ExecutorService executor = Executors.newThreadPerTaskExecutor(factory);

		executor.submit(() -> System.out.println("Custom factory: " + Thread.currentThread()));

		Thread.sleep(2000);
		executor.shutdown();
	}
}
