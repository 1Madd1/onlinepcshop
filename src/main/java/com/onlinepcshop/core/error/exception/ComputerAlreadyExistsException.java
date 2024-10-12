package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerAlreadyExistsException extends OnlinePCShopException {
    public ComputerAlreadyExistsException(String m) {
        super(ErrorCodes.COMPUTER_ALREADY_EXISTS, m);
    }
}
