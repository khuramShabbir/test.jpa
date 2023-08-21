package com.jpa.testjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration

public class AppConfig {
@Bean
    public UserDetailsService userDetailsService(){
        UserDetails build = User.builder().username("khuram").password(encoder().encode("khuram ")).roles("ADMIN").build();

        return  new InMemoryUserDetailsManager(build);
    }
    @Bean
    public PasswordEncoder encoder(){

    return  new BCryptPasswordEncoder( );
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    return  configuration.getAuthenticationManager();
    }
}
