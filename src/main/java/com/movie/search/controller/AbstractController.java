package com.movie.search.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import com.movie.search.integration.exception.InvalidCityOrCountryException;
import com.movie.search.integration.exception.InvalidKeyException;

public abstract class AbstractController {

	@ExceptionHandler(value = { InvalidKeyException.class, InvalidCityOrCountryException.class })
	protected void handleBadRequest(HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler(value = HttpStatusCodeException.class)
	protected void handleInternalServerError(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
}
