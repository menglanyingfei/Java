package org.lxy.thread;
/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Demo1_Thread {
	public static void main(String[] args) {
		//  继承Thread类
		new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("thread1");
				}
			}
		}.start();
		
		// 实现Runnable接口
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 1000; j++) {
					System.out.println("thread2");
				}
			}	
		}).start();
	}
	
	
	
	
}









