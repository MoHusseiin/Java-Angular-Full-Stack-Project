package com.shika.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shika.domain.Movie;
import com.shika.domain.Rating;
import com.shika.service.MovieInfoService;

@Service
public class MovieInfoServiceImpl implements MovieInfoService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackMovieInfo", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
	})
	public Movie getMovieInfo(Rating rating) {
		return restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
	}

	public Movie getFallbackMovieInfo(Rating rating) {
		return new Movie("0", "No Movie", "No Description");
	}
	
}
