package Complete_Concurrent_Collections.executos;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;



public class scheduledThreadPool
{
   public static void main(String[] args) throws InterruptedException, ExecutionException
    {
 
        Runnable runnabledelayedTask = new Runnable()
        {
            @Override
            public void run()
            {
                 System.out.println(Thread.currentThread().getName()+" is Running Delayed Task");
            }
        };
 
 
        Callable callabledelayedTask = new Callable()
        {
 
            @Override
            public String call() throws Exception
            {
                  return "GoodBye! See you at another invocation...";
            }
        };
 
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);
 
        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask, 1, 2, TimeUnit.SECONDS);
 
      
        
        scheduledPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        
        System.out.println("Is ScheduledThreadPool shutting down? "+scheduledPool.isShutdown());
        
        
        ScheduledFuture sf = scheduledPool.schedule(callabledelayedTask, 20, TimeUnit.SECONDS);
 
        String value = (String)sf.get();
 
        System.out.println("Callable returned"+value);
 
       
        
        
       
        
        
    }
}
