package com.onlinepcshop.adapters.security.keycloak.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialsDto {

    private String value;
    private boolean temporary;
}
