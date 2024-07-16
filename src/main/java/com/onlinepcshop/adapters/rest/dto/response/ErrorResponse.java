package com.onlinepcshop.adapters.rest.dto.response;

import com.onlinepcshop.core.error.exception.OnlinePCShopException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;

    public static ErrorResponse getInstance(OnlinePCShopException exception) {
        return ErrorResponse.builder()
                .errorCode(exception.getCode())
                .errorMessage(exception.getMessage())
                .build();
    }
}