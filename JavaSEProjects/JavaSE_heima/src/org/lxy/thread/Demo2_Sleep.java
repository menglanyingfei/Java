package org.lxy.thread;
/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Demo2_Sleep {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 10; i >= 0; i--) {
			Thread.sleep(1000);
			System.out.println("倒计时 " + i + " 秒");
		}
	}
}
