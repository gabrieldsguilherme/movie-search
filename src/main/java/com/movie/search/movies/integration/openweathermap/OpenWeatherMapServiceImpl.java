package com.movie.search.movies.integration.openweathermap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.movies.integration.RestClient;
import com.movie.search.movies.integration.openweathermap.to.WeatherResponse;
import com.movie.search.movies.service.ApplicationConfig;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Override
	public WeatherResponse searchByCityAndCountry(String city, String country) {
		String key = applicationConfig.getOpenWeatherMapApiKey();
		String url = StringUtils.join(applicationConfig.getOpenWeatherMapBaseUrl(),
				"/weather",
				"?q={city},{country}",
				"&units=metric",
				"&appid={key}");
		return restClient.get(url, WeatherResponse.class, city, country, key);
	}

}
