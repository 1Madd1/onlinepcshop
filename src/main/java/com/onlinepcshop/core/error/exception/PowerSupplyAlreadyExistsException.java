package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class PowerSupplyAlreadyExistsException extends OnlinePCShopException {
    public PowerSupplyAlreadyExistsException(String m) {
        super(ErrorCodes.POWER_SUPPLY_ALREADY_EXISTS, m);
    }
}
