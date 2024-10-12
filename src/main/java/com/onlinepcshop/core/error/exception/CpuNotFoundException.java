package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CpuNotFoundException extends OnlinePCShopException {
    public CpuNotFoundException(String m) {
        super(ErrorCodes.CPU_NOT_FOUND, m);
    }
}
