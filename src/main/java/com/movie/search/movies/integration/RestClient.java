package com.movie.search.movies.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
	
	public <T> T get(String url, Class<T> clazz, Object...queryParameters) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, clazz, queryParameters);
	}

}
