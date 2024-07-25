package com.onlinepcshop.config;


import com.onlinepcshop.adapters.persistance.repository.*;
import com.onlinepcshop.adapters.persistance.repository.jpa.*;
//import com.onlinepcshop.adapters.persistance.repository.paging.VlasnikPagingAndSortingRepository;
import com.onlinepcshop.core.repository.*;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
//    @Bean
//    PosebniDeoRepository posebniDeoRepository(PosebniDeoJpaRepository posebniDeoJpaRepository,
//            PosebniDeoPagingAndSortingRepository posebniDeoPagingAndSortingRepository,
//            JPAStreamer jpaStreamer){
//        return PosebniDeoRepositoryImpl.builder()
//                .posebniDeoJpaRepository(posebniDeoJpaRepository)
//                .posebniDeoPagingAndSortingRepository(posebniDeoPagingAndSortingRepository)
//                .jpaStreamer(jpaStreamer)
//                .build();
//    }
//    @Bean
//    AgentRepository agentRepository(AgentJpaRepository agentJpaRepository) {
//        return AgentRepositoryImpl.builder()
//                .agentJpaRepository(agentJpaRepository)
//                .build();
//    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return UserRepositoryImpl.builder()
                .userJpaRepository(userJpaRepository)
                .build();
    }

//    @Bean
//    VlasnikRepository vlasnikRepository(VlasnikJpaRepository vlasnikJpaRepository,
//                                        VlasnikPagingAndSortingRepository vlasnikPagingAndSortingRepository,
//                                        JPAStreamer jpaStreamer) {
//        return VlasnikRepositoryImpl.builder()
//                .vlasnikJpaRepository(vlasnikJpaRepository)
//                .vlasnikPagingAndSortingRepository(vlasnikPagingAndSortingRepository)
//                .jpaStreamer(jpaStreamer)
//                .build();
//    }
}
