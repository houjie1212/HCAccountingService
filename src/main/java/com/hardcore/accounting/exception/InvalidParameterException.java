package com.hardcore.accounting.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends ServiceException {

    /**
     * Invalid Parameter Exception.
     * @param message description for the exception
     */
    public InvalidParameterException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST);
        this.setErrorCode("REQUEST_PARAM_IS_INVALID");
        this.setErrorType(ErrorType.Client);
    }
}
