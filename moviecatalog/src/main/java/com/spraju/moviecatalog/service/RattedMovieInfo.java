package com.spraju.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spraju.moviecatalog.model.MovieInfo;
import com.spraju.moviecatalog.model.MovieRatting;

@Service
public class RattedMovieInfo {
	@Autowired
	RestTemplate restTemplate;
	
	   @HystrixCommand(fallbackMethod = "getFallBackRattedMoviesInfo", commandProperties = {
			   @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
			   @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
			   @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
			   @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
	   })
		public MovieInfo getRattedMovieInfo(MovieRatting userMovie) {
			return restTemplate.getForObject("http://movieinfo/movieInfo/"+userMovie.getMovieId(),MovieInfo.class);
		}
		public MovieInfo getFallBackRattedMoviesInfo(MovieRatting userMovie) {
			return new MovieInfo(0, "nill", "nill");
		}
}
