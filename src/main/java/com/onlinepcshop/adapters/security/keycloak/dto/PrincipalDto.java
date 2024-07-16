package com.onlinepcshop.adapters.security.keycloak.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class PrincipalDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<CredentialsDto> credentials;
    private boolean enabled;
    private Map<String, List<String>> clientRoles;
}
