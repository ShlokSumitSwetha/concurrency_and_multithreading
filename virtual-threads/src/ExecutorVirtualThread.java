
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ExecutorVirtualThread {
	public static void main(String[] args) {
		Instant start = Instant.now();
		Set<Thread> threads1 = Thread.getAllStackTraces().keySet();
		System.out.println("Before Virtual Threads:");
		System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
		for (Thread t : threads1) {
			System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
		}
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			IntStream.range(0, 100000).forEach(i -> {
				executor.submit(() -> {
					Thread.sleep(Duration.ofSeconds(1));
					//System.out.println("Thread name:"+Thread.currentThread().threadId());
					return i;
				});
			});
		}
		System.out.println("------------------------------------------------------------");
		Instant end = Instant.now();
		System.out.println("Total Duration:"+Duration.between(start, end).getSeconds());
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		System.out.println("After Virtual Threads:");
		System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
		for (Thread t : threads) {
			System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
		}
		System.out.println("------------------------------------------------------------");
	}
}
