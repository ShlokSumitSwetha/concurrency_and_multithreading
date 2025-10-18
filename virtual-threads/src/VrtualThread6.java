import java.util.*;
import java.util.concurrent.*;

public class VrtualThread6 {
	public static void main(String[] args) {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			List.of(1, 2, 3, 4).forEach(n -> executor.submit(() -> {
				//System.out.println("Processing " + n + " in " + Thread.currentThread());
			}));

			System.out.println("Processing " + Runtime.getRuntime().availableProcessors());
		}
	}
}
