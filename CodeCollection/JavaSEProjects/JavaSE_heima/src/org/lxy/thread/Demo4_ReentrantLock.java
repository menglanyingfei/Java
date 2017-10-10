package org.lxy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author menglanyingfei
 * @date 2017-4-16
 */
public class Demo4_ReentrantLock {
	public static void main(String[] args) {
		final Printer1 p = new Printer1();
		new Thread() {
			public void run() {
				while (true) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

class Printer1 {
	private ReentrantLock r = new ReentrantLock();
	private Condition c1 = r.newCondition();
	private Condition c2 = r.newCondition();
	private int flag = 1;
	
    public void print1() throws InterruptedException {
        	r.lock();
        	if (flag != 1) {
        		c1.await();
        	}
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            c2.signal();
            r.unlock();
    }

    public void print2() throws InterruptedException {   
    	r.lock();
    	if (flag != 2) {
    		c2.await();
    	}
        System.out.print("传");
        System.out.print("智");
        System.out.print("播");
        System.out.print("客");
        System.out.print("\r\n");
        flag = 1;
        c1.signal();
        r.unlock();
    }
}















