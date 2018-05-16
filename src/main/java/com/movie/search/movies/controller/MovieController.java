package com.movie.search.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.search.movies.service.MovieService;
import com.movie.search.movies.to.MoviesSuggestion;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/api/movie", params = {"city", "country"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MoviesSuggestion searchMovie(@RequestParam(value="city") String city, @RequestParam(value="country") String country) {
		return movieService.searchMovies(city, country);
	}

}
