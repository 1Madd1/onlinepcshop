package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class StorageNotAssignedException extends OnlinePCShopException {
    public StorageNotAssignedException(String m) {
        super(ErrorCodes.STORAGE_NOT_ASSIGNED, m);
    }
}
