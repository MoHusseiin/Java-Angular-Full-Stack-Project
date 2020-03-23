package com.shika.service;

import com.shika.domain.Movie;
import com.shika.domain.Rating;

public interface MovieInfoService {

	Movie getMovieInfo(Rating rating);

}
