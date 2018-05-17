package com.movie.search.integration.openweathermap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.movie.search.integration.IntegrationService;
import com.movie.search.integration.RestClient;
import com.movie.search.integration.exception.InvalidCityOrCountryException;
import com.movie.search.integration.exception.InvalidKeyException;
import com.movie.search.integration.openweathermap.to.WeatherResponse;
import com.movie.search.service.ApplicationConfig;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService, IntegrationService {
	
	private static final String INTEGRATION_NAME = "OpenWeatherMap";

	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Override
	public WeatherResponse searchByCityAndCountry(String city, String country) throws Exception {
		try {
			String key = applicationConfig.getOpenWeatherMapApiKey();
			String url = StringUtils.join(applicationConfig.getOpenWeatherMapBaseUrl(),
					"/weather",
					"?q={city},{country}",
					"&units=metric",
					"&appid={key}");
			return restClient.get(url, WeatherResponse.class, city, country, key);
		} catch (HttpClientErrorException e) {
			if (HttpStatus.UNAUTHORIZED == e.getStatusCode()) {
				throw new InvalidKeyException(getIntegrationName());
			} else if (HttpStatus.NOT_FOUND == e.getStatusCode()) {
				throw new InvalidCityOrCountryException();
			}
			throw e;
		}
	}
	
	@Override
	public String getIntegrationName() {
		return INTEGRATION_NAME;
	}

}
