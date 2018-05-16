package com.movie.search.integration.themoviedb;

import com.movie.search.integration.themoviedb.to.MovieResponse;

public interface TheMovieDBService {

	MovieResponse searchByGenre(Genre genre);

}
