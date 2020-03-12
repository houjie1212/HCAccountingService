package com.hardcore.accounting.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ServiceException {

    public ResourceNotFoundException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.NOT_FOUND);
        this.setErrorCode("USER_NOT_FOUND");
        this.setErrorType(ErrorType.Client);
    }
}
