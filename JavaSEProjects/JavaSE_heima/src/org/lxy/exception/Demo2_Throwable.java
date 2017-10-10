package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo2_Throwable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int a = 10 / 0;
			System.out.println(a);
		} catch (Exception e) { // Exceptio e = new ArithmeticException("/ by zero");
			//System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}



















