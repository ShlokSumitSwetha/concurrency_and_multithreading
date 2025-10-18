package Complete_Concurrent_Collections.scoped_values;

public class ScopedDefaultValue {
	static final ScopedValue<String> ENVIRONMENT = ScopedValue.newInstance();

	public static void main(String[] args) {
		System.out.println("Env: " + ENVIRONMENT.orElse("DEV")); // Default to DEV

		ScopedValue.where(ENVIRONMENT, "PROD").run(() -> {
			System.out.println("Env in scope: " + ENVIRONMENT.get());
		});
	}
}
