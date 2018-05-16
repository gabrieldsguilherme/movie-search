package com.movie.search.movies.service;

import com.movie.search.movies.to.MoviesSuggestion;

public interface MovieService {
	
	public MoviesSuggestion searchMovies(String city, String country);

}
