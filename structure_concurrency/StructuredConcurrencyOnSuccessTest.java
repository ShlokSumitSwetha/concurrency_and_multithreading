package Complete_Concurrent_Collections.structure_concurrency;

import java.util.concurrent.*;

public class StructuredConcurrencyOnSuccessTest {

	public static void main(String[] args) throws InterruptedException {
		try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {

			// Launch two subtasks (redundant sources)
			scope.fork(() -> fetchFromServerA());
			scope.fork(() -> fetchFromServerB());

			// Wait for one successful completion
			scope.join();

			// Get the first successful result
			String result = scope.result();
			System.out.println("✅ Got data: " + result);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	static String fetchFromServerA() throws InterruptedException {
		Thread.sleep(1000); // slower
		return "Response from Server A";
	}

	static String fetchFromServerB() throws InterruptedException {
		Thread.sleep(400); // faster
		return "Response from Server B";
	}
}