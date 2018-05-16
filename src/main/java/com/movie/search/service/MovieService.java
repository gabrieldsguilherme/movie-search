package com.movie.search.service;

import com.movie.search.to.MoviesSuggestion;

public interface MovieService {
	
	public MoviesSuggestion searchMovies(String city, String country);

}
