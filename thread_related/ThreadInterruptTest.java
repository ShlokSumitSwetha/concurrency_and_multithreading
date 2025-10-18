package Complete_Concurrent_Collections.thread_related;

public class ThreadInterruptTest implements  Runnable{

	public static void main(String[] args) {
		Thread t= new Thread(new ThreadInterruptTest());
		t.start();
		t.interrupt();
	}

	@Override
	public void run() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
