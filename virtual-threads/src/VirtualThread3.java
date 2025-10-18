public class VirtualThread3 {
	public static void main(String[] args) throws InterruptedException {

		        Runnable task = () -> System.out.println("Unstarted thread running!");

				Thread t = Thread.ofVirtual().unstarted(task);

				System.out.println("Before start: " + t.getState());
				t.start();
				t.join();
			}
}
