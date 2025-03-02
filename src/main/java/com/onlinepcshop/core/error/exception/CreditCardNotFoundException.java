package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class CreditCardNotFoundException extends OnlinePCShopException {
    public CreditCardNotFoundException(String m) {
        super(ErrorCodes.CREDIT_CARD_NOT_FOUND, m);
    }
}
