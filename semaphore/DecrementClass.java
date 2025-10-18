package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.Semaphore;

public class DecrementClass implements Runnable{
	Semaphore semaphore;
	
	public DecrementClass(Semaphore semaphore){
		this.semaphore=semaphore;
	}

	
	@Override
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName()+"requesting for permit");
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"granted Access");
			for(int i=0;i<10;i++){
			SharedResourceAccess.count--;
			System.out.println("decremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	//once done release lock
		semaphore.release();
	}
}
