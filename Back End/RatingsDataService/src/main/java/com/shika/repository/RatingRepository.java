package com.shika.repository;

import java.util.List;

import com.shika.domain.Rating;

public interface RatingRepository {

	float getAvgMovieRating(String movieId);

	List<Rating> getUserRatings(String userId);

}
