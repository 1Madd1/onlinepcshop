package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class StorageNotFoundException extends OnlinePCShopException {
    public StorageNotFoundException(String m) {
        super(ErrorCodes.STORAGE_NOT_FOUND, m);
    }
}
