package com.onlinepcshop.adapters.rest.exceptionhandler;

import com.onlinepcshop.adapters.rest.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ErrorResponse Exception(Exception exception) {
        return ErrorResponse.builder()
                .errorCode("e000")
                .errorMessage(exception.getMessage())
                .build();
    }
}
