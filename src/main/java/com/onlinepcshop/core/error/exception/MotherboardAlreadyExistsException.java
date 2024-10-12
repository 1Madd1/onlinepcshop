package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class MotherboardAlreadyExistsException extends OnlinePCShopException {
    public MotherboardAlreadyExistsException(String m) {
        super(ErrorCodes.MOTHERBOARD_ALREADY_EXISTS, m);
    }
}
