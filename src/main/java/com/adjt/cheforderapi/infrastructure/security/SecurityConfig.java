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