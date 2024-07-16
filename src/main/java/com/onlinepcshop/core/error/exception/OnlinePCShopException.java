package com.onlinepcshop.core.error.exception;

import lombok.Getter;

@Getter
public class OnlinePCShopException extends RuntimeException {
    private final String code;
    private final String message;

    public OnlinePCShopException(String c, String m) {
        super(m);
        this.code = c;
        this.message = m;
    }
}
