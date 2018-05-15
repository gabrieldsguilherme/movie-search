package com.movie.search.movies.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.movies.service.ApplicationConfig;
import com.movie.search.movies.to.WeatherResponse;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Override
	public WeatherResponse searchByCityAndCountry(String city, String country) {
		String url = applicationConfig.getOpenWeatherMapBaseUrl() + "/weather?q={city},{country}&appid={key}&units=metric";
		String key = applicationConfig.getOpenWeatherMapApiKey();
		return (WeatherResponse) restClient.get(url, WeatherResponse.class, city, country, key);
	}

}
