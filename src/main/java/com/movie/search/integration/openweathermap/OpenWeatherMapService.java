package com.movie.search.integration.openweathermap;

import com.movie.search.integration.openweathermap.to.WeatherResponse;

public interface OpenWeatherMapService {
	
	public WeatherResponse searchByCityAndCountry(String city, String country);

}
