package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class PcieInterfaceNotFoundException extends OnlinePCShopException {
    public PcieInterfaceNotFoundException(String m) {
        super(ErrorCodes.PCIE_INTERFACE_NOT_FOUND, m);
    }
}
