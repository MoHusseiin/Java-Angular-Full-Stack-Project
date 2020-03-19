package com.shika.data;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shika.domain.Movie;
import com.shika.error.MovieNotFoundException;

@Component
public class Database {
	
	private final ConcurrentHashMap<String, Movie> movies = new ConcurrentHashMap<>();
	
	{
		movies.put("111", new Movie("111", "The Lighthouse", "The allure of the light drives two men into pitch-black madness in Robert Eggers’ The Lighthouse."));
		movies.put("222", new Movie("222", "Marriage Story", "Divorce is a cataclysm that destroys the past, present and future"));
		movies.put("333", new Movie("333", "The Irishman", "Reuniting him with his favorite stars for Al Pacino."));
		movies.put("444", new Movie("444", "Joker", "DescriptionForever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City"));
		movies.put("555", new Movie("555", "Jumanji 2", "DescriptionWhen Spencer goes back into the fantastical world of Jumanji, pals Martha."));
	}
	
	public List<Movie> getAllMovies() {
		return movies.values().stream().sorted(Comparator.comparing(Movie::getName).reversed()).collect(Collectors.toList());
	}
	
	public Movie getMovieById(String movieId) {
		if(!movies.containsKey(movieId)) throw new MovieNotFoundException(movieId);
		return movies.get(movieId);
	}

	public Movie addMovie(Movie movie) {
		String movieId = String.valueOf(movie.hashCode());
		movie.setMovieId(movieId);
		movies.put(movieId, movie);
		return movie;
	}

	public Movie updateMovieById(Movie movie) {
		if(!movies.containsKey(movie.getMovieId()))
			throw new MovieNotFoundException(movie.getMovieId());
		movies.put(movie.getMovieId(), movie);
		return movie;
	}

	public Movie deleteMovie(String movieId) {
		if(!movies.containsKey(movieId)) throw new MovieNotFoundException(movieId);
		return	movies.remove(movieId);
	}
}
