package com.farheen.ilabsfaqmanagerbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Consider security implications for your case
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/user/signUp",
                                "/api/v1/user/signIn",
                                "api/v1/faq/saveFaq",
                                "api/v1/faq/getFaqs",
                                "api/v1/faq/delete/{id}",
                                "api/v1/faq/getFaq/{questionTitle}"
                        ).permitAll() // Allow unauthenticated access
                        .anyRequest().authenticated() // Require authentication for all other requests
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
