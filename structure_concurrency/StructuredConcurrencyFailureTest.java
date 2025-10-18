package Complete_Concurrent_Collections.structure_concurrency;

import java.util.concurrent.*;

public class StructuredConcurrencyFailureTest {

	record User(String name) {}
	record Account(double balance) {}



	public static void main(String[] args) throws InterruptedException {
		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

			// Launch tasks in parallel
			var userFuture = scope.fork(() -> fetchUser());
			var accountFuture = scope.fork(() -> fetchAccount());

			// Wait for all tasks to complete or any to fail
			scope.join();
			scope.throwIfFailed(); // throws if any subtask failed

			// Get results safely
			User user = userFuture.get();
			Account account = accountFuture.get();

			System.out.println("User: " + user.name() + ", Balance: " + account.balance());
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	static User fetchUser() throws InterruptedException {
		System.out.println("Fetch user");
		Thread.sleep(500); // simulate delay
		return new User("Sumit");
	}

	static Account fetchAccount() throws InterruptedException {
		System.out.println("Fetch account");
		Thread.sleep(700);
		throw new RuntimeException();
	}
}