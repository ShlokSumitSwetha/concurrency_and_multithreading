package Complete_Concurrent_Collections.scoped_values;

public class ScopedValueNestedScope {
	static final ScopedValue<String> USER_NAME = ScopedValue.newInstance();

	public static void main(String[] args) {
		ScopedValue.where(USER_NAME, "Alice").run(() -> {
			System.out.println("Outer scope: " + USER_NAME.get());

			ScopedValue.where(USER_NAME, "Bob").run(() -> {
				System.out.println("Inner scope: " + USER_NAME.get());
				System.out.println("Bound scope: " + USER_NAME.isBound());
			});

			System.out.println("Back to outer: " + USER_NAME.get()); // outer scope is valid here
			System.out.println("Bound scope: " + USER_NAME.isBound());
		});
		System.out.println("Bound scope: " + USER_NAME.isBound());
	}
}
