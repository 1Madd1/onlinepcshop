package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class PcieInterfaceNotAssignedException extends OnlinePCShopException {
    public PcieInterfaceNotAssignedException(String m) {
        super(ErrorCodes.PCIE_INTERFACE_NOT_ASSIGNED, m);
    }
}
