package com.movie.search.integration;

public interface IntegrationService {
	
	public default String getIntegrationName() {
		return "integration";
	}

}
