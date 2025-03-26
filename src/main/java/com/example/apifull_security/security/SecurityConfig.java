package com.example.apifull_security.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(HttpMethod.GET, "/api/funko").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/funko/{funkoId}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/funko").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/funko/{funkoId}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/funko/{funkoId}").hasRole("ADMIN")

                )

                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();

    }
}