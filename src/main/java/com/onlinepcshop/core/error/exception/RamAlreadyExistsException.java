package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class RamAlreadyExistsException extends OnlinePCShopException {
    public RamAlreadyExistsException(String m) {
        super(ErrorCodes.RAM_ALREADY_EXISTS, m);
    }
}
