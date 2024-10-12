package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerCaseFanNotFoundException extends OnlinePCShopException {
    public ComputerCaseFanNotFoundException(String m) {
        super(ErrorCodes.COMPUTER_CASE_FAN_NOT_FOUND, m);
    }
}
