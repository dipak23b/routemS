package com.zigatta.ms.exception;

/**
 * Unchecked runtime exception that can be thrown by application for invalid input received by resource.
 * 
 */
public class InvalidInputException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int httpCode;
	private final String errorMessage;
	
	public InvalidInputException(int httpCode, String errorMessage) {
		super();
		this.httpCode = httpCode;
		this.errorMessage = errorMessage;
	}
	
	public int getHttpCode() {
		return httpCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
