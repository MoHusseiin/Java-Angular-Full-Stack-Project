package com.shika.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.shika.domain.CatalogItem;
import com.shika.domain.Movie;
import com.shika.domain.UserRating;
import com.shika.service.MovieInfoService;
import com.shika.service.UserRatingService;

@CrossOrigin
@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@Autowired
	UserRatingService userRatingService;
	
	@Autowired
	MovieInfoService movieInfoService;
	
	@GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		
//		List<Rating> ratings = Arrays.asList(
//				new Rating("222", 4),
//				new Rating("333", 5)
//		);

		UserRating userRating = userRatingService.getUserRating(userId);
//		UserRating userRating = webClientBuilder.build().get().uri("http://RATINGS-DATA-SERVICE/ratings/user/" + userId).retrieve().bodyToMono(UserRating.class).block();
		
//		RestTemplate restTemplate = new RestTemplate();
		if(userRating.getRatings() == null || userRating.getRatings().isEmpty()) 
			return new ArrayList<CatalogItem>();
		
		return userRating.getRatings().stream().map(rating -> {
			
			Movie movie = movieInfoService.getMovieInfo(rating);
//			Movie movie = webClientBuilder.build().get().uri("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
			
		}).collect(Collectors.toList());
		
	}
}
