package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class MotherboardNotFoundException extends OnlinePCShopException {
    public MotherboardNotFoundException(String m) {
        super(ErrorCodes.MOTHERBOARD_NOT_FOUND, m);
    }
}
