package com.movie.search.movies.service;

import com.movie.search.movies.to.MovieResponse;

public interface MovieService {
	
	public MovieResponse searchMovies(String city, String country);

}
