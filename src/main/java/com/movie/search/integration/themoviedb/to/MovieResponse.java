package com.movie.search.integration.themoviedb.to;

import java.util.List;

public class MovieResponse {
	
	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
