package com.shika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovieById(@PathVariable String movieId) {
		return movieService.getMovieById(movieId);
	}
	
	@PostMapping()
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@PutMapping()
	public Movie updateMovieById(@RequestBody Movie movie) {
		if(movie == null) return movie;
		return movieService.updateMovieById(movie);
	}
	
	@DeleteMapping("/{movieId}")
	public Movie deleteMovie(@PathVariable String movieId) {
		return movieService.deleteMovie(movieId);
	}
}
