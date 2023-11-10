package com.example.demo;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.core.utilities.exceptions.BusinessException;
import com.example.demo.core.utilities.exceptions.ProblemDetails;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.Value;
@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	
	//disables ınternal_server_error response message.activate in production
	/*
	 * @ExceptionHandler
	 * 
	 * @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) public String
	 * ignoreExcepitonMessage(Exception exception) { RuntimeException
	 * runtimeException = new
	 * RuntimeException("Error occured.Consult to your assistant."); return
	 * runtimeException.getMessage(); }
	 */
	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}