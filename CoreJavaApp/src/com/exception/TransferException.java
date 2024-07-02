package com.exception;

public class TransferException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public TransferException(String message) {
		super();
		this.message = message;
	}
	
	
}
