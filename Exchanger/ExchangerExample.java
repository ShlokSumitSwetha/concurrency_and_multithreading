package Complete_Concurrent_Collections.Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();

		Thread thread1 = new Thread(() -> {
			try {
				System.out.println("Thread 1: Waiting to exchange data...");
				String data = exchanger.exchange("Data from Thread 1");
				System.out.println("Thread 1: Exchanged data: " + data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				System.out.println("Thread 2: Waiting to exchange data...");
				String data = exchanger.exchange("Data from Thread 2");
				System.out.println("Thread 2: Exchanged data: " + data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		thread1.start();
		thread2.start();
	}
}

