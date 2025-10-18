import java.util.concurrent.*;

public class VirtualThread4 {
	public static void main(String[] args) {
				try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
					executor.submit(() -> System.out.println("Task 1: " + Thread.currentThread()));
					executor.submit(() -> System.out.println("Task 2: " + Thread.currentThread()));
				}
			}
		}

