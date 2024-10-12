package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerRamNotFoundException extends OnlinePCShopException {
    public ComputerRamNotFoundException(String m) {
        super(ErrorCodes.COMPUTER_RAM_NOT_FOUND, m);
    }
}
