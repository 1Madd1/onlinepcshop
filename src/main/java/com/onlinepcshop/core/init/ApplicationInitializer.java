package com.onlinepcshop.core.init;

import com.onlinepcshop.core.security.SecurityProvider;
import jakarta.annotation.PostConstruct;
import lombok.Builder;

@Builder
public class ApplicationInitializer {
    private SecurityProvider securityProvider;

    @PostConstruct
    public void initialize() {
        securityProvider.initialize();
    }
}
