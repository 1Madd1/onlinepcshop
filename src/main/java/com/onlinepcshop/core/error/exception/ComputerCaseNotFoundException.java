package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerCaseNotFoundException extends OnlinePCShopException {
    public ComputerCaseNotFoundException(String m) {
        super(ErrorCodes.COMPUTER_CASE_NOT_FOUND, m);
    }
}
