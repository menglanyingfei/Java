package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo5_MyException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

class AgeOutOfBoundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2786349777055806103L;

	public AgeOutOfBoundsException() {
		super();
	}

	public AgeOutOfBoundsException(String message) {
		super(message);
	}
}

















