package com.shika.service;

import java.util.List;

import com.shika.domain.Rating;

public interface RatingService {

	float getAvgMovieRating(String movieId);

	List<Rating> getUserRatings(String userId);

}
