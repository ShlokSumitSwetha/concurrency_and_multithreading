package Complete_Concurrent_Collections.runnable_callable;

import java.util.concurrent.*;

public class RunnableExample  implements Runnable{
	@Override
	public void run() {
		try {
			throw new InterruptedException("Interrupted");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

	}

	class callableExample implements Callable{

		@Override
		public Object call() throws Exception {
			throw new InterruptedException("Interrupted");
		}
	}
}
