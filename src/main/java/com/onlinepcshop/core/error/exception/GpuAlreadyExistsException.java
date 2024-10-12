package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class GpuAlreadyExistsException extends OnlinePCShopException {
    public GpuAlreadyExistsException(String m) {
        super(ErrorCodes.GPU_ALREADY_EXISTS, m);
    }
}
