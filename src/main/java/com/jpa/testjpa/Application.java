package com.jpa.testjpa;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Application extends MySQLDialect {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }


}
