package com.onlinepcshop.adapters.rest.exceptionhandler;

import com.onlinepcshop.adapters.rest.dto.response.ErrorResponse;
import com.onlinepcshop.core.error.exception.AgentNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AgentExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AgentNotFoundException.class)
    public ErrorResponse handleAgentNotFoundException(AgentNotFoundException exception) {
        return ErrorResponse.getInstance(exception);
    }
}
