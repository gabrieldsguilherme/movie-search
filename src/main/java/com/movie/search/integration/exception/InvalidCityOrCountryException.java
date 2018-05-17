package com.movie.search.integration.exception;

public class InvalidCityOrCountryException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidCityOrCountryException() {
		super("Invalid city or country");
	}

}
