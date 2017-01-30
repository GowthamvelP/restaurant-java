package com.restaurant.exception;

public class SessionNameNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  SessionNameNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public  SessionNameNotFoundException(String message) {
		super(message);

	}
}
