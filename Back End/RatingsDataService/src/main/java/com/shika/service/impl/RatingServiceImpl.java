package com.shika.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shika.domain.Rating;
import com.shika.domain.UserRating;
import com.shika.repository.RatingRepository;
import com.shika.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public float getAvgMovieRating(String movieId) {
		return ratingRepository.getAvgMovieRating(movieId);
	}

	@Override
	public List<Rating> getUserMoviesRatings(String userId) {
		return ratingRepository.getUserMoviesRatings(userId);
	}

	@Override
	public UserRating getUserRatings(String userId) {
		return ratingRepository.getUserRatings(userId);
	}
	
}
