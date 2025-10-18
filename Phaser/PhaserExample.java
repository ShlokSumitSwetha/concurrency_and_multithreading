package Complete_Concurrent_Collections.Phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {
	public static void main(String[] args) {
		int parties = 3; // Number of threads participating
		int phases = 4;  // Number of synchronization phases

		Phaser phaser = new Phaser(parties);

		for (int i = 0; i < parties; i++) {
			Thread thread = new Thread(() -> {
				for (int phase = 0; phase < phases; phase++) {
					System.out.println("Thread " + Thread.currentThread().getId() + " - Phase " + phase);
					phaser.arrive(); // Wait for all threads to reach this point
				}
			});
			thread.start();
		}
	}
}

