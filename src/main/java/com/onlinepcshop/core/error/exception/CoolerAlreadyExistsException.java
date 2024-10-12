package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CoolerAlreadyExistsException extends OnlinePCShopException {
    public CoolerAlreadyExistsException(String m) {
        super(ErrorCodes.COOLER_ALREADY_EXISTS, m);
    }
}
