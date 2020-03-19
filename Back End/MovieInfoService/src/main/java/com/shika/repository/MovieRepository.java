package com.shika.repository;

import java.util.List;

import com.shika.domain.Movie;

public interface MovieRepository {

	Movie getMovieById(String movieId);

	List<Movie> getAllMovies();

	Movie addMovie(Movie movie);

	Movie updateMovieById(Movie movie);

	Movie deleteMovie(String movieId);

}
