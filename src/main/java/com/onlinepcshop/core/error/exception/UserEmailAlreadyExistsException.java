package com.onlinepcshop.core.error.exception;


import com.onlinepcshop.core.error.ErrorCodes;

public class UserEmailAlreadyExistsException extends OnlinePCShopException {
    public UserEmailAlreadyExistsException(String m) {
        super(ErrorCodes.USER_EMAIL_ALREADY_EXISTS, m);
    }
}
