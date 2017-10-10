package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-5-4
 */
public class AccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1436175223672373033L;

	public AccountException() {
		super();
		
	}

	public AccountException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountException(String message) {
		super(message);
		
	}

	public AccountException(Throwable cause) {
		super(cause);
		
	}
	
}















