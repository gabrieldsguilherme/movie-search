package com.movie.search.to;


public class Movie {
	
	private String title;
	private String overview;
	private String releaseDate;
	
	public String getTitle() {
		return title;
	}

	public String getOverview() {
		return overview;
	}

	public String getReleaseDate() {
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
		
		public Builder withReleaseDate(String releaseDate) {
			movie.releaseDate = releaseDate;
			return this;
		}
	}
	
}
