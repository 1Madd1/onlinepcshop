package com.onlinepcshop.config;

import com.onlinepcshop.core.init.ApplicationInitializer;
import com.onlinepcshop.core.security.SecurityProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiscConfig {

    @Bean
    ApplicationInitializer applicationInitializer(SecurityProvider securityProvider) {
        return ApplicationInitializer.builder()
                .securityProvider(securityProvider)
                .build();
    }
}
