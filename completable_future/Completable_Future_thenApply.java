package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.*;

public class Completable_Future_thenApply {

	public static void main(String[] args) {

		CompletableFuture.supplyAsync(() -> helloWorld())
				.thenApply(String::toUpperCase)
				.thenAccept((result) -> {
					System.out.println("Result Received from completable Future:" + result);
				}).join();
		// join helps to complete the child thread first then blocks the main thread

		System.out.println("Done");


	}

	public static String helloWorld(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "hello";
	}
}
