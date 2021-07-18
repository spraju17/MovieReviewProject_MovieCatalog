package com.spraju.moviecatalog.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spraju.moviecatalog.model.MovieCatalog;
import com.spraju.moviecatalog.model.MovieInfo;
import com.spraju.moviecatalog.model.MovieRatting;
import com.spraju.moviecatalog.service.RattedMovieInfo;
import com.spraju.moviecatalog.service.RattedMovies;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RattedMovies rattedMovies;
	
	@Autowired
	RattedMovieInfo rattedMovieInfo;
	
	
	@GetMapping("/{UserId}")
	//@HystrixCommand(fallbackMethod = "getFallBackCatalog")
	public List<MovieCatalog> getMovieCatalog(@PathVariable Integer UserId){
		System.out.println("hitted");
		//MovieRattingInfo
		var url="http://movieratting/ratting";
		
		//ResponseEntity<MovieRatting[]> movieRattings = getRattedMovies(url);
		
		ResponseEntity<MovieRatting[]> movieRattings = rattedMovies.getRattedMovies(url);
		
//		return Arrays.asList(movieRattings.getBody()).stream().filter(movie->movie.getUserId()==UserId).map(
//				userMovie->{MovieInfo movieInfo=getRattedMovieInfo(userMovie);
//				             return new MovieCatalog(movieInfo.getMovieName(), movieInfo.getMovieDesc(), userMovie.getMovieRatting());}).collect(Collectors.toList());	
		
		return Arrays.asList(movieRattings.getBody()).stream().filter(movie->movie.getUserId()==UserId).map(
				userMovie->{MovieInfo movieInfo=rattedMovieInfo.getRattedMovieInfo(userMovie);
				             return new MovieCatalog(movieInfo.getMovieName(), movieInfo.getMovieDesc(), userMovie.getMovieRatting());}).collect(Collectors.toList());		
	}
//	@HystrixCommand(fallbackMethod = "getFallBackRattedMoviesInfo")
//	private MovieInfo getRattedMovieInfo(MovieRatting userMovie) {
//		return restTemplate.getForObject("http://movieinfo/movieInfo/"+userMovie.getMovieId(),MovieInfo.class);
//	}
//	private MovieInfo getFallBackRattedMoviesInfo(MovieRatting userMovie) {
//		return new MovieInfo(0, "nill", "nill");
//	}
//	@HystrixCommand(fallbackMethod = "getFallBackRattedMovies")
//	private ResponseEntity<MovieRatting[]> getRattedMovies(String url) {
//		ResponseEntity<MovieRatting[]> movieRattings=restTemplate.getForEntity(url, MovieRatting[].class);
//		return movieRattings;
//	}
//	private ResponseEntity<MovieRatting[]> getFallBackRattedMovies(String url) {
//		MovieRatting rattedMovies[] = new MovieRatting[1];
//		rattedMovies[0]=new MovieRatting(0, 0, 0);
//		ResponseEntity<MovieRatting[]> movieRattings=new ResponseEntity<>(rattedMovies,HttpStatus.BAD_REQUEST);
//		return movieRattings;
//	}
	
	//main hystrix fallback
	
//	public List<MovieCatalog> getFallBackCatalog(@PathVariable Integer UserId){
//		return Collections.singletonList(new MovieCatalog("no movies fetched", "no desc available", 0));
//	}

}
