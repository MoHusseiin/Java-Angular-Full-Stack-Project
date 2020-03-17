package com.shika.data;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shika.domain.Movie;

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
		return movies.values().stream().collect(Collectors.toList());
	}
	
	public Movie getMovieById(String movieId) {
		return movies.get(movieId);
	}
}
