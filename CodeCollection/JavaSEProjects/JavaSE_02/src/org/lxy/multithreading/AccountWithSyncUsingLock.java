package org.lxy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author menglanyingfei
 * @date 2017-5-25
 */
public class AccountWithSyncUsingLock {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 1000; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		
		// Wait until all tasks are finished
		while (!executor.isTerminated()) {
		}
		
		System.out.println("What is balance? " + account.getBalance());
	}
	
	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable {
		@Override
		public void run() {
			account.deposit(1);
		}
	}
	
	/*
	// a inner class for account
	private static class Account {
		// Create a lock
		private static Lock lock = new ReentrantLock();
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			// Acquire the lock
			lock.lock();
			try {
				int newBalance = balance + amount;
				Thread.sleep(5);
				balance = newBalance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}		
	*/
	
	// An inner class for account
	private static class Account {
		// Create a semaphore	
		private static Semaphore semaphore = new Semaphore(1);
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			try {
				// Acquire a permit
				semaphore.acquire();
				int newBalance = balance + amount;
				// This delay is deliberately added to magnify the
				// data-corruption problem and make it easy to see
				Thread.sleep(5);
				
				balance = newBalance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				// Release a permit
				semaphore.release();
			}
		}
	}		
}











