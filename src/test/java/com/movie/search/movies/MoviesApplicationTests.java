package com.movie.search.movies;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.http.ContentType;
import com.movie.search.movies.service.ApplicationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class MoviesApplicationTests {
	
	public static final String URL = "http://localhost:8181/api/movie?city=Campinas&country=br";
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Test
	public void testMovieResponse() {
		given()
		.accept(ContentType.JSON)
		.when()
		.get(URL)
		.then()
		.statusCode(200);
	}

}
