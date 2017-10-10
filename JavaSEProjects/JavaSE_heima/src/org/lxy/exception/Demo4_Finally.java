package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo4_Finally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(10 / 0);
		} catch (Exception e) {
			System.out.println("除数为0了!");
			//return;
			System.exit(0);
		} finally {
			//System.out.println("我还是执行了!");
			System.out.println("我只有这种情况, 不执行了!");
		}
	}

}
