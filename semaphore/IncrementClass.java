package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.Semaphore;

public class IncrementClass implements Runnable{

	Semaphore semaphore;
	public IncrementClass(Semaphore semaphore){
		this.semaphore=semaphore;
	}

	@Override
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName()+" requesting for permit"+ Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName()+" Semaphore Permit Count before acquire() called"+semaphore.availablePermits());
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
			System.out.println(Thread.currentThread().getName()+" granted Access");
			for(int i=0;i<10;i++){
			SharedResourceAccess.count++;
			System.out.println("incremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	  //once done release lock
		semaphore.release();
		System.out.println("Semaphore Permit Count after release() called"+semaphore.availablePermits());
	}

}
