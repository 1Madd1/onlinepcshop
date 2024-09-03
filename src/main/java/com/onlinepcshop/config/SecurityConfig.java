package com.onlinepcshop.config;


import com.onlinepcshop.adapters.security.keycloak.KeycloakJwtRolesConverter;
import com.onlinepcshop.adapters.security.keycloak.KeycloakSecurityProperties;
import com.onlinepcshop.adapters.security.keycloak.KeycloakSecurityProvider;
import com.onlinepcshop.core.security.SecurityProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManagers;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, KeycloakJwtRolesConverter jwtRolesConverter)
            throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Allow everyone to access /user/register
                        .requestMatchers(HttpMethod.POST, "/user/register").permitAll()

                        // Allow public access to /test/** endpoints
                        .requestMatchers("/test/**").permitAll()

                        // Secure /operator/** GET requests for ADMIN role with SCOPE_all authority
                        .requestMatchers(HttpMethod.GET, "/operator/**")
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN")))

                        // Secure /upravnik POST and DELETE requests for ADMIN or OPERATOR roles with SCOPE_all authority
                        .requestMatchers(HttpMethod.POST, "/upravnik")
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN", "OPERATOR")))
                        .requestMatchers(HttpMethod.DELETE, "/upravnik")
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN", "OPERATOR")))

                        // Secure /operator/** and /upravnik/** PUT requests for ADMIN role with SCOPE_all authority
                        .requestMatchers(HttpMethod.PUT, "/operator/**", "/upravnik/**")
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN")))

                        // Secure /admin/** endpoints for ADMIN role with SCOPE_all authority
                        .requestMatchers("/admin/**")
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN")))

                        // Secure all other endpoints for users with ADMIN or USER roles and SCOPE_all authority
                        .anyRequest()
                        .access(AuthorizationManagers.allOf(
                                AuthorityAuthorizationManager.hasAnyAuthority("SCOPE_all"),
                                AuthorityAuthorizationManager.hasAnyRole("ADMIN", "USER")))
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/user/register") // Disable CSRF protection for /user/register
                )
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtRolesConverter);

        return http.build();
    }


    @Bean
    SecurityProvider securityProvider(KeycloakSecurityProperties props) {
        return KeycloakSecurityProvider.builder().properties(props).build();
    }

    @Bean
    KeycloakJwtRolesConverter jwtRolesConverter() {
        return new KeycloakJwtRolesConverter();
    }
}