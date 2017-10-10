package org.lxy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author menglanyingfei
 * @date 2017-5-25
 */
public class AccountWithoutSync {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 1000; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		
		System.out.println("What is balance? " + account.getBalance());
	}
	
	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable {
		@Override
		public void run() {
			//account.deposit(1);
			synchronized (account) {
				account.deposit(1);
			}		
		}
	}
	
	// a inner class for account
	private static class Account {
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			int newBalance = balance + amount;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
		}
	}
}











