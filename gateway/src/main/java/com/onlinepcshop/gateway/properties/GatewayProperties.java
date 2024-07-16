package com.onlinepcshop.gateway.properties;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@ConfigurationProperties(prefix = "online-pc-shop.gateway")
public class GatewayProperties {
    private String backendHost;
}
