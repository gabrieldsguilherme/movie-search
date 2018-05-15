package com.movie.search.movies.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {
	
	private ApplicationConfig() {
		// Do nothing
	}
	
	@Value("${integration.openweathermap.base-url}")
	String openWeatherMapBaseUrl;
	
	@Value("${integration.openweathermap.api-key}")
	String openWeatherMapApiKey;
	
	public String getOpenWeatherMapBaseUrl() {
		return openWeatherMapBaseUrl;
	}
	
	public String getOpenWeatherMapApiKey() {
		return openWeatherMapApiKey;
	}

}
