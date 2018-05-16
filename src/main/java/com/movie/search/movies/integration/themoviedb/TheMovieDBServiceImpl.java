package com.movie.search.movies.integration.themoviedb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.search.movies.integration.RestClient;
import com.movie.search.movies.integration.themoviedb.to.MovieResponse;
import com.movie.search.movies.service.ApplicationConfig;

@Service
public class TheMovieDBServiceImpl implements TheMovieDBService {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Override
	public MovieResponse searchByGenre(Genre genre) {
		String startDate = getDate(LocalDate.now().minusMonths(1));
		String endDate = getDate(LocalDate.now());
		String key = applicationConfig.getTheMovieDBApiKey();
		String language = applicationConfig.getTheMovieDBLanguage();
		String url = StringUtils.join(applicationConfig.getTheMovieDBBaseUrl(),
				"/discover/movie",
				"?primary_release_date.gte={start-date}&primary_release_date.lte={end-date}",
				"&sort_by=popularity.desc",
				"&with_genres={genre}",
				"&language={language}",
				"&api_key={key}");
		return restClient.get(url, MovieResponse.class, startDate, endDate, genre.getId(), language, key);
	}
	
	private String getDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}

}
