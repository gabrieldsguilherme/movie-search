package com.movie.search.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.movies.factory.MovieGenresFactory;
import com.movie.search.movies.integration.openweathermap.OpenWeatherMapService;
import com.movie.search.movies.integration.themoviedb.Genre;
import com.movie.search.movies.integration.themoviedb.TheMovieDBService;
import com.movie.search.movies.to.Movie;
import com.movie.search.movies.to.MovieResponse;
import com.movie.search.movies.to.MoviesSuggestion;
import com.movie.search.movies.to.MoviesSuggestion.Builder;
import com.movie.search.movies.to.Result;
import com.movie.search.movies.to.WeatherResponse;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private OpenWeatherMapService openWeatherMapService;
	
	@Autowired
	private TheMovieDBService theMovieDBService;
	
	@Autowired
	private MovieGenresFactory movieGenresFactory;
	
	@Override
	public MoviesSuggestion searchMovies(String city, String country) {
		WeatherResponse weather = openWeatherMapService.searchByCityAndCountry(city, country);
		Long temperature = weather.getMain().getTemp();
		
		Genre genre = movieGenresFactory.getGenreByTemperature(temperature);
		
		MovieResponse movie = theMovieDBService.searchByGenre(genre);
		
		return buildMovieSuggestion(genre, movie);
	}

	private MoviesSuggestion buildMovieSuggestion(Genre genre, MovieResponse movie) {
		List<Result> movies = movie.getResults();
		
		Builder moviesSuggestionBuilder = new MoviesSuggestion.Builder()
			.withGenre(genre);
		
		movies.forEach(m -> {
			moviesSuggestionBuilder.addMovie(
					new Movie.Builder()
						.withTitle(m.getTitle())
						.withOverview(m.getOverview())
						.withReleaseDate(m.getReleaseDate())
						.build());
		});
		
		return moviesSuggestionBuilder.build();
	}

}
