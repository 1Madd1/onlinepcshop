package com.onlinepcshop.config;

import com.onlinepcshop.core.repository.*;
import com.onlinepcshop.core.security.SecurityProvider;
import com.onlinepcshop.core.usecase.*;
import com.onlinepcshop.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
//
//    @Bean
//    AgentUseCase agentUseCase(AgentRepository agentRepository, SecurityProvider securityProvider) {
//        return AgentUseCaseImpl.builder()
//                .agentRepository(agentRepository)
//                .securityProvider(securityProvider)
//                .build();
//    }

    @Bean
    UserUseCase userUseCase(UserRepository userRepository, SecurityProvider securityProvider) {
        return UserUseCaseImpl.builder()
                .userRepository(userRepository)
                .securityProvider(securityProvider)
                .build();
    }
}
