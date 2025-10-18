package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.*;

public class Completable_Future_thenCombine {

	public static void main(String[] args) {

		CompletableFuture<String> one = CompletableFuture.supplyAsync(() -> helloWorld());
		CompletableFuture<String> two = CompletableFuture.supplyAsync(() -> howRU());

		one.thenCombine(two,(o,t)->o+t )
		   .thenApply(String::toUpperCase)
				.thenAccept((result) -> {
					System.out.println("Result Received from completable Future:" + result);
				}).join();

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

	public static String howRU(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "How r u ?";
	}
}
