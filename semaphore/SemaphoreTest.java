package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	/**
	 * Semaphore is useful for shared resources
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(1);
		System.out.println("Starting Semaphore Example");


		Thread t1=new Thread(new IncrementClass(semaphore));
		t1.setName("Increment Thread");
		t1.start();

		Thread t2 = new Thread(new DecrementClass(semaphore));
		t2.setName("Decrement Thread");
		t2.start();
	}
}


/*Starting Semaphore Example
A thread requesting for permit
A thread granted Access
incremented the shared resource1
B thread requesting for permit
incremented the shared resource2
incremented the shared resource3
incremented the shared resource4
incremented the shared resource5
incremented the shared resource6
incremented the shared resource7
incremented the shared resource8
incremented the shared resource9
incremented the shared resource10
B thread granted Access
decremented the shared resource9
decremented the shared resource8
decremented the shared resource7
decremented the shared resource6
decremented the shared resource5
decremented the shared resource4
decremented the shared resource3
decremented the shared resource2
decremented the shared resource1
decremented the shared resource0*/