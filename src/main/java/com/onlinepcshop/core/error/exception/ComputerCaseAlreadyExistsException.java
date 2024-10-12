package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerCaseAlreadyExistsException extends OnlinePCShopException {
    public ComputerCaseAlreadyExistsException(String m) {
        super(ErrorCodes.COMPUTER_CASE_ALREADY_EXISTS, m);
    }
}
