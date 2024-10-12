package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class PowerSupplyNotFoundException extends OnlinePCShopException {
    public PowerSupplyNotFoundException(String m) {
        super(ErrorCodes.POWER_SUPPLY_NOT_FOUND, m);
    }
}
