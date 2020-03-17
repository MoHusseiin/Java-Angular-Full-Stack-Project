package com.shika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shika.domain.Movie;
import com.shika.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public List<Movie> getMovies() {
		System.out.println("get movies");
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovieBy(@PathVariable String movieId) {
		return movieService.getMovieById(movieId);
	}
}
