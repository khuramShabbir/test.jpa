package com.jpa.testjpa.config;

import com.jpa.testjpa.security.jwtAuthEntryPoint.JwtAuthEntryPoint;
import com.jpa.testjpa.security.jwtAuthEntryPoint.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;







@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthEntryPoint authEntryPoint;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/auth", "/", "/addCar","/getCar","/getAllCars").permitAll() // Allow access without token
                                .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> {
                    System.out.println("Exception handling: " + ex);
                    ex.authenticationEntryPoint(authEntryPoint);
                })
                .sessionManagement(session -> {
                    System.out.println("Session management: " + session);
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
