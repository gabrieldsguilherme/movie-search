package com.movie.search.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {
	
	private ApplicationConfig() {
		// Do nothing
	}
	
	@Value("${integration.openweathermap.base-url}")
	private String openWeatherMapBaseUrl;
	
	@Value("${integration.openweathermap.api-key}")
	private String openWeatherMapApiKey;
	
	@Value("${integration.themoviedb.base-url}")
	private String theMovieDBBaseUrl;
	
	@Value("${integration.themoviedb.api-key}")
	private String theMovieDBApiKey;
	
	@Value("${integration.themoviedb.language}")
	private String theMovieDBLanguage;
	
	public String getOpenWeatherMapBaseUrl() {
		return openWeatherMapBaseUrl;
	}
	
	public String getOpenWeatherMapApiKey() {
		return openWeatherMapApiKey;
	}

	public String getTheMovieDBBaseUrl() {
		return theMovieDBBaseUrl;
	}

	public String getTheMovieDBApiKey() {
		return theMovieDBApiKey;
	}

	public String getTheMovieDBLanguage() {
		return theMovieDBLanguage;
	}

}
