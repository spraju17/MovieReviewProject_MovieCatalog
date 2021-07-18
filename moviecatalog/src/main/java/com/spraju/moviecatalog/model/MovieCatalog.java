package com.spraju.moviecatalog.model;


public class MovieCatalog {
	private String movieName;
	private String movieDesc;  
	private Integer movieRattingGiven;
	public MovieCatalog(String movieName, String movieDesc, Integer movieRattingGiven) {
		super();
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.movieRattingGiven = movieRattingGiven;
	}
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
	public Integer getMovieRattingGiven() {
		return movieRattingGiven;
	}
	public void setMovieRattingGiven(Integer movieRattingGiven) {
		this.movieRattingGiven = movieRattingGiven;
	}  
}
