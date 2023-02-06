package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }


    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void createMovieDirectorPair(String movie, String director) {

        if(movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            List<String> currentMovies = new ArrayList<String>();
            if(directorMovieMap.containsKey(director)) {
                currentMovies = directorMovieMap.get(director);
            }
            // if director name is not present in the map then we have to add
            // all movies of that director in currentMovies list
            // and also in the directorMovieMap
            currentMovies.add(movie);
            directorMovieMap.put(director, currentMovies);
        }

    }

    public Movie getMovieByName(String movieName) {
        return movieMap.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> moviesList = new ArrayList<String>();

        if(directorMovieMap.containsKey(director))
            moviesList = directorMovieMap.get(director);

        return moviesList;

        //return directorMovieMap.get(director);
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director) {
        // we have to remove the director from both maps
        // directorMap and directorMovieMap and also movie from movieMap

        List<String> movies = new ArrayList<String>();

        if(directorMovieMap.containsKey(director)) {
            movies = directorMovieMap.get(director);
            for(String movie : movies) {
                if(movieMap.containsKey(movie))
                    movieMap.remove(movie);
            }
            directorMovieMap.remove(director);
        }
        if(directorMap.containsKey(director)) {
            directorMap.remove(director);
        }
    }

    public void deleteAllDirectors() {
        HashSet<String> movieSet = new HashSet<>();

        for(String director : directorMovieMap.keySet()) {
            for(String movie : directorMovieMap.get(director)) {
                movieSet.add(movie);
            }
        }

        for(String movie : movieSet) {
            if(movieMap.containsKey(movie)) {
                movieMap.remove(movie);
            }
        }

    }
}













