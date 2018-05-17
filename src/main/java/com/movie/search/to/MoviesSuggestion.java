package com.movie.search.to;

import java.util.ArrayList;
import java.util.List;

public class MoviesSuggestion {
	
	private String city;
	private Long temperature;
	private String genre;
	private List<Movie> movies;

	public String getGenre() {
		return genre;
	}

	public List<Movie> getMovies() {
		return movies;
	}
	
	public String getCity() {
		return city;
	}
	
	public Long getTemperature() {
		return temperature;
	}
	
	public static class Builder {
		private MoviesSuggestion moviesSuggestion;
		
		public Builder() {
			moviesSuggestion = new MoviesSuggestion();
			moviesSuggestion.movies = new ArrayList<>();
		}
		
		public MoviesSuggestion build() {
			return moviesSuggestion;
		}
		
		public Builder withGenre(String genre) {
			moviesSuggestion.genre = genre;
			return this;
		}
		
		public Builder addMovie(Movie movie) {
			moviesSuggestion.movies.add(movie);
			return this;
		}
		
		public Builder withCity(String city) {
			moviesSuggestion.city = city;
			return this;
		}
		
		public Builder withTemperature(Long temperature) {
			moviesSuggestion.temperature = temperature;
			return this;
		}
 	}

}
