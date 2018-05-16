package com.movie.search.movies.integration.openweathermap;

import com.movie.search.movies.integration.openweathermap.to.WeatherResponse;

public interface OpenWeatherMapService {
	
	public WeatherResponse searchByCityAndCountry(String city, String country);

}
