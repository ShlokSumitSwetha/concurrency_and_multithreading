package Complete_Concurrent_Collections.scoped_values;

public class ScopedValueTest {
	static final ScopedValue<String> USER = ScopedValue.newInstance();
	static final ScopedValue<String> ROLE = ScopedValue.newInstance();

	public static void main(String[] args) {

			ScopedValue.where(USER, "Alice").where(ROLE, "Admin").run(() -> {
				System.out.println("User: " + USER.get());
				System.out.println("Role: " + ROLE.get());
			});
		}
}
