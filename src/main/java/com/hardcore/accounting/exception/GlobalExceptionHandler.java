package com.hardcore.accounting.exception;

import lombok.val;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    ResponseEntity<?> handleServiceException(ServiceException ex) {
        val errorResponse = ErrorResponse.builder()
                .statusCode(ex.getStatusCode().value())
                .message(ex.getMessage())
                .code(ex.getErrorCode())
                .errorType(ex.getErrorType())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    ResponseEntity<?> handleIncorrectCredentialsException(IncorrectCredentialsException ex) {
        val errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .code("INCORRECT_CREDENTIALS")
                .errorType(ServiceException.ErrorType.Client)
                .build();
        return ResponseEntity.status(errorResponse.getStatusCode()).body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        val errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .code("Bad_Request")
                .errorType(ServiceException.ErrorType.Client)
                .build();
        return ResponseEntity.status(errorResponse.getStatusCode()).body(errorResponse);
    }
}
