package org.lxy.thread;
/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Demo3_Synchronized {
	public static void main(String[] args) {
		final Printer p = new Printer();
		
		new Thread() {
			public void run() {
				while (true) {
					p.print1();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					p.print2();
				}
			}
		}.start();
	}
}

class Printer {
    static Demo d = new Demo();
    public void print1() {
        synchronized(d) {                //锁对象可以是任意对象,但是被锁的代码需要保证是同一把锁,不能用匿名对象
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
        }
    }

    public void print2() {   
        synchronized(d) {   
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
        }
    }
}

class Demo {
}
