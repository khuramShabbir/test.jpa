package com.jpa.testjpa;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends MySQLDialect {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }


}
