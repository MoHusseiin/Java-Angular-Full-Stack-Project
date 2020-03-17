package com.shika.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shika.domain.CatalogItem;
import com.shika.domain.Movie;
import com.shika.domain.Rating;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("222", 4),
				new Rating("333", 5)
		);
		
//		RestTemplate restTemplate = new RestTemplate();
		return ratings.stream().map(rating -> {
			
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
			
		}).collect(Collectors.toList());
		
	}
}
