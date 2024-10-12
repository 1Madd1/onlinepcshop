package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class GpuNotFoundException extends OnlinePCShopException {
    public GpuNotFoundException(String m) {
        super(ErrorCodes.GPU_NOT_FOUND, m);
    }
}
