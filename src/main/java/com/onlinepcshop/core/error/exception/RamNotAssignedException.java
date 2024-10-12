package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class RamNotAssignedException extends OnlinePCShopException {
    public RamNotAssignedException(String m) {
        super(ErrorCodes.RAM_NOT_ASSIGNED, m);
    }
}
