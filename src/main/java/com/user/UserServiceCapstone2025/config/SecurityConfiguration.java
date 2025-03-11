package com.user.UserServiceCapstone2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                            try {
                                requests

                                        .requestMatchers("/", "/home").permitAll()
//                                                .anyRequest().permitAll()
                                                .and().cors().disable()
                                                .csrf().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
//                        .anyRequest().authenticated()
                );
//                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
