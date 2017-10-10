package org.lxy.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author menglanyingfei
 * @date 2017-6-13
 */
public class ConsumerProducerUsingBlockingQueue {

	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(
			2);

	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}

	// A task for adding an int to the buffer
	private static class ProducerTask implements Runnable {
		@Override
		public void run() {
			try {
				int i = 1;
				while (true) {
					System.out.println("Producer writes " + i);
					// Add a value to the buffer
					buffer.put(i++);
					// Put the thread to sleep
					Thread.sleep((int) (Math.random()) * 10000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	// A task for reading and deleting an int from the buffer
	private static class ConsumerTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					System.out
							.println("\t\t\tConsumer reads  " + buffer.take());
					// Put the thread to sleep
					Thread.sleep((int) (Math.random()) * 10000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
