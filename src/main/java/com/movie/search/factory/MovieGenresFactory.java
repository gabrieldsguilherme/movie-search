package com.movie.search.factory;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.movie.search.integration.themoviedb.Genre;

@Component
public class MovieGenresFactory {
	
	public Genre getGenreByTemperature(Long temperature) {
		return Stream.of(Genre.values())
				.filter(genre -> genre.isCompatibleWithTemperature(temperature))
				.findFirst()
				.orElse(null);
	}

}
