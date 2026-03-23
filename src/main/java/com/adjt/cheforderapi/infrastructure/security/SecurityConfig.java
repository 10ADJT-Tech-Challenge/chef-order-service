package com.adjt.cheforderapi.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;
@Configuration
public class SecurityConfig {

    private final RSAPublicKey publicKey;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(
            RSAPublicKey publicKey,
            JwtAuthenticationEntryPoint authenticationEntryPoint
    ) {
        this.publicKey = publicKey;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(jwt -> jwt.decoder(jwtDecoder()))
                        .authenticationEntryPoint(authenticationEntryPoint)
                );

        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }
}