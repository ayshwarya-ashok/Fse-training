package com.cognizant.menuitemservice.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.menuitemservice.model.MyError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("Start");
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("timestamp", new Date());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);
		LOGGER.info("End");
		return new ResponseEntity<>(body, headers, status);

	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("Start");
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("error", "Bad Request");

		if (ex.getCause() instanceof InvalidFormatException) {
			final Throwable cause = ex.getCause() == null ? ex : ex.getCause();
			for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
				body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
			}
		}
		LOGGER.info("End");
		return new ResponseEntity<>(body, headers, status);
	}

	@ExceptionHandler(CartEmptyException.class)
	public final ResponseEntity<MyError> handleUserNotFoundException(CartEmptyException ex, WebRequest request) {
		LOGGER.info("Start");
		MyError errorDetails = new MyError(ex.getCartEmptyMssg(), new Date(), request.getDescription(false));
		LOGGER.info("End");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	
}
