package com.shika.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shika.data.Database;
import com.shika.domain.Rating;
import com.shika.repository.RatingRepository;

@Repository
public class RatingRepositoryImpl implements RatingRepository{

	@Autowired
	Database ratingsDatabase;

	@Override
	public float getAvgMovieRating(String movieId) {
		return ratingsDatabase.getAvgMovieRating(movieId);
	}

	@Override
	public List<Rating> getUserRatings(String userId) {
		return ratingsDatabase.getRatingByUserId(userId);
	}

}
