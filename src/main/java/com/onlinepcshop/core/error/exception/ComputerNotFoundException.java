package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerNotFoundException extends OnlinePCShopException {
    public ComputerNotFoundException(String m) {
        super(ErrorCodes.COMPUTER_NOT_FOUND, m);
    }
}
