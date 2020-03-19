package com.shika.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shika.data.Database;
import com.shika.domain.Movie;
import com.shika.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@Autowired
	Database movieDatabase;
	
	@Override
	public Movie getMovieById(String movieId) {
		return movieDatabase.getMovieById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieDatabase.getAllMovies();
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieDatabase.addMovie(movie);
	}

	@Override
	public Movie updateMovieById(Movie movie) {
		return movieDatabase.updateMovieById(movie);
	}

	@Override
	public Movie deleteMovie(String movieId) {
		return movieDatabase.deleteMovie(movieId);
	}

}
