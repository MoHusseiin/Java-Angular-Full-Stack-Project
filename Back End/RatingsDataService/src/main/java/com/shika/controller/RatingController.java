package com.shika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shika.domain.UserRating;
import com.shika.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/movies")
	public float getMovies(@RequestParam(name = "movieId") String movieId) {
		return ratingService.getAvgMovieRating(movieId);
	}
	
	@GetMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        return ratingService.getUserRatings(userId);

    }
}
