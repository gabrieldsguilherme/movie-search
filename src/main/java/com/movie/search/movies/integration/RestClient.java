package com.movie.search.movies.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
	
	public Object get(String url, Class clazz, String...queryParameters) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, clazz, queryParameters);
	}

}
