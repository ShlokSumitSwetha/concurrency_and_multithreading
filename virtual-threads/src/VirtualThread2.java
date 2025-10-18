public class VirtualThread2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.ofVirtual()
						.name("virtual thread demo")
						.start(() -> {
							System.out.println("Name: " + Thread.currentThread().getName());
						});

		t.join();
	}
}
