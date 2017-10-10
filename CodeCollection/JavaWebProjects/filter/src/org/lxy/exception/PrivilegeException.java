package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class PrivilegeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4137040321625002945L;

	public PrivilegeException() {
		super();
		
	}

	public PrivilegeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PrivilegeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PrivilegeException(String message) {
		super(message);
		
	}

	public PrivilegeException(Throwable cause) {
		super(cause);
		
	}
	
}
