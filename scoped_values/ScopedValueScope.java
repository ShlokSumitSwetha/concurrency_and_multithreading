package Complete_Concurrent_Collections.scoped_values;

public class ScopedValueScope {
	// Define a scoped value
	static final ScopedValue<String> USER_NAME = ScopedValue.newInstance();

	public static void main(String[] args) {
		// Use the scoped value in a scope
		ScopedValue.where(USER_NAME, "Sumit").run(() -> {
			printUser(); // bounded
		});
		printUser2(); // unbounded
	}

	static void printUser() {
		System.out.println("Current user: " + USER_NAME.get());
		System.out.println("Bound scope: " + USER_NAME.isBound());
	}

	static void printUser2() {
		System.out.println("Bound scope: " + USER_NAME.isBound());
		System.out.println("Current user: " + USER_NAME.get());
	}
}
