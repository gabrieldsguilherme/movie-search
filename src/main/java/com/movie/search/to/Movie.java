package com.movie.search.to;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Movie {
	
	private String title;
	private String overview;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
	public String getTitle() {
		return title;
	}

	public String getOverview() {
		return overview;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public static class Builder {
		private Movie movie;
		
		public Builder() {
			movie = new Movie();
		}
		
		public Movie build() {
			return movie;
		}
		
		public Builder withTitle(String title) {
			movie.title = title;
			return this;
		}
		
		public Builder withOverview(String overview) {
			movie.overview = overview;
			return this;
		}
		
		public Builder withReleaseDate(LocalDate releaseDate) {
			movie.releaseDate = releaseDate;
			return this;
		}
	}
	
}
