package com.myAPI.mySplitAPI.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class SplitExceptionHandler {

	@ExceptionHandler(value = SplitException.class)
	public SplitExceptionBody handleSplitException(SplitException e) {
		log.error("Error Occurred: {}", e.getErrorMessage());
		return new SplitExceptionBody(e.getErrorCode(), e.getErrorMessage());

	}

}
