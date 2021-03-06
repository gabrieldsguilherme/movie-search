package com.movie.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.search.service.MovieService;
import com.movie.search.to.MoviesSuggestion;

@RestController
public class MovieController extends AbstractController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/api/movie", params = {"city", "country"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MoviesSuggestion searchMovie(@RequestParam(value="city") String city, @RequestParam(value="country") String country) throws Exception {
		return movieService.searchMovies(city, country);
	}
	
}
