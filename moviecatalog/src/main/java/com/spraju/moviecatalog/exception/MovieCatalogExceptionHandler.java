package com.spraju.moviecatalog.exception;

import java.net.SocketTimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spraju.moviecatalog.model.ResponseBody;

@RestControllerAdvice
public class MovieCatalogExceptionHandler {
	
//	@ExceptionHandler(SocketTimeoutException.class)
//	public ResponseEntity<ResponseBody> hanhleTimeout(SocketTimeoutException exp)
//	{
//		ResponseEntity<ResponseBody> responseEntity=new ResponseEntity<>(new ResponseBody(400, "Timeout"),HttpStatus.REQUEST_TIMEOUT);
//		return responseEntity;
//	}
//	
}
