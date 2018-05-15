package com.movie.search.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.movies.factory.MovieGenresFactory;
import com.movie.search.movies.integration.OpenWeatherMapService;
import com.movie.search.movies.to.MovieResponse;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private OpenWeatherMapService openWeatherMapService;
	
	@Autowired
	private MovieGenresFactory movieGenresFactory;
	
	@Override
	public MovieResponse searchMovies(String city, String country) {
		openWeatherMapService.searchByCityAndCountry(city, country);
		return null;
	}

}
