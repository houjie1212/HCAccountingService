package com.hardcore.accounting.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends ServiceException {

    public InvalidParameterException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST);
        this.setErrorCode("Request param is not valid");
        this.setErrorType(ErrorType.Client);
    }
}
