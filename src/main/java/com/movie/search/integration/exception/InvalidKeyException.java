package com.movie.search.integration.exception;

public class InvalidKeyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidKeyException() {
		super("Invalid api key");
	}

}
