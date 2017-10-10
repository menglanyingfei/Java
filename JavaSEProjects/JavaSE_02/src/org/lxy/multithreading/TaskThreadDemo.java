package org.lxy.multithreading;
/**
 * @author menglanyingfei
 * @date 2017-5-24
 */
public class TaskThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create tasks
		Runnable printA = new PrintChar('a', 100);
		Runnable print100 = new PrintNum(100);
		
		// Create threads 
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(print100);
		
		// Start threads
		thread1.start();
		thread2.start();
	}
}

class PrintChar implements Runnable {
	private char charToPrint;
	private int times;
	
	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}
	/**
	 * Override the run() method to tell the system 
	 * what task to perform
	 */
	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}
		System.out.println();
	}
	
}

class PrintNum implements Runnable {
	private int lastNum;
	
	public PrintNum(int n) {
		lastNum = n;
	}
	/** 
	 * Tell the thread how to run 
	 */
	@Override
	public void run() {
		for (int i = 1; i <= lastNum; i++) {
			System.out.print(" " + i);
		}
	}
	
}




