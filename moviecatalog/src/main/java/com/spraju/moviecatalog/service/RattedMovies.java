package com.spraju.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spraju.moviecatalog.model.MovieRatting;

@Service
public class RattedMovies {
	@Autowired
	RestTemplate restTemplate;
	
	
	    @HystrixCommand(fallbackMethod = "getFallBackRattedMovies" ,commandProperties = {
				   @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
				   @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
				   @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
				   @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
		   })
		public ResponseEntity<MovieRatting[]> getRattedMovies(String url) {
			ResponseEntity<MovieRatting[]> movieRattings=restTemplate.getForEntity(url, MovieRatting[].class);
			return movieRattings;
		}
		public ResponseEntity<MovieRatting[]> getFallBackRattedMovies(String url) {
			MovieRatting rattedMovies[] = new MovieRatting[1];
			rattedMovies[0]=new MovieRatting(0, 0, 0);
			ResponseEntity<MovieRatting[]> movieRattings=new ResponseEntity<>(rattedMovies,HttpStatus.BAD_REQUEST);
			return movieRattings;
		}
}
