package com.exception;

public class MarksException extends Exception{

	private static final long serialVersionUID = -5033598888953273625L;
	private String message;

	public String getMessage() {
		return message;
	}

	public MarksException(String message) {
		super();
		this.message = message;
	} 
	
	
}
