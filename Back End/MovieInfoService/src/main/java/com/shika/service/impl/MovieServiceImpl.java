package com.shika.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shika.domain.Movie;
import com.shika.repository.MovieRepository;
import com.shika.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	@Override
	public Movie getMovieById(String movieId) {
		return movieRepository.getMovieById(movieId);
	}

}
