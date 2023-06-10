package com.example.ayumuadmin.exception;

import com.example.ayumuadmin.utils.AyumuErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AyumuExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = AyumuException.class)
	public ResponseEntity<Object> handleSunnyAdminException(AyumuException ex) {
		String errorMessage = ex.getMessage();
		String errorCode = ex.getStatusCode();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		if (AyumuErrorCode.INTERNAL_SERVER_ERROR.equals(errorCode)) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(httpStatus).body(new AyumuException(errorCode, errorMessage));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllOtherExceptions(Exception ex) {
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
		if (ex instanceof IllegalArgumentException) {
			httpStatus = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof NullPointerException) {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(httpStatus).body(ex.getMessage());
	}
}
