package com.shika.error;

public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(String movieId) {
		super("Movie Id "+movieId+" Not Found.");
	}
}
