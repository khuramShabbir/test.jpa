package com.jpa.testjpa.models;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String message;
    private int status;
    private  String token;
    private  UserEntity userEntity;

}
