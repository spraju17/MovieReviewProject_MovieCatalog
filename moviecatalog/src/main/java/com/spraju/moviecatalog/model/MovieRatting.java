package com.spraju.moviecatalog.model;

public class MovieRatting {
	private Integer userId;
	private Integer movieId;
	private Integer movieRatting;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getMovieRatting() {
		return movieRatting;
	}
	public void setMovieRatting(Integer movieRatting) {
		this.movieRatting = movieRatting;
	}
	public MovieRatting(Integer userId, Integer movieId, Integer movieRatting) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.movieRatting = movieRatting;
	}
	public MovieRatting() {
		
	}
}
