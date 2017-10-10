package org.lxy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author menglanyingfei
 * @date 2017-5-24
 */
public class ExecutorDemo {
	public static void main(String[] args) {
		// Create a fixed thread pool with maximum two threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		
		// Shut down the executor
		executor.shutdown();
	}
}







