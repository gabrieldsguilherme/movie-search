package com.movie.search.movies.integration.themoviedb;

import com.movie.search.movies.integration.themoviedb.to.MovieResponse;

public interface TheMovieDBService {

	MovieResponse searchByGenre(Genre genre);

}
