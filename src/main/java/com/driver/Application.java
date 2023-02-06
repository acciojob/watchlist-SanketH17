package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
/*

You are a big time cinephile and you want to maintain a watchlist by making a simple spring boot application to perform basic CRUD operations to maintain your movie records. So there are 3 major ways you want to add new records. One way is to add a movie you really want to watch, another way is to add a new director you discovered and want to explore his work, and a third way is you want to add a movie-director pair.

Requirements of the application:
Make an MVC architecture, with Movie and Director as your only model classes, which will have some fields as their properties, constructors and getters-setters. Then make a controller, service and repository class with appropriate annotations. Since you want to keep it simple, you don’t need to use any database. (Hint: Think HashMap(s))

You need to implement the logic for following functionalities:

Add a movie: POST /movies/add-movie
Pass the Movie object as request body
Return success message wrapped in a ResponseEntity object
Controller Name - addMovie

Add a director: POST /movies/add-director
Pass the Director object as request body
Return success message wrapped in a ResponseEntity object
Controller Name - addDirector

Pair an existing movie and director: PUT /movies/add-movie-director-pair
Pass movie name and director name as request parameters
Return success message wrapped in a ResponseEntity object
Controller Name - addMovieDirectorPair

Get Movie by movie name: GET /movies/get-movie-by-name/{name}
Pass movie name as path parameter
Return Movie object wrapped in a ResponseEntity object
Controller Name - getMovieByName

Get Director by director name: GET /movies/get-director-by-name/{name}
Pass director name as path parameter
Return Director object wrapped in a ResponseEntity object
Controller Name - getDirectorByName

Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
Pass director name as path parameter
Return List of movies name(List()) wrapped in a ResponseEntity object
Controller Name - getMoviesByDirectorName

Get List of all movies added: GET /movies/get-all-movies
No params or body required
Return List of movies name(List()) wrapped in a ResponseEntity object
Controller Name - findAllMovies

Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
Pass director’s name as request parameter
Return success message wrapped in a ResponseEntity object
Controller Name - deleteDirectorByName

Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
No params or body required
Return success message wrapped in a ResponseEntity object
Controller Name - deleteAllDirectors
(Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)

Please make the following classes and make sure you name them exactly as following:
MovieController.java
MovieService.java
MovieRepository.java
Movie.java - String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters
Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters

Note:

Use ResponseEntity object to return the required objects in the controllers
Make sure you follow the requirements for the controller very very carefully or your application will give compilation error while running against hidden test cases
Test all the APIs in postman before you submit.


* */