package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CaseFanAlreadyExistsException extends OnlinePCShopException {
    public CaseFanAlreadyExistsException(String m) {
        super(ErrorCodes.CASE_FAN_ALREADY_EXISTS, m);
    }
}
