package com.rest.exception;

public class RequestProcessingFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequestProcessingFailedException(String message) {
		super(message);
	}

}
