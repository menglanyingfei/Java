package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-4-28
 */
public class LoginException extends Exception {
	/**
	 * 自定义异常
	 */
	private static final long serialVersionUID = -2395537203064607851L;

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LoginException(String message) {
		super(message);
		
	}

	public LoginException(Throwable cause) {
		super(cause);
		
	}
	
}
