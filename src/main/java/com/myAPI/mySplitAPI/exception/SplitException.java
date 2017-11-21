package com.myAPI.mySplitAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SplitException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

}
