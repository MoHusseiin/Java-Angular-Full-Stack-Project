package com.shika.service;

import java.util.List;

import com.shika.domain.Rating;
import com.shika.domain.UserRating;

public interface RatingService {

	float getAvgMovieRating(String movieId);

	List<Rating> getUserMoviesRatings(String userId);
	
	UserRating getUserRatings(String userId);
}
