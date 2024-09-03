package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class StorageInterfaceNotFoundException extends OnlinePCShopException {
    public StorageInterfaceNotFoundException(String m) {
        super(ErrorCodes.STORAGE_INTERFACE_NOT_FOUND, m);
    }
}
