package com.onlinepcshop.adapters.security.keycloak;


import com.onlinepcshop.adapters.security.keycloak.dto.*;
import com.onlinepcshop.adapters.security.keycloak.mapper.PrincipalMapper;
import com.onlinepcshop.core.domain.entity.User;
import com.onlinepcshop.core.error.exception.UserEmailAlreadyExistsException;
import com.onlinepcshop.core.security.Role;
import com.onlinepcshop.core.security.SecurityProvider;
import lombok.Builder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Builder
public class KeycloakSecurityProvider implements SecurityProvider {

    private KeycloakSecurityProperties properties;
    private String authToken;
    private String clientId;

    @Override
    public void initialize() {
        obtainClientId();
        if (getPrincipalCount() == 0) {
            String adminId = createDefaultAdmin();
            assignRoles(adminId, Role.ADMIN);
        }
    }

//    @Override
//    public String createPrincipal(Operator operator) {
//        PrincipalDto principal = PrincipalMapper.INSTANCE.operatorToPrincipal(operator);
//        principal.setCredentials(
//                List.of(CredentialsDto.builder().value("admin").temporary(false).build()));
//        return createPrincipal(principal);
//    }

    @Override
    public void assignRoles(String principalId, Role... roles) {
        String url = properties
                .getAssignClientRoleUrl()
                .replace("{userId}", principalId)
                .replace("{clientId}", this.clientId);
        WebClient client = WebClient.create(url);
        List<RoleRepresentationDto> availableRoles = Arrays.asList(getAvailableRolesForPrincipal(principalId));
        List<RoleRepresentationDto> rolesRepresentations = availableRoles.stream()
                .filter(r -> Stream.of(roles).map(Role::getName).toList().contains(r.getName()))
                .toList();
        client.post()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(BodyInserters.fromValue(rolesRepresentations))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public String createPrincipal(User user) {
        PrincipalDto principal = PrincipalMapper.INSTANCE.userToPrincipal(user);
        principal.setCredentials(
                List.of(CredentialsDto.builder().value(user.getPassword()).temporary(false).build()));
        return createPrincipal(principal);
    }

    @Override
    public void authorize() {
        WebClient client = WebClient.create(properties.getAuthorizeUrl());
        AdminAccessTokenResponseBody accessTokenResponse = client.post()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("username", properties.getUsername())
                        .with("password", properties.getPassword())
                        .with("client_id", properties.getAdminClientName())
                        .with("grant_type", properties.getGrantType()))
                .retrieve()
                .bodyToMono(AdminAccessTokenResponseBody.class)
                .block();
        authToken = accessTokenResponse.getAccessToken();
    }

    public String getAuthToken() {
        return authToken;
    }

    private void obtainClientId() {
        authorize();
        String url = properties.getGetClientIdUrl().replace("{client}", properties.getFrontendClientName());
        WebClient client = WebClient.create(url);
        ClientDataDto[] responseBody = client.get()
                .header("Authorization", "Bearer " + authToken)
                .retrieve()
                .bodyToMono(ClientDataDto[].class)
                .block();
        clientId = responseBody[0].getId();
    }

    private String createDefaultAdmin() {
        PrincipalDto principal = PrincipalDto.builder()
                .username(properties.getDefaultAdminUsername())
                .enabled(true)
                .credentials(List.of(CredentialsDto.builder()
                        .value(properties.getDefaultAdminPassword())
                        .temporary(false)
                        .build()))
                .build();
        return createPrincipal(principal);
    }

    private String createPrincipal(PrincipalDto principal) {
        authorize();
        WebClient client = WebClient.create(properties.getCreatePrincipalUrl());
        ResponseEntity<Void> response;
        try {
            response = client.post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + authToken)
                    .body(BodyInserters.fromValue(principal))
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (Exception e) {
            throw new UserEmailAlreadyExistsException("User with email " + principal.getEmail() + " already exists");
        }

        String path = response.getHeaders().getLocation().getRawPath();
        return path.split("/")[path.split("/").length - 1];
    }

    @Override
    public void updatePrincipal(String principalId, String newEmail) {
        authorize();
        PrincipalUpdateRequestDto principal = PrincipalUpdateRequestDto.builder().username(newEmail).email(newEmail).enabled(true).build();
        String url = properties.getUpdatePrincipalUrl().replace("{id}", principalId);
        WebClient client = WebClient.create(url);
        client.put()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(BodyInserters.fromValue(principal))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void changePassword(String principalId, String newPassword) {
        authorize();
        CredentialsDto credentialsDto =
                CredentialsDto.builder().value(newPassword).temporary(false).build();
        PrincipalDto principal = PrincipalDto.builder()
                .credentials(List.of(credentialsDto))
                .enabled(true)
                .build();
        String url = properties.getUpdatePrincipalUrl().replace("{id}", principalId);
        WebClient client = WebClient.create(url);
        client.put()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(BodyInserters.fromValue(principal))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void deletePrincipal(String principalId) {
        authorize();
        String url = properties.getDeletePrincipalUrl().replace("{id}", principalId);
        WebClient client = WebClient.create(url);
        client.delete()
                .header("Authorization", "Bearer " + authToken)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public Integer getPrincipalCount() {
        WebClient client = WebClient.create(properties.getGetPrincipalCountUrl());
        return client.get()
                .header("Authorization", "Bearer " + authToken)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
    }

    private RoleRepresentationDto[] getAvailableRolesForPrincipal(String principalId) {
        String url = properties
                .getGetAvailableRolesUrl()
                .replace("{clientId}", this.clientId)
                .replace("{userId}", principalId);
        WebClient client = WebClient.create(url);
        return client.get()
                .header("Authorization", "Bearer " + authToken)
                .retrieve()
                .bodyToMono(RoleRepresentationDto[].class)
                .block();
    }
}
