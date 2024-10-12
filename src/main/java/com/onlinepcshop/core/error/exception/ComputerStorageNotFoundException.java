package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class ComputerStorageNotFoundException extends OnlinePCShopException {
    public ComputerStorageNotFoundException(String m) {
        super(ErrorCodes.COMPUTER_STORAGE_NOT_FOUND, m);
    }
}
