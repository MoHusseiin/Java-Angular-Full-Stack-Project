package com.shika.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shika.domain.Rating;
import com.shika.domain.UserRating;
import com.shika.service.UserRatingService;

@Service
public class userRatingServiceImpl implements UserRatingService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackUserRating", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
	})
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratings/user/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("000", 0));
		return new UserRating("0", ratings);
	}
}
