package Complete_Concurrent_Collections.scoped_values;

public class ScopedValueCall {
	static final ScopedValue<Integer> DISCOUNT = ScopedValue.newInstance();

	public static void main(String[] args) throws Exception {
		int total = ScopedValue.where(DISCOUNT, 10).call(() -> {
			return calculatePrice(200);
		});
		System.out.println("Total: " + total);
	}

	static int calculatePrice(int price) {
		return price - DISCOUNT.get();
	}
}
