package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.*;

public class Completable_Future_thenCompose {

	public static void main(String[] args) {

		CompletableFuture.supplyAsync(() -> helloWorld())
				.thenCompose((previous)->composeValue(previous))
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
		return "hello ";
	}

	public static CompletableFuture<String> composeValue(String value){
		return CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return value+"added compose";
		});
	}
}
