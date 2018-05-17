package com.movie.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.factory.MovieGenresFactory;
import com.movie.search.integration.openweathermap.OpenWeatherMapService;
import com.movie.search.integration.openweathermap.to.WeatherResponse;
import com.movie.search.integration.themoviedb.Genre;
import com.movie.search.integration.themoviedb.TheMovieDBService;
import com.movie.search.integration.themoviedb.to.MovieResponse;
import com.movie.search.integration.themoviedb.to.Result;
import com.movie.search.to.Movie;
import com.movie.search.to.MoviesSuggestion;
import com.movie.search.to.MoviesSuggestion.Builder;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private OpenWeatherMapService openWeatherMapService;
	
	@Autowired
	private TheMovieDBService theMovieDBService;
	
	@Autowired
	private MovieGenresFactory movieGenresFactory;
	
	@Override
	public MoviesSuggestion searchMovies(String city, String country) throws Exception {
		WeatherResponse weather = openWeatherMapService.searchByCityAndCountry(city, country);
		Long temperature = weather.getMain().getTemp();
		
		Genre genre = movieGenresFactory.getGenreByTemperature(temperature);
		
		MovieResponse movie = theMovieDBService.searchByGenre(genre);
		
		return buildMovieSuggestion(genre, movie, weather);
	}

	private MoviesSuggestion buildMovieSuggestion(Genre genre, MovieResponse movie, WeatherResponse weather) {
		List<Result> movies = movie.getResults();
		
		Builder moviesSuggestionBuilder = new MoviesSuggestion.Builder()
			.withGenre(genre.name())
			.withCity(weather.getName())
			.withTemperature(weather.getMain().getTemp());
		
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
