package com.jpa.testjpa.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private  String token;
    private  String mobileNumber;
}
