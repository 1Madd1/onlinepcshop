package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CoolerNotFoundException extends OnlinePCShopException {
    public CoolerNotFoundException(String m) {
        super(ErrorCodes.COOLER_NOT_FOUND, m);
    }
}
