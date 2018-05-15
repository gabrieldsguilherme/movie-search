package com.movie.search.movies.integration;

import com.movie.search.movies.to.WeatherResponse;

public interface OpenWeatherMapService {
	
	public WeatherResponse searchByCityAndCountry(String city, String country);

}
