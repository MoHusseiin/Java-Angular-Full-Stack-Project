package com.shika.service;

import java.util.List;

import com.shika.domain.Movie;

public interface MovieService {

	List<Movie> getAllMovies();
	
	Movie getMovieById(String movieId);

	Movie addMovie(Movie movie);

	Movie updateMovieById(Movie movie);

	Movie deleteMovie(String movieId);
}
