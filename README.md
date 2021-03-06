# movie-search
Spring Boot Application that returns movies in theatres based on temperature of the city informed.

# Api Documentation
GET /api/movie?city={city}&country={country}
- {city}: City name (required)
- {country}: Country code (required)

> Example: /api/movie?city=Campinas&country=BR

Note: The pattern used to validate cities and countries is OpenWeatherMap responsibility. For more information, read the documentation.

# Requirements
- Java 8+
- Account on OpenWeatherMap (https://openweathermap.org/) to generate api key
- Account on The Movie DB (https://www.themoviedb.org/) to generate api key
- Properties Configuration
  - Deploy: https://github.com/gabrieldsguilherme/movie-search/blob/master/src/main/resources/application.properties
  - Local Tests: https://github.com/gabrieldsguilherme/movie-search/blob/master/src/test/resources/application.properties

# API Goal
Get movie suggestions in theatres based on local temperature.

- Temperature > 40: Action Movies
- 36 >= Temperature <= 40: Comedy Movies
- 20 >= Temperature <= 35: Animation Movies
- 0 >= Temperature <= 19: Mystery Movies
- Temperature < 0: Documentary Movies

# TODO
- Add more tests using RestAssured
- Insert/configure logs
- Tests mocking integration services to explore responses
- Modularize integrations
- Return custom objects describing the error
