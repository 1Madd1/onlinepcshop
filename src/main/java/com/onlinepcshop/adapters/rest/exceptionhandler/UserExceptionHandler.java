package com.onlinepcshop.adapters.rest.exceptionhandler;

import com.onlinepcshop.adapters.rest.dto.response.ErrorResponse;
import com.onlinepcshop.core.error.exception.UserEmailAlreadyExistsException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserEmailAlreadyExistsException.class)
    public ErrorResponse handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException exception) {
        return ErrorResponse.getInstance(exception);
    }
}
