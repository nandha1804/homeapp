package com.Productimage.handling;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Productimage.exception.Productnotfoundexception;


@RestControllerAdvice
public class Exceptionhandling {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Productnotfoundexception.class)
	public String handleexception(Productnotfoundexception ex)
	{
//		Map<String, String> errm=new HashMap<>();
//		errm.put("errorMessage", ex.getMessage());
		return ex.getMessage();
	}

}
