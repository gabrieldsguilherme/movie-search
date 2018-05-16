package com.movie.search.movies.to;

import java.util.ArrayList;
import java.util.List;

import com.movie.search.movies.integration.themoviedb.Genre;

public class MoviesSuggestion {
	
	private Genre genre;
	private List<Movie> movies;

	public Genre getGenre() {
		return genre;
	}

	public List<Movie> getMovies() {
		return movies;
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
		
		public Builder withGenre(Genre genre) {
			moviesSuggestion.genre = genre;
			return this;
		}
		
		public Builder addMovie(Movie movie) {
			moviesSuggestion.movies.add(movie);
			return this;
		}
 	}

}
