package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class UserNotFoundException extends OnlinePCShopException{
    public UserNotFoundException(String m) {
        super(ErrorCodes.USER_NOT_FOUND, m);
    }
}
