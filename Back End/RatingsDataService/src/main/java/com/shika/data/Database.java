package com.shika.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shika.domain.Rating;
import com.shika.domain.UserRating;

@Component
public class Database {
	
	private final ConcurrentHashMap<String, UserRating> userRatings = new ConcurrentHashMap<>();
	
	{
		List<Rating> ratings1 = new ArrayList<Rating>();
		ratings1.add(new Rating("222", 4));
		ratings1.add(new Rating("333", 4));
		ratings1.add(new Rating("444", 5));
		List<Rating> ratings2 = new ArrayList<Rating>();
		ratings2.add(new Rating("111", 5));
		ratings2.add(new Rating("333", 4));
		ratings2.add(new Rating("444", 5));
		ratings2.add(new Rating("222", 3));
		ratings2.add(new Rating("555", 3));
		userRatings.put("2020", new UserRating("2020", ratings1));
		userRatings.put("1919", new UserRating("1919", ratings2));
		userRatings.put("2121", new UserRating("2121", ratings1));
		
	}
	
	public float getAvgMovieRating(String movieId) {
		List<UserRating> userRating = userRatings.values().stream().collect(Collectors.toList());
		float sum = 0.0f;
		int count = 0;
		for (UserRating userRating2 : userRating) {
			List<Rating> ratings = userRating2.getRatings();
			for (Rating rating : ratings) {
				if (rating.getMovieId().equals(movieId)) {
					sum += rating.getRating();
					count++;
				}
			}
		}
		return (float) (Math.round((sum / count) * 100.0) / 100.0);
	}
	
	public UserRating getRatingByUserId(String userId) {
		return new UserRating(userId, userRatings.get(userId).getRatings());
	}
	
	
	public List<Rating> getUserRatings(String userId) {
		return userRatings.get(userId).getRatings();
	}
}
