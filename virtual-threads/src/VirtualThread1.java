public class VirtualThread1 {
	public static void main(String[] args) throws InterruptedException {

		Thread t = Thread.startVirtualThread(() -> {
			System.out.println("Running in: " + Thread.currentThread());
		});
		// Main ends immediately
		Thread.sleep(20000);
		System.out.println("Main thread ends!");

	}

}
