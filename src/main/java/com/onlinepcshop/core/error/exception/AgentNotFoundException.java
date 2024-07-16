package com.onlinepcshop.core.error.exception;

import com.onlinepcshop.core.error.ErrorCodes;

public class AgentNotFoundException extends OnlinePCShopException {
    public AgentNotFoundException(String m) {
        super(ErrorCodes.AGENT_NOT_FOUND, m);
    }
}
