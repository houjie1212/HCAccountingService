package com.hardcore.accounting.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private HttpStatus statusCode;
    private String message;
    private String code;
    private ServiceException.ErrorType errorType;
}
