package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo1_Exception {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int a = 10 / 0;
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("你好, 除数不能为0!");
		}
	}

}
