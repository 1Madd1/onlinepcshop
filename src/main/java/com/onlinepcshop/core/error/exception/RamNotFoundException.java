package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class RamNotFoundException extends OnlinePCShopException {
    public RamNotFoundException(String m) {
        super(ErrorCodes.RAM_NOT_FOUND, m);
    }
}
