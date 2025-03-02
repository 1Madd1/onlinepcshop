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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, KeycloakJwtRolesConverter jwtRolesConverter)
            throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/**").permitAll()
                        // Allow everyone to access /user/register and /multiple-tables/all-requested-components
                        .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/multiple-tables/all-requested-components").permitAll()
                        .requestMatchers(HttpMethod.POST, "/multiple-tables/purchase-products").permitAll()

                        // Allow public access to /test/** endpoints
                        .requestMatchers("/test/**").permitAll()

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
                        // Disable CSRF protection for /user/register, /multiple-tables/all-requested-components nad /multiple-tables/purchase-products
                        // Should change in future for post request so that it doesn't use post as a way to get information for computer
                        .ignoringRequestMatchers("/user/register")
                        .ignoringRequestMatchers("/multiple-tables/all-requested-components")
                        .ignoringRequestMatchers("/multiple-tables/purchase-products")
                )
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtRolesConverter);

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityProvider securityProvider(KeycloakSecurityProperties props, PasswordEncoder passwordEncoder) {
        return KeycloakSecurityProvider.builder()
                .properties(props)
                .passwordEncoder(passwordEncoder)
                .build();
    }


    @Bean
    KeycloakJwtRolesConverter jwtRolesConverter() {
        return new KeycloakJwtRolesConverter();
    }
}