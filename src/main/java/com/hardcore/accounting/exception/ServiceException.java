package com.hardcore.accounting.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceException extends RuntimeException {
    private HttpStatus statusCode;
    private String errorCode; // biz error code
    private ErrorType errorType; // Service, Client, Unknown

    public enum ErrorType {
        Client,
        Service,
        Unknown;
    }

    public ServiceException(String message) {
        super(message);
    }
}
