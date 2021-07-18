package com.spraju.moviecatalog.model;

public class MovieInfo {
	private Integer movieId;
	private String movieName;
	private String movieDesc;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public MovieInfo(Integer movieId, String movieName, String movieDesc) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
	}
	public MovieInfo() {
		
	}
	
	
}
