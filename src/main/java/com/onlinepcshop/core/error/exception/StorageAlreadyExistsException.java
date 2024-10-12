package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class StorageAlreadyExistsException extends OnlinePCShopException {
    public StorageAlreadyExistsException(String m) {
        super(ErrorCodes.STORAGE_ALREADY_EXISTS, m);
    }
}
