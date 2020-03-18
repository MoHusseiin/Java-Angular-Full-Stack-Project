package com.shika.repository;

import java.util.List;

import com.shika.domain.Rating;
import com.shika.domain.UserRating;

public interface RatingRepository {

	float getAvgMovieRating(String movieId);

	List<Rating> getUserMoviesRatings(String userId);
	
	UserRating getUserRatings(String userId);

}
