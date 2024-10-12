package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CaseFanNotFoundException extends OnlinePCShopException {
    public CaseFanNotFoundException(String m) {
        super(ErrorCodes.CASE_FAN_NOT_FOUND, m);
    }
}
