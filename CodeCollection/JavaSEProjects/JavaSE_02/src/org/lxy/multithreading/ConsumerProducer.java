package org.lxy.multithreading;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author menglanyingfei
 * @date 2017-6-13
 */
public class ConsumerProducer {

	private static Buffer buffer = new Buffer();

	/**
	 * @param args
	 */
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
					buffer.write(i++);
					// Put the thread to sleep
					Thread.sleep((int) (Math.random()) * 100000000);
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
							.println("\t\t\tConsumer reads  " + buffer.read());
					// Put the thread to sleep
					Thread.sleep((int) (Math.random()) * 100000000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	// An inner class for buffer
	private static class Buffer {
		// buffer size
		private static final int CAPACITY = 1;
		private LinkedList<Integer> queue = new LinkedList<>();

		// Create a new lock
		private static Lock lock = new ReentrantLock();

		// Create two conditions
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();

		public void write(int value) {
			// Acquire the lock
			lock.lock();
			try {
				while (queue.size() == CAPACITY) {
					System.out.println("Wait for notFull condition");
					notFull.await();
				}

				queue.offer(value);
				// Signal notEmpty condition
				notEmpty.signal();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				// Release the lock
				lock.unlock();
			}
		}

		@SuppressWarnings("finally")
		public int read() {
			int value = 0;

			// Acquire the lock
			lock.lock();
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\t\tWait for notEmpty condition");
					notEmpty.await();
				}

				value = queue.remove();
				// Signal notFull condition
				notFull.signal();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				// Release the lock
				lock.unlock();
				return value;
			}
		}
	}
}
