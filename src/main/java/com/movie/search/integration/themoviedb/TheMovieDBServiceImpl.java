package com.movie.search.integration.themoviedb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.movie.search.integration.IntegrationService;
import com.movie.search.integration.RestClient;
import com.movie.search.integration.exception.InvalidKeyException;
import com.movie.search.integration.themoviedb.to.MovieResponse;
import com.movie.search.service.ApplicationConfig;

@Service
public class TheMovieDBServiceImpl implements TheMovieDBService, IntegrationService {
	
	private static final String INTEGRATION_NAME = "The Movie DB";

	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Override
	public MovieResponse searchByGenre(Genre genre) throws Exception {
		try {
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
		} catch (HttpClientErrorException e) {
			if (HttpStatus.UNAUTHORIZED == e.getStatusCode()) {
				throw new InvalidKeyException(getIntegrationName());
			}
			throw e;
		}
	}
	
	@Override
	public String getIntegrationName() {
		return INTEGRATION_NAME;
	}
	
	private String getDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
	
}
