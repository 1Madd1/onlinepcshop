package com.onlinepcshop.adapters.security.keycloak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalUpdateRequestDto {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
    private Map<String, List<String>> clientRoles;
}
