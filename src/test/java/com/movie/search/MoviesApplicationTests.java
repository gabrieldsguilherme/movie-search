package com.movie.search;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.http.ContentType;
import com.movie.search.service.ApplicationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MoviesApplicationTests {
	
	public static final String URL = "http://localhost:%s/api/movie?city=Campinas&country=br";
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Test
	public void testMovieResponse() {
		given()
		.accept(ContentType.JSON)
		.when()
		.get(String.format(URL, port))
		.then()
		.statusCode(200);
	}

}
