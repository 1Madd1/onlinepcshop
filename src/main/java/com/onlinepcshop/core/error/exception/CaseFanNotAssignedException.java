package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CaseFanNotAssignedException extends OnlinePCShopException {
    public CaseFanNotAssignedException(String m) {
        super(ErrorCodes.CASE_FAN_NOT_ASSIGNED, m);
    }
}
