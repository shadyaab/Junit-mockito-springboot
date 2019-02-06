package com.sady.junit.exception;

//@ControllerAdvice
public class InvalidCartId extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidCartId() {
		super("Invalid Cart Id");
	}
	
	public InvalidCartId(String message) {
		super(message);
	}
	
}
