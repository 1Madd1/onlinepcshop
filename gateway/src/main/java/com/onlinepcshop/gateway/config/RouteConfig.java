package com.onlinepcshop.gateway.config;

import com.onlinepcshop.gateway.properties.GatewayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, GatewayProperties props) {
        return builder.routes()
                .route("backend_service", p -> p.path(
                                "/case-fan/**",
                                "/user/**",
                                "/cpu/**",
                                "/cooler/**",
                                "/computer-case/**",
                                "/gpu/**",
                                "/motherboard/**",
                                "/pcie-interface/**",
                                "/power-supply/**",
                                "/ram/**",
                                "/storage/**",
                                "/storage-interface/**")
                        .filters(f -> f.prefixPath("/backend_service"))
                        .uri("http://" + props.getBackendHost() + "/"))
                .build();
    }
}
