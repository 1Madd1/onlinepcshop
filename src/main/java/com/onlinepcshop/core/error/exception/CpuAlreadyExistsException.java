package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CpuAlreadyExistsException extends OnlinePCShopException {
    public CpuAlreadyExistsException(String m) {
        super(ErrorCodes.CPU_ALREADY_EXISTS, m);
    }
}
